package br.com.postech.soat.revendaveiculos.application.repositories

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle

interface VehicleRepository {
    fun save(vehicle: Vehicle): Vehicle
}