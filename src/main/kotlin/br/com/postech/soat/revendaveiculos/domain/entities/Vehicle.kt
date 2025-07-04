package br.com.postech.soat.revendaveiculos.domain.entities

import java.math.BigDecimal

enum class VehicleStatus {
    A_VENDA, PAGAMENTO_PENDENTE, VENDIDO
}

data class Vehicle(
    val id: Long? = null,
    val ano: Int,
    val cor: String,
    val marca: String,
    val modelo: String,
    val preco: BigDecimal,
    var status: VehicleStatus,
    var cpfComprador: String? = null,
    var codigoPagamento: String? = null
)