<%@ include file="/init.jsp"%>
<portlet:actionURL var="editBookActionUrl">
	<portlet:param name="myaction" value="editBook" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
	<portlet:param name="myaction" value="books" />
</portlet:renderURL>
<form:form name="editBookForm" commandName="book" method="post"
	action="${editBookActionUrl}">
	<table>
		<tr align="left">
			<a href="${homeUrl}">Home</a>
		</tr>
	</table>
	<table>
		<tr>
			<td>Title:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="title" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="title" /></font></td>
		</tr>
		<tr>
			<td>Author:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="author" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="author" /></font></td>
		</tr>
		<tr>
			<td>ISBN:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="isbnNumber" readonly="true"/></td>
			<td><font style="color: #C11B17;"><form:errors
				path="isbnNumber" /></font></td>
		</tr>
		<tr>
			<td>Summary:<font style="color: #C11B17;">*</font></td>
			<c:set var="fck_summary" value="${book.summary}"/>
			<td><aui:field-wrapper>
		       			<liferay-ui:input-editor initMethod="initEditor" name="summary"/>
		       			<script type="text/javascript">
				         function <portlet:namespace />initEditor() {
				          return "<%=UnicodeFormatter.toString((String)pageContext.getAttribute("fck_summary"))%>";
				         }
				       </script>
	  			   </aui:field-wrapper>
				<input name="<portlet:namespace />" type="hidden" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="summary" /></font></td>
		</tr>
	</table>
	<table align="right">
		<tr>
			<td><input type="submit" value="Update Book" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<br></br>