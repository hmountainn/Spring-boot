window.addEventListener("load", function(){
    //querySelector로 변경
    var section = document.querySelector("#ex3")

    var span = section.querySelector(".span");
    var button = section.querySelector(".btn");

    button.onclick = function(){
        // window.setInterval(로직, 시간(3000:3초))
        // 1초마다 실행
        window.setInterval(function(){
        var num = parseInt(span.innerText);
        num--;
        span.innerText = num;
        }, 1000);
    }
});