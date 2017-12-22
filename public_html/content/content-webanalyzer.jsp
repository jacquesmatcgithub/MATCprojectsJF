<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="padding-left:10px">
  <h2>Token Analyzer</h2>
  <br />
  <h4>${webAnalyzerMessage}</h4>
</div>

<c:set var="webAnalyzerMessage" value="" scope="session" />

<div id="content" style="position:absolute; top:160px;">
  <form action="project4WebAnalyzer" method="POST" enctype="multipart/form-data">
    <table cellspacing="10">
      <tr>
        <td>Select token file to analyze:</td>
        <td><input type="file" name="tokenFile" accept=".txt"></td>
      </tr>
      <tr>
        <td>Select keyword file to use:</td>
        <td><input type="file" name="keywordFile" accept=".txt"></td>
      </tr>
      <tr><td><br/><input type="submit" value="Analyze"></td></tr>
    </table>
  </form>
</div>
