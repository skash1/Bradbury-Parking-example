package com.example.dto.mapper

import com.example.dto.TakeParkingPlaceRequestParamsDto
import com.example.model.parking.params.TakeParkingPlaceRequestParams
import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId
import org.springframework.stereotype.Component

@Component
class TakeParkingPlaceRequestParamsDtoMapper: Mapper<TakeParkingPlaceRequestParamsDto, TakeParkingPlaceRequestParams> {

    override fun map(input: TakeParkingPlaceRequestParamsDto): TakeParkingPlaceRequestParams =
        with(input) {
            TakeParkingPlaceRequestParams(AccountId(accountId), ParkingId(parkingId), TransportId(transportId))
        }

}
