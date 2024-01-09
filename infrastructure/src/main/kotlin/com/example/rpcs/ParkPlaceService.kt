package com.example.rpcs

import ParkPlaceServiceGrpcKt
import ParkPlaceServiceOuterClass
import com.example.model.parking.ParkPlace
import com.example.repository.ParkPlaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class ParkPlaceService @Autowired constructor(
    private val parkPlaceRepository: ParkPlaceRepository
) : ParkPlaceServiceGrpcKt.ParkPlaceServiceCoroutineImplBase() {

    override suspend fun getParkPlace(request: ParkPlaceServiceOuterClass.ParkPlaceId): ParkPlaceServiceOuterClass.ParkPlaceResponse =
        parkPlaceRepository.findById(request.id)
            .map {
                successParkPlaceResponse(listOf(it))
            }.orElse(failureParkPlaceResponse(listOf()))

    override fun listParkPlace(request: ParkPlaceServiceOuterClass.ParkingId): Flow<ParkPlaceServiceOuterClass.ParkPlaceResponse> =
        flowOf(successParkPlaceResponse(parkPlaceRepository.findAllByParkingId(request.id)))

    override fun listParkPlaces(requests: Flow<ParkPlaceServiceOuterClass.ParkPlaceId>): Flow<ParkPlaceServiceOuterClass.ParkPlaceResponse> =
        runBlocking {
            flowOf(successParkPlaceResponse(parkPlaceRepository.findAllById(requests.toList().map { it.id })))
        }

    companion object {
        private fun successParkPlaceResponse(
            parkPlaces: List<ParkPlace>
        ): ParkPlaceServiceOuterClass.ParkPlaceResponse = parkPlaceResponse(200, parkPlaces)

        private fun failureParkPlaceResponse(
            parkPlaces: List<ParkPlace>
        ): ParkPlaceServiceOuterClass.ParkPlaceResponse = parkPlaceResponse(500, parkPlaces)

        private fun parkPlaceResponse(
            code: Int,
            parkPlaces: List<ParkPlace>
        ): ParkPlaceServiceOuterClass.ParkPlaceResponse {
            val parkPlaceResponse = ParkPlaceServiceOuterClass.ParkPlaceResponse.newBuilder()
                .setCode(code)
            parkPlaces.forEach { parkPlace -> parkPlaceResponse.addParkPlace(parkPlace.toGRPCParkPlace())}
            return parkPlaceResponse.build()
        }

        private fun ParkPlace.toGRPCParkPlace(): ParkPlaceServiceOuterClass.ParkPlace {
            val parkPlace = ParkPlaceServiceOuterClass.ParkPlace.newBuilder()
                .setId(id)
                .setSize(size.capacity)
                .setCapacityUsed(capacityUsed)
                .setTakeMoment(takeMoment?.let { Timestamp.from(it).time.toInt() / 1000 } ?: 0)
                .setParkingId(parking?.id ?: 150)
            return parkPlace.build()
        }
    }


}
