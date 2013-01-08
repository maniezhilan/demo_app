<%@ include file="/init.jsp"%>
<portlet:actionURL var="addBookActionUrl">
	<portlet:param name="myaction" value="addBook" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
	<portlet:param name="myaction" value="books" />
</portlet:renderURL>

<form:form name="addBookForm" commandName="book" method="post"
	action="${addBookActionUrl}">
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
			<td></td>
			<td><font style="color: #C11B17;"></font></td>
		</tr>
		<tr>
			<td>ISBN:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="isbnNumber" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="isbnNumber" /></font></td>
		</tr>
		<tr>
			<td>Summary:<font style="color: #C11B17;"></font></td>
			<td><liferay-ui:input-editor name="summary"/>
				<input name="<portlet:namespace />" type="hidden"/>
			</td>
			<td><font style="color: #C11B17;"><form:errors
				path="summary" /></font></td>
		</tr>
	</table>
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