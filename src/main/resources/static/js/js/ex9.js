window.addEventListener("load",function(){
    var section = document.querySelector("#ex9");

    var uploadBox = section.querySelector(".upload-box")
    var selButton = section.querySelector(".btn-sel");
    var fileButton = section.querySelector(".btn-file");

    //darg이벤트
    uploadBox.ondragenter = function(e){
        console.log("enter");
    }

    uploadBox.ondragover = function(e){
        e.preventDefault();

        //drag한것 file인지 여부
        var valid = e.dataTransfer.types.indexOf("Files") >= 0;

        if(!valid) //파일이 아니면
            uploadBox.style.backgroundColor = "red";
        else //파일이면
            uploadBox.style.backgroundColor = "green";
    }

    uploadBox.ondragleave = function(e){
        uploadBox.style.backgroundColor = "white"
        console.log("leave");
    }

    //drop이벤트
    uploadBox.ondrop = function(e){
        uploadBox.style.backgroundColor = "white"
        e.preventDefault();

        console.log(e.dataTransfer.files[0].size);
    }

    //파일업로드 버튼통해 업로드해서 파일정보 들고오기
    fileButton.oninput = function(e){
        console.log(fileButton.files[0]);
    }

    //가짜버튼 누르면 진짜업로드버튼 실행
    selButton.onclick = function(e){
        var event = new MouseEvent("click",{
            'view' : window,
            'bubbles': true,
            'cancelable':true
        });

        fileButton.dispatchEvent(event);
    }
});