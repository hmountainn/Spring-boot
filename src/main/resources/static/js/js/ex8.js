window.addEventListener("load",function(){
    var section = document.querySelector("#ex8");

    var product = section.querySelector(".product");
    product.onclick = function(e){
        var target = e.target;
        if(!target.classList.contains("up") &&
        !target.classList.contains("down") &&
        !target.classList.contains("current"))
            return;

        if(target.classList.contains("up")){
            var input = target.parentElement.querySelector("input");
            input.value = parseInt(input.value)+1;
        }
        else if(target.classList.contains("down")){
            var input = target.parentElement.querySelector("input");
            input.value = parseInt(input.value)-1;
        }
        else if(target.classList.contains("current")){
            target.parentElement.classList.toggle("current")
        }
    }
});