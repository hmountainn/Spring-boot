// window.onload = function(){
window.addEventListener("load", function(){
    var section = window.document.getElementById("ex2");
    var button = section.getElementsByClassName("submit-button")[0];
    var x = section.getElementsByClassName("x")[0];
    var y = section.getElementsByClassName("y")[0];
    var result = section.getElementsByClassName("result")[0];


    button.onclick = function(){

        var a = parseInt(x.value);
        var b = parseInt(y.value);

        result.innerText = a+b;
    }
});


// window.onload = function(){
window.addEventListener("load", function(){
    var section = window.document.getElementById("ex1");
    var Test = section.getElementsByClassName("submit-button")[0]; //섹션중에 submit-button중이 0번째

    Test.onclick = function(){
        console.log("test");
    } 
});