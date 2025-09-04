package com.example.threetier.service;

import com.example.threetier.common.exception.PostFileNotFoundException;
import com.example.threetier.domain.FileVO;
import com.example.threetier.dto.FileDTO;
import com.example.threetier.dto.PostCriteriaDTO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.dto.PostFileDTO;
import com.example.threetier.repository.CategoryDAO;
import com.example.threetier.repository.FileDAO;
import com.example.threetier.repository.PostDAO;
import com.example.threetier.repository.PostFileDAO;
import com.example.threetier.util.Criteria;
import com.example.threetier.util.DateUtils;
import com.example.threetier.util.Search;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final FileDAO fileDAO;
    private final PostFileDAO postFileDAO;
    private final CategoryDAO categoryDAO;

    @Override
    public void write(PostDTO postDTO, List<MultipartFile> files) {
        String todayPath = getPath();
        String rootPath = "C:/file/" + todayPath;

        postDAO.save(postDTO);

        files.forEach(file -> {
            if(file.getOriginalFilename().equals("")){
                return;
            }

            UUID uuid = UUID.randomUUID();

            FileDTO fileDTO = new FileDTO();
            PostFileDTO postFileDTO = new PostFileDTO();

            fileDTO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
            fileDTO.setFileOriginalName(file.getOriginalFilename());
            fileDTO.setFilePath(todayPath);
            fileDTO.setFileSize(String.valueOf(file.getSize()));
            fileDTO.setFileContentType(file.getContentType());

            fileDAO.save(fileDTO);

            postFileDTO.setId(fileDTO.getId());
            postFileDTO.setPostId(postDTO.getId());

            postFileDAO.save(toPostFileVO(postFileDTO));

            File directory = new File(rootPath);
            if(!directory.exists()){
                directory.mkdirs();
            }

            try {
//                원본 업로드
                file.transferTo(new File(rootPath, uuid.toString() + "_" + file.getOriginalFilename()));
                
//                썸네일 업로드
                if(file.getContentType().startsWith("image")) {
//                    UUID tUuid = new UUID(); // 원본 이미지의 UUID와 다르게 설정
                    FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid.toString() + "_" + file.getOriginalFilename()));
                    Thumbnailator.createThumbnail(file.getInputStream(), out, 100, 100);
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    @Override
    public PostCriteriaDTO getList(int page, Search search) {
        PostCriteriaDTO postCriteriaDTO = new PostCriteriaDTO();
        Criteria criteria = new Criteria(page, postDAO.findCountAll(search));
        List<PostDTO> posts = postDAO.findAll(criteria, search);
        posts.forEach((post) -> {
            String[] arData = null;

            Object[] categoryNames = categoryDAO.findPostId(post.getId())
                    .stream().map((category -> category.getCategoryName())).toArray();
            arData = new String[categoryNames.length];

            for (int i=0; i<categoryNames.length; i++){
                arData[i] = String.valueOf(categoryNames[i]);
            }

            post.setRelativeDate(DateUtils.toRelativeTime(post.getCreatedDatetime()));
            post.setCategoryNames(arData);
        });
        postCriteriaDTO.setCategoryNames(categoryDAO.findAll().stream().map(categoryDTO -> categoryDTO.getCategoryName()).collect(Collectors.toList()));

        criteria.setHasMore(posts.size() > criteria.getRowCount());

//        11개 가져왔으면, 마지막 1개 삭제
        if(criteria.isHasMore()){
            posts.remove(posts.size() - 1);
        }

        postCriteriaDTO.setPosts(posts);
        postCriteriaDTO.setCriteria(criteria);
        return postCriteriaDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<PostDTO> getPost(Long id) {
        postDAO.updatePostReadCount(id);
        Optional<PostDTO> foundPost = postDAO.findById(id);
        foundPost.ifPresent((post) -> {
            post.setCreatedDate(DateUtils.getCreatedDate(post.getCreatedDatetime()));
            post.setFiles(postFileDAO.findPostFilesByPostId(post.getId()));
        });
        return foundPost;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PostDTO postDTO, List<MultipartFile> files, Long[] deleteFileIds) {
        String todayPath = getPath();
        String rootPath = "C:/file/" + todayPath;
        List<FileDTO> postFiles = new ArrayList<>();

        postDAO.setPost(toPostVO(postDTO));

        Arrays.stream(deleteFileIds).forEach((id) -> {
            postFiles.add(fileDAO.findById(id).orElseThrow(PostFileNotFoundException::new));
        });

        Arrays.stream(deleteFileIds).forEach(postFileDAO::deleteById);
        Arrays.stream(deleteFileIds).forEach(fileDAO::delete);

        postFiles.forEach((postFile) -> {
            File file = new File("C:/file/" + postFile.getFilePath(), postFile.getFileName());
            if(file.exists()){
                file.delete();
            }

            if(postFile.getFileContentType().startsWith("image")) {
                file = new File("C:/file/" + postFile.getFilePath(), "t_" + postFile.getFileName());
                if(file.exists()){
                    file.delete();
                }
            }
        });

        files.forEach(file -> {
            if(file.getOriginalFilename().equals("")){
                return;
            }

            UUID uuid = UUID.randomUUID();

            FileDTO fileDTO = new FileDTO();
            PostFileDTO postFileDTO = new PostFileDTO();

            fileDTO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
            fileDTO.setFileOriginalName(file.getOriginalFilename());
            fileDTO.setFilePath(todayPath);
            fileDTO.setFileSize(String.valueOf(file.getSize()));
            fileDTO.setFileContentType(file.getContentType());

            fileDAO.save(fileDTO);

            postFileDTO.setId(fileDTO.getId());
            postFileDTO.setPostId(postDTO.getId());

            postFileDAO.save(toPostFileVO(postFileDTO));

            File directory = new File(rootPath);
            if(!directory.exists()){
                directory.mkdirs();
            }

            try {
//                원본 업로드
                file.transferTo(new File(rootPath, uuid.toString() + "_" + file.getOriginalFilename()));

//                썸네일 업로드
                if(file.getContentType().startsWith("image")) {
//                    UUID tUuid = new UUID(); // 원본 이미지의 UUID와 다르게 설정
                    FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid.toString() + "_" + file.getOriginalFilename()));
                    Thumbnailator.createThumbnail(file.getInputStream(), out, 100, 100);
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        postDAO.delete(id);
        List<FileDTO> postFiles = postFileDAO.findPostFilesByPostId(id);

        postFileDAO.delete(id);
        postFiles.stream().map(postFile -> postFile.getId()).forEach(fileDAO::delete);

        postFiles.forEach((postFile) -> {
            File file = new File("C:/file/" + postFile.getFilePath(), postFile.getFileName());
            if(file.exists()){
                file.delete();
            }

            if(postFile.getFileContentType().startsWith("image")) {
                file = new File("C:/file/" + postFile.getFilePath(), "t_" + postFile.getFileName());
                if(file.exists()){
                    file.delete();
                }
            }
        });
    }
}










