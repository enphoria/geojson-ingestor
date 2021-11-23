package com.enphoria.geojsoningestor.transform


import com.enphoria.geojsoningestor.mapper.geojson.GeoJson
import com.fasterxml.jackson.databind.ObjectMapper
import com.zepben.evolve.services.network.NetworkService
import java.nio.file.Paths

class Transform2 {
    fun readGeojson(){
        val mapping = ObjectMapper()
        val service = NetworkService()

        val geojson = mapping.readValue(
            Paths.get("/home/alex/Documentos/Projects/AUTRALIA/geojson-ingestor/src/main/resources/geojson.json").toFile(),
            GeoJson::class.java
        )

        /*geojson.features.forEach(Consumer { item: Feature ->

        })*/
    }
}