<%@page import="sun.reflect.generics.visitor.Reifier"%>
<%@page import="kr.or.bit.dao.ReviewDao"%>
<%@page import="kr.or.bit.dto.REAImage"%>
<%@page import="kr.or.bit.dto.REAUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bit.dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
	<html class="no-js" lang="en">
	<meta charset="UTF-8">
	<title>중개사 후기 목록</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- CSS style -->
	<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
		<!-- include summernote css/js-->
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

	<jsp:include page="../../css/css.jsp" />
	
<%	
	List<Review> reviewList = (ArrayList<Review>) request.getAttribute("rvList");
	
	String reaId = (String) session.getAttribute("reaId");
	String userId = (String) session.getAttribute("userId");
	System.out.println("ReviewList userId: " + userId);
	System.out.println("ReviewList reaId: " + reaId);
	Review review = new Review();
	System.out.println("ReviewList review.toString: " + review.toString());
	// java.sql.Date reviewDate = (java.sql.Date) request.getAttribute("reviewDate");
	// String reviewContent = (String) request.getAttribute("reviewContent");
	// int reviewNum = (Integer) request.getAttribute("reviewNum"); 
%>
	
<c:set var="reviewList" value="<%=reviewList%>"></c:set>

<section id="id" class="about">
	<div class="container">
		<div class="about_content">
			<div class="container-fluid">
				<div class="card-header py-3">
					<h5 class="m-0 font-weight-bold text-primary">계약자 생생후기</h5>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						
						<form action="InsertReviewService.d4b" method="post">
							<table class="table table-bordered" id="reviewTable"
								style="text-align: center; margin: auto; width: 100%; border: none;">
			                    <tr>
			                        <td style="padding: 0;"><div align="left" style="padding-left: 10px;">날짜:&nbsp;
			                        	<input type="text" id="reviewDate" name="reviewDate" placeholder="날짜입력" 
			                        		style="border: 1px solid #d2d0d0; display: inline; width: 50%; padding: 0;">
										<input type="hidden" id="reviewNum" name="reviewNum" value=""></div></td>
			                       	<td style="padding: 0;"><div align="right" style="padding-right: 10px;">작성자:&nbsp;
			                       		<input type="text" id="userId" name="userId" placeholder="작성자아이디" 
			                       			style="border: 1px solid #d2d0d0; display: inline; width: 50%; padding: 0;">
			                       		<input type="hidden" id="reaId" name="reaId" value=""></div></td>
			                    </tr>
			                    <tr>
			                    	<td colspan="4" align="left">
			                    		<textarea id="reviewContent" name="reviewContent" class="ckeditor"
											rows="5" style="resize: none; width: 100%; border: 1px solid #d2d0d0;"></textarea>
									<div align="right">
			                    		<input type="button" id="insert_review" name="insert_review"  
			                    			value="확인">
									</div></td>
			                    </tr>
		                   </table>
						</form>
						
						<div style="margin-top: 20px; margin-bottom: 20px;">
							<hr>
						</div>
						
						<table style="width: 100%;" id="reviewbody">
							<c:forEach var="reviewTable" items="<%=reviewList%>" varStatus="status">
									<tr>
										<td align="left" width="70%">
											<span id="reviewDate">${reviewTable.reviewDate}</span></td>
										<td align="right">
											작성자: <span id="userId">${reviewTable.userId}</span></td>
									</tr>
									<tr>
										<td colspan="2" style="border: 1px solid #d2d0d0; height: 120px;" id="reviewContent">
											${reviewTable.reviewContent}</td>
									</tr>
									<tr>
										<td colspan="2">
											<div style="margin-top: 20px; margin-bottom: 20px;">
												<hr>
											</div>
										</td>
									</tr>
							</c:forEach>
						</table>
						
<%-- 						<!--이전 링크 --> <!-- 아직 구현 안 함 -->
						<c:if test="${cpage>1}">
							<a href="board_list.jsp?cp=${cpage-1}&ps=${pagesize}">이전</a>
						</c:if> 
						<!--페이지 리스트 구현  -->
						<c:forEach var="i" begin="1" end="${pagecount}" step="1">
							<c:choose>
								<c:when test="${cpage==i}">
									<font color='red'>[${i}]</font>
								</c:when>
								<c:otherwise>
									<a href="board_list.jsp?cp=${i}&ps=${pagesize}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <!--다음 링크 --> <c:if test="${cpage<pagecount}">
							<a href="board_list.jsp?cp=${cpage+1}&ps=${pagesize}">다음</a>
						</c:if> --%>
			
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- scroll up-->
<jsp:include page="./ScrollUp.jsp"></jsp:include>

<script type="text/javascript">
	$(function() {
		$('#insert_review').click(function() {
			$.ajax({
				url: 'InsertReview', // kr.or.bit.ajax
				dataType: 'json',
				type: 'post',
				data: {
					reaId: "",
					userId: "",
					reviewContent: "",
					reviewDate: "",
					reviewNum: ""
				},
				success: function(insertReview) {
					var review = "";
						review += "<tr>";
						review += "<td align='left' width='70%'>";
						review += "<span>" + $('#reviewDate').val() + "</span></td>";
						review += "<td align='right'>";
						review += "작성자: <span>" + $('#userId').val() + "</span></td>";
						review += "</tr>";
						review += "<tr>";
						review += "<td colspan='2' style='border: 1px solid #d2d0d0; height: 120px;'>";
						review += $('#reviewContent').val() + "</td>";
						review += "</tr>";
						review += "<tr>";
						review += "<td colspan='2'>";
						review += "<div style='margin-top: 20px; margin-bottom: 20px;'>";
						review += "<hr></div></td></tr>";
						
						$('#reviewbody').append(review);
				}
			})
		})
	})
</script>




	
	