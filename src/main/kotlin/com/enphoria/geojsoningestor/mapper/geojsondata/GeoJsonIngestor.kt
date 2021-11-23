package com.enphoria.geojsoningestor.mapper.geojsondata

data class GeoJsonIngestor(
    val crs: Crs,
    val features: List<Feature>,
    val type: String,
)

