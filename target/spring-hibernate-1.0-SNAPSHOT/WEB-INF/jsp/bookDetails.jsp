<%@ include file="/init.jsp"%>
<portlet:renderURL var="homeUrl">
	<portlet:param name="myaction" value="books" />
</portlet:renderURL>
	<table>
		<tr align="left">
			<a href="${homeUrl}">Home</a>
		</tr>
	</table>
	<table border="1">
          <c:out value="${param.book}"/>
		<tr>
			<td bgcolor="#99CCFF"><b>Title:</b><font style="color: #C11B17;"></font></td>
			<td>${book.title}</td>
		</tr>
		<tr>
			<td bgcolor="#99CCFF"><b>Author:</b><font style="color: #C11B17;"></font></td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td bgcolor="#99CCFF"><b>ISBN:</b><font style="color: #C11B17;"></font></td>
			<td>${book.isbnNumber}</td>
		</tr>
		<tr>
			<td bgcolor="#99CCFF"><b>Summary:</b><font style="color: #C11B17;"></font></td>
			<c:set var="fck_summary" value="${book.summary}"/>
			<td>${fck_summary}</td>
			
		</tr>
	</table>
	
<br></br>