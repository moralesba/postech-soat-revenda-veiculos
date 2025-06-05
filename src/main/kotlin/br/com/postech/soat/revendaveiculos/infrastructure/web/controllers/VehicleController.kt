package br.com.postech.soat.revendaveiculos.infrastructure.web.controllers

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.usecases.RegisterVehicleUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/veiculos")
class VehicleController(private val registerVehicleUseCase: RegisterVehicleUseCase) {
    @PostMapping
    fun createVehicle(@Valid @RequestBody request: CreateVehicleRequest): ResponseEntity<Vehicle> {
        val vehicleDomain = request.toDomain()
        val createdVehicle = registerVehicleUseCase.execute(vehicleDomain)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle)
    }
}