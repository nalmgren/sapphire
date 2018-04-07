package com.gleam.controller

import com.gleam.finder.PersonFinder
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(val finder: PersonFinder) {

    @RequestMapping("/list", method = arrayOf(RequestMethod.GET))
    fun get(): PersonListDto {
        return PersonListDto(finder.all().map { person ->
            PersonDto(person.id!!, person.name)
        })
    }

    data class PersonDto(val id: Long, val name: String)

    data class PersonListDto(
            val people: List<PersonDto>
    )
}