package br.com.postech.soat.revendaveiculos.infrastructure.persistence

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "veiculos")
data class VehicleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val marca: String,
    val modelo: String,
    val ano: Int,
    val cor: String,
    val preco: BigDecimal,
    @Enumerated(EnumType.STRING)
    val status: VehicleStatus
)

// Funções de Mapeamento para converter entre Domínio e Persistência
fun VehicleEntity.toDomain(): Vehicle = Vehicle(
    id = this.id,
    marca = this.marca,
    modelo = this.modelo,
    ano = this.ano,
    cor = this.cor,
    preco = this.preco,
    status = this.status
)

fun Vehicle.toEntity(): VehicleEntity = VehicleEntity(
    id = this.id,
    marca = this.marca,
    modelo = this.modelo,
    ano = this.ano,
    cor = this.cor,
    preco = this.preco,
    status = this.status
)