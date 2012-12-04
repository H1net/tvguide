package tvguide

import grails.plugins.springsecurity.Secured

class HomeController {
    
    def springSecurityService
    
    def index() { }
    
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def home() {
        List tvShowsWatched = []
        User.get(springSecurityService.principal.id).watching.each() { tvShowWatcher ->
            tvShowsWatched.add(tvShowWatcher.show)
        }
        
        List days = []
        Date dateToday = new Date().clearTime()
        for(Integer i=-10; i<11; i++) {
            Date date = dateToday + i
            def tvEpisodes = TVEpisode.findAll() {
                //show in tvShowsWatched
                airDate == date-1
            }
            days.add(date: date, tvEpisodes: tvEpisodes)
        }
        [days: days, tvShowsWatched: tvShowsWatched]
    }
    
}
