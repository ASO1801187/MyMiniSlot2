package com.example.ganng.myminislot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.preference.PreferenceManager


class MainActivity : AppCompatActivity() {
    val defultCoin = 1000;
    val defultbet = 10;
    var coin = 0;
    var bet = 10;
//    val prefer = PreferenceManager.getDefaultSharedPreferences(this);
//    val editor = prefer.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        up_bet.setOnClickListener {bet_upTapped(it)}
        down_bet.setOnClickListener {bet_downTapped(it)}
        reset_btn.setOnClickListener { reset(it) }
        start.setOnClickListener { intent(it) }


    }

    override fun onResume() {
        super.onResume()

        val prefer = PreferenceManager.getDefaultSharedPreferences(this);
        val editor = prefer.edit()
        coin = prefer.getInt("MY_COIN", 1000)
        my_coin1.setText(coin.toString())
        my_bet1.setText(bet.toString())

    }

    fun bet_upTapped(view: View?){
        if(coin <= 0){

        }else{
            coin = coin - 10;
            bet = bet + 10
            my_coin1.setText((coin).toString())
            my_bet1.setText((bet).toString())
        }
    }

    fun bet_downTapped(view: View?){
        if(bet == 10){

        }else{
            coin = coin + 10
            bet = bet -10
            my_coin1.setText((coin).toString())
            my_bet1.setText((bet).toString())
        }
    }
    fun reset(view: View?){
        val prefer = PreferenceManager.getDefaultSharedPreferences(this);
        val editor = prefer.edit()
        coin = defultCoin
        bet = defultbet
        my_coin1.setText((coin).toString())
        my_bet1.setText((bet).toString())
        editor.putInt("MY_COIN",defultCoin)
        editor.commit()
    }
    fun intent(view: View?){
        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("coin" , coin)
        intent.putExtra("bet", bet)
        startActivity(intent)
    }

}
