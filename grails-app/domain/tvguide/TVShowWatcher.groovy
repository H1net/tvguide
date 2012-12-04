package tvguide

class TVShowWatcher {

    TVShow show
    User user
    Date dateCreated
    Date lastUpdated
    
    String toString() {
        "${rating}"
    }
    
    static belongsTo = [show:TVShow] // done this way round because if we delete user we want to keep watches for ratings but if we delete the media the ratings are useless
    
    static mapping = {
        show sort:'title'
    }
}
