package com.example.jokeapp.ui.joke

import com.example.jokeapp.data.model.Joke

object DataProvider {

    val jokeList = listOf(
        Joke(
            id = 1,
            joke = "",
            type = "twopart",
            setup = "Why do Africans have dark skin?",
            delivery = "It's easier to commit crimes at night.",
            category = "Dark",
        ),
        Joke(
            id = 2,
            joke = "How do you make holy water? You boil the hell out of it.",
            type = "single",
            setup = "",
            delivery = "",
            category = "Pun",
        ),
        Joke(
            id = 3,
            type = "single",
            joke = "I bought some shoes from a drug dealer. I don't know what he laced them with, but I was tripping all day!",
            setup = "",
            delivery = "",
            category = "Pun",
        ),
        Joke(
            id = 4,
            type = "single",
            joke = "Two SQL tables sit at the bar. A query approaches and asks \"Can I join you?\"",
            setup = "",
            delivery = "",
            category = "Programming",
        ),
    )
}