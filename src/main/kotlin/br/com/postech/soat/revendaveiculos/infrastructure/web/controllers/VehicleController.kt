package br.com.postech.soat.revendaveiculos.infrastructure.web.controllers

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.exceptions.VehicleNotFoundException
import br.com.postech.soat.revendaveiculos.domain.usecases.EditVehicleUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.RegisterVehicleUseCase
import br.com.postech.soat.revendaveiculos.infrastructure.web.controllers.dto.UpdateVehicleRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/veiculos")
class VehicleController(
    private val editVehicleUseCase: EditVehicleUseCase,
    private val registerVehicleUseCase: RegisterVehicleUseCase)
{

    @PostMapping
    fun createVehicle(@Valid @RequestBody request: CreateVehicleRequest): ResponseEntity<Vehicle> {
        val vehicleDomain = request.toDomain()
        val createdVehicle = registerVehicleUseCase.execute(vehicleDomain)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle)
    }

    @PutMapping("/{id}")
    fun updateVehicle(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdateVehicleRequest
    ): ResponseEntity<Vehicle> {
        val vehicleDomain = request.toDomain(id)
        val updatedVehicle = editVehicleUseCase.execute(id, vehicleDomain)
        return ResponseEntity.ok(updatedVehicle)
    }

    @ExceptionHandler(VehicleNotFoundException::class)
    fun handleVehicleNotFound(ex: VehicleNotFoundException): ResponseEntity<Map<String, String?>?> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("error" to ex.message))
    }
}