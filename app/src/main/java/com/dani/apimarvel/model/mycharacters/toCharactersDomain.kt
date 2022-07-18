package com.dani.apimarvel.model.mycharacters

import com.dani.apimarvel.model.database.entities.CharactersEntity
import com.dani.domain.*

fun CharactersEntity.toCharactersDomain(): Mycharacter = Mycharacter(
    id,
    name,
    description,
    resourceURI,
    urls,
    thumbnail
)

fun Mycharacter.toCharactersEntity(): CharactersEntity =
    CharactersEntity(
        id = this.id,
        name = name,
        description = this.description,
        resourceURI = this.resourceURI,
        urls = this.urls,
        thumbnail = this.thumbnail
    )
