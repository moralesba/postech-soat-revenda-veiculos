package br.com.postech.soat.revendaveiculos.infrastructure.web.controllers

import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import br.com.postech.soat.revendaveiculos.domain.usecases.ProcessPaymentWebhookUseCase

data class WebhookRequest(
    @field:NotBlank val status: String,
    @field:NotBlank val codigoPagamento: String
)

@RestController
@RequestMapping("/webhook")
class WebhookController(
    private val processPaymentWebhookUseCase: ProcessPaymentWebhookUseCase
) {
    @PostMapping("/pagamentos")
    fun processPayment(@RequestBody request: WebhookRequest): ResponseEntity<Void> {
        processPaymentWebhookUseCase.execute(request.codigoPagamento, request.status)
        return ResponseEntity.ok().build()
    }
}