package tvguide

class TVEpisode {
    
    DataStatus status
    TVShow show
    Integer number
    Integer season
    Integer episode
    String productionCode
    Date airDate
    String title
    Boolean isSpecial
    String tvrage
    Boolean updateFlag
    
    String toString() {
        "${title}"
    }
    
    static hasMany = [downloads:TVEpisodeDownload]
    static belongsTo = [show:TVShow]
    
    static constraints = {
    }
}
