package com.example.ganng.myminislot

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.sub_activity.*

class SubActivity : AppCompatActivity(){
    var coin = 0;
    var bet = 0;
    val array = arrayOf(R.drawable.banana,R.drawable.bar,R.drawable.bigwin,R.drawable.cherry
        , R.drawable.grape, R.drawable.lemon, R.drawable.orange
        , R.drawable.seven, R.drawable.waltermelon)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sub_activity)



        coin = intent.getIntExtra("coin",0)
        bet = intent.getIntExtra("bet", 0)

        my_coin1.setText(coin.toString())
        my_bet1.setText(bet.toString())
        btn.setOnClickListener { stop(it) }
        modoru.setOnClickListener { modoru(it) }
    }

    fun stop(view: View?){
        val bt1 = (Math.random() * 9).toInt()
        iv_1.setImageResource(array[bt1])
        val bt2 = (Math.random() * 9).toInt()
        iv_2.setImageResource(array[bt2])
        val bt3 = (Math.random() * 9).toInt()
        iv_3.setImageResource(array[bt3])

        if(coin >= bet){
            if (bt1 == bt2 && bt2 == bt3) {

                if(bt1 == 7){
                    coin = coin + (bet * 30)
                }else if(bt1 == 3){
                    coin = coin + (bet * 10)
                }else if(bt1 == 2){
                    coin = coin + (bet * 5)
                }else{
                    coin = coin + (bet * 3)
                }

            }else if(bt1 == bt2 || bt2 == bt3 || bt1 == bt3){
                coin = coin + (bet * 1)

            }else if(bt1 == 9 || bt2 == 9 || bt3 == 9){
                coin = coin * (bet * 1)
            }else if(bt1 == 7 && bt2 == 4 && bt3 == 6){
                coin = coin * (bet * 30)
            }else if(bt1 == 9 && bt2 == 1 && bt3 == 5){
                coin = coin * (bet * 10)
            }else{
                coin = coin - bet
            }

            my_coin1.setText(coin.toString())

            val prefer = PreferenceManager.getDefaultSharedPreferences(this);
            val editor = prefer.edit()
            editor.putInt("MY_COIN",coin).apply()
            editor.commit()
        }

    }

    fun modoru(view: View?){

        finish()
    }




}