/*
 * Copyright 2021. Zeppelin Bend Pty Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.enphoria.geojsoningestor.mapper.model

import com.zepben.evolve.cim.iec61970.base.core.BaseVoltage
import com.zepben.evolve.cim.iec61970.base.core.ConnectivityNode
import com.zepben.evolve.cim.iec61970.base.core.IdentifiedObject
import com.zepben.evolve.services.common.meta.MetadataCollection
import com.zepben.evolve.services.diagram.DiagramService
import com.zepben.evolve.services.network.NetworkService

internal class CimServices(
    val networkService: NetworkService = NetworkService(),
    val diagramService: DiagramService = DiagramService(),
    val metadataCollection: MetadataCollection = MetadataCollection()
) {
    fun services() = listOf(networkService, diagramService)

    val baseVoltageCache = Cache<BaseVoltage, Int>(
        { voltage -> "$voltage" },
        { baseVoltage -> baseVoltage.nominalVoltage.toString() }
    )

    val feederToSubstationEdgeConnectivityNode: MutableMap<String, ConnectivityNode> = mutableMapOf()

    val switchMRIDToCompositeSwitchMRID = mutableMapOf<String, String>()
    val compositeSwitchToLocation= mutableMapOf<String, String>()

    internal class Cache<T : IdentifiedObject, E : Any>(
        private val rdfToHash: (element: E) -> String,
        private val cimToHash: (element: T) -> String
    ) {

        private val tsByHash = mutableMapOf<String, T>()

        internal fun getHash(element: E) = rdfToHash(element)

        internal fun add(t: T) {
            val hash = cimToHash(t)

            if (tsByHash[hash] != null)
                throw IllegalStateException("[Internal Error] Hash collision while trying to add new object to cache.")

            tsByHash[hash] = t
        }

        internal fun get(element: E): T? {
            val hash = rdfToHash(element)
            return tsByHash[hash]
        }

    }

}
