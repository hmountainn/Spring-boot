window.addEventListener("load",function(){
	var section = document.querySelector("#ex10");
	var tbody = section.querySelector("tbody");
    var requestButton = document.querySelector(".btn-request");
	var pager = section.querySelector(".pager");
	
	var submitButton = section.querySelector(".search-form input[type=submit]");
	var fieldInput = section.querySelector(".search-form select");
	var queryInput = section.querySelector(".search-form input[name=q]");
	var pageElement = pager.querySelector("a");
	
	submitButton.onclick = function(e){
		
		e.preventDefault();
		
		var field = fieldInput.value;
		var query = queryInput.value;
		
		bind(`../../api/notice/list?f=${field}&q=${query}`);
	};
	
	function bind(url){
		var request = new XMLHttpRequest(); //요청도구
		
		request.onload = function(){
			
			//tbody자식들 데이터 지우기
			tbody.innerHTML = ""; 
			
			// 새로운 목록으로 tbody채우기
			var list = JSON.parse(request.responseText);
			console.log(list);
			
			//insertAdjacentElement를 이용해서 문자열로 추가
			var trEmpty = tbody.querySelector(".empty")
			if(list.length>0 && trEmpty != null)
				trEmpty.remove();
			
			for(var i=0; i<list.length; i++){
				var tr = `<tr>
								<td>${list[i].id}</td>
								<td>${list[i].title}</td>
						 </tr>`;
				tbody.insertAdjacentHTML("beforeend",tr);				
			}
			
			screen.remove();
		};
		
		//2. 창과 아이콘을 제거
		request.onabort = function(){
			console.log("abor");
			screen.remove();			
		};
		request.open("GET",url, true); //true: 비동기방식
		request.send(null);
		
		var screen = document.createElement("div");
		
		// 1.창과 아이콘을 띄운다
		screen.style.width = "100%";
		screen.style.height = "100%";
		screen.style.backgroundColor = "black";
		screen.style.position = "absolute";
		screen.style.top = "0px";
		screen.style.left = "0px";
		screen.style.opacity = 0;
		screen.style.transition = ".5s";
		
		screen.style.display = "flex";
		screen.style.alignItems = "center";
		screen.style.justifyContent = "center";
		
		var img = document.createElement("img");
		img.src = "../../images/ajax-loader.gif";
		screen.append(img);
		
		var closeButton = document.createElement("input");
		closeButton.value = "닫기";
		closeButton.type = "button";
		closeButton.style.alignSelf = "flex-start";
		closeButton.style.position = "absolute";
		closeButton.style.right = "0px"
		
		screen.append(closeButton);
		
		closeButton.onclick = function(){ //닫기 클릭
			request.abort(); //abort불러옴
		};
		
		
		setTimeout(function(){
			screen.style.opacity = 0.7;
		},0);
		
		section.append(screen);
	}
	
	pager.onclick = function(e){
		e.preventDefault();
		
		if(e.target.tagName != "A")
			return;
		
		var page = e.target.innerText;
		
		bind(`../../api/notice/list?p=${page}`)
		/*var request = new XMLHttpRequest();
		request.onload = function(e){
			var list = JSON.parse(request.responseText);
			console.log(request.responseText);
		}
		request.open("GET", `../../api/notice/list?p=${page}`,true);
		request.send(null);*/
		
		//text-strong 전체 다 삭제하고 다시 추가하는방법
		/*var as = pager.querySelectorAll("a");
		
		for(var i=0; i<as.length; i++)
			as[i].classList.remove("text-strong");*/
		
	
		pageElement.classList.remove("text-strong");
		
		e.target.classList.add("text-strong")
		pageElement = e.target;
		
	};	
	
    
	bind("http://localhost:8080/api/notice/list");
    /*requestButton.onclick = function(e){
	}*/



})