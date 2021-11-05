package com.enphoria.geojsoningestor.mapper.geojson

class GeoJson {
    var type: String? = null
    var crs: Crs? = null
    lateinit var features: List<Feature>
}