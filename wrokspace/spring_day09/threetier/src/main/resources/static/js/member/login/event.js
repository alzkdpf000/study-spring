// 카카오 로그인
const kakaoLoginButton = document.getElementById("kakao-login");
kakaoLoginButton.addEventListener("click", (e) => {
    window.location.href = "https://kauth.kakao.com/oauth/authorize?client_id=3ebb02ebe2a0366ed7f138a9c5e23053&redirect_uri=http://localhost:10000/kakao/login&response_type=code";
});




