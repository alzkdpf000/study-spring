replyService.getList(post.id, replyLayout.showList);

const replyPageWrap = document.getElementById("replyPageWrap");
replyPageWrap.addEventListener("click", (e) => {
    if(e.target.classList.contains("paging")){
        e.preventDefault();
        replyService.getList(post.id, replyLayout.showList, e.target.dataset.page);
    }
});

const replyWriteButton = document.getElementById("replyWriteButton");
replyWriteButton.addEventListener("click", async (e) => {
    const replyContent = document.getElementById("replyContent");
    const reply = {
        replyContent: replyContent.value,
        memberId: memberId,
        postId: post.id
    }
    await replyService.write(reply)
    replyContent.value = "";
    await replyService.getList(post.id, replyLayout.showList);
});

const replyWrap = document.getElementById("replyWrap");
replyWrap.addEventListener("click", async (e) => {
    let replyId = 0;
    let textArea = null;
    let span = null;
    if(e.target.classList.contains("update-button")){
        replyId = e.target.classList[1].replaceAll("id", "");
        span = document.querySelector(`span.id${replyId}`)
        textArea = document.querySelector(`textarea.id${replyId}`);
        textArea.style.display = "inline-block";
        span.style.display = "none";
        e.target.style.display = "none"
        e.target.nextElementSibling.style.display = "inline-block";
        document.querySelector(`button.cancel-button.id${replyId}`).style.display = "inline-block";

    }else if(e.target.classList.contains("cancel-button")){
        replyId = e.target.classList[1].replaceAll("id", "");
        span = document.querySelector(`span.id${replyId}`)
        textArea = document.querySelector(`textarea.id${replyId}`);
        textArea.value = span.innerText;
        textArea.style.display = "none";
        span.style.display = "inline";
        document.querySelector(`button.update-button.id${replyId}`).style.display = "inline-block";
        e.target.previousElementSibling.style.display = "none";

    }else if(e.target.classList.contains("update-ok-button")){
        replyId = e.target.classList[1].replaceAll("id", "");
        textArea = document.querySelector(`textarea.id${replyId}`);
        const reply = {
            replyContent: textArea.value,
            id: replyId
        }
        await replyService.update(reply);
        await replyService.getList(post.id, replyLayout.showList);

    }else if(e.target.classList.contains("delete-button")) {
        replyId = e.target.classList[1].replaceAll("id", "");
        await replyService.remove(replyId);
        await replyService.getList(post.id, replyLayout.showList);
    }
});
