package com.example.model.cost

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class PeriodBound(
    @Column(name = MIN_BOUND_COLUMN_NAME) val minBound: Int,
    @Column(name = MAX_BOUND_COLUMN_NAME) val maxBound: Int
) {
    companion object {
        const val MIN_BOUND_COLUMN_NAME = "min_bound"
        const val MAX_BOUND_COLUMN_NAME = "max_bound"
    }
}
