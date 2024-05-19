package com.example.m_littlelemon.route

interface Destinations {
    val route: String
}

object LoginS : Destinations {
    override val route = "Login"
}

object Prof : Destinations {
    override val route = "Profile"
}