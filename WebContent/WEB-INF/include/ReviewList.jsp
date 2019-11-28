<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.bit.dto.GenericUser"%>
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
	REAUser reaUser = (REAUser) request.getAttribute("reaUser");
	String reaId = reaUser.getReaId();
	String genericUserId = (String) session.getAttribute("userId");
	System.out.println("ReviewList userId: " + genericUserId);
	System.out.println("ReviewList reaId: " + reaId);
	
	
	// Review review = new Review();
	// System.out.println("ReviewList review.toString: " + review.toString());
	// java.sql.Date reviewDate = (java.sql.Date) request.getAttribute("reviewDate");
	// String reviewContent = (String) request.getAttribute("reviewContent");
	// int reviewNum = (Integer) request.getAttribute("reviewNum");
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd");
%>
	
<input type="hidden" id="getREAId" value="<%=reaId%>">
<input type="hidden" id="getUserId" value="<%=genericUserId%>">

<section id="id" class="about">
	<div class="container">
		<div class="about_content">
			<div class="container-fluid">
				<div class="card-header py-3">
					<h5 class="m-0 font-weight-bold text-primary">계약자 생생후기</h5>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div>
							<table class="table table-bordered" id="reviewTable"
								style="text-align: center; margin: auto; width: 100%; border: none;">
			                    <tr>
			                        <td style="padding: 0;"><div align="left" style="padding-left: 10px;">
		                        		날짜:&nbsp;<input type="text" id="reviewDate" name="reviewDate" value="<%=sdf.format(today) %>" 
			                        					readonly="readonly" style="display: inline; width: 50%; padding: 0;">
			                       	<td style="padding: 0;"><div align="right" style="padding-right: 10px;">
			                       		작성자:&nbsp;<input type="text" id="userId" name="userId" value="<%=genericUserId%>" 
			                       						readonly="readonly" style="; display: inline; width: 30%; padding: 0;">
			                       		<input type="hidden" id="reaId" name="reaId" value=""></div></td>
			                    </tr>
			                    <tr>
			                    	<td colspan="4" align="left" id="contentTd">
			                    		<textarea id="reviewContent" name="reviewContent" class="ckeditor"
											rows="5" style="resize: none; width: 100%; border: 1px solid #d2d0d0;"></textarea>
									<div align="right">
			                    		<button type="submit" id="insert_review" class="btn btn-primary btn-block btn-lg" name="insert_review">작성 완료</button>
									</div></td>
			                    </tr>
		                   </table>
						</div>
						<div style="margin-top: 20px; margin-bottom: 20px;">
							<hr>
						</div>
						
						
						<form name="review" method="post">
						<!-- 후기글 뿌려지는 곳 -->
						<table style="width: 100%;" id="reviewbody">
						
						<tbody id="tbody">
							<%-- 
									 <tr>
										<td align="left" width="70%">
											<span>${reviewTable.reviewDate}</span></td>
										<td align="right">
											작성자: <span id="reviewId">${reviewTable.userId}</span></td>
									</tr>
									<tr>
										<td colspan="2" style="height: 100px;">
											<textarea rows="3" style="resize: none; width: 100%; border: 1px solid #d2d0d0;" 
												readonly="readonly">${reviewTable.reviewContent}</textarea>
	 											<input type="hidden" id="reviewNum" value="${ reviewTable.reviewNum}">
												<div class="row">
											<div class="col-sm-6">
												<button type="submit"
													class="btn btn-primary btn-block btn-lg" id="signUp">Sign Up</button> 
											</div>
											<div class="col-sm-6">
												<button type="reset"
													class="btn btn-primary btn-block btn-lg">Cancel</button>
											</div>
										</div>
											<hr></td>
											
									</tr>   --%>
									
							</tbody>
							
						</table>
						
						</form>						
						
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
 
<jsp:include page="./ScrollUp.jsp"></jsp:include>

<script type="text/javascript">
	$(function() {
		getReviewList();

	});
	var reaId = $("#getREAId").val();
	var reviewNum = $("#reviewNum").val();

		function getReviewList(){ //리뷰 리스트 가져오기
			$.ajax({
				url:"GetReviewList?reaId="+reaId,
				dataType:"JSON",
				type:"POST",
				success: function(data){
					console.log(data);
					$.each(data,function(index, element){
						var review = "";
						review += "<tr>";
						review += "<td align='left' width='70%'>";
						review += "<span>" + element.reviewDate+ "</span></td>";
						review += "<td align='right'>";
						review += "작성자: <span id='reviewId'>"+element.userId+"</span></td>";
						review += "</tr>";
						review += "<tr>";
						review += "<td colspan='2' style='height: 100px;'>";
						review += "<textarea id='textarea' rows='3' style='resize: none; width: 100%; border: 1px solid #d2d0d0;'>";
						review += element.reviewContent+"</textarea>";
						review += "<input type='hidden' id='reviewNum value='"+element.reviewNum+"'>";
						review += "<div class='row'>"
						review += "<div class='col-sm-6'>"
						review += "<button id='delete_review' class='btn btn-primary btn-block btn-sm'>삭제</button></div>";
						review += "<div class='col-sm-6'>"
						review += "<button id='edit_review' class='btn btn-primary btn-block btn-sm'>수정</button></div>";
						review += "</div></div><hr></td></tr>";					
 						$("#tbody").append(review);
					});
				}
		});
		}
		$('#insert_review').click(function() {
			
			var param = {
					userId : $('#getUserId').val(),
					reviewContent : $('#reviewContent').val(),
					reaId : $('#getREAId').val()
					};
			$.ajax({
				url: 'InsertReview', // kr.or.bit.ajax
				dataType: 'json',
				type: 'post',
				data: param,
				success: function(data) {
					console.log(data);
					getReviewList();
					$("#reviewContent").val("");
					/*
					 $.each(data, function(index, value){
						console.log(value.reviewNum);
						var review = "";
						review += "<tr>";
						review += "<td align='left' width='70%'>";
						review += "<span>" + value.reviewDate+ "</span></td>";
						review += "<td align='right'>";
						review += "작성자: <span id='reviewId'>" + value.userId + "</span></td>";
						review += "</tr><tr>";
						review += "<td colspan='2' style='height: 100px;'>";
						review += "<textarea id='textarea' rows='3' style='resize: none; width: 100%; border: 1px solid #d2d0d0;'>";
						review += value.reviewContent+"</textarea>";
						review += "<div align='right' id='delete_div'>";
						review += "<input type='button' id='delete_review' value='삭제'>";
						review += "<input type='button' id='edit_review' value='수정'>";
						review += "<input type='hidden' id='reviewNum' value='+"+value.reviewNum+"'>";
						review += "</div><hr></td></tr>";						
						$('#tbody').append(review);
						$("#reviewContent").val("");
					});
					*/
				}
			});
		});
		
		$('#delete_review').click(function() {
			var param = {
					reviewNum : $("#reviewNum").val(),
					reaId : $('#getREAId').val()
					};
			$.ajax({
				url:'DeleteReview',
				dataType: 'json',
				data : param,
				type: 'post',
				success:function(data){
					getReviewList();
				}
			})
		});
		/*
		$("#edit_review").click(function(){
			$.ajax({
				url: 'EditReview', // kr.or.bit.ajax
				dataType: 'json',
				type: 'post',
				data: {
					userId: $('#getUserId').val(),
					reviewContent: $('#reviewContent').val(),
					reaId: $('#getREAId').val()
				},
				success: function(data) {
					console.log(data);
				}
		});
			*/
</script>