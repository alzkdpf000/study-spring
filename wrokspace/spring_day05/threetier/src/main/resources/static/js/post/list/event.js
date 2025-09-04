// ########################### 게시글 목록 ###########################
// const postContainer = document.querySelector("#post-container tbody");
// let text = ``;
// posts.forEach((post) => {
//    text += `
//         <tr>
//             <td>${post.id}</td>
//             <td>${post.postTitle}</td>
//             <td>${post.postReadCount}</td>
//             <td>${post.memberName}</td>
//             <td>${post.relativeDate}</td>
//         </tr>
//    `;
// });
// postContainer.innerHTML = text;
// ########################### 게시글 페이징 ###########################
// const pageContainer = document.getElementById("page-container");
// text = ``;
//
// if(criteria.hasPreviousPage){
//    text = `<a href="/post/list/${criteria.startPage - 1}">이전</a>`
// }
//
// for(let i = criteria.startPage; i <= criteria.endPage; i++){
//    text += `
//       <a href="/post/list/${i}">${i}</a>
//    `;
// }
//
// if(criteria.hasNextPage){
//    text += `<a href="/post/list/${criteria.endPage + 1}">다음</a>`
// }
// pageContainer.innerHTML = text;
// ########################### 게시글 무한 스크롤 ###########################
let page = 1;
const showList = async (page = 1) => {
    const loading = document.getElementById("loading");

    loading.style.display = "block";
    const postsCriteria = await postService.getPost(page, postLayout.showList);
    setTimeout(() => {
        loading.style.display = "none";
    }, 1000)

    return postsCriteria;
}
showList();

let checkScroll = true;
let postsCriteria;

window.addEventListener("scroll", async (e) => {
    // 현재 스크롤 위치
    const scrollTop = window.scrollY
    // 화면 높이
    const windowHeight = window.innerHeight;
    // 문서 전체 높이
    const documentHeight = document.documentElement.scrollHeight
    if(scrollTop + windowHeight >= documentHeight - 2) {
    //     바닥에 닿았을 때
        if(checkScroll){
            postsCriteria = await showList(++page);
            checkScroll = false;
        }
        setTimeout(() => {
            if(postsCriteria !== null && postsCriteria.criteria.hasMore){
                checkScroll = true
            }
        }, 1100);
    }
})
// ########################### 게시글 더보기 ###########################


















