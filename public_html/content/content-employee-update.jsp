<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="padding-left:10px">
    <h2>Employee Search Results</h2>
    <h3>${searchmessage}</h3>
</div>

<div id="content" style="padding-left:10px; height:470px; width:650px; overflow-y: scroll; position: absolute; top:160px"">
    <c:if test="${searchmessage.equals(\"\")}">
        <c:forEach var="employee" items="${searchResults}">
            <form method="POST" action="Project4Update">
                <table cellspacing="10">
                    <tr><td>First Name</td>
                        <td><input type="text" value="${employee.firstName}" name="firstName" size="30" maxlength="25" autofocus></td>
                    </tr>
                    <tr><td>Last Name</td>
                        <td><input type="text" value="${employee.lastName}" name="lastName" size="30" maxlength="30"></td>
                    </tr>
                    <tr><td>SSN</td>
                        <td><input type="text" value="${employee.ssn}" name="employeeSSN" size="30" maxlength="20"></td>
                    </tr>
                    <tr><td>Department</td>
                        <td><input type="text" value="${employee.department}" name="department" size="30" maxlength="10"></td>
                    </tr>
                    <tr><td>Room</td>
                        <td><input type="text" value="${employee.room}" name="roomNumber" size="30" maxlength="10"></td>
                    </tr>
                    <tr><td>Phone</td>
                        <td><input type="text" value="${employee.phone}" name="phoneNumber" size="30" maxlength="10"></td>
                    </tr>
                    <tr><td><br /><input type="submit" value="Update"></td></tr>
                </table>
            </form>
        </c:forEach>
    </c:if>
</div>
