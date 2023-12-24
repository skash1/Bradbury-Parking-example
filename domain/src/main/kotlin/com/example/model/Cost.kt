package com.example.model

import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
data class Cost(val amount: BigDecimal)
