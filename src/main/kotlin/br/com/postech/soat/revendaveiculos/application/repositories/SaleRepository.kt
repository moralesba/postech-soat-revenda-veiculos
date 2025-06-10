package br.com.postech.soat.revendaveiculos.application.repositories

import br.com.postech.soat.revendaveiculos.domain.entities.Sale

interface SaleRepository {
    fun save(sale: Sale): Sale
}