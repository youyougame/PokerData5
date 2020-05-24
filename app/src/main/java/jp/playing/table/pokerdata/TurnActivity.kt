package jp.playing.table.pokerdata

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_setting.*

import kotlinx.android.synthetic.main.activity_turn.*
import kotlin.math.log

class TurnActivity : AppCompatActivity() {

    private var spinnerText1 = ""
    private var spinnerText2 = ""
    private var spinnerText3 = ""
    private var spinnerText4 = ""
    private var spinnerText5 = ""
    private var spinnerText6 = ""
    private var spinnerText7 = ""
    private var spinnerText8 = ""
    private var spinnerText9 = ""
    private var spinnerText10 = ""

    private var player1 = ""
    private var player2 = ""
    private var player3= ""
    private var player4 = ""
    private var player5 = ""
    private var player6 = ""
    private var player7 = ""
    private var player8 = ""
    private var player9 = ""
    private var player10 = ""

    private var mMember = 0

    private var mChips = 0

    private lateinit var mRealm: Realm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turn)
        setSupportActionBar(turnToolbar)

        //Realmの設定
        mRealm = Realm.getDefaultInstance()
        //Todo mRealm.addChangeListener(mRealmListener)




        //インテントを受け取る
        val extras = intent.extras
        mMember = extras.getString("Member").toInt()
        mChips = extras.getString("Chips").toInt()




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

                spinnerText1 = item
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

                spinnerText2 = item
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

                spinnerText3 = item
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

                spinnerText4 = item
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

                spinnerText5 = item
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

                spinnerText6 = item
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

                spinnerText7 = item
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

                spinnerText8 = item
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

                spinnerText9 = item
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
                spinnerText10 = item
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

            cheackSpinner()

            val intent = Intent(this@TurnActivity, HandActivity::class.java)
            startActivity(intent)
        }

    }

    private fun cheackSpinner() {
        when (mMember) {
            2 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

            }

            3 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }
            }

            4 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }
            }

            5 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }

                when (spinnerText5) {
                    "" -> player5 = "player5"
                    else -> player5 = spinnerText5
                }
            }

            6 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player5 = "player5"
                    else -> player5 = spinnerText5
                }

                when (spinnerText6) {
                    "" -> player6 = "player6"
                    else -> player6 = spinnerText6
                }
            }

            7 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player5 = "player5"
                    else -> player5 = spinnerText5
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player6 = "player6"
                    else -> player6 = spinnerText6
                }

                when (spinnerText7) {
                    "" -> player7 = "player7"
                    else -> player7 = spinnerText7
                }
            }

            8 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player5 = "player5"
                    else -> player5 = spinnerText5
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player6 = "player6"
                    else -> player6 = spinnerText6
                }

                when (spinnerText7) {
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player7 = "player7"
                    else -> player7 = spinnerText7
                }

                when (spinnerText8) {
                    "" -> player8 = "player8"
                    else -> player8 = spinnerText8
                }
            }

            9 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player5 = "player5"
                    else -> player5 = spinnerText5
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player6 = "player6"
                    else -> player6 = spinnerText6
                }

                when (spinnerText7) {
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player7 = "player7"
                    else -> player7 = spinnerText7
                }

                when (spinnerText8) {
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player8 = "player8"
                    else -> player8 = spinnerText8
                }

                when (spinnerText9) {
                    "" -> player9 = "player9"
                    else -> player9 = spinnerText9
                }
            }

            10 -> {
                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player1 = "player1"
                    else -> player1 = spinnerText1
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player2 = "player2"
                    else -> player2 = spinnerText2
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player3 = "player3"
                    else -> player3 = spinnerText3
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player4 = "player4"
                    else -> player4 = spinnerText4
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player5 = "player5"
                    else -> player5 = spinnerText5
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player6 = "player6"
                    else -> player6 = spinnerText6
                }

                when (spinnerText7) {
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player7 = "player7"
                    else -> player7 = spinnerText7
                }

                when (spinnerText8) {
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player8 = "player8"
                    else -> player8 = spinnerText8
                }

                when (spinnerText9) {
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                    "" -> player9 = "player9"
                    else -> player9 = spinnerText9
                }

                when (spinnerText10) {
                    "" -> player10 = "player10"
                    else -> player10 = spinnerText10
                }
            }


        }
    }

    override fun onResume() {
        super.onResume()

        //Spinnerをセット
        val userRealmResults = mRealm.where(User::class.java).contains("name", String()).findAll()

        val spinnerItems = ArrayList<String>()

        spinnerItems.add("")
        spinnerItems.add("自分")

        val length = userRealmResults.size

        for (i in 0 .. length - 1) {
            spinnerItems.add(userRealmResults[i]!!.name)
        }

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