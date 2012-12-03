<%@ page import="tvguide.TVShow" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main">
    <r:require modules="application, tvShowManage"/>
  </head>
  <body>
    <div id="tvShows">
      <g:each in="${tvShows}" var="tvShow">
        <div class="tvShow">
          <h3>${fieldValue(bean: tvShow, field: "title")}</h3>
        </div>
      </g:each>
      <div class="pagination">
        <g:paginate total="${tvShowTotal}"/>
      </div>
    </div>
  </body>
</html>
