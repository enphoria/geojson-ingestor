package com.enphoria.geojsoningestor.mapper.model

import com.enphoria.geojsoningestor.mapper.geojsondata.GeoJsonIngestor
import com.enphoria.geojsoningestor.mapper.geojsonline.GeoJsonLine
import com.zepben.evolve.services.network.NetworkService
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Util {
   companion object {
      @JvmField
      val GUIDE_TYPE: ArrayList<String> = ArrayList()
      @JvmField
      val service:NetworkService = NetworkService()
      @JvmField
      val routeGeoJson:String = "/home/alex/Documentos/Projects/AUTRALIA/geojson-ingestor/src/main/resources"
      @JvmField
      val objectMapper:ArrayList<GeoJsonIngestor> = ArrayList()
      @JvmField
      val objectMapperLine:ArrayList<GeoJsonLine> = ArrayList()
      @JvmStatic
      fun findIndexGeoJson(listData: ArrayList<Any>, filterName:String):Int{// Define el método estático
       var index:Int = 0;
       return index
      }
   }
}