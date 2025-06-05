package br.com.postech.soat.revendaveiculos.domain.usecases

import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.exceptions.VehicleNotFoundException

class EditVehicleUseCase(private val vehicleRepository: VehicleRepository) {

    fun execute(id: Long, vehicleData: Vehicle): Vehicle {

        val existingVehicle = vehicleRepository.findById(id)
            ?: throw VehicleNotFoundException("Veículo com ID $id não encontrado.")

        val updatedVehicle = existingVehicle.copy(
            marca = vehicleData.marca,
            modelo = vehicleData.modelo,
            ano = vehicleData.ano,
            cor = vehicleData.cor,
            preco = vehicleData.preco
        )

        return vehicleRepository.save(updatedVehicle)
    }
}