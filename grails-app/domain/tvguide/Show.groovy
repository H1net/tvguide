package tvguide

class Show {
    
    DataStatus status
    String title
    String directory
    String tvrage
    String startDate
    String endDate
    String numbeOfEpisodes
    String runTime
    String network
    String country
    
    String toString() {
        "${title}"
    }
    
    static hasMany = [episodes:Episode]

    static constraints = {
    }
}
