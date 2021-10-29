package com.anatolyg.poemtolog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val LOG_PUSHK: String = "logPushk"
private var countStart: Int = 0
private var countResume: Int = 0
private var countPause: Int = 0
private var countStop: Int = 0
private var countRestart: Int = 0

// Стих выводится корректно для последовательности действий:
// Открыть (первый раз, в недавно открытых быть не должно),
// свернуть (кнопка "домой"),
// восстановить (кнопка "обзор", выбор из списка недавно открытых),
// снова свернуть,
// снова восстановить,
// закрыть (кнопка "назад").
// Операции пауза-резюме не удается съимитровать на эмуляторе (Pixel2 API24),
// поэтому не стал их использовать в цепочке.

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_PUSHK, getString(R.string.puskin01))
    }

    override fun onStart() {
        super.onStart()
        when{
            countStart == 0 -> Log.d(LOG_PUSHK, getString(R.string.puskin02))
            countStart == 1 -> Log.d(LOG_PUSHK, getString(R.string.puskin07))
        }
        countStart++
    }

    override fun onResume() {
        super.onResume()
        when{
            countResume == 0 -> Log.d(LOG_PUSHK, getString(R.string.puskin03))
            countResume == 1 -> Log.d(LOG_PUSHK, getString(R.string.puskin08))
        }
        countResume++
    }

    override fun onPause() {
        super.onPause()
        when{
            countPause == 0 -> Log.d(LOG_PUSHK, getString(R.string.puskin04))
            countPause == 1 -> Log.d(LOG_PUSHK, getString(R.string.puskin09))
        }
        countPause++
    }

    override fun onStop() {
        super.onStop()
        when{
            countStop == 0 -> Log.d(LOG_PUSHK, getString(R.string.puskin05))
            countStop == 1 -> Log.d(LOG_PUSHK, getString(R.string.puskin10))
        }
        countStop++
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_PUSHK, getString(R.string.puskin12))
    }

    override fun onRestart() {
        super.onRestart()
        when{
            countRestart == 0 -> Log.d(LOG_PUSHK, getString(R.string.puskin06))
            countRestart == 1 -> Log.d(LOG_PUSHK, getString(R.string.puskin11))
        }
        countRestart++
    }

}