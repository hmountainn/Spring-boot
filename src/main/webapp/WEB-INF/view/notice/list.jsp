<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<fmt:formatNumber var="num" value="${count/10}" pattern="#"/>
<%-- <fmt:formatNumber var="b" value="${count/10}" pattern="#,###.#"/> --%>


<c:set var="lastPage" value="${num+(count%10==0?0:1)}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../CSS/style copy mainmenu.css" type="text/css" rel="stylesheet">
</head>

<body>
    <div id="root">
        <header id="header">
            <div class="float-content"> 
                
                
                <h1 class="logo"><img src="../images/logo.png" alt="뉴렉처 온라인"></h1>
                <section>
                    <h1 class="d-none">헤더</h1>
                    <nav class="main-menu">
                        <h1 class="d-none">메인메뉴</h1>
                        <ul>
                            <li><a class="redsun" href="" dir="ltr">학습가이드</a></li>
                            <li><a href="">강좌선택</a></li>
                            <li><a href="">AnswerIs</a></li>
                        </ul>
                    </nav>
                    <section class="lecture-search-form">
                        <h1 class="d-none">강좌검색폼</h1>
                        <form>
                            <fieldset>
                                <legend class="d-none">과정 검색 필드</legend>
                                <label>과정검색</label>
                                <input id="a1" type="text">
                                <input class="button" type="submit" value="검색">
                            </fieldset>
                        </form>
                    </section>

                    <nav class="member-menu">
                        <h1 class="d-none">회원메뉴</h1>
                        <ul>
                            <li><a href="index.html">HOME</a></li>
                            <li><a href="member/login.html">로그인</a></li>
                            <li><a href="">회원가입</a></li>
                        </ul>
                    </nav>
                
                    <nav class="customer-menu">
                        <h1 class="d-none">고객센터메뉴</h1>
                        <ul>
                            <li><a class="button mypage-button" href="">마이페이지</a></li>
                            <li><a class="button customer-button" href="">고객센터</a></li>
                        </ul>
                    </nav>
                </section>
            </div>
        </header>

        <div id="visual">
            <div class="float-content">

            </div>
        </div>


        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <h1>고객센터</h1>
                    <nav class="main-aside-menu">
                        <h1>고객센터메뉴</h1>
                        <ul>
                            <li><a class="current" href="list.html">공지사항</a></li>
                            <li><a href="">자주하는 질문</a></li>
                            <li><a href="">수강문의</a></li>
                            <li><a href="">이벤트</a></li>
                        </ul>
                    </nav>

                    <nav class="aside-menu recommend-aside-menu">
                        <h1>협력업체 ${a}</h1>
                        <ul>
                            <li><a class="img img-notepubs" href="">노트펍스</a></li>
                            <li><a class="img img-namoolab" href="">나무랩연구소</a></li>
                        </ul>
                    </nav>
                </aside>

                <main id="main">
                <%for(int i=0; i<5; i++){ %>
                	<div>hello</div>
            		<% } %>
                    <section>
                        <h1 class="main-title">공지사항</h1>

                        <section class="breadcrumb">
                            <h1 class="d-none">경로</h1>
                            <ol>
                                <li>home</li>
                                <li>고객센터</li>
                                <li>공지사항</li>
                            </ol>
                        </section>

                        <section class="search-form">
                            <h1>검색폼</h1>
                            <form action="list" method="get">
                            	<label class="d-none">검색분류</label>
                            	<%-- <%
                            		String selectedTitle = "";
                            		String selectedWriterId = "";
                            		
                            		if(field.equals("title"))
                            			selectedTitle = "selected";
                            		
                            		if(field.equals("writer_id"))
                            			selectedWriterId = "selected";
                            	%> --%>
								<select name="f">
									<option value="">분류선택</option>
									<option ${param.f=='title'?'selected':''} value="title">제목</option>
									<option ${param.f=='writer_id'?'selected':''} value="writer_id">작성자</option>
								</select>
								<label class="d-none">검색어</label>
								<input type="text" name="q" value="${param.q}">
								<input type="submit" value="검색">
                            </form>
                        </section>

                        <section class="mt-3">
                            <h1 class="d-none">공지사항 목록</h1>
                            <table class="table">
                                <thead>
                                    <tr>                                  
                                        <td class="w-1">번호</td>
                                        <td class="truncate">제목</td>
                                        <td class="w-2">작성자</td>
                                        <td class="w-2">작성일</td>                                   
                                        <td class="w-1">조회수</td>
                                    </tr>
                                </thead>
                               
                                <tbody>
                                <c:forEach var="n" items="${list}">
                                   <tr>
                                       <td class="w-1">${n.id}</td>
                                       <td class="truncate text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
                                       <td class="w-2">${n.writerId}</td>
                                       <td class="w-2"><fmt:formatDate value="${n.regDate}" pattern="yyyy년 MM월 dd일"/></td>
                                       <td class="w-1">${n.hit}</td>
                                   </tr>
                                </c:forEach> 
                                </tbody>
                            </table>
                            
                            <div>
                            	<a href="reg">글쓰기</a>
                            </div>
                            
                        </section>

                        <section class="page-status mt-3">
                            <h1 class="d-none">현재 페이지 정보</h1>

                            <div>
                            	<c:set var="lastPage" value="${count/10 + (count%10==0?0:1)}"/> <!-- ex) 5.8 -->
                                <c:set var="lastPage" value="${fn:substringBefore(lastPage,'.')}"/> <!-- 소수점 없앰 -->
                                <span class="text-strong">${(empty param.p)?1:param.p}</span> / ${lastPage} pages
                            </div>
                        </section>	
                        <nav class="pager mt-3">
                            <h1 class="d-none">페이저</h1>
                            <div class="button">이전</div>
                            <ul>
                            <c:set var="page" value="${empty param.p?1:param.p}"/>
                            <c:forEach var="num" begin="1" end="5">
                            	<c:if test="${num <= lastPage}">
                            	<li><a class="${(page == num)?'text-strong':''}" href="list?p=${num}&f=${param.f}&q=${param.q}">${num}</a></li>
                            	</c:if>
                            </c:forEach>
<%--                             <%for(int i=0; i<5; i++){ %>
                            	<%if(i+1<=lastPage) {%>
                                <li><a class="<%=page_==i+1?"text-strong":""%>" href="list?p=<%=i+1 %>&f=<%=field %>&q=<%=query %>"><%=i+1 %></a></li>
                            	<%} %>
                            <%} %> --%>
                            </ul>
                            <div class="button">다음</div>
                        </nav>
                    </section>
                </main>
                <!-- <aside id="quick-menu">
                        <h1>퀵메뉴</h1>
                        <ul>
                            <li>MyHome</li>
                            <li>학습방</li>
                        </ul>
                    </aside> -->
            </div>
        </div>


        <footer id="footer">
            <div class="float-content">
                <!-- 회사정보
        Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information -->
            </div>
        </footer>
    </div>

</body>


</html>