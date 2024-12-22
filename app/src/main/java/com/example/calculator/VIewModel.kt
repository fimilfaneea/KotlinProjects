package com.example.calculator


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: Actions){
        when(action){
            is Actions.Number -> enterNumber(action.number)
            is Actions.Decimal -> enterDecimal()
            is Actions.Clear -> state = CalculatorState()
            is Actions.Operation -> enterOperation(action.operation)
            is Actions.Calculate -> performCalculation()
            is Actions.Delete -> performDelete()
        }
    }

    private fun performDelete() {
       state = when {
            state.number2.isNotBlank() -> state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operations != null -> state.copy(
                operations = null
            )
            state.number1.isNotBlank() -> state.copy(
                number1 = state.number1.dropLast(1)
            )
           else -> state

       }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val  number2 = state.number2.toDoubleOrNull()
        if(number1!=null &&  number2!=null){
        val result =when(state.operations){
            is Operations.Add ->  number1 + number2
            is Operations.Subtract -> number1 - number2
            is Operations.Divide -> number1 / number2
            is Operations.Multiply -> number1 * number2
            null -> return
        }
        state = state.copy(
            number1 = result.toString().take(15),
            number2 =  "",
            operations = null
        )
        }



    }

    private fun enterOperation(operation: Operations) {
        if(state.number1.isNotBlank()){
            state = state.copy(operations = operation)
        }
    }

    private fun enterDecimal() {
        if(state.operations==null && !state.number1.contains(".")
            && state.number1.isNotBlank()){
            state =state.copy(
                number1 = state.number1 + "."
            )
            return
        }

        if( !state.number2.contains(".")
            && state.number2.isNotBlank()){
            state =state.copy(
                number1 = state.number2 + "."
            )

        }

    }

    private fun enterNumber(number: Int) {
    if(state.operations==null){
        if(state.number1.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number1 = state.number1 + number
        )
        return
    }
        if (state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state=state.copy(
            number2 = state.number2 + number
        )
    }
    companion object{
        private const val MAX_NUM_LENGTH = 10
    }
}






