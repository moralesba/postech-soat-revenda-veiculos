package br.com.postech.soat.revendaveiculos.infrastructure.persistence

import br.com.postech.soat.revendaveiculos.domain.entities.Vehicle
import br.com.postech.soat.revendaveiculos.domain.entities.VehicleStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "veiculos")
data class VehicleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val ano: Int,
    val cor: String,
    val marca: String,
    val modelo: String,
    val preco: BigDecimal,
    @Enumerated(EnumType.STRING)
    val status: VehicleStatus,
    val cpfComprador: String?,
    val codigoPagamento: String?
)

// Funções de Mapeamento para converter entre Domínio e Persistência
fun VehicleEntity.toDomain(): Vehicle = Vehicle(
    id = this.id,
    ano = this.ano,
    cor = this.cor,
    marca = this.marca,
    preco = this.preco,
    status = this.status,
    modelo = this.modelo,
    cpfComprador = this.cpfComprador,
    codigoPagamento = this.codigoPagamento
)

fun Vehicle.toEntity(): VehicleEntity = VehicleEntity(
    id = this.id,
    marca = this.marca,
    modelo = this.modelo,
    ano = this.ano,
    cor = this.cor,
    preco = this.preco,
    status = this.status,
    cpfComprador = this.cpfComprador,
    codigoPagamento = this.codigoPagamento
)