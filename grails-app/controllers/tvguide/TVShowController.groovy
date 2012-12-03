package tvguide

import groovy.xml.*
import grails.plugins.springsecurity.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class TVShowController {

    def index() { }
    
    def list(Integer max) {
        params.max = Math.min(max ?: 100, 100)
        [tvShows: TVShow.list(params), tvShowTotal: TVShow.count()]
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
