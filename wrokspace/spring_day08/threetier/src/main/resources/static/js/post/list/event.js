// ########################### 게시글 목록 ###########################
const postContainer = document.querySelector("#post-container tbody");
let text = ``;
posts.forEach((post) => {
   text += `
        <tr>
            <td>${post.id}</td>
            <td><a href="/post/${post.id}">${post.postTitle}</a></td>
            <td>${post.postReadCount}</td>
            <td>${post.memberName}</td>
            <td>${post.relativeDate}</td>
            <td>
        `

   post.categoryNames.forEach((categoryName) => {
      text += `
               ${categoryName}
      `;
   });
   text += `</td></tr>`;
});
postContainer.innerHTML = text;
// ########################### 게시글 페이징 - 통합검색 ###########################
// const pageContainer = document.getElementById("page-container");
// text = ``;
//
// if(criteria.hasPreviousPage){
//    text = `<a href="/post/list/${criteria.startPage - 1}?keyword=${keyword}">이전</a>`
// }
//
// for(let i = criteria.startPage; i <= criteria.endPage; i++){
//    text += `
//       <a href="/post/list/${i}?keyword=${keyword}">${i}</a>
//    `;
// }
//
// if(criteria.hasNextPage){
//    text += `<a href="/post/list/${criteria.endPage + 1}?keyword=${keyword}">다음</a>`
// }
// pageContainer.innerHTML = text;
// ########################### 게시글 페이징 - 날짜 + 통합검색 ###########################
// const pageContainer = document.getElementById("page-container");
// text = ``;
//
// if(criteria.hasPreviousPage){
//    text = `<a href="/post/list/${criteria.startPage - 1}?keyword=${keyword}&month=${month}">이전</a>`
// }
//
// for(let i = criteria.startPage; i <= criteria.endPage; i++){
//    text += `
//       <a href="/post/list/${i}?keyword=${keyword}&month=${month}">${i}</a>
//    `;
// }
//
// if(criteria.hasNextPage){
//    text += `<a href="/post/list/${criteria.endPage + 1}?keyword=${keyword}&month=${month}">다음</a>`
// }
// pageContainer.innerHTML = text;
// ########################### 게시글 페이징 - 카테고리 제작 ###########################
const categoryWrap = document.getElementById("categoryWrap");
text = ``;
categoryNames.forEach((name) => {
   text += `<label><input type="checkbox" name="categories" value="${name}"> ${name}</label>`;
});
categoryWrap.innerHTML = text;

const checkboxes = document.querySelectorAll("input[name=categories]");
categories.forEach((category) => {
   checkboxes.forEach((checkbox) => {
      if(checkbox.value === category){
         checkbox.checked = true;
      }
   });
});


// ########################### 게시글 페이징 - 카테고리 검색 ###########################
const pageContainer = document.getElementById("page-container");
text = ``;
queryString = ``;
categories.forEach((category) => {
   queryString += `&categories=${category}`
});

if(criteria.hasPreviousPage){
   text = `<a href="/post/list/${criteria.startPage - 1}?keyword=${keyword}&month=${month}${queryString}">이전</a>`
}

for(let i = criteria.startPage; i <= criteria.endPage; i++){
   text += `
      <a href="/post/list/${i}?keyword=${keyword}&month=${month}${queryString}">${i}</a>
   `;
}

if(criteria.hasNextPage){
   text += `<a href="/post/list/${criteria.endPage + 1}?keyword=${keyword}&month=${month}${queryString}">다음</a>`
}
pageContainer.innerHTML = text;
// ########################### 게시글 무한 스크롤 ###########################
// let page = 1;
// const showList = async (page = 1) => {
//     const loading = document.getElementById("loading");
//
//     loading.style.display = "block";
//     const postsCriteria = await postService.getPost(page, postLayout.showList);
//     setTimeout(() => {
//         loading.style.display = "none";
//     }, 1000)
//
//     return postsCriteria;
// }
// showList();
//
// let checkScroll = true;
// let postsCriteria;
//
// window.addEventListener("scroll", async (e) => {
//     // 현재 스크롤 위치
//     const scrollTop = window.scrollY
//     // 화면 높이
//     const windowHeight = window.innerHeight;
//     // 문서 전체 높이
//     const documentHeight = document.documentElement.scrollHeight
//     if(scrollTop + windowHeight >= documentHeight - 2) {
//     //     바닥에 닿았을 때
//         if(checkScroll){
//             postsCriteria = await showList(++page);
//             checkScroll = false;
//         }
//         setTimeout(() => {
//             if(postsCriteria !== null && postsCriteria.criteria.hasMore){
//                 checkScroll = true
//             }
//         }, 1100);
//     }
// })
// ########################### 게시글 더보기 ###########################
// const getMoreButton = document.getElementById("getMoreButton");
// let page = 1;
//
// const showList = async (page = 1) => {
//     const loading = document.getElementById("loading");
//
//     loading.style.display = "block";
//     const postsCriteria = await postService.getPost(page, postLayout.showList);
//     setTimeout(() => {
//         loading.style.display = "none";
//     }, 1000)
//
//     return postsCriteria;
// }
// showList();
//
// getMoreButton.addEventListener("click", async (e) => {
//     postsCriteria = await showList(++page);
//
//     //     더보기 버튼 숨기기
//     e.target.style.display = postsCriteria.criteria.hasMore ? "block" : "none";
// });

















