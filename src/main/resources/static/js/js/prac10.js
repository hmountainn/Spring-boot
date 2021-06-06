window.addEventListener("load",function(){
	var section = document.querySelector("#prac10");
	var requestButton = section.querySelector(".btn-request");
	
	var tbody = section.querySelector("tbody");
	requestButton.onclick = function(){
		var request = new XMLHttpRequest();
		
		request.onload = function(){
			var list = JSON.parse(request.responseText);
			
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
			
		};
		
		request.open("GET", "../../api/notice/list");
		request.send(null);
	}
	
});