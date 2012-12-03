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
          <h3 <g:if test="${tvShowsWatched.contains(tvShow.id)}">style="color:green"</g:if>>${fieldValue(bean: tvShow, field: "title")}</h3>
          <g:if test="${tvShowsWatched.contains(tvShow.id)}">
              <a class="tvShowRemoveWatch" id="tvShowRemoveWatch_${fieldValue(bean: tvShow, field: "id")}">Remove</a>
          </g:if>
          <g:else>
            <a class="tvShowAddWatch" id="tvShowAddWatch_${fieldValue(bean: tvShow, field: "id")}">Add</a>
          </g:else>
        </div>
      </g:each>
      <div class="pagination">
        <g:paginate total="${tvShowTotal}"/>
      </div>
    </div>
  </body>
</html>
