window.addEventListener("load", function(){
    var app = new Vue({
        el: '#mvc',
        data: {
            x:0,
            y:0,
            sum:0,
            list:
            [
                {id:1, title:'hello'} //model
            ,   {id:2, title:'hi'}
            ]
        },
        methods:{
            btnClickHandler:function(){
                this.sum = parseInt(this.x) + parseInt(this.y);
            }
        }
      });
});


// window.addEventListener("load", function(){
//     let xInput = document.querySelectorAll("input")[0];
//     let yInput = document.querySelectorAll("input")[1];
//     let submit = document.querySelectorAll("input")[2];
//     let resultSpan = document.querySelector("span:last-child");

//     // xInput.oninput = function(e){
//     //     let x = parseInt(xInput.value);
//     //     let y = parseInt(yInput.value);
//     //     resultSpan.innerText = x+y;
//     // };

//     // yInput.oninput = function(e){
//     //     let x = parseInt(xInput.value);
//     //     let y = parseInt(yInput.value);
//     //     resultSpan.innerText = x+y;
//     // };

//     submit.onclick = function(){
//         let x = parseInt(xInput.value);
//         let y = parseInt(yInput.value);

//         resultSpan.innerText = x+y;
//         xInput.value = 0;
//         yInput.value = 0;
//     }
// })