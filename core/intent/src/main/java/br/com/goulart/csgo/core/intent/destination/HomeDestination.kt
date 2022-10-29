package br.com.goulart.csgo.core.intent.destination

object HomeDestination {

    object Matches : ChildDestination(parent = ParentDestination.Home, route = "matches")

}