package com.gleam.controller

import com.gleam.model.Person
import io.ebean.EbeanServer
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jedi")
class TestController(val ebeanServer: EbeanServer) {

    @RequestMapping("/list", method = arrayOf(RequestMethod.GET))
    fun get(): Jedi {
        val jedi = ebeanServer.find(Person::class.java).where().eq("name", "Luke").findOne()
        return Jedi(jedi?.name ?: "Not found", 73)
        //return JediList(database.getCollection<Jedi>().find().map { result -> Jedi(result.name, result.age) })
    }

    data class Jedi(val name: String, val age: Int)

    /*
    data class JediList(
        //val jedis: MongoIterable<Jedi>
    )
    */
}