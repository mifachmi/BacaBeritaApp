package id.mifachmi.bacaberitaapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform