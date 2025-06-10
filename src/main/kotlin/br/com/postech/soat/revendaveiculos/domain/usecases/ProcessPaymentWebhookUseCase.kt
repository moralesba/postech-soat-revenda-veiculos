package br.com.postech.soat.revendaveiculos.domain.usecases

import br.com.postech.soat.revendaveiculos.application.repositories.SaleRepository
import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Sale
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus
import br.com.postech.soat.revendaveiculos.domain.exceptions.VehicleNotFoundException
import java.time.LocalDateTime

class ProcessPaymentWebhookUseCase(
    private val vehicleRepository: VehicleRepository,
    private val saleRepository: SaleRepository
) {
    fun execute(paymentCode: String, paymentStatus: String) {
        val vehicle = vehicleRepository.findByPaymentCode(paymentCode)
            ?: throw VehicleNotFoundException("Veículo com código de pagamento $paymentCode não encontrado.")

        if (vehicle.status != VehicleStatus.PAGAMENTO_PENDENTE) {
            throw IllegalStateException("Este veículo não está aguardando pagamento.")
        }

        if (paymentStatus.equals("efetuado", ignoreCase = true)) {
            vehicle.status = VehicleStatus.VENDIDO
            vehicleRepository.save(vehicle)

            val sale = Sale(
                vehicleId = vehicle.id!!,
                buyerCpf = vehicle.cpfComprador!!,
                saleDate = LocalDateTime.now(),
                finalValue = vehicle.preco
            )
            saleRepository.save(sale)

        } else {
            vehicle.status = VehicleStatus.A_VENDA
            vehicle.cpfComprador = null
            vehicle.codigoPagamento = null
            vehicleRepository.save(vehicle)
        }
    }
}