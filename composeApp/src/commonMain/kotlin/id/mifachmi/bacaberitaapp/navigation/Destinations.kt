package id.mifachmi.bacaberitaapp.navigation

enum class Destination(
    val route: String,
    val label: String
) {
    HOME("/beranda", "Beranda"),
    BOOKMARKS("/bookmarks", "Bookmarks")
}