package com.example.threetier.service;

import com.example.threetier.common.exception.LoginFailException;
import com.example.threetier.dto.MemberDTO;
import com.example.threetier.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public void join(MemberDTO memberDTO) {
        memberDAO.save(toVO(memberDTO));
    }

    @Override
    public boolean isExistMemberEmail(String memberEmail) {
        return memberDAO.isExistMemberEmail(memberEmail);
    }

    @Override
    public Optional<MemberDTO> login(MemberDTO memberDTO) {
        return memberDAO.findMemberByMemberEmailAndMemberPassword(memberDTO);
    }
}
