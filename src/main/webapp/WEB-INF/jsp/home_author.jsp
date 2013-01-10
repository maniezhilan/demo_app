<%@ include file="/init.jsp"%>
<!--<portlet:renderURL var="showAddBookUrl">
	<portlet:param name="myaction" value="addBookForm" />
</portlet:renderURL>

<portlet:renderURL var="showAddAuthorUrl">
	<portlet:param name="myaction" value="addAuthorForm" />
</portlet:renderURL>
<portlet:renderURL var="showUrl">
</portlet:renderURL>
	<table>
		<tr align="left">
			<td><a href="${homeUrl}">Books</a></td>
		</tr>
	</table>
<form:form name="authorForm" method="post" action="${showAddAuthorUrl}">
	
	<c:if test="${not empty authors}">
		<table border="1">
			<tr bgcolor="#99CCFF">
				<td align="center" valign="middle"><b>Author</b></td>
			</tr>
			<c:forEach var="author" items="${authors}">
				<tr>
					<td><c:out value="${author.name}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br></br>

	<table align="right">
		<tr>
			<td><input type="submit" value="Add Author" /></td>
			</form:form>
			<form:form name="bookForm" method="post" action="${showAddBookUrl}">
			<td><input type="submit" value="Add Book" /></td>
			</form:form>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>

<br></br>-->