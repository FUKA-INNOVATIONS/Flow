package com.fuka.flow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


/**
 * Flows are corutines
 */


class TimerViewModel : ViewModel() {

    // flatMapConcat
    // flatMapMerge
    // flatMapLatest
    // .buffet()    = runs the flow/partially in different coroutine -> check Filips video2 21.29
    // .conflate()  =


    val countdownFlow = flow<Int> {
        val startValue = 10
        var currentValue = startValue
        emit(currentValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        //collectFlow()
    }



    /*private fun collectFlow() {
        viewModelScope.launch {
            val reduce = countdownFlow
                .reduce { accumulator, value -> //.fold(100)
                    println("The c -- ac: $accumulator - v: $value")
                    accumulator + value
                }

        }
    }*/



    /*private fun collectFlow() {
        viewModelScope.launch {
            val count = countdownFlow
                .filter { time ->
                    time % 2 == 0
                }
                .count { // returns based on this condition (+ earlier conditions like filter)and assign to variable
                    it % 2 == 0
                }
            println("The c $count")
        }
    }*/




    /*private fun collectFlow() {
        viewModelScope.launch {
            countdownFlow
                .filter { time ->
                    time % 2 == 0
                }
                .map { time ->
                    time * time
                }
                .onEach { time -> // Does not transform values, just does something with them
                    println("The current : $time")
                }
                .collect { time ->
                    println("The current time is $time")
                }
        }
    }*/


    /* val countdownFlow = flow<Int> {
         val startValue = 10
         var currentValue = startValue
         emit(currentValue)
         while (currentValue > 0) {
             delay(1000L)
             currentValue--
             emit(currentValue)
         }
     }

     private fun collectFlow() {
         viewModelScope.launch {
             countdownFlow.collect { // collectLatest
                 delay(1000L)
             }
         }
     }*/


    /*private fun collectFlow2() {
        viewModelScope.launch {
            countdownFlow.onEach {
                println(it)
            }.launchIn(viewModelScope)
        }
    }*/


}