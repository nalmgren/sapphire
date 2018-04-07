package com.gleam.config

import io.ebean.config.CurrentUserProvider
import org.springframework.stereotype.Component

@Component
class CurrentUser : CurrentUserProvider {

    override fun currentUser(): Any {
        return "test"
    }
}