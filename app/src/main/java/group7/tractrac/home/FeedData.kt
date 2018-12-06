package group7.tractrac.home

class FeedData {
    var name: String? = null
    var imageUrl: String? = null

    constructor() {}

    constructor(name: String, imageUrl: String) {
        this.name = name
        this.imageUrl = imageUrl
    }
}
