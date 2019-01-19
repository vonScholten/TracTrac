package group7.tractrac.home

class FeedData {
    var name: String? = null
    var imageUrl: String? = null
    var date: String? = null
    var text: String? = null

    constructor()

    constructor(name: String, imageUrl: String, date: String, text: String) {
        this.name = name
        this.imageUrl = imageUrl
        this.date = date
        this.text = text
    }
}
