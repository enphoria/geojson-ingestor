package com.enphoria.geojsoningestor


import com.enphoria.geojsoningestor.transform.Transform2
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GeojsoningestorApplication

fun main(args: Array<String>) {
    runApplication<GeojsoningestorApplication>(*args)
    val transform: Transform2 = Transform2()
    transform.readGeojson()

}
