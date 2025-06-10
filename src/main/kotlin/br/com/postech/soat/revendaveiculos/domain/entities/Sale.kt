package br.com.postech.soat.revendaveiculos.domain.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class Sale(
    val id: Long? = null,
    val vehicleId: Long,
    val buyerCpf: String,
    val finalValue: BigDecimal,
    val saleDate: LocalDateTime
)