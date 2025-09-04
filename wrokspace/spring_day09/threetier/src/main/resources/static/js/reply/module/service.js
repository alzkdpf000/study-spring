const replyService = (() => {
    const write = async (reply) => {
        const response = await fetch("/api/replies/write", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reply)
        });

        if(response.ok) {
            console.log("댓글 작성 성공");
        } else{
            const errorMessage = await response.text();
            console.log(errorMessage)
        }
    }
    const getList = async (postId, callback, page=1) => {
        const response = await fetch(`/api/replies/${page}?postId=${postId}`)
        const repliesCriteria = await response.json();

        if(callback){
            callback(repliesCriteria);
        }

    }
    const update = async (reply) => {
        await fetch(`/api/replies/${reply.id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reply)
        })
    }
    const remove = async (id) => {
        await fetch(`/api/replies/${id}`, {
            method: "DELETE",
        });
    }

    return {write: write, getList: getList, update: update, remove: remove}
})();










