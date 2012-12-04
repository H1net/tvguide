<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'TVEpisode.label', default: 'TVEpisode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
                <r:require modules="application"/>
	</head>
	<body>
		<a href="#list-mediaFile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
                <h2>The Following Episodes Have Been Added</h2>
		<g:each in="${newEpisodeList}" status="i" var="episode">
                  ${episode.title}<br />
                </g:each>
                <h2>The Following Episodes Have Been Updated</h2>
		<g:each in="${existingEpisodeList}" status="i" var="episode">
                  ${episode.title}<br />
                </g:each>
	</body>
</html>
