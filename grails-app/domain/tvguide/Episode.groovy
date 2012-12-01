package tvguide

class Episode {
    
    DataStatus status
    Show show
    Integer number
    Integer season
    Integer episode
    String productionCode
    Date airDate
    String title
    Boolean isSpecial
    String tvrage
    
    static belongsTo = [show:Show]
    
    static constraints = {
    }
}
