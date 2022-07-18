package com.dani.domain

import java.util.*
import kotlin.collections.ArrayList


data class CharacterListResponseData (
    val data: CharacterListResponse
)

data class CharacterListResponse (
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Mycharacter>
)

data class Mycharacter (
    val id: Int,
    val name: String,
    val description: String,
    val resourceURI: String,
    val urls: List<Url>,
    val thumbnail: Image
)

data class Url (
    val type: String,
    val url: String
)

data class Image (
    val path: String,
    val extension: String
)

data class ComicList (
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: ArrayList<ComicSummary>
)

data class ComicSummary (
    val resourceURI: String,
    val name: String
)

data class StoryList (
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: ArrayList<StorySummary>
)

data class StorySummary (
    val resourceURI: String,
    val name: String,
    val type: String
)

data class EventList (
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: ArrayList<EventSummary>
)

data class EventSummary (
    val resourceURI: String,
    val name: String
)

data class SeriesList (
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: ArrayList<SeriesSummary>
)

data class SeriesSummary (
    val resourceURI: String,
    val name: String
)