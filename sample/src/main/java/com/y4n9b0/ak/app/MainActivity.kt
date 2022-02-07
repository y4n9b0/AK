package com.y4n9b0.ak.app

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.y4n9b0.ak.*
import com.y4n9b0.fp.y

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_greeting).visibleIf(true).clicks(
            lifecycleScope,
            duration = 1000,
            onIgnore = { view, interval ->
                toast("click onIgnore $view interval=$interval")
                ("click onIgnore $view interval=$interval").logw()
            },
            onClick = {
                toast("click onClick $it")
            }
        ).expandTouchArea(
            findViewById<ConstraintLayout>(R.id.relative),
            50.dp2px,
            50.dp2px,
            100.dp2px,
            0
        )

        findViewById<TextView>(R.id.text_greeting2).clicks(
            lifecycleScope
        ) {
            toast("click onClick $it")
        }.expandTouchArea(
            findViewById<ConstraintLayout>(R.id.constraint),
            50.dp2px,
            50.dp2px,
            100.dp2px,
            0
        ).visibleIf(true, View.INVISIBLE)

        "screenWidth=$SCREEN_WIDTH screenHeight=$SCREEN_HEIGHT".logd()

        isNetworkAvailable.toString().logd("Bob")
        NetworkObservable(this).observe(this) {
            (if (it) "Network Available" else "Network not available").logd("Bob")
        }

        addAll(2, 3, 1, 60, 4, -7)
        factorial(10)
    }

    private fun addAll(vararg args: Int): Int {
        val sum = y<Int, Int> { f ->
            { n ->
                if (n == 1) args[0]
                else args[n - 1] + f(n - 1)
            }
        }
        return sum(args.size)
    }

    private fun addAll2(vararg args: Int) = y<Int, Int> { f ->
        { n ->
            if (n == 1) args[0]
            else args[n - 1] + f(n - 1)
        }
    }(args.size)

    private fun factorial(n: Int): Int {
        val fact = y<Int, Int> { f ->
            { n ->
                if (n == 0) 1
                else n * f(n - 1)
            }
        }
        return fact(n)
    }

    private fun factorial2(n: Int) = y<Int, Int> { f ->
        { n ->
            if (n == 0) 1
            else n * f(n - 1)
        }
    }(n)
}
