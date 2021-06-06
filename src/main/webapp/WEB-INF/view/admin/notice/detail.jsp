<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        
						<table border="1">
                        	<tr>
                        		<th>제목</th>
                        		<td colspan="3">${notice.title}</td>
                        	</tr>
                        	<tr>
                        		<th>작성일</th>
                        		<td colspan="3"><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
                        	</tr>
                        	<tr>
                        		<th>작성자</th>
                        		<td>${notice.writerId}</td>
                        		<th>조회수</th>
                        		<td>${notice.hit}</td>
                        	</tr>
                        	<tr>
                        		<th>첨부파일</th>
                        		<td colspan="3">
                        			<c:forTokens var="fileName" items="${notice.files}" delims="," varStatus="st">
                        				<a download href="/upload/${fileName}">${fileName}</a>
                        				<c:if test="${!st.last}"> <!-- 마지막빼고 구분자넣기 -->
                        					|
                        				</c:if>
                        			</c:forTokens>
                        		</td>
                        	</tr>
                        	<tr>
                        		<td colspan="4">
                        			${notice.content}
                        		</td>
                        	</tr>
                        </table>
						<div>
							<a href="list">목록</a>
							<a href="edit?id=${notice.id}">수정</a>
							<a href="del?id=${notice.id}" onclick="if(!confirm('삭제할겨?')) return false;">삭제</a>
						</div>
                    </section>
                </main>