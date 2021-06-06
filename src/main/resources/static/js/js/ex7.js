window.addEventListener("load",function(){
    var section = document.querySelector("#ex7");

    var accordion = section.querySelector(".accordion");
    accordion.onclick = function(e){
        //1. title이 아니면 return
        if(!e.target.classList.contains("title")){
            return;
        }
        //2. target의 동생의 d-none을 제거하고 다시 추가
        e.target.nextElementSibling.classList.toggle("d-none");
    }

});