package tvguide

class TVShowController {

    def index() { }
    
    def importer() {
        String address = "http://epguides.com/common/allshows.txt"
        def file = new FileOutputStream(address.tokenize("/")[-1])
        def out = new BufferedOutputStream(file)
        out << new URL(address).openStream()
        out.close()
        File wf= new File("allshowsParsed.txt")
        wf.delete()
        new File("allshows.txt").eachLine { line ->
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
        new File("allshowsParsed.txt").toCsvReader(['charset':'UTF-8', 'skipLines':1]).eachLine { tokens ->
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
