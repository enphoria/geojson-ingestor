package com.enphoria.geojsoningestor.transform

import com.zepben.evolve.database.sqlite.DatabaseWriter
import com.enphoria.geojsoningestor.mapper.geojson.Feature
import kotlin.Throws
import java.io.IOException
import com.fasterxml.jackson.databind.ObjectMapper
import com.enphoria.geojsoningestor.mapper.geojson.GeoJson
import com.zepben.evolve.cim.iec61968.common.Location
import com.zepben.evolve.cim.iec61968.common.PositionPoint
import com.zepben.evolve.cim.iec61968.metering.UsagePoint
import com.zepben.evolve.cim.iec61970.base.core.BaseVoltage
import com.zepben.evolve.cim.iec61970.base.diagramlayout.Diagram
import com.zepben.evolve.cim.iec61970.base.diagramlayout.DiagramObject
import com.zepben.evolve.cim.iec61970.base.diagramlayout.DiagramObjectPoint
import com.zepben.evolve.cim.iec61970.base.meas.Accumulator
import com.zepben.evolve.cim.iec61970.base.meas.Analog
import com.zepben.evolve.cim.iec61970.base.meas.Measurement
import com.zepben.evolve.cim.iec61970.base.wires.EnergyConsumer
import com.zepben.evolve.cim.iec61970.base.wires.EnergyConsumerPhase
import com.zepben.evolve.services.common.BaseService
import com.zepben.evolve.services.common.meta.DataSource
import com.zepben.evolve.services.common.meta.MetadataCollection
import com.zepben.evolve.services.diagram.DiagramService
import com.zepben.evolve.services.network.NetworkService
import com.zepben.protobuf.cim.iec61968.metering.UsagePointOrBuilder
import com.zepben.protobuf.cim.iec61970.base.wires.EnergyConnection
import com.zepben.protobuf.cim.iec61970.base.wires.EnergySource
import java.nio.file.Paths
import java.util.function.Consumer

class Transform {
    @Throws(IOException::class)
    fun readGeojson() {
        //String geojson = "";
        val mapping = ObjectMapper()
        //Paths.get("geojson.json").toFile()
        val geojson = mapping.readValue(
            Paths.get("/Users/camcardenas/Downloads/geojsoningestor/src/main/resources/geojson.json").toFile(),
            GeoJson::class.java
        )
        geojson.features.forEach(Consumer { item: Feature ->
            if (item.properties.classd == "EnergyConsumer") {
                println(item.properties.fid)
                println(item.properties.id)
            }
        })

        val metaData = MetadataCollection().apply { add(DataSource("geojson extractor", version = "0.1")) }
        val dbFile = "/Users/camcardenas/Documents/Personal/Zepben/ewb/ee-ehv-prod/2021-11-02/2021-11-02-network-model.sqlite"
        /*val services = ServicesStore()*/

        /*Create network services*/
        val service = NetworkService()
        val amps = Analog().apply { powerSystemResourceMRID = "ASWITCH" }
        val count = Accumulator().apply { powerSystemResourceMRID = "ASWITCH" }
        var loc = Location().apply { name = "prueba"
                                            description = "dfg"
                                            addPoint(PositionPoint(149.109057447049,-35.2696664208097))
        }

        //val energyConsumer = EnergyConsumer().phaseConnectio
        service.add(amps)
        service.add(count)
        service.add(loc)
        //service.add(positionPoint)
        // Gets both the analog and the accumulator
        service.getMeasurements<Measurement>("ASWITCH")
        // Will get just the analog
        service.getMeasurements<Analog>("ASWITCH")

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
        /*val point = listOf(UsagePoint().apply {
            usagePointLocation = Location().addPoint(PositionPoint(149.109057447049,-35.2696664208097))
        })*/
        val energyC = EnergyConsumer().apply { customerCount = 1
            grounded = true
            p = 0.0
            q = 0.0
            pFixed = 0.0
            name = "ec1"
            description = "ec1 description"
            location = loc
        }

        //.location?.apply { name = "prueba2"
        //            description = "dfg2"
        //            addPoint(PositionPoint(149.109057447049,-35.2696664208097)) }
        service.add(energyC)

        // Contains [do1]
        serviceDiagram.getDiagramObjects(do1.mRID)

        // Contains [do1, do2, do3]
        serviceDiagram.getDiagramObjects(aDiagram.mRID)

        // Contains [do1, do2]
        serviceDiagram.getDiagramObjects("aSwitch")


        DatabaseWriter(dbFile).save(metaData, listOf(service, serviceDiagram))
        //geojson.features.forEach(System.out::println);
    }
}