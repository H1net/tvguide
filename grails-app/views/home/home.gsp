
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
    [show calender here TODO]
    <h2>Your Shows</h2>
    [print list of shows here TODO]
  </body>
</html>