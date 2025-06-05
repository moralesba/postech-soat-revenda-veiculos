package br.com.postech.soat.revendaveiculos.infrastructure.web.controllers

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class CreateVehicleRequest(
    @field:NotBlank val marca: String,
    @field:NotBlank val modelo: String,
    @field:Positive val ano: Int,
    @field:NotBlank val cor: String,
    @field:Positive val preco: BigDecimal
) {
    fun toDomain(): Vehicle {
        return Vehicle(marca = marca, modelo = modelo, ano = ano, cor = cor, preco = preco, status = VehicleStatus.A_VENDA)
    }
}