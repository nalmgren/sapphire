package com.gleam.config

import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class EbeanFactoryBean : FactoryBean<EbeanServer> {

    @Autowired
    lateinit var currentUser: CurrentUser

    @Autowired
    lateinit var databaseConfiguration: DatabaseConfiguration

    @Autowired
    lateinit var environment: Environment

    override fun getObject(): EbeanServer? {
        val config = ServerConfig()
        config.name = "db"
        config.currentUserProvider = currentUser
        config.isDefaultServer = true
        val databaseConfiguration = databaseConfiguration.toProperties()
        databaseConfiguration.put("ebean.search.packages", environment.getProperty("ebean.search.packages"))
        config.loadFromProperties(databaseConfiguration)
        return EbeanServerFactory.create(config)
    }

    override fun getObjectType(): Class<EbeanServer>? {
        return EbeanServer::class.java
    }

    override fun isSingleton(): Boolean {
        return true
    }
}