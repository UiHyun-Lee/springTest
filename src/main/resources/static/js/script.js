$(document).ready(function () {
    $(".login_func").click(function () {
        if ($(".login-form").css("display") === "block") {
            $(".login-form").css("display", "none");
        } else {
            $(".login-form").css("display", "block");
        }
    });
});
$(document).ready(function () {
    $(".sear_func").click(function () {
        if ($(".sear-form").css("display") === "block") {
            $(".sear-form").css("display", "none");
        } else {
            $(".sear-form").css("display", "block");
        }
    });
});
setInterval(function(){
    var a = document.getElementById("title");
    var random = Math.round(Math.random() * 0xffffff).toString(16);
    a.style.color = "#"+random;
},1000);