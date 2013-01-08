<%@ include file="/init.jsp"%>
<portlet:resourceURL var="removeBook" id="deleteBook" escapeXml="false" />

<script type="text/javascript">
$(document).ready(function() {
    $("input").click(function(event) {
        var rowid = event.target.id;
        RemoveBook(rowid);
    });
});
function RemoveBook(row_id) {
	console.log(row_id);
    $.ajax({
    type: "POST",
    url: "<%=renderResponse.encodeURL(removeBook.toString())%>",
    data: {isbnNumber:row_id},
    success: function(msg) {
    	console.log(msg);
    	var div = document.getElementById(row_id);
	    if(msg == 0){
	    	div.innerHTML = "No books";		
	    }else{
        	div.innerHTML = "";
	    }
	    
    }
    });
}
</script>


<portlet:renderURL var="showAddBookUrl">
	<portlet:param name="myaction" value="addBookForm" />
</portlet:renderURL>
<portlet:renderURL var="showUrl">
</portlet:renderURL>

	<h3><%=welcome_message%></h3>
<form:form name="catalogForm" method="post" action="${showAddBookUrl}">
	<c:if test="${not empty books}">
		<table border="1">
			<tr bgcolor="#99CCFF">
				<td align="center" valign="middle"><b>Title</b></td>
				<td align="center" valign="middle"><b>Author</b></td>
				<td align="center" valign="middle"><b>ISBN Number</b></td>
				<td align="center" valign="middle"><b>Summary</b></td>
				<td align="center" valign="middle"><b>ACTION</b></td>
			</tr>
			<c:forEach var="book" items="${books}">
				<tr id="${book.isbnNumber}">
					<td valign="middle">
					<a href="
						<portlet:renderURL>
							<portlet:param name="myaction" value="editBookForm" />
							<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
						</portlet:renderURL>					
					"><b><c:out value="${book.title}" /></b></a>
					</td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.isbnNumber}" /></td>
					<c:set var="fck_summary" value="${book.summary}"/>
					<td>${fck_summary}</td>
					<td align="center" valign="middle" width="100px">
					<input type="button" id="${book.isbnNumber}" value="Delete"/>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br></br>
	<table align="right">
		<tr>
			<td><input type="submit" value="Add Book" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<br></br>