package com.example.fooddonation.Navigation

sealed class Screen (val route: String){
    object loginScreen: Screen("login")
    object singupScreen: Screen("signup")

    fun withArgs (vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {
                    arg->
                append("/$arg")
            }
        }
    }
}
