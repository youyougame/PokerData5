package jp.playing.table.pokerdata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ShowDownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_down)

        supportActionBar?.title = "Showdown"
    }
}
