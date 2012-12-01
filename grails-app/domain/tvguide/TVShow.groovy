package tvguide

class TVShow {
    
    DataStatus status
    String title
    String directory
    String tvrage
    String startDate
    String endDate
    String numberOfEpisodes
    String runTime
    String network
    String country
    Boolean updateFlag
    
    String toString() {
        "${title}"
    }
    
    static hasMany = [episodes:TVEpisode, watchers:TVShowWatcher]

    static constraints = {
    }
}
