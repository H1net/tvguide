package tvguide

import grails.plugins.springsecurity.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class HomeController {

    def index() { }
   
    // show calendar
    def home() { }
    
    
}
