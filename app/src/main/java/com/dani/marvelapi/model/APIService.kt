package com.dani.marvelapi.model

import com.dani.marvelapi.BuildConfig
import com.dani.domain.CharacterListResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("apikey") apiKey: String = BuildConfig.PUBLIC_API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("limit") limit: Int = 15,
        @Query("hash") hash : String = Constants.hash(),
        @Query("offset") offset : Int
    ): Response<CharacterListResponseData>

    @GET("/v1/public/characters")
    suspend fun getAllCharactersFilter(
        @Query("apikey") apiKey: String = BuildConfig.PUBLIC_API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("limit") limit: Int = 15,
        @Query("nameStartsWith") name : String,
        @Query("hash") hash : String = Constants.hash(),
        @Query("offset") offset : Int
    ): Response<CharacterListResponseData>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharactersInfo(
        @Path("characterId") characterId: Int,
        @Query("apikey") apiKey: String = BuildConfig.PUBLIC_API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash : String = Constants.hash()
    ): Response<CharacterListResponseData>
}
