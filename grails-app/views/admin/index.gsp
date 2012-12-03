<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <h1>Admin</h1>
    <h2>Links</h2>
    <sec:ifAllGranted roles="ROLE_ADMIN">
      <ul>
        <li><g:link controller="TVShow" action="importer">Import Shows</g:link></li>
        <li><g:link controller="TVEpisode" action="importer">Import Episodes</g:link></li>
      </ul>
    </sec:ifAllGranted>
  </body>
</html>