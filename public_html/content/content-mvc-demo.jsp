<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="height:470px; width:500px; overflow-y: scroll;">
  <h3>MVC Demo</h3>

  <p><b>Data from my bean:</b> ${myCoolBean.data}
    <br />
    <b>Description:</b> ${myCoolBean.description}
  </p>
  <p><b>Here is a picure:</b></p>
  <img src="images/${myCoolBean.pictureName}" width="75%" />
  <p>This is so cool!!!!</p>
  <a href="/java112/">Home</a>
</div>