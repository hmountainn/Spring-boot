/**
 * 
 */

window.addEventListener("load", function(){
	const section = document.querySelector("#dnd-section");
	const uploadBox = section.querySelector(".upload-box");
	const progressStatusDiv = document.querySelector(".progress-status");
	const fileInput = document.querySelectorAll(".form input[type='file']")[0];
	
	fileInput.oninput = function(e){
		let file = fileInput.files[0];
		if(file.type.indexOf("image/") < 0)
			alert("이미지형식만 사용가능하다");
		
		var reader = new FileReader(); //로컬파일 읽어올수있음
		reader.onload = function(evt){
			let img = document.createElement("img");
			img.src = evt.target.result;
			
			fileInput.insertAdjacentElement("afterend", img);
		};
		reader.readAsDataURL(file);
		
	}
	
	uploadBox.ondragenter = function(){
		console.log("enter");
	}
	
	uploadBox.ondragleave = function(){
		console.log("leave");
		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");
	}
	
	uploadBox.ondragover = function(e){
		e.preventDefault();
		let dt = e.dataTransfer;
		
		var valid = dt.types.indexOf("Files") >= 0;
		
		if(valid){
			uploadBox.classList.add("valid");
		}
		else{
			uploadBox.classList.add("invalid");
		}
		
		
	}
	
	uploadBox.ondrop = function(e){
		e.preventDefault();
		
		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");
		
		let dt = e.dataTransfer;
		if(dt.files.length > 1){ //파일 개수 제약
			alert("파일은 하나씩만 전송이 가능합니다.");
			return;
		}
		
		if(dt.files[0].size > 500*1024*1024){ //파일크기 제약
			alert("ㅈㅅ. 500MByte를 넘는 파일은 전송안됨")
		}
		
		let formData = new FormData();
		formData.append("p", "/upload/test");
		formData.append("f", dt.files[0]);
		
		let request = new XMLHttpRequest();
		request.onload = function(){
			console.log(request.responseText);
			let filePath = request.responseText;
			
/*			let li = `<li>
						<a download href="${filePath}">
							${filePath}
						</a>
					  </li>`;*/
			
			let li = `<li><img style="width:100px" src="${filePath}"></li>`
			
			let ul = progressStatusDiv.lastElementChild;
			ul.insertAdjacentHTML("beforeend",li);
		};
		request.upload.onprogress = function(e){
			/*console.log(`total:${e.total}, loaded:${e.loaded}`);*/
			let status = Math.round(e.loaded*100/e.total)+'%'
			
			let bar = progressStatusDiv.firstElementChild.firstElementChild; 
			
			bar.innerText = status; //숫자
			
			bar.style.width = status; //막대
		}
		
		request.open("POST", "/admin/uploader", true);
		request.send(formData);
		
		console.log("drop");
	}	
	
	
});