package br.com.postech.soat.revendaveiculos.domain.usecases

import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus

class RegisterVehicleUseCase(
    private val vehicleRepository: VehicleRepository // Depende da ABSTRAÇÃO
) {
    fun execute(vehicle: Vehicle): Vehicle {
        // Regra de negócio: todo veículo cadastrado começa como "A_VENDA"
        vehicle.status = VehicleStatus.A_VENDA
        return vehicleRepository.save(vehicle)
    }
}