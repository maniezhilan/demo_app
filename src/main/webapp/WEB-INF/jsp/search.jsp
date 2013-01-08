<%@ include file="/init.jsp"%>

<portlet:actionURL name="bookSearch" var="bookSearchURL"></portlet:actionURL>

<aui:form action="<%=bookSearchURL.toString() %>" method="post" name="searchForm">
<table>
			<tr>
				<td>
				Enter ISBN
				</td>
				<td>
				<input name="isbnNumber" label="ISBN" type="text" value=""/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><aui:button class="aui-button-input" type="submit" value="Search" /></td>
			</tr>
</table>
</aui:form>