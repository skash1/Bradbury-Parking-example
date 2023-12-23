package com.example.controller

import com.example.model.parking.params.ReleaseParkingPlaceRequestParams
import com.example.model.parking.params.TakeParkingPlaceRequestParams
import com.example.usecase.DirectParkingUseCase
import com.example.utils.Log.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/parkplace")
class ExampleParkPlaceUsageController @Autowired constructor(
    private val directParkingUseCase: DirectParkingUseCase
) {

    @PostMapping("/take")
    @ResponseBody
    fun takeParkPlace(@RequestBody params: TakeParkingPlaceRequestParams)  {
        //perform validations, etc.
        directParkingUseCase.takeParkingPlace(params)
            .onLeft {
                logger().error("Unable to take parking place.", it)
                throw it
            }
    }

    @PostMapping("/release")
    @ResponseBody
    fun releaseParkPlace(@RequestBody params: ReleaseParkingPlaceRequestParams)  {
        //perform validations, etc.
        directParkingUseCase.releaseParkingPlace(params)
            .onLeft {
                logger().error("Unable to release parking place.", it)
                throw it
            }
    }

}
