<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
	
<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body id="page-top">
	<!-- Page Wrapper -->

	<%@include file="../include/header.jsp"%>

	<!-- Begin Page Content -->
	

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시판</h1>


		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 샘플 게시판
                    <button type="button" class="btn btn-primary btn-sm float-right" onclick="location.href='register?pageNum=${pageMarker.cri.pageNum}'">글쓰기</button>
                </h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
			
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="good" items="${board_list}" varStatus="num">
							<tr>
								<td>${good.num }</td>
								<!-- 7. 조회페이지로 이동  -->
								<!-- 상세페이지 이동후 목록 페이지로 이동 , 기존 페이지로 유지하지 못하는 문제가 있다.
								상세, 수정 화면으로 이동할때 항상 pageNum과 count를 가지고 다녀야한다.
								변경했다면 , content요청에서 변경합니다.-->
								<td>
								<a href="viewContent?num=${good.num}&pageNum=${pageMarker.cri.pageNum }&
								&count=${pageMarker.cri.count }">
								${good.title }</a>
								<!--  <a href="viewContent?num=${good.num}">${good.title }</a>-->
								</td>
								<td>${good.writer }</td>
								<td>
								<f:formatDate value="${good.regdate }" pattern="yyyy-MM-dd"/> 
								</td>
								<td>
								<f:formatDate value="${good.updatedate }" pattern="yyyy-MM-dd hh:mm:ss"/>
								
								</td>
							</tr>
							</c:forEach>
						</tbody>
						
					</table>
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					
					<ul class="pagination justify-content-center">
					<!--1. 이전 페이지 실행 -->
					 <c:if test="${pageMarker.prev}">
                       	 			<li class="page-item">
                       	 			<!--6. 이전페이지 활성화 링크
                       	 			시작페이지는 startpage가11일때 활성화 됩니다. -->
                       	 			<!-- 이전 페이지를 클릭했을때, startpage-1 을 하게 되면10을 페이지 넘으로 넘겨준다.
                       	 			getPageStart()을 통해 mybatis에 값이 전달..... -->
							<a class="page-link" href="list?pageNum=${pageMarker.startPage -1}">Previous</a>
						</li>
						</c:if>
						<!--2. 페이지 번호 활성화 여부 -->
					
					   <c:forEach var="num" begin="${pageMarker.startPage}" end="${pageMarker.endPage}">
					    	<!-- 4-1 #active 속성을 이용하여 활성화 버튼을 연결 -->
					    <li class="page-item ${pageMarker.cri.pageNum.equals(num) ? 'active' : '' }">

					    	<!-- 4.list 요청으로 페이지 번호를 전달, 자동으로 count=10(보여질 페이지 수)  -->
						    <!-- 사용자가 버튼을 클릭시에, 해당 버튼의 페이지 번호를 criteria에 전달 -->
					    	
					   	<a class="page-link" href="list?pageNum=${num}">${num }</a>
					    </li>
					   </c:forEach>
					   
					   <!-- 3.다음 페이지 활성화 여부 -->
					   <c:if test="${pageMarker.next }">
					    <li class="page-item">
					    
					    <!-- 5.pageMarker endPage 화면에 보여지는 끝번호10이 들어있기 때문에 
					    	1이 증가한 11pageNum(페이지 번호)에 전달합니다.
					    	11이 criteria클래스에 pageNum(setter)에 전달되고,
					    	getPageStart()를 통해 mybatis 쿼리에 전달한다.
					    	
					    	
					    	-->
					      <a class="page-link" href="list?pageNum=${pageMarker.endPage +1}">Next</a>
					    </li>
					    </c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>
</body>

</html>
