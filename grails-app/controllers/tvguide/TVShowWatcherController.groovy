package tvguide

class TVShowWatcherController {
    static scaffold = true

    def index() { redirect(action: list) }
}
