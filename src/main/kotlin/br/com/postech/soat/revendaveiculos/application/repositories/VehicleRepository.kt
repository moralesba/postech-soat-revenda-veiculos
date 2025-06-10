package br.com.postech.soat.revendaveiculos.application.repositories

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus

interface VehicleRepository {
    fun findById(id: Long): Vehicle?
    fun save(vehicle: Vehicle): Vehicle
    fun findByPaymentCode(paymentCode: String): Vehicle?
    fun findAllByStatusOrderByPriceAsc(status: VehicleStatus): List<Vehicle>
}