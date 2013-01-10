<%@ include file="/init.jsp"%>

<portlet:renderURL var="homeAuthorUrl">
	<portlet:param name="myaction" value="authors" />
</portlet:renderURL>
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
			<td><a href="${homeUrl}">Home</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>Title:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="title" /></td>
			<td><spring:bind path="authors">
  			<c:if test="${status.error}">
    		<img src="<c:url value="/resources/images/warning.png"/>" 
       			width="31" height="32" class="error_tooltip" title="${status.errorMessage}" />
  			</c:if>
			</spring:bind></td>
		</tr>
		<tr>
			<td>Author:<font style="color: #C11B17;">*</font></td>
			<td>
			<form:select path="authors" multiple="true">
				<form:option value="">----Select Author ---</form:option>
				<form:options items="${book.authors}" itemLabel="name" itemValue="id"/>
			</form:select>
			</td><td> <a href="${homeAuthorUrl}">Add Authors</a> </td>
			<td>
			<spring:bind path="authors">
  			<c:if test="${status.error}">
    		<img src="<c:url value="/resources/images/warning.png"/>" 
       			width="31" height="32" class="error_tooltip" title="${status.errorMessage}" />
  			</c:if>
			</spring:bind>
			</td>
		</tr>
		<tr>
			<td>ISBN:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="isbnNumber" /></td>
			<td><spring:bind path="authors">
  			<c:if test="${status.error}">
    		<img src="<c:url value="/resources/images/warning.png"/>" 
       			width="31" height="32" class="error_tooltip" title="${status.errorMessage}" />
  			</c:if>
			</spring:bind></td>
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