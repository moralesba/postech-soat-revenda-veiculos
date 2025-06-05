package br.com.postech.soat.revendaveiculos


import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.usecases.RegisterVehicleUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansConfig {
    @Bean
    fun registerVehicleUseCase(vehicleRepository: VehicleRepository): RegisterVehicleUseCase {
        return RegisterVehicleUseCase(vehicleRepository)
    }
}