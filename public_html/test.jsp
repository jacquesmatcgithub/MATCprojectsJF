<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<c:set var = "pageTitle" value="Advanced Java Home" scope="request" />

<html xmlns="http://www.w3.org/1999/xhtml">

  <c:import url="jsp/head-tag.jsp" />

  <body>
    <div id="wrap">
      <c:import url="jsp/header.jsp" />

      <c:import url="jsp/menu.jsp" />

      <c:import url="content/content-test.jsp" />

      <c:import url="jsp/footer.jsp" />
    </div>
  </body>
</html>