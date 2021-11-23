package com.enphoria.geojsoningestor.mapper.geojson
import com.fasterxml.jackson.annotation.JsonProperty

class Properties {
    var fid = 0
    var id: String? = null

    @JsonProperty("Name")
    var name: String? = null

    @JsonProperty("Class")
    var classd: String? = null

    @JsonProperty("BaseVoltage")
    var baseVoltage: String? = null

    @JsonProperty("HeadTerminal")
    var headTerminal: String? = null

    @JsonProperty("Lat")
    var lat = 0.0

    @JsonProperty("Lon")
    var lon = 0.0

    @JsonProperty("Creator")
    var creator: String? = null

    @JsonProperty("CreationDate")
    var creationDate: String? = null

    @JsonProperty("Editor")
    var editor: String? = null

    @JsonProperty("EditDate")
    var editDate: String? = null

    @JsonProperty("Grounded")
    var grounded: Any? = null

    @JsonProperty("PowerTransformerID")
    var powerTransformerID: Any? = null

    @JsonProperty("EndNumber")
    var endNumber: Any? = null
    var layer: String? = null

    @JsonProperty("ObjectId")
    var objectId = 0
}