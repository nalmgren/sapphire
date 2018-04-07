package com.gleam.model

import javax.persistence.Entity

@Entity
class Person : BaseModel() {
    lateinit var name: String
}