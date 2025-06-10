package br.com.postech.soat.revendaveiculos.infrastructure.persistence

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "vendas")
data class SaleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val vehicleId: Long,
    val buyerCpf: String,
    val finalValue: BigDecimal,
    val saleDate: LocalDateTime
)