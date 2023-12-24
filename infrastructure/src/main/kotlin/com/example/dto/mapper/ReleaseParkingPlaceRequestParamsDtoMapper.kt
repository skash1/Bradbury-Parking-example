package com.example.dto.mapper

import com.example.dto.ReleaseParkingPlaceRequestParamsDto
import com.example.model.parking.params.ReleaseParkingPlaceRequestParams
import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId
import org.springframework.stereotype.Component

@Component
class ReleaseParkingPlaceRequestParamsDtoMapper: Mapper<ReleaseParkingPlaceRequestParamsDto, ReleaseParkingPlaceRequestParams> {
    override fun map(input: ReleaseParkingPlaceRequestParamsDto): ReleaseParkingPlaceRequestParams =
        with(input) {
            ReleaseParkingPlaceRequestParams(AccountId(accountId), ParkingId(parkingId), TransportId(transportId))
        }
}
