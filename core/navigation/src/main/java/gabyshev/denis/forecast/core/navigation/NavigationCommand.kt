package gabyshev.denis.forecast.core.navigation

import com.github.terrakok.modo.Screen

interface NavigationCommand

data class NavigationForward(val screen: Screen, val screens: List<Screen> = emptyList()) :
    NavigationCommand

data class NavigationReplace(val screen: Screen, val screens: List<Screen> = emptyList()) :
    NavigationCommand

data class NavigationSetStack(val screens: List<Screen>) : NavigationCommand

data class NavigationNewStack(val screen: Screen, val screens: List<Screen> = emptyList()) :
    NavigationCommand

data class NavigationBackTo(val screen: Screen) : NavigationCommand

data class NavigationRemoveScreen(val positions: List<Int>) : NavigationCommand

object NavigationBackToRoot : NavigationCommand

object NavigationBack : NavigationCommand

object NavigationExit : NavigationCommand

