package tvguide

import groovy.xml.*
import grails.plugins.springsecurity.Secured
import ajaxtools.*
import grails.converters.JSON

@Secured(['IS_AUTHENTICATED_FULLY'])
class TVShowController {
    def springSecurityService
    
    def index() { }
    
    def list(Integer max) {
        params.max = Math.min(max ?: 100, 100)
        
        List tvShowsWatched = []
        User.get(springSecurityService.principal.id).watching.each() { tvShowWatcher ->
            tvShowsWatched.add(tvShowWatcher.show.id)
        }
        
        [tvShows: TVShow.list(params), tvShowTotal: TVShow.count(), tvShowsWatched: tvShowsWatched]
    }
    
    def listHunting() {
        
        List tvShowsHunting = [
            "2 Broke Girls",
            "30 Rock",
            "666 Park Avenue",
            "Adventure Time",
            "Alphas",
            "American Dad!",
            "American Horror Story",
            "American Idol",
            "Ancient Aliens",
            "Anger Management",
            "Apprentice (UK) [The]",
            "Apprentice (US) [The]",
            "Archer",
            "Arrow",
            "Avengers: Earth's Mightest Heroes",
            "Awkward",
            "Bang Goes The Theory",
            "Beavis and Butt-Head",
            "Big Bang Theory [The]",
            "Blue Bloods",
            "Boardwalk Empire",
            "Body of Proof",
            "Borgias [The]",
            "Boss",
            "Breaking Bad",
            "Burn Notice",
            "Californication",
            "Call The Midwife",
            "Castle",
            "Charlie Brookers Newswipe",
            "Cleveland Show [The]",
            "Client List [The]",
            "Clone Wars [The]",
            "Community",
            "Continuum",
            "Cougar Town",
            "Covert Affairs",
            "Dallas",
            "Death In Paradise",
            "Derek",
            "Dexter",
            "Don't Trust the B---- in Apartment 23",
            "Downton Abbey",
            "Dragon's Den",
            "Eastbound and Down",
            "Enlightened",
            "Eureka",
            "Exes [The]",
            "Falling Skies",
            "Family Guy",
            "Femme Fatales",
            "Flashpoint",
            "Franklin And Bash",
            "Fringe",
            "Futurama",
            "Game of Thrones",
            "Girls",
            "Glee",
            "Gossip Girl",
            "Grand Designs",
            "Green Lantern",
            "Greys Anatomy",
            "Grimm",
            "Have I Got News for You",
            "Hawaii Five-0",
            "Hell on Wheels",
            "Homeland",
            "Horizon",
            "Hotel Hell",
            "Hour [The]",
            "How I Met Your Mother",
            "It's Always Sunny in Philadelphia",
            "Jane By Design",
            "Jessie",
            "Jonathan Ross Show [The]",
            "Kitchen Nightmares",
            "Last Man Standing",
            "Legend of Korra [The]",
            "Leverage",
            "Longmire",
            "Luther",
            "Lying Game [The]",
            "Mad Dogs",
            "Mad Men",
            "Magic City",
            "Man v. Food",
            "Man, Woman, Wild",
            "Men at Work",
            "Mentalist [The]",
            "Misfits",
            "Modern Family",
            "Mrs Brown's Boys",
            "MythBusters",
            "NCIS",
            "Never Mind The Buzzcocks",
            "New Girl",
            "Newsroom [The]",
            "Nikita",
            "Nurse Jackie",
            "Office (US) [The]",
            "Once Upon a Time",
            "Onion News Network",
            "Parenthood",
            "Pawn Stars",
            "Person of Interest",
            "Portlandia",
            "Pretty Little Liars",
            "Private Practice",
            "Psych",
            "QI",
            "Raising Hope",
            "Red Dwarf",
            "Revenge",
            "Revolution",
            "Saving Hope",
            "Secret Circle [The]",
            "Sherlock",
            "Simpsons [The]",
            "Skins (UK)",
            "Smash",
            "So You Think You Can Dance",
            "Sons of Anarchy",
            "South Park",
            "Spartacus",
            "Suburgatory",
            "Suits",
            "Supernatural",
            "Switched At Birth",
            "Teen Wolf",
            "Teenage Mutant Ninja Turtles",
            "Thick of It [The]",
            "Through the Wormhole",
            "Top Gear",
            "Torchwood",
            "Touch",
            "Transformers: Prime",
            "Treme",
            "Tron: Uprising",
            "True Blood",
            "True Justice",
            "Ultimate Spider-Man",
            "Unchained Reaction",
            "Unforgettable",
            "Universe [The]",
            "Unsupervised",
            "Up All Night",
            "Vampire Diaries [The]",
            "Veep",
            "Walking Dead [The]",
            "Warehouse 13",
            "Web Therapy",
            "Weeds",
            "Whitney",
            "Workaholics",
            "X Factor (UK) [The]",
            "X Factor (US) [The]",
            "Young Justice"
        ]
        List tvShowsFound = []
        
        tvShowsHunting.each() { showTitle -> 
            List searchShowResults = []
            def searchTitle = showTitle.replaceAll('\\[The\\]|\\(US\\)|\\(UK\\)', '').trim()
            def tvShows = TVShow.findAllByTitleLike("%"+searchTitle+"%")
            tvShows.each() { tvShow ->
                searchShowResults.add(tvShow)
            }
            tvShowsFound.add(title: showTitle, search: searchTitle, tvShows: searchShowResults)
        }
        
        List tvShowsWatched = []
        User.get(springSecurityService.principal.id).watching.each() { tvShowWatcher ->
            tvShowsWatched.add(tvShowWatcher.show.id)
        }
        
        [tvShowsFound: tvShowsFound, tvShowTotal: tvShowsFound.size(), tvShowsWatched: tvShowsWatched]
    }
    
    def jsonWatcherAdd(Integer id, Integer user_id) {
        def response = new AJAXResponseContainer()
        def tvShow = TVShow.get(id)
        def user = User.get(user_id)
        if(tvShow && user) {
            def tvShowWatcher = new TVShowWatcher(show: tvShow, user: user).save(flush:true)
            if(tvShowWatcher.id > 0) {
                response.success()
                response.addData(tvShowWatcher: tvShowWatcher)
            } else {
                response.addMessage("Save failed")
            } 
        } else {
            response.addMessage("Invalid show or user")
        }
        render response as JSON
    }
    
    def jsonWatcherRemove(Integer id, Integer user_id) {
        def response = new AJAXResponseContainer()
        def tvShow = TVShow.get(id)
        def user = User.get(user_id)
        if(tvShow && user) {
            def tvShowWatcher = TVShowWatcher.findByShowAndUser(tvShow, user)
            if(tvShowWatcher.delete()) {
                response.success()
            } else {
                response.addMessage("Save failed")
            } 
        } else {
            response.addMessage("Invalid show or user")
        }
        render response as JSON
    }
    
    @Secured(['ROLE_ADMIN'])
    def importer() {
        String address = "http://epguides.com/common/allshows.txt"
        String pathForData = System.properties['base.dir']+"/web-app/WEB-INF/epguides"
        String pathOriginalShows = pathForData+"/allshows.txt"
        String pathParsedShows = pathForData+"/allshowsParsed.txt"
        def file = new FileOutputStream(pathOriginalShows)
        def out = new BufferedOutputStream(file)
        out << new URL(address).openStream()
        out.close()
        File wf= new File(pathParsedShows)
        wf.delete()
        new File(pathOriginalShows).eachLine { line ->
            if(line.length()>5) {
                wf.append(line+"\r\n")
                //render(line)
            }
        }
        //wf.close()
        
        //TVShow.list().each { show ->
        //    show.updateFlag = false
        //    show.save(flush:true)
        //    log.error "updating flag"
        //}
        TVShow.updateFlagReset()
        
        List newShowsList = []
        List existingShowsList = []
        
        //new File(System.properties['base.dir']+"/dev/testData/allshowsEdited.txt").toCsvReader(['charset':'UTF-8', 'skipLines':1]).eachLine { tokens ->
        new File(pathParsedShows).toCsvReader(['charset':'UTF-8', 'skipLines':1]).eachLine { tokens ->
            def showTitle = tokens[0].toString() ?: null
            def showDirectory = tokens[1].toString() ?: null
            def showTVRage = tokens[2].toString() ?: null
            def showStartDate = tokens[3].toString() ?: null
            def showEndDate = tokens[4].toString() ?: null
            def showNumberOfEpisodes = tokens[5].toString() ?: null
            def showRunTime = tokens[6].toString() ?: null
            def showNetwork = tokens[7].toString() ?: null
            def showCountry = tokens[8].toString() ?: null
            //render showTitle
            
            //def tvShow = TVShow.findByDirectoryAndNetwork(tokens[1].toString(), tokens[7].toString())
            def tvShow = TVShow.findByDirectory(showDirectory)
            if(tvShow) { // update it
                if(tvShow.updateFlag == false) {
                    tvShow.updateFlag = true
                    tvShow.save(flush:true)
                    existingShowsList.add(tvShow)
                    //log.error tvShow.updateFlag
                    //log.error "already exists: " + tokens[1]
                } else {
                    log.error "skipping: " + showTitle
                }
            } else { // create new one
                def tvShowNew = new TVShow(title: showTitle, directory: showDirectory, tvrage: showTVRage, startDate: showStartDate, endDate: showEndDate, numberOfEpisodes: showNumberOfEpisodes, runTime: showRunTime, network: showNetwork, country: showCountry, updateFlag: true).save(flush:true, failOnError: true)
                newShowsList.add(tvShowNew)
                log.error "added: " + showTitle
            }
       }
       [newShowsList: newShowsList, existingShowsList: existingShowsList]
    }
   
}
