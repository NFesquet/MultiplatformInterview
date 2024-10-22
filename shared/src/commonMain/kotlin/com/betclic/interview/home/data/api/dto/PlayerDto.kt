package com.betclic.interview.home.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PlayerDto(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "image") val image: String,
    @SerialName(value = "club") val club: String,
    @SerialName(value = "position") val position: String,
)