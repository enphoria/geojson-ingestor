package com.enphoria.geojsoningestor.transform

import com.zepben.evolve.cim.iec61970.base.wires.EnergyConsumer
import com.zepben.evolve.cim.iec61970.base.wires.EnergyConsumerPhase
import com.enphoria.geojsoningestor.mapper.geojsondata.Feature
import com.enphoria.geojsoningestor.mapper.geojsondata.GeoJsonIngestor
import com.enphoria.geojsoningestor.mapper.geojsonline.GeoJsonLine
import com.enphoria.geojsoningestor.mapper.model.ConsumerModel
import com.enphoria.geojsoningestor.mapper.model.Util
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zepben.evolve.services.network.NetworkService
import java.io.File
import java.io.IOException
import java.nio.file.Paths
import java.util.function.Consumer

class Transform {
    @Throws(IOException::class)
    fun readGeojson() {
        val service = NetworkService()
        val consumerModel = ConsumerModel()

        val geoJsonMap = ObjectMapper().registerModule(KotlinModule())

        val jsonString =  File(Util.routeGeoJson+"/geojson.json").readText(Charsets.UTF_8)
        val mapper = ObjectMapper().registerModule(KotlinModule())
        var geojson = mapper.readValue(jsonString, GeoJsonIngestor::class.java)


       File(Util.routeGeoJson).list().forEach{
           if(!it.equals("application.properties")) {
               var readGeoJson = File(Util.routeGeoJson+"/"+it).readText(Charsets.UTF_8)
               try {
                   Util.objectMapper.add(geoJsonMap.readValue(readGeoJson, GeoJsonIngestor::class.java))
               }catch (e:Exception){
                   Util.objectMapperLine.add(geoJsonMap.readValue(readGeoJson, GeoJsonLine::class.java))
               }
           }
       }

        //consumerModel.setObjecMapper(geoIngestors)
        consumerModel.setClassLoad("EnergyConsumer","Location")




    //val deserializedValue = ObjectMapper().readerFor(GeoJsonIngestor::class.java).readValue<GeoJsonIngestor>(jsonString)

     println("OK")


        /*val geojson = mapping.readValue(
            Paths.get("/home/alex/Documentos/Projects/AUTRALIA/geojson-ingestor/src/main/resources/geojson.json").toFile(),
            GeoJsonIngestor::class.java
        )*/


/*
        geojson.features.forEach(Consumer { item: Feature ->
            if (item.properties.classd == "EnergyConsumer") {
                cEc++
                println(item.properties.fid)
                println(item.properties.id)

                val amps = Analog().apply { powerSystemResourceMRID = "ASWITCH" }
                val count = Accumulator().apply { powerSystemResourceMRID = "ASWITCH" }

                var loc = Location().apply {
                    name = "prueba"+cEc
                    description = item.properties.classd.toString()+cEc
                    addPoint(PositionPoint(item.properties.lon,item.properties.lat))
                }
                val energyC = EnergyConsumer().apply {
                    customerCount = cEc
                    grounded = item.properties.grounded.toString().toBoolean()
                    p = 0.0
                    q = 0.0
                    pFixed = 0.0
                    name = item.properties.name.toString()
                    description = item.properties.classd.toString()+cEc
                    location = loc
                }

                service.getMeasurements<Measurement>("ASWITCH")
                service.getMeasurements<Analog>("ASWITCH")
                service.add(amps)
                service.add(count)
                service.add(loc)
                service.add(energyC)
            }

        })

        val metaData = MetadataCollection().apply { add(DataSource("geojson extractor", version = "0.1")) }
        val dbFile = "/home/alex/Documentos/zepben/dataMode/2021-11-11/2021-11-11-network-model.sqlite"


        /*Creatte diagram service*/
        val serviceDiagram = DiagramService()
        val aDiagram = Diagram().apply {
            name = "prueba"
            description = "prueba"
        }
        //aDiagram
        val do1 = DiagramObject().apply {
            diagram = aDiagram
            identifiedObjectMRID = "aSwitch1"
            addPoint(DiagramObjectPoint(149.109057447049,-35.2696664208097))
        }

        aDiagram.addDiagramObject(do1)

        val do2 = DiagramObject().apply {
            diagram = aDiagram
            identifiedObjectMRID = "aSwitch2"
            addPoint(DiagramObjectPoint(149.109057447049,-35.2696664208097))
        }
        aDiagram.addDiagramObject(do2)


        val do3 = DiagramObject().apply {
            diagram = aDiagram
            identifiedObjectMRID = "aSwitch3"
            addPoint(DiagramObjectPoint(149.109057447049,-35.2696664208097))
        }
        aDiagram.addDiagramObject(do3)
        serviceDiagram.add(aDiagram)
        serviceDiagram.add(do1)
        serviceDiagram.add(do2)
        serviceDiagram.add(do3)

        serviceDiagram.getDiagramObjects(do1.mRID)

        // Contains [do1, do2, do3]
        serviceDiagram.getDiagramObjects(aDiagram.mRID)

        // Contains [do1, do2]
        serviceDiagram.getDiagramObjects("aSwitch")


        DatabaseWriter(dbFile).save(metaData, listOf(service, serviceDiagram))*/
        //geojson.features.forEach(System.out::println);
    }


}