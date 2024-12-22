package com.example.calculator

sealed class Actions {
    data class Number(val number: Int): Actions()
    object Clear: Actions()
    object Delete: Actions()
    object Decimal: Actions()
    object Calculate: Actions()
    data class Operation(val operation : Operations): Actions()


}