const imageContainer = document.getElementById("imageContainer");
const files = post.files;
let text = ``;
files.forEach((file) => {
    text += `<img class="image" data-id="${file.id}" src="/api/files/display?filePath=${file.filePath}&fileName=${file.fileName}">`;
});
imageContainer.innerHTML = text;

const images = document.querySelectorAll("img.image");
const deleteFileIds = [];
images.forEach((image) => {
    image.addEventListener("click", (e) => {
        deleteFileIds.push(e.target.dataset.id);
        e.target.remove();
    });
});

const updateButton = document.getElementById("updateButton");
updateButton.addEventListener("click", (e) => {
    deleteFileIds.forEach((id) => {
        const input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "deleteFileId");
        input.value = id;
        document.updateForm.appendChild(input);
    });

    document.updateForm.submit();
});









