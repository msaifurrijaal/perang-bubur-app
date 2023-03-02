package com.example.perangbubur.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    var question = arrayOf(
        "Kamu kalau makan bubur sagu diaduk apa engga?",
        "Kamu kalau makan bubur ayam diaduk apa engga?",
        "Kamu kalau makan bubur sum-sum diaduk apa engga?"
    )

    var current_q = 0

    private var _questionBubur = MutableLiveData<String>()
    val questionBubur : LiveData<String> = _questionBubur

    private var _diadukScore = MutableLiveData<Int>()
    val diadukScore : LiveData<Int> = _diadukScore

    private var _gaDiadukScore = MutableLiveData<Int>()
    val gaDiadukScore : LiveData<Int> = _gaDiadukScore

    private var _eventFinished = MutableLiveData<Boolean>()
    val eventFinished : LiveData<Boolean> = _eventFinished

    private var _result = MutableLiveData<String>()
    val result : LiveData<String>
        get() = _result

    init {
        _diadukScore.value = 0
        _gaDiadukScore.value = 0
        _questionBubur.value = question[0]
        _eventFinished.value = false
    }

    fun updateScore(choice : Int) {
        current_q++
        if (current_q < question.size) {
            _questionBubur.value = question[current_q]
            if(choice == 1) {
                _diadukScore.value = (_diadukScore.value)?.plus(1)
                _result.value = "Kamu Tim Bubur Diaduk"
            } else {
                _gaDiadukScore.value = (_gaDiadukScore.value)?.plus(1)
                _result.value = "Kamu Tim Bubur Ga Diaduk"
            }
            if(((_diadukScore.value)!!.compareTo(2) >= 0) || ((_gaDiadukScore.value)!!.compareTo(2) >= 0)) {
                _eventFinished.value = true
            }
        }
    }

    fun reset() {
        _eventFinished.value = false
    }
}