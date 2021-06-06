window.addEventListener("load", function(){
    var section = document.querySelector("#ex6");

    var container = section.querySelector(".container");
    var btnDel = section.querySelector(".btn-del");
    var btnClone = section.querySelector(".btn-clone");
    var btnChange = section.querySelector(".btn-change");

    var selected = null;

    // var boxes = container.querySelectorAll(".box");
    // //박스 클릭하면 selected에 넣기
    // for(let i=0; i<boxes.length; i++){
    //     boxes[i].onclick = function(){
    //         selected = boxes[i];
    //         console.log(selected);
    //     }
    // }

    //이벤트 버블링과 event.target속성사용
    container.onclick = function(e){
        if(!e.target.classList.contains("box")) //box가 포함이 안됐다면
            return;
        
        if(selected != null && selected != e.target) //다른거선택했을때 이미선택돼있는거 지우기
            selected.classList.remove("selected");

        selected = e.target;
        selected.classList.toggle("selected");

        // if(selected.classList.contains("selected"))
        //     selected.classList.remove("selected");
        // else
        //     selected.classList.add("selected");
    }

    //selected 삭제
    btnDel.onclick = function(){
        if(selected != null)
            selected.remove();
    }
});