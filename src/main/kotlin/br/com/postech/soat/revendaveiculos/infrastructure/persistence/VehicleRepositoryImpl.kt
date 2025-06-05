package br.com.postech.soat.revendaveiculos.infrastructure.persistence

import br.com.postech.soat.revendaveiculos.application.repositories.VehicleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface VehicleJPARepository : JpaRepository<VehicleEntity, Long>

@Repository
class VehicleRepositoryImpl(private val jpaRepository: VehicleJPARepository) : VehicleRepository {
    override fun save(vehicle: Vehicle): Vehicle {
        val entity = vehicle.toEntity()
        val savedEntity = jpaRepository.save(entity)
        return savedEntity.toDomain()
    }

    override fun findById(id: Long): Vehicle? {
        return jpaRepository.findById(id)
            .map { it.toDomain() } // Mapeia de Entity para Domain se encontrar
            .orElse(null)
    }
}