package br.com.postech.soat.revendaveiculos.domain.usecases

import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus
import br.com.postech.soat.revendaveiculos.domain.exceptions.VehicleNotFoundException
import java.util.UUID

class InitiateSaleUseCase(private val vehicleRepository: VehicleRepository) {
    fun execute(id: Long, cpfComprador: String): Vehicle {
        val vehicle = vehicleRepository.findById(id)
            ?: throw VehicleNotFoundException("Veículo com ID $id não encontrado.")

        if (vehicle.status != VehicleStatus.A_VENDA) {
            throw IllegalStateException("Este veículo não está disponível para venda.")
        }

        vehicle.cpfComprador = cpfComprador
        vehicle.status = VehicleStatus.PAGAMENTO_PENDENTE
        vehicle.codigoPagamento = UUID.randomUUID().toString()

        return vehicleRepository.save(vehicle)
    }
}