
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <h1>Dashboard</h1>
    <h2>Links</h2>
    <ul>
      <sec:ifAllGranted roles="ROLE_ADMIN">
        <li><g:link controller="Admin">Admin</g:link></li>
      </sec:ifAllGranted>
      <li><g:link controller="TVShow" action="list">Shows</g:link></li>
    </ul>
    <h2>Calendar</h2>
    <div id="days">
      <g:each in="${days}" var="day">
        <div class="day">
          <h3>${day.date.format("EEE, MMM d, ''yy")}</h3>
          <ul>
            <g:each in="${day.tvEpisodes}" var="tvEpisode">
              <li><a href="http://nzbmatrix.com/nzb-search.php?search=${tvEpisode.show.title.encodeAsURL()}+S${tvEpisode.season}E<g:if test="${tvEpisode.episode<10}">0</g:if>${tvEpisode.episode}&cat=0" target="_blank">[nzb]</a> <a href="${createLink(controller: 'TVShow', action:'show', id: tvEpisode.show.id)}">${tvEpisode.show.title}</a> - ${tvEpisode.season}x${tvEpisode.episode} - <a href="${tvEpisode.tvrage}" target="_blank">${tvEpisode.title}</a></li>
            </g:each>
          </ul>
        </div>
      </g:each>
    </div>
    <h2>Your Shows</h2>
    <div id="tvShows">
      <g:each in="${tvShowsWatched}" var="tvShow">
        <div class="tvShow">
          <h4>${tvShow.title}</h4>
        </div>
      </g:each>
    </div>
  </body>
</html>