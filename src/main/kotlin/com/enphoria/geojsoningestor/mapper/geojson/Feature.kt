package com.enphoria.geojsoningestor.mapper.geojson

class Feature {
    var type: String? = null
    var id = 0
    var geometry: Geometry = Geometry()
    var properties: Properties = Properties()
}