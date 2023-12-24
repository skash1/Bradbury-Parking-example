package com.example.controller

import arrow.core.getOrElse
import com.example.dto.ParkPlaceDto
import com.example.dto.ReleaseParkingPlaceRequestParamsDto
import com.example.dto.TakeParkingPlaceRequestParamsDto
import com.example.dto.mapper.*
import com.example.model.value.ParkingId
import com.example.usecase.DirectParkingUseCase
import com.example.utils.Log.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/parking")
class ExampleParkingUsageController @Autowired constructor(
    private val directParkingUseCase: DirectParkingUseCase
) {

    @GetMapping("/{parkingId}/parkplace/list/available")
    @ResponseBody
    fun listAvailableParkPlaces(@PathVariable parkingId: Long): List<ParkPlaceDto> {
        //perform validations, etc.
        return directParkingUseCase.getAvailableParkingPlaces(ParkingId(parkingId))
            .getOrElse {
                logger().error("Unable to take parking place.", it)
                throw it
            }
            .map { parkPlaceMapper.map(it) }
    }

    @PostMapping("/takePlace")
    @ResponseBody
    fun takeParkPlace(@RequestBody paramsDto: TakeParkingPlaceRequestParamsDto)  {
        //perform validations, etc.
        val params = takeParkingPlaceRequestParamsDtoMapper.map(paramsDto)
        directParkingUseCase.takeParkingPlace(params)
            .onLeft {
                logger().error("Unable to take parking place.", it)
                throw it
            }
    }

    @PostMapping("/releasePlace")
    @ResponseBody
    fun releaseParkPlace(@RequestBody paramsDto: ReleaseParkingPlaceRequestParamsDto)  {
        //perform validations, etc.
        val params = releaseParkingPlaceRequestParamsDtoMapper.map(paramsDto)
        directParkingUseCase.releaseParkingPlace(params)
            .onLeft {
                logger().error("Unable to release parking place.", it)
                throw it
            }
    }

}
