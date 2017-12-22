<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="padding-left:10px">
  <h2>Employee Search Results</h2>
  <h3>${searchmessage}</h3>
</div>

<div id="content" style="padding-left:10px; height:470px; width:650px; overflow-y: scroll; position: absolute; top:160px"">
  <c:if test="${searchmessage.equals(\"\")}">
    <table cellspacing="15">
      <tr>
        <th>ID</th><th>First Name</th><th>Last Name</th><th>SSN</th>
        <th>Department</th><th>Room</th><th>Phone</th>
      </tr>
      <c:forEach var="employee" items="${searchResults}">
        <tr>
          <td>${employee.employeeId}</td>
          <td>${employee.firstName}</td>
          <td>${employee.lastName}</td>
          <td>${employee.ssn}</td>
          <td>${employee.department}</td>
          <td>${employee.room}</td>
          <td>${employee.phone}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</div>
