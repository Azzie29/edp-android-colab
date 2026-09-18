package com.example.myapplication.data.network.dto

import com.example.myapplication.domain.Message
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import java.time.Instant

fun MessageDto.toDomain(): Message =
    Message(
        id = id ?: "",
        sender = sender ?: "Unknown",
        text = text ?: "",
        createdAt = createdAt.toTimestamp()
    )

fun List<MessageDto>.toDomain(): List<Message> =
    map { it.toDomain() }

private fun JsonElement?.toTimestamp(): Long {
    if (this == null) {
        return 0L
    }

    val primitive = this as? JsonPrimitive
        ?: return 0L

    val value = primitive.contentOrNull
        ?: return 0L

    // Normal API format:
    // "1789578294485"
    value.toLongOrNull()?.let {
        return it
    }

    // Some existing API records use ISO date format:
    // "2026-09-16T11:13:03.395Z"
    return try {
        Instant.parse(value).toEpochMilli()
    } catch (e: Exception) {
        0L
    }
}