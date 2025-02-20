package org.ntt.habittracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform