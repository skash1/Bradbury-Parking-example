package com.example.dto.mapper

import com.example.dto.TakeParkingPlaceRequestParamsDto
import com.example.model.parking.params.TakeParkingPlaceRequestParams
import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId

val takeParkingPlaceRequestParamsDtoMapper = Mapper<TakeParkingPlaceRequestParamsDto, TakeParkingPlaceRequestParams> {
    TakeParkingPlaceRequestParams(AccountId(it.accountId), ParkingId(it.parkingId), TransportId(it.transportId))
}
