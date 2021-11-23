package com.enphoria.geojsoningestor.mapper.geojsonline

data class Geometry(
    val coordinates: List<List<Double>>,
    val type: String
)