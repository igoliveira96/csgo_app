package br.com.goulart.csgo.core.intent.destination

import androidx.navigation.NamedNavArgument
import br.com.goulart.csgo.core.intent.utils.encode
import com.google.gson.Gson

sealed class ParentDestination(val route: String) {
    object Home : ParentDestination(route = "home")
}

sealed class ChildDestination(
    val parent: ParentDestination,
    private val route: String,
) {
    private val gson = Gson()
    fun Any?.toGson(): String = gson.toJson(this).encode()

    open val arguments: List<NamedNavArgument> = emptyList()
    fun createRoute() = "${parent.route}/$route"

}