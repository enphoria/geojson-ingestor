package com.enphoria.geojsoningestor.json

data class Feature(
    val geometry: Geometry,
    val id: Int,
    val properties: PropertiesX,
    val type: String
)