class List extends React.Component{
	
	constructor(){
		super();
		
		console.log("const")
		
		this.state = {
			list:[],
			count:0
		};
	}
	
	componentDidMount(){
		console.log("mount")
		
		fetch('/api/notice/list')
		.then(response => response.json())
		.then(json =>{
			this.setState(json);
		});
	}
	
	componentDidUpdate(){
		console.log("update");
	}
	// 1. Fetch API
	
	// 2. Fetch API를 사용하는 위치 : React LifeCycle
	
	// 3. CSRF를 이용하는 방법
   
   render(){
	console.log("render")
     return <main className="main">
            <h2 className="main title" >공지사항</h2>

            <div className="breadcrumb">
               <h3 className="hidden">경로</h3>
               <ul>
                  <li>home</li>
                  <li>고객센터</li>
                  <li>공지사항</li>
               </ul>
            </div>

            <div className="search-form margin-top first align-right">
               <h3 className="hidden">공지사항 검색폼</h3>
               <form className="table-form">
                  <fieldset>
                     <legend className="hidden">공지사항 검색 필드</legend>
                     <label className="hidden">검색분류</label>
                     <select name="f">
                        <option value="title">제목</option>
                        <option value="writerId">작성자</option>
                     </select>
                     <label className="hidden">검색어</label>
                     <input type="text" name="q" />
                     <input className="btn btn-search" type="submit" value="검색" />
                  </fieldset>
               </form>
            </div>
            
            <div className="notice margin-top">
               <h3 className="hidden">공지사항 목록</h3>
               <table className="table">
                  <thead>
                     <tr>
                        <th className="w60">번호</th>
                        <th className="expand">제목</th>
                        <th className="w100">작성자</th>
                        <th className="w100">작성일</th>
                        <th className="w60">조회수</th>
                        <th className="w40">공개</th>
                        <th className="w40">삭제</th>
                     </tr>
                  </thead>
                  <tbody>                     
                    {this.state.list.map(n=>{
						return <tr>
	                        <td>{n.id}</td>
	                        <td className="title indent text-align-left">
	                        
	                           <a href="detail?id=92032942">{n.title}</a>
	                        </td>
	                        <td>{n.writerId}</td>
	                        <td>
	                           {n.regDate}
	                        </td>
	                        <td>{n.hit}</td>
	                        <td><input type="checkbox" name="open"/></td>
	                        <td><input type="checkbox" name="del"/></td>
	                     </tr>
					})}

                  </tbody>
               </table>
            </div>

            <div className="indexer margin-top align-right">
               <h3 className="hidden">현재 페이지</h3>
               <div>
                  <span className="text-orange text-strong">1</span> / <span>1</span> pages
               </div>
            </div>

            <div className="text-align-right margin-top">
               <input type="submit" className="btn-text btn-default" value="일괄공개"/>
               <input type="submit" className="btn-text btn-default" value="일괄삭제"/>
               <a className="btn-text btn-default" href="reg.html">글쓰기</a>
            </div>
            
            <div></div>
            <div></div>

            <div className="margin-top align-center pager">
               
               <div>
                  <span className="btn btn-prev" onClick={()=>{alert('이전페이지가 없습니다.');}} >이전</span>
                  <a className="btn btn-prev" href="list?p=5">이전</a>
               </div>               
               
               <ul className="-list- center">
                  <li>
                     <a className="aa bb cc"  href="?p=1&f=&q=" >1</a>
                  </li>
               </ul>
               <div>
                  <span className="btn btn-next" onClick={()=>{alert('다음 페이지가 없습니다.');}}>다음</span>
                  <a className="btn btn-next">다음</a>
               </div>

            </div>
         </main>;
   }
}


ReactDOM.render(<List />, document.querySelector("#root"));