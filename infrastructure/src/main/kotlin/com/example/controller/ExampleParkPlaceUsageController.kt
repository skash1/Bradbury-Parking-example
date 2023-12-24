package com.example.controller

import com.example.dto.ReleaseParkingPlaceRequestParamsDto
import com.example.dto.TakeParkingPlaceRequestParamsDto
import com.example.dto.mapper.Mapper
import com.example.model.parking.params.ReleaseParkingPlaceRequestParams
import com.example.model.parking.params.TakeParkingPlaceRequestParams
import com.example.usecase.DirectParkingUseCase
import com.example.utils.Log.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/parkplace")
class ExampleParkPlaceUsageController @Autowired constructor(
    private val takeParkingPlaceRequestParamsMapper: Mapper<TakeParkingPlaceRequestParamsDto, TakeParkingPlaceRequestParams>,
    private val releaseParkingPlaceRequestParamsMapper: Mapper<ReleaseParkingPlaceRequestParamsDto, ReleaseParkingPlaceRequestParams>,
    private val directParkingUseCase: DirectParkingUseCase
) {

    @PostMapping("/take")
    @ResponseBody
    fun takeParkPlace(@RequestBody paramsDto: TakeParkingPlaceRequestParamsDto)  {
        //perform validations, etc.
        val params = takeParkingPlaceRequestParamsMapper.map(paramsDto)
        directParkingUseCase.takeParkingPlace(params)
            .onLeft {
                logger().error("Unable to take parking place.", it)
                throw it
            }
    }

    @PostMapping("/release")
    @ResponseBody
    fun releaseParkPlace(@RequestBody paramsDto: ReleaseParkingPlaceRequestParamsDto)  {
        //perform validations, etc.
        val params = releaseParkingPlaceRequestParamsMapper.map(paramsDto)
        directParkingUseCase.releaseParkingPlace(params)
            .onLeft {
                logger().error("Unable to release parking place.", it)
                throw it
            }
    }

}
