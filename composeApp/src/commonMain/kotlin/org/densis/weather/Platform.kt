package org.densis.weather

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform