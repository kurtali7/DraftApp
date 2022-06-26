package com.kurt.draftapp.data.model

import java.io.Serializable


class Track : Serializable{
    var wrapperType: String? = null
    var kind: String? = null
    var artistId: Int? = null
    var collectionId: Int? = null
    var trackId: Int? = null
    var artistName: String? = null
    var collectionName: String? = null
    var trackName: String? = null
    var collectionCensoredName: String? = null
    var trackCensoredName: String? = null
    var artistViewUrl: String? = null
    var collectionViewUrl: String? = null
    var trackViewUrl: String? = null
    var previewUrl: String? = null
    var artworkUrl30: String? = null
    var artworkUrl60: String? = null
    var artworkUrl100: String? = null
    var collectionPrice: Double? = null
    var trackPrice: Double? = null
    var releaseDate: String? = null
    var collectionExplicitness: String? = null
    var trackExplicitness: String? = null
    var discCount: Int? = null
    var discNumber: Int? = null
    var trackCount: Int? = null
    var trackNumber: Int? = null
    var trackTimeMillis: Int? = null
    var country: String? = null
    var currency: String? = null
    var primaryGenreName: String? = null
    var contentAdvisoryRating: String? = null
    var description: String? = null
    var shortDescription: String? = null
    var longDescription: String? = null
    var isStreamable: Boolean? = null
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    constructor() {}
    constructor(
        wrapperType: String?,
        kind: String?,
        artistId: Int?,
        collectionId: Int?,
        trackId: Int?,
        artistName: String?,
        collectionName: String?,
        trackName: String?,
        collectionCensoredName: String?,
        trackCensoredName: String?,
        artistViewUrl: String?,
        collectionViewUrl: String?,
        trackViewUrl: String?,
        previewUrl: String?,
        artworkUrl30: String?,
        artworkUrl60: String?,
        artworkUrl100: String?,
        collectionPrice: Double?,
        trackPrice: Double?,
        releaseDate: String?,
        collectionExplicitness: String?,
        trackExplicitness: String?,
        discCount: Int?,
        discNumber: Int?,
        trackCount: Int?,
        trackNumber: Int?,
        trackTimeMillis: Int?,
        country: String?,
        currency: String?,
        primaryGenreName: String?,
        contentAdvisoryRating: String?,
        description: String?,
        shortDescription: String?,
        longDescription: String?,
        isStreamable: Boolean?
    ) : super() {
        this.wrapperType = wrapperType
        this.kind = kind
        this.artistId = artistId
        this.collectionId = collectionId
        this.trackId = trackId
        this.artistName = artistName
        this.collectionName = collectionName
        this.trackName = trackName
        this.collectionCensoredName = collectionCensoredName
        this.trackCensoredName = trackCensoredName
        this.artistViewUrl = artistViewUrl
        this.collectionViewUrl = collectionViewUrl
        this.trackViewUrl = trackViewUrl
        this.previewUrl = previewUrl
        this.artworkUrl30 = artworkUrl30
        this.artworkUrl60 = artworkUrl60
        this.artworkUrl100 = artworkUrl100
        this.collectionPrice = collectionPrice
        this.trackPrice = trackPrice
        this.releaseDate = releaseDate
        this.collectionExplicitness = collectionExplicitness
        this.trackExplicitness = trackExplicitness
        this.discCount = discCount
        this.discNumber = discNumber
        this.trackCount = trackCount
        this.trackNumber = trackNumber
        this.trackTimeMillis = trackTimeMillis
        this.country = country
        this.currency = currency
        this.primaryGenreName = primaryGenreName
        this.contentAdvisoryRating = contentAdvisoryRating
        this.description = description
        this.shortDescription = shortDescription
        this.longDescription = longDescription
        this.isStreamable = isStreamable
    }

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}