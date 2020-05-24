package jp.playing.table.pokerdata

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_setting.*

import kotlinx.android.synthetic.main.activity_turn.*
import kotlin.math.log

class TurnActivity : AppCompatActivity() {

    private var SpinnerText = ""

    private var mMember = 0

    private var mChips = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turn)
        setSupportActionBar(turnToolbar)

        //インテントを受け取る
        val extras = intent.extras
        mMember = extras.getString("Member").toInt()
        mChips = extras.getString("Chips").toInt()

        //Spinnerの準備
        val spinnerItems = arrayOf(
            "",
            "自分"
        )

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            spinnerItems
        )

        turnSpinner1.adapter = adapter
        turnSpinner2.adapter = adapter
        turnSpinner3.adapter = adapter
        turnSpinner4.adapter = adapter
        turnSpinner5.adapter = adapter
        turnSpinner6.adapter = adapter
        turnSpinner7.adapter = adapter
        turnSpinner8.adapter = adapter
        turnSpinner9.adapter = adapter
        turnSpinner10.adapter = adapter




        //UI部品の設定
        //Spinnerのリスナー
        turnSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit1.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit2.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit3.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit4.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit5.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit6.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit7.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit8.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner9.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit9.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        turnSpinner10.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                if (item == "自分"){
                    turnEdit10.setText(mChips.toString())
                }

                SpinnerText = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //プレイヤー新規登録ボタンのリスナー
        newPlayerButton.setOnClickListener {
            val intent = Intent(this@TurnActivity, AddMemberListActivity::class.java)
            startActivity(intent)
        }

        //全員同額ボタンのリスナー
        sameChipsButton.setOnClickListener {
            turnEdit1.setText(mChips.toString())
            turnEdit2.setText(mChips.toString())
            turnEdit3.setText(mChips.toString())
            turnEdit4.setText(mChips.toString())
            turnEdit5.setText(mChips.toString())
            turnEdit6.setText(mChips.toString())
            turnEdit7.setText(mChips.toString())
            turnEdit8.setText(mChips.toString())
            turnEdit9.setText(mChips.toString())
            turnEdit10.setText(mChips.toString())
        }

        //決定ボタンのリスナー
        turnDoneButton.setOnClickListener {

            val intent = Intent(this@TurnActivity, HandActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        Log.d("kotlintest", "通過")

        //設定したプレイヤー数のみ表示する
        when {
            (mMember == 2) -> {
                turnText3.visibility = View.INVISIBLE
                turnText4.visibility = View.INVISIBLE
                turnText5.visibility = View.INVISIBLE
                turnText6.visibility = View.INVISIBLE
                turnText7.visibility = View.INVISIBLE
                turnText8.visibility = View.INVISIBLE
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit3.visibility = View.INVISIBLE
                turnEdit4.visibility = View.INVISIBLE
                turnEdit5.visibility = View.INVISIBLE
                turnEdit6.visibility = View.INVISIBLE
                turnEdit7.visibility = View.INVISIBLE
                turnEdit8.visibility = View.INVISIBLE
                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner3.visibility = View.INVISIBLE
                turnSpinner4.visibility = View.INVISIBLE
                turnSpinner5.visibility = View.INVISIBLE
                turnSpinner6.visibility = View.INVISIBLE
                turnSpinner7.visibility = View.INVISIBLE
                turnSpinner8.visibility = View.INVISIBLE
                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 3) -> {
                turnText4.visibility = View.INVISIBLE
                turnText5.visibility = View.INVISIBLE
                turnText6.visibility = View.INVISIBLE
                turnText7.visibility = View.INVISIBLE
                turnText8.visibility = View.INVISIBLE
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit4.visibility = View.INVISIBLE
                turnEdit5.visibility = View.INVISIBLE
                turnEdit6.visibility = View.INVISIBLE
                turnEdit7.visibility = View.INVISIBLE
                turnEdit8.visibility = View.INVISIBLE
                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner4.visibility = View.INVISIBLE
                turnSpinner5.visibility = View.INVISIBLE
                turnSpinner6.visibility = View.INVISIBLE
                turnSpinner7.visibility = View.INVISIBLE
                turnSpinner8.visibility = View.INVISIBLE
                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 4) -> {
                turnText5.visibility = View.INVISIBLE
                turnText6.visibility = View.INVISIBLE
                turnText7.visibility = View.INVISIBLE
                turnText8.visibility = View.INVISIBLE
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit5.visibility = View.INVISIBLE
                turnEdit6.visibility = View.INVISIBLE
                turnEdit7.visibility = View.INVISIBLE
                turnEdit8.visibility = View.INVISIBLE
                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner5.visibility = View.INVISIBLE
                turnSpinner6.visibility = View.INVISIBLE
                turnSpinner7.visibility = View.INVISIBLE
                turnSpinner8.visibility = View.INVISIBLE
                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 5) -> {
                turnText6.visibility = View.INVISIBLE
                turnText7.visibility = View.INVISIBLE
                turnText8.visibility = View.INVISIBLE
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit6.visibility = View.INVISIBLE
                turnEdit7.visibility = View.INVISIBLE
                turnEdit8.visibility = View.INVISIBLE
                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner6.visibility = View.INVISIBLE
                turnSpinner7.visibility = View.INVISIBLE
                turnSpinner8.visibility = View.INVISIBLE
                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 6) -> {
                turnText7.visibility = View.INVISIBLE
                turnText8.visibility = View.INVISIBLE
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit7.visibility = View.INVISIBLE
                turnEdit8.visibility = View.INVISIBLE
                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner7.visibility = View.INVISIBLE
                turnSpinner8.visibility = View.INVISIBLE
                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 7) -> {
                Log.d("kotlintest", "通過2")
                turnText8.visibility = View.INVISIBLE
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit8.visibility = View.INVISIBLE
                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner8.visibility = View.INVISIBLE
                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 8) -> {
                turnText9.visibility = View.INVISIBLE
                turnText10.visibility = View.INVISIBLE

                turnEdit9.visibility = View.INVISIBLE
                turnEdit10.visibility = View.INVISIBLE

                turnSpinner9.visibility = View.INVISIBLE
                turnSpinner10.visibility = View.INVISIBLE
            }

            (mMember == 9) -> {
                turnText10.visibility = View.INVISIBLE

                turnEdit10.visibility = View.INVISIBLE

                turnSpinner10.visibility = View.INVISIBLE
            }
        }
    }

}