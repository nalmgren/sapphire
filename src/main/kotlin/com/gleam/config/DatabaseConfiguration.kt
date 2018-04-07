package com.gleam.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.util.Properties

const val PREFIX = "datasource.db"
const val PROP_USER = "$PREFIX.username"
const val PROP_PASSWORD = "$PREFIX.password"
const val PROP_DRIVER = "$PREFIX.driver"
const val PROP_URL = "$PREFIX.databaseUrl"

@Configuration
@ConfigurationProperties(prefix = "datasource.db")
class DatabaseConfiguration {

    lateinit var host: String
    lateinit var username: String
    lateinit var password: String
    val driver: String = "org.postgresql.Driver"

    val url: String by lazy { "jdbc:postgresql://$host:5432/sapphire?useSSL=false" }

    fun toProperties(): Properties {
        val properties = Properties()
        properties.put(PROP_URL, url)
        properties.put(PROP_USER, username)
        properties.put(PROP_PASSWORD, password)
        properties.put(PROP_DRIVER, driver)
        return properties
    }
}