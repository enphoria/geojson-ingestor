package com.enphoria.geojsoningestor.mapper.geojsondata

data class Feature(
    val geometry: Geometry,
    val id: Int,
    val properties: PropertiesX,
    val type: String
)
