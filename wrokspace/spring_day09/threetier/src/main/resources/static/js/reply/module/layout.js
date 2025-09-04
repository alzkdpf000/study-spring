const replyLayout = (() => {
    const showList = (repliesCriteria) => {
        const replyWrap = document.getElementById("replyWrap");
        const replyPageWrap = document.getElementById("replyPageWrap");
        let text = ``;
        repliesCriteria.replies.forEach((reply) => {
            text += `
                <li>
                    <span class="id${reply.id}">${reply.replyContent}</span>
                    <textarea class="id${reply.id}" style="display: none;">${reply.replyContent}</textarea>
                    <span>${reply.memberName}</span>
                    <span>${reply.relativeDate}</span>
                    <button class="update-button id${reply.id}">수정</button>
                    <button class="update-ok-button id${reply.id}" style="display: none;">수정 완료</button>
                    <button class="cancel-button id${reply.id}" style="display: none;">취소</button>
                    <button class="delete-button id${reply.id}">삭제</button>
                </li>
            `;
        });
        replyWrap.innerHTML = text;

        text = ``;
        let criteria = repliesCriteria.criteria;

        if(criteria.hasPreviousPage){
        text = `<a data-page="${criteria.startPage - 1}" class="paging">이전</a>`
        }

        for(let i = criteria.startPage; i <= criteria.endPage; i++){
        text += `
            <a data-page="${i}" class="paging">${i}</a>
        `;
        }

        if(criteria.hasNextPage){
        text += `<a data-page="${criteria.endPage + 1}" class="paging">다음</a>`
        }

        replyPageWrap.innerHTML = text;
    }

    return {showList: showList}
})();












