<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View list of participant</title>
</head>
<body>
      
    <table border="1">
    <thead>
        <tr>
            <th>Participant Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Time</th>
            <th>Date</th>
            <th colspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${participants}" var="participant">
            <tr>
                <td><c:out value="${participant.id}" /></td>
                <td><c:out value="${participant.name}" /></td>
                <td><c:out value="${participant.age}" /></td>
                <td><c:out value="${participant.height}" /></td>
                <td><c:out value="${participant.weight}" /></td>
                <td><c:out value="${participant.phonenumber}" /></td>
                <td><c:out value="${participant.email}" /></td>
                <td><c:out value="${participant.time}" /></td>
                <td><c:out value="${participant.jdate}" /></td>
                <td><a href="ParticipantServlet?action=edit&participantId=<c:out value="${participant.id}"/>">Update</a></td>
                <td><a href="ParticipantController?action=delete&participantId=<c:out value="${participant.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p><a href="ParticipantServlet?action=insert">Add Participant</a></p>
    
</body>
</html>