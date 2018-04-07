package com.gleam.finder

import com.gleam.model.Person
import org.springframework.stereotype.Repository

@Repository
class PersonFinder : AbstractFinder<Person>(Person::class.java) {

    fun all(): List<Person> {
        return query.findList()
    }
}