<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="padding-left:10px;">
  <h2>Employee Search</h2>
  <br />
  <form action="Project4Search" method="GET">
    <table>
      <tr>
        <td>Search: <input type="text" name="searchTerm" autofocus><br /> </td>
        <td style="padding:10px;">
            <input type="radio" name="searchType" value="LASTNAME" checked>Last Name<br />
            <input type="radio" name="searchType" value="FIRSTNAME"> First Name<br />
            <input type="radio" name="searchType" value="ID"> Employee ID<br />
        </td>
      </tr>
      <tr><td><input type="submit" name="" value="Search" /> </td></tr>
    </table>
  </form>
</div>