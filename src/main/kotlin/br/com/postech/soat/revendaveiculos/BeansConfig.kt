package br.com.postech.soat.revendaveiculos

import br.com.postech.soat.revendaveiculos.application.repositories.SaleRepository
import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.usecases.EditVehicleUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.InitiateSaleUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.ListAvailableVehiclesUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.ListSoldVehiclesUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.ProcessPaymentWebhookUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.RegisterVehicleUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansConfig {
    @Bean
    fun registerVehicleUseCase(vehicleRepository: VehicleRepository): RegisterVehicleUseCase {
        return RegisterVehicleUseCase(vehicleRepository)
    }

    @Bean
    fun editVehicleUseCase(vehicleRepository: VehicleRepository): EditVehicleUseCase {
        return EditVehicleUseCase(vehicleRepository)
    }

    @Bean
    fun initiateSaleUseCase(vehicleRepository: VehicleRepository): InitiateSaleUseCase {
        return InitiateSaleUseCase(vehicleRepository)
    }

    @Bean
    fun processPaymentWebhookUseCase(
        vehicleRepository: VehicleRepository,
        saleRepository: SaleRepository
    ): ProcessPaymentWebhookUseCase {
        return ProcessPaymentWebhookUseCase(vehicleRepository, saleRepository)
    }

    @Bean
    fun listAvailableVehiclesUseCase(vehicleRepository: VehicleRepository): ListAvailableVehiclesUseCase {
        return ListAvailableVehiclesUseCase(vehicleRepository)
    }

    @Bean
    fun listSoldVehiclesUseCase(vehicleRepository: VehicleRepository): ListSoldVehiclesUseCase {
        return ListSoldVehiclesUseCase(vehicleRepository)
    }
}