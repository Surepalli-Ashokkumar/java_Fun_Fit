<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Participant</title>
</head>
<body>
<form method="POST" action='ParticipantServlet' name="frmAddParticipant">
    Participant ID: <input type="text" readonly="readonly" name="participantId"
        value="<c:out value="${participant.id}" />" /> <br />
    Name: <input type="text" name="participantname"
        value="<c:out value="${participant.name}" />" /> <br />
    Age: <input type="text" name="participantage"
        value="<c:out value="${participant.age}" />" /> <br />
    Height: <input type="text" name="participantHeight"
        value="<c:out value="${participant.height}" />" /> <br />
    Weight: <input type="text" name="participantweight"
        value="<c:out value="${participant.weight}" />" /> <br />
    Phone Number: <input type="text" name="participantnumber"
        value="<c:out value="${participant.phonenumber}" />" /> <br />
    Email: <input type="text" name="participantemail"
        value="<c:out value="${participant.email}" />" /> <br />
    Time: <input type="text" name="participanttime"
        value="<c:out value="${participant.time}" />" /> <br />
    Date: <input type="text" name="participantDate"
        value="<c:out value="${participant.jdate}" />" /> <br />

    <input type="submit" value="Submit" />
</form>

</body>
</html>