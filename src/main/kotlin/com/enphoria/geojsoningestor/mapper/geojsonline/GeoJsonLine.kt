package com.enphoria.geojsoningestor.mapper.geojsonline

data class GeoJsonLine(
    val crs: Crs,
    val features: List<Feature>,
    val type: String
)