package com.enphoria.geojsoningestor.mapper.model

class ConsumerModel {
   var objectMapper:ArrayList<Any> = ArrayList()


    public fun setObjecMapper(objectsMap: ArrayList<Any>){
        this.objectMapper =  objectsMap;
    }

    public fun setClassLoad (vararg className: String){
      for (nameClass in className){
          callFuntionsClass(nameClass)
      }
    }

    public fun setClassLoad(className:String){
       var data =  className.split(",").toTypedArray()
        for (nameClass in data){
            callFuntionsClass(nameClass)
        }
    }

    private fun callFuntionsClass(className:String){
        when(className){
            "EnergyConsumer"->EnegyConsumer()
            "Location"->Location()
        }
    }

    private fun EnegyConsumer(){

    }

    private fun Location(){

    }


}