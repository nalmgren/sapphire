package com.gleam.config

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class DatabaseMigrator : ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private lateinit var databaseConfiguration: DatabaseConfiguration

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val flyway = Flyway()
        flyway.setDataSource(
                databaseConfiguration.url,
                databaseConfiguration.username,
                databaseConfiguration.password
        )
        flyway.migrate()
    }
}