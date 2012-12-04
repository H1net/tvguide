package tvguide

import groovy.xml.*
import grails.plugins.springsecurity.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class TVEpisodeController {
    def springSecurityService

    def index() { }
    
    @Secured(['ROLE_ADMIN'])
    def importer() {
        
        List newEpisodeList = []
        List existingEpisodeList = []
        
        
        def myUser = User.get(springSecurityService.principal.id)
        if(myUser && (myUser.watching.size() > 0)) {
            myUser.watching.each() { tvShowWatcher ->
                //def tvShow = TVShow.findByDirectory('Simpsons')
                def tvShow = tvShowWatcher.show

                log.error "start show " + tvShow.title + " with rage id " + tvShow.tvrage

                TVEpisode.updateFlagReset()
                //def tvShow = TVShow.get()
                String address = "http://services.tvrage.com/feeds/episode_list.php?sid="
                String addressComplete = address + tvShow.tvrage

                def importFeed = new XmlSlurper().parse(addressComplete)
                def episodeList = importFeed.Episodelist
                //render episodeList
                
                Integer countShowFound = 0
                Integer countShowAdded = 0
                Integer countShowSkipped = 0
                Integer countShowUpdated = 0
                episodeList.Season.each() { season ->
                    //render "S" + season.@no + "-"
                    season.episode.each { episode ->
                        countShowFound++
                        //render "E" + episode.seasonnum + ","
                        Integer episodeNumber = episode.epnum.text() as int
                        Integer episodeSeason = season.@no.text() as int
                        Integer episodeEpisode = episode.seasonnum.text() as int
                        String episodeProductionCode = episode.prodnum.text()
                        Date episodeAirDate = new Date().parse('yyyy-MM-dd', episode.airdate.text())
                        String episodeTitle = episode.title
                        Boolean episodeIsSpecial = false
                        String episodeTVRage = episode.link

                        def tvEpisode = TVEpisode.findByShowAndSeasonAndEpisode(tvShow, episodeSeason, episodeEpisode)
                        if(tvEpisode) { // update it
                            if(tvEpisode.updateFlag == false) {
                                tvEpisode.updateFlag = true
                                tvEpisode.save(flush:true)
                                existingEpisodeList.add(tvEpisode)
                                countShowUpdated++
                                //log.error tvShow.updateFlag
                                //log.error "already exists: " + tokens[1]
                            } else {
                                countShowSkipped++
                                //log.error "skipping: " + tvShow.title + " " + episodeSeason + "x" + episodeEpisode + " - " + episodeTitle + " on " + episodeAirDate.format("d MMMM, yyyy")
                                //log.error "for: " + tvEpisode.show.title + " " + tvEpisode.season + "x" + tvEpisode.episode + " - " + tvEpisode.title + " on " + tvEpisode.airDate.format("d MMMM, yyyy")
                            }
                        } else { // create new one
                            def tvEpisodeNew = new TVEpisode(show: tvShow, number: episodeNumber, season: episodeSeason, episode: episodeEpisode, productionCode: episodeProductionCode, airDate: episodeAirDate, title: episodeTitle, isSpecial: episodeIsSpecial, tvrage: episodeTVRage, updateFlag: true).save(flush:true, failOnError: true)
                            newEpisodeList.add(tvEpisodeNew)
                            countShowAdded++
                            log.error "added: " + tvShow.title + " " + episodeSeason + "x" + episodeEpisode + " - " + episodeTitle + " on " + episodeAirDate.format("d MMMM, yyyy")
                        }
                    }
                }
                log.error "end show " + tvShow.title + " with F:" + countShowFound + " A:" + countShowAdded + " U:" + countShowUpdated + " S:" + countShowSkipped + " episodes"
            }
        } else {
            render "bad user"
        }
        
        
        
        //render tvShow.title
        
        //wf.close()
        
        //TVShow.list().each { show ->
        //    show.updateFlag = false
        //    show.save(flush:true)
        //    log.error "updating flag"
        //}
//        TVShow.updateFlagReset()
//        
//        List newShowsList = []
//        List existingShowsList = []
//        
//        //new File(System.properties['base.dir']+"/dev/testData/allshowsEdited.txt").toCsvReader(['charset':'UTF-8', 'skipLines':1]).eachLine { tokens ->
//        new File(pathParsedEpisodes).toCsvReader(['charset':'UTF-8', 'skipLines':1]).eachLine { tokens ->
//            def showTitle = tokens[0].toString() ?: null
//            def showDirectory = tokens[1].toString() ?: null
//            def showTVRage = tokens[2].toString() ?: null
//            def showStartDate = tokens[3].toString() ?: null
//            def showEndDate = tokens[4].toString() ?: null
//            def showNumberOfEpisodes = tokens[5].toString() ?: null
//            def showRunTime = tokens[6].toString() ?: null
//            def showNetwork = tokens[7].toString() ?: null
//            def showCountry = tokens[8].toString() ?: null
//            //render showTitle
//            
//            //def tvShow = TVShow.findByDirectoryAndNetwork(tokens[1].toString(), tokens[7].toString())
//            def tvEpisode = TVEpisode.findByDirectory(showDirectory)
//            if(tvShow) { // update it
//                if(tvShow.updateFlag == false) {
//                    tvShow.updateFlag = true
//                    tvShow.save(flush:true)
//                    existingShowsList.add(tvShow)
//                    //log.error tvShow.updateFlag
//                    //log.error "already exists: " + tokens[1]
//                } else {
//                    log.error "skipping: " + showTitle
//                }
//            } else { // create new one
//                def tvShowNew = new TVShow(title: showTitle, directory: showDirectory, tvrage: showTVRage, startDate: showStartDate, endDate: showEndDate, numberOfEpisodes: showNumberOfEpisodes, runTime: showRunTime, network: showNetwork, country: showCountry, updateFlag: true).save(flush:true, failOnError: true)
//                newShowsList.add(tvShowNew)
//                log.error "added: " + showTitle
//            }
//       }
//       [newShowsList: newShowsList, existingShowsList: existingShowsList]
    }
}
