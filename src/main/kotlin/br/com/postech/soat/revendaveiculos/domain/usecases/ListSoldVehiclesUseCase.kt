package br.com.postech.soat.revendaveiculos.domain.usecases

import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus

class ListSoldVehiclesUseCase(private val vehicleRepository: VehicleRepository) {
    fun execute(): List<Vehicle> {
        return vehicleRepository.findAllByStatusOrderByPriceAsc(VehicleStatus.VENDIDO)
    }
}