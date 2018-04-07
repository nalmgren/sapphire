package com.gleam.finder

import io.ebean.EbeanServer
import io.ebean.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
abstract class AbstractFinder<T>(private var clazz: Class<T>) {

    @Autowired
    lateinit var ebeanServer: EbeanServer

    val query: Query<T> by lazy { ebeanServer.createQuery(clazz) }
}