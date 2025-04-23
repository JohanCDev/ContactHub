package com.contacthub.health

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class DbHealthService(
    private val jdbcTemplate: JdbcTemplate
) {
    fun isDbUp(): Boolean {
        return try {
            jdbcTemplate.queryForObject("SELECT 1", Int::class.java) == 1
        } catch (ex: Exception) {
            false
        }
    }
}
