package tvguide

class TVEpisodeDownload {

    TVEpisode episode
    User user
    Date dateCreated
    
    String toString() {
        "${episode.title}"
    }
    
    static belongsTo = [episode:TVEpisode] // done this way round because if we delete user we want to keep watches for ratings but if we delete the media the ratings are useless
    
}
