package com.gleam.config

import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EbeanFactoryBean : FactoryBean<EbeanServer> {

    @Autowired
    internal var currentUser: CurrentUser? = null

    @Throws(Exception::class)
    override fun getObject(): EbeanServer? {

        val config = ServerConfig()
        config.name = "db"
        config.currentUserProvider = currentUser

        config.loadFromProperties()

        return EbeanServerFactory.create(config)
    }

    override fun getObjectType(): Class<*>? {
        return EbeanServer::class.java
    }

    override fun isSingleton(): Boolean {
        return true
    }
}