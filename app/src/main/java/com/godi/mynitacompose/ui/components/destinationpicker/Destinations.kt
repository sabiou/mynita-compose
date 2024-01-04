package com.godi.mynitacompose.ui.components.destinationpicker

data class Destination(
    val name: String
)

fun getDestinations(): List<Destination> {
    val destinations: MutableList<Destination> = ArrayList()
    destinations.add(Destination("Maradi"))
    destinations.add(Destination("Niamey"))
    destinations.add(Destination("Dosso"))
    destinations.add(Destination("Tillabery"))
    destinations.add(Destination("Zinder"))
    destinations.add(Destination("Diffa"))
    destinations.add(Destination("Tahoua"))
    destinations.add(Destination("Agadez"))
    return destinations
}