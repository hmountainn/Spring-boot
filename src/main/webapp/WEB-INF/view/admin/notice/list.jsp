<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
                                <c:forEach var="n" items="${list}" varStatus="st">
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
                            </ul>
                            <div class="button">다음</div>
                        </nav>
                    </section>
                </main>