package tvguide

class TVShow {
    
    DataStatus status = DataStatus.ACTIVE
    String title
    String directory
    String tvrage
    String startDate
    String endDate
    String numberOfEpisodes
    String runTime
    String network
    String country
    Date dateCreated
    Date lastUpdated
    Boolean updateFlag = true
    
    String toString() {
        "${title}"
    }
    
    static hasMany = [episodes:TVEpisode, watchers:TVShowWatcher]
    
    static mapping = {
        title index: 'title_idx'
        directory index: 'directory_idx'
        dateCreated index: 'dateCreated_idx'
        updateFlag index: 'updateFlag'
    }

    static constraints = {
        title()
        directory(nullable: true)
        tvrage(nullable: true)
        startDate(nullable: true)
        endDate(nullable: true)
        numberOfEpisodes(nullable: true)
        runTime(nullable: true)
        network(nullable: true)
        country(nullable: true)
    }
    
    static updateFlagReset() {
        executeUpdate("update TVShow tvs set tvs.updateFlag=:updateFlag", [updateFlag: false])
    }
}
