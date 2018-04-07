package com.gleam.config

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class DatabaseMigrator : ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private lateinit var environment: Environment

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val flyway = Flyway()
        flyway.setDataSource(
                environment.getProperty("datasource.db.databaseUrl"),
                environment.getProperty("datasource.db.username"),
                environment.getProperty("datasource.db.password")
        )
        flyway.migrate()
    }
}