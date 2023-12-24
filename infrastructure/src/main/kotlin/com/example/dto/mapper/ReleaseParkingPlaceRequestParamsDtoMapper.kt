package com.example.dto.mapper

import com.example.dto.ReleaseParkingPlaceRequestParamsDto
import com.example.model.parking.params.ReleaseParkingPlaceRequestParams
import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId

val releaseParkingPlaceRequestParamsDtoMapper = Mapper<ReleaseParkingPlaceRequestParamsDto, ReleaseParkingPlaceRequestParams> {
    ReleaseParkingPlaceRequestParams(AccountId(it.accountId), ParkingId(it.parkingId), TransportId(it.transportId))
}
