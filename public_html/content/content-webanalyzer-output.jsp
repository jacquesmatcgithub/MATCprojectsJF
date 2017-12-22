<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
  <div class = "tabinator">
    <h2>Web Analyzer Output</h2>
    <input type = "radio" id = "tab1" name = "tabs" checked>
    <label for = "tab1">Summary</label>
    <input type = "radio" id = "tab2" name = "tabs">
    <label for = "tab2">Unique Tokens</label>
    <input type = "radio" id = "tab3" name = "tabs">
    <label for = "tab3">Token Size</label>
    <input type = "radio" id = "tab4" name = "tabs">
    <label for = "tab4">Token Count</label>
    <input type = "radio" id = "tab5" name = "tabs">
    <label for = "tab5">Keyword Locations</label>
    <input type = "radio" id = "tab6" name = "tabs">
    <label for = "tab6">Big Words</label>
    <div id = "content1" style="height:400px; width:650px; overflow-y: scroll;">
      <br />
      <pre><c:import url="file:${outputPath}/web_summary_report.txt"/></pre>
    </div>
    <div id = "content2" style="height:400px; width:650px; overflow-y: scroll;">
      <br />
      <pre><c:import url="file:${outputPath}/web_unique_tokens.txt"/></pre>
    </div>
    <div id = "content3"  style="height:400px; width:650px; overflow-y: scroll;">
      <br />
      <pre><c:import url="file:${outputPath}/web_token_size.txt"/></pre>
    </div>
    <div id = "content4"  style="height:400px; width:650px; overflow-y: scroll;">
      <br />
      <pre><c:import url="file:${outputPath}/web_token_count.txt"/></pre>
    </div>
    <div id = "content5"  style="height:400px; width:650px; overflow-y: scroll;">
      <br />
      <pre><c:import url="file:${outputPath}/web_keyword_locations.txt"/></pre>
    </div>
    <div id = "content6"  style="height:400px; width:650px; overflow-y: scroll;">
      <br />
      <pre><c:import url="file:${outputPath}/web_big_words.txt"/></pre>
    </div>
  </div>
</div>

