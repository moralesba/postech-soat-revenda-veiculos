package br.com.postech.soat.revendaveiculos.infrastructure.web.controllers

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class UpdateVehicleRequest(
    @field:NotBlank val marca: String,
    @field:NotBlank val modelo: String,
    @field:Positive val ano: Int,
    @field:NotBlank val cor: String,
    @field:Positive val preco: BigDecimal
) {
    fun toDomain(id: Long): Vehicle {
        return Vehicle(id = id, marca = marca, modelo = modelo, ano = ano, cor = cor, preco = preco, status = VehicleStatus.A_VENDA)
    }
}

data class InitiateSaleRequest(
    @field:NotBlank(message = "CPF do comprador não pode ser vazio.")
    @field:Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}", message = "Formato de CPF inválido.")
    val cpfComprador: String
)