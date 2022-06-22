package com.kareemdev.apptestjsonplaceholder.core.utils

import com.kareemdev.apptestjsonplaceholder.core.data.source.local.entity.JsonEntity
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response.JsonResponse
import com.kareemdev.apptestjsonplaceholder.core.domain.model.Json

object DataMapper {
    fun mapResponsesToEntities(input: List<JsonResponse>): List<JsonEntity> {
        val jsonList = ArrayList<JsonEntity>()
        input.map {
            val tourism = JsonEntity(
                userId = it.userId,
                id = it.id,
                title = it.title,
                isFavorite = false
            )
            jsonList.add(tourism)
        }
        return jsonList
    }

    fun mapEntitiesToDomain(input: List<JsonEntity>): List<Json> =
        input.map {
            Json(
                userId = it.userId,
                id = it.id,
                title = it.title,
                isFavorite = it.isFavorite,
            )
        }

    fun mapDomainToEntity(input: Json) = JsonEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        isFavorite = input.isFavorite,
    )
}