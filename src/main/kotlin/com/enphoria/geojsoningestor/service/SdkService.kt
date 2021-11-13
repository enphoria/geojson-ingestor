package com.enphoria.geojsoningestor.service

import com.zepben.evolve.services.network.NetworkService

class SdkService {
  private val networkService = NetworkService()


    public fun addSDK(vararg xs: NetworkService) {

    }


    override fun toString(): String {
        return "SdkService(networkService=$networkService)"
    }
}