package com.enphoria.geojsoningestor.mapper.geojsonline

data class Feature(
    val geometry: Geometry,
    val id: Int,
    val properties: PropertiesX,
    val type: String
)