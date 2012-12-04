<%@ page import="tvguide.TVShow" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main">
    <r:require modules="application, tvShowManage"/>
  </head>
  <body>
    <div id="tvShowFounds">
      <g:each in="${tvShowsFound}" var="tvShowFound">
        <div class="tvShowFound">
          <h3>Title: ${tvShowFound.title} [Search: ${tvShowFound.search}]</h3>
          <g:each in="${tvShowFound.tvShows}" var="tvShow">
            <div class="tvShow">
              <h5>${fieldValue(bean: tvShow, field: "title")}</h3>
              <a class="tvShowRemoveWatch" id="tvShowRemoveWatch_${tvShow.id}" data-id="${tvShow.id}" <g:if test="${!tvShowsWatched.contains(tvShow.id)}">style="display:none"</g:if>>Remove</a>
              <a class="tvShowAddWatch" id="tvShowAddWatch_${tvShow.id}" data-id="${tvShow.id}" <g:if test="${tvShowsWatched.contains(tvShow.id)}">style="display:none"</g:if>>Add</a>
            </div>
          </g:each>
        </div>
      </g:each>
    </div>
  </body>
</html>
