package tvguide

class TVEpisode {
    
    DataStatus status = DataStatus.ACTIVE
    TVShow show
    Integer number
    Integer season
    Integer episode
    String productionCode
    Date airDate
    String title
    Boolean isSpecial
    String tvrage
    Date dateCreated
    Date lastUpdated
    Boolean updateFlag
    
    String toString() {
        "${title}"
    }
    
    static hasMany = [downloads:TVEpisodeDownload]
    static belongsTo = [show:TVShow]
    
    static mapping = {
        show index: 'show_idx'
        number index: 'number_idx'
        season index: 'season_idx'
        episode index: 'episode_idx'
        airDate index: 'airDate_idx'
        updateFlag index: 'updateFlag'
        dateCreated index: 'dateCreated_idx'
    }
    
    static constraints = {
    }
    
    static updateFlagReset() {
        executeUpdate("update TVEpisode tve set tve.updateFlag=:updateFlag", [updateFlag: false])
    }
    
    static deleteNotUpdatedByShow(show) {
        executeUpdate("DELETE FROM TVEpisode tve WHERE tve.updateFlag=:updateFlag AND show=:tvShow", [updateFlag: false, tvShow: show])
    }
}
