package uk.nightlines.navigation

import androidx.navigation.NamedNavArgument

object Directions {

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""

    }
}