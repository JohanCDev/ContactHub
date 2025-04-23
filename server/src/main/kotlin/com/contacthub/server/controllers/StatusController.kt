package com.contacthub.health

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class HealthController(
    private val dbHealthService: DbHealthService
) {

    @GetMapping
    fun status(): ResponseEntity<Map<String, String>> {
        val dbStatus = if (dbHealthService.isDbUp()) "UP" else "DOWN"

        val overallStatus = mapOf("dbStatus" to dbStatus, "status" to "UP")

        return ResponseEntity.ok(overallStatus)
    }
}
