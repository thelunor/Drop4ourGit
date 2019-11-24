<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bit.dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<meta charset="UTF-8">
	<title>중개사 후기 목록</title>
	
	<%
		List<Review> review = (ArrayList<Review>) request.getAttribute("rvList");
	%>
	
<script>
	$(function() {
		$('#insert_review').click(function() {
			
		})
	})
</script>

<div>
	<section>
		<h4><div>후기</div></h4>
		<div>
			<div>
				<h6>계약을 완료한 분들의 후기</h6>
			</div>
			<div style="margin-top: 20px; margin-bottom: 20px;">
				<hr>
			</div>
				<!-- <form name="review" action="" method="post" style="width: 100%;">
					<table style="border: 0;">
						<tr>
							<td style="text-align: right;">
								<span>
									날짜:
								</span>
							</td>
							<td>
								<input type="text" id="selectdate" placeholder="날짜입력" 
									style="text-align: left;" readonly>
							</td>
							<td align="right">
								<label>작성자: </label>
							</td>
							<td align="left">
								<input type="text" id="review_wrtier" name="review_writer" style="border-bottom: 1px solid #d2d0d0">									
							</td>
						</tr>
						<tr>
							<td align="left" colspan="3" width="100%">
								<textarea id="summernote" name="content" class="ckeditor"
									rows="5" cols="100" style="resize: none;"></textarea>
							</td>
						</tr>
						<tr>
							<td align="right" colspan="4">
								<input type="button" value="확인" onclick="">
							</td>
						</tr>
					</table>
				</form> -->
				
				<form name="review" action="" method="post">
					<table width="95%">
	                    <tr>
	                        <td align="left">날짜:&nbsp;</td>
	                        <td align="left"><input type="text" id="review_date" name="review_date" 
	                        					placeholder="날짜입력" style="border: 1px solid #d2d0d0;"></td>
                        	<td align="left">작성자:&nbsp;</td>
                        	<td><input type="text" id="review_writer" name="review_writer" 
                        						placeholder="작성자아이디" style="border: 1px solid #d2d0d0;"></td>
	                    </tr>
	                    <tr>
	                    	<td colspan="4" align="left">
	                    		<textarea id="summernote" name="review_content" class="ckeditor"
									rows="5" cols="100" style="resize: none;"></textarea></td>
	                    </tr>
	                    <tr>
	                    	<td colspan="4" align="right">
	                    		<input type="button" id="insert_review" name="insert_review" value="확인" onclick="insert_review()">
	                    	</td>
	                    </tr>
                    </table>
				</form>
				
			<div style="margin-top: 20px; margin-bottom: 20px;">
				<hr>
			</div>
			<table style="width: 100%;">
				<tr>
					<td align="left" width="70%">
						<span>2019.01.01.</span>
					</td>
					<td align="right">
						작성자: <span>김김김</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="border: 1px solid #d2d0d0; height: 120px;">
						방은 좋고
					</td>
				</tr>
			</table>
			<div style="margin-top: 20px; margin-bottom: 20px;">
				<hr>
			</div>
			<table style="width: 100%;">
				<tr>
					<td align="left">
						<span>2019.01.01.</span>
					</td>
					<td align="right">
						작성자: <span>김김김</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="border: 1px solid #d2d0d0; height: 120px;">
						방은 좋고
					</td>
				</tr>
			</table>
			<div style="margin-top: 20px; margin-bottom: 20px;">
				<hr>
			</div>
			
			<!--이전 링크 --> <!-- 아직 구현 안 함 -->
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
			</c:if>
		</div>
	</section>
</div>