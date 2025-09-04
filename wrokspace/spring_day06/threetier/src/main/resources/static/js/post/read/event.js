const buttonWrap = document.querySelector(".button-wrap");
let text = ``;
if(post.memberId === memberId){
    text = `
        <button onclick="window.location.href = '/post/update/${post.id}'">수정</button>
        <button onclick="window.location.href = '/post/delete/${post.id}'">삭제</button>
    `;
    buttonWrap.innerHTML = text;
}


const imageContainer = document.getElementById("imageContainer");
const files = post.files;
text = ``;
files.forEach((file) => {
    text += `<img src="/api/files/display?filePath=${file.filePath}&fileName=${file.fileName}">`;
});
imageContainer.innerHTML = text;










