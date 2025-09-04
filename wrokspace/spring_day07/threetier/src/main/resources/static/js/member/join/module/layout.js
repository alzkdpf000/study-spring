const memberLayout = (() => {
    const checkEmail = async (result) => {
        const errorMessage = document.querySelector("div.error-message")
        if(result.isExist) {
            errorMessage.style.display = "block";
            errorMessage.innerText = "사용할 수 없는 이메일입니다.";
            return;
        }
        errorMessage.style.display = "none";
        errorMessage.innerText = "";
    }

    return {checkEmail: checkEmail}
})();