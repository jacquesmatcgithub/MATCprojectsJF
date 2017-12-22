<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org">
 
    <title>Include Example Main Page</title>
  </head>
 
  <body>
  <h1>Include Example Main Page</h1>
   
  <p>This content is from the main page.</p>
   
   
  <%-- 
    The following line will insert the contents of the file 
    before translation.
  --%>
   <c:import url="include-example-included.jsp" /> 
   
  </body>
</html>