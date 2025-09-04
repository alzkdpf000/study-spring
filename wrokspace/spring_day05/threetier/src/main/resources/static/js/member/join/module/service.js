const memberService = (() => {
    const checkEmail = async (member, callback) => {
        try{
            const response = await fetch("/member/check-email", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(member)
            })
            const result = await response.json();

            if(response.ok) {
                // 로그 출력
                console.log("사용 가능");
            }else if(response.status === 409) {
                // 로그 출력
                console.log("사용 불가");
            }else {
                // 로그 출력
                const errorText = await response.text();
                console.log(response.status);
                console.log(errorText || "Fetch Error");
            }

            if(callback){
                callback(result);
            }

            return result.isExist;
        } catch (error) {
            console.error(error);
        }


    }
    return {checkEmail: checkEmail}
})();
















