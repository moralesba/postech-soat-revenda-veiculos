package br.com.postech.soat.revendaveiculos.infrastructure.web.controllers

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.exceptions.VehicleNotFoundException
import br.com.postech.soat.revendaveiculos.domain.usecases.EditVehicleUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.InitiateSaleUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.ListAvailableVehiclesUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.ListSoldVehiclesUseCase
import br.com.postech.soat.revendaveiculos.domain.usecases.RegisterVehicleUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/veiculos")
class VehicleController(
    private val editVehicleUseCase: EditVehicleUseCase,
    private val initiateSaleUseCase: InitiateSaleUseCase,
    private val registerVehicleUseCase: RegisterVehicleUseCase,
    private val listSoldVehiclesUseCase: ListSoldVehiclesUseCase,
    private val listAvailableVehiclesUseCase: ListAvailableVehiclesUseCase
){

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

    @PostMapping("/{id}/vender")
    fun initiateSale(
        @PathVariable id: Long,
        @Valid @RequestBody request: InitiateSaleRequest
    ): ResponseEntity<Vehicle> {
        val updatedVehicle = initiateSaleUseCase.execute(id, request.cpfComprador)
        return ResponseEntity.ok(updatedVehicle)
    }

    @ExceptionHandler(VehicleNotFoundException::class)
    fun handleVehicleNotFound(ex: VehicleNotFoundException): ResponseEntity<Map<String, String?>?> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("error" to ex.message))
    }

    @GetMapping("/a-venda")
    fun listAvailableVehicles(): ResponseEntity<List<Vehicle>> {
        val vehicles = listAvailableVehiclesUseCase.execute()
        return ResponseEntity.ok(vehicles)
    }

    @GetMapping("/vendidos")
    fun listSoldVehicles(): ResponseEntity<List<Vehicle>> {
        val vehicles = listSoldVehiclesUseCase.execute()
        return ResponseEntity.ok(vehicles)
    }
}