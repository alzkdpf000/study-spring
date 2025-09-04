const memberEmailInput = document.getElementById("email");
const signupButton = document.querySelector("button.signup-button");
const signupForm = document.getElementById("signupForm");
const arCheck = new Array(1).fill(false);

memberEmailInput.addEventListener("blur", async (e) => {
    const memberEmail = memberEmailInput.value;
    arCheck[0] = !(await memberService.checkEmail({memberEmail: memberEmail}, memberLayout.checkEmail));
    console.log(`비동기: ${arCheck[0]}`);
});

signupButton.addEventListener("click", (e) => {
    console.log(`동기: ${arCheck[0]}`);
    if(arCheck.filter(check => !check).length === 0){
        signupForm.submit();
    }
});




