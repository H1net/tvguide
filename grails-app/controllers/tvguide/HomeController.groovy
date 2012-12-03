package tvguide

import grails.plugins.springsecurity.Secured

class HomeController {

    def index() { }
    
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def home() { }
    
}
