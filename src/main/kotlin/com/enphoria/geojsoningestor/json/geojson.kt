package com.enphoria.geojsoningestor.json

data class geojson(
    val crs: Crs,
    val features: List<Feature>,
    val type: String
)