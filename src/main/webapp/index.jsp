<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="RestServiceBean" scope="page" type="org.example.RestServiceBean"/>
<!DOCTYPE html>
<html>
<head>
    <title>HomeWork 14</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h3>SYSTEM VARIABLES</h3>
<table>
    <colgroup>
        <col style="background-color:#ff564f">
        <col style="background-color:#33d1ff">
    </colgroup>
    <tr>
        <th>NAME</th>
        <th>PATH</th>
    </tr>
    <tr>
        <c:set var="bean" value="${RestServiceBean}"/>
        <c:set var="array" value="${bean.toList()}"/>
        <c:forEach items="${array}" var="string">
        <td><c:out value="${string}"/>/td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
