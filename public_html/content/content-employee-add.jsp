<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="padding-left:10px">
  <h2>Add Employee</h2>
  <h3>${project4AddMessage}</h3>
</div>

<c:set var="project4AddMessage" value="" scope="session" />

<div id="content" style="position:absolute; top:140px;">
  <form method="POST" action="Project4Add">
    <table cellspacing="10">
      <tr><td>First Name</td>
          <td><input type="text" name="firstName" size="30" maxlength="25" autofocus></td>
      </tr>
      <tr><td>Last Name</td>
          <td><input type="text" name="lastName" size="30" maxlength="30"></td>
      </tr>
      <tr><td>SSN</td>
          <td><input type="text" name="employeeSSN" size="30" maxlength="20"></td>
      </tr>
      <tr><td>Department</td>
          <td><input type="text" name="department" size="30" maxlength="10"></td>
      </tr>
      <tr><td>Room</td>
          <td><input type="text" name="roomNumber" size="30" maxlength="10"></td>
      </tr>
      <tr><td>Phone</td>
          <td><input type="text" name="phoneNumber" size="30" maxlength="10"></td>
      </tr>
      <tr><td><br /><input type="submit" value="Add"></td></tr>
    </table>
  </form>
</div>
