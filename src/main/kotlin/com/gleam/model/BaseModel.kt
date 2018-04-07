package com.gleam.model

import io.ebean.Model
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class BaseModel: Model() {

    @Id
    var id: Long? = null

    @Version
    var version: Long? = null

    /*
    @WhenCreated
    lateinit var whenCreated: Timestamp

    @WhenModified
    lateinit var whenModified: Timestamp

    @WhoCreated
    lateinit var whoCreated: String

    @WhoModified
    lateinit var whoModified: String
    */
}