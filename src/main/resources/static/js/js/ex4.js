window.addEventListener("load", function(){
    var section = document.querySelector("#ex4")

    var boxes = section.querySelectorAll(".box");
    var button = section.querySelector("input[value='click']");

    button.onclick = function(){
        
        var box = boxes[0];
        let boxStyle = window.getComputedStyle(box); //css 스타일을 들고오기(box1)
        
        var left = parseInt(boxStyle.getPropertyValue("left")); //'70px' -> 70 으로 변경

        var time = window.setInterval(function(){
            left++;
            boxes[0].style.left = left+"px";
            if(left == 400){ //박스 끝에서 멈추기
                clearInterval(time);
            }
        }, 17);
    }
});