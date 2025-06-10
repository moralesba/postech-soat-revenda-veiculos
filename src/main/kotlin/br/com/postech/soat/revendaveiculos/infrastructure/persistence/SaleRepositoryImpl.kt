package br.com.postech.soat.revendaveiculos.infrastructure.persistence

import br.com.postech.soat.revendaveiculos.application.repositories.SaleRepository
import br.com.postech.soat.revendaveiculos.domain.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SaleJPARepository : JpaRepository<SaleEntity, Long>

@Repository
class SaleRepositoryImpl(private val jpaRepository: SaleJPARepository) : SaleRepository {
    override fun save(sale: Sale): Sale {
        val entity = SaleEntity(
            vehicleId = sale.vehicleId,
            buyerCpf = sale.buyerCpf,
            saleDate = sale.saleDate,
            finalValue = sale.finalValue
        )
        jpaRepository.save(entity)
        return sale
    }
}