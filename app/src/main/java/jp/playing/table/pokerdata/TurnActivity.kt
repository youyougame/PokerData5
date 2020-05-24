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

    private var player = ""
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

    private var chips1 = "none"
    private var chips2 = "none"
    private var chips3 = "none"
    private var chips4 = "none"
    private var chips5 = "none"
    private var chips6 = "none"
    private var chips7 = "none"
    private var chips8 = "none"
    private var chips9 = "none"
    private var chips10 = "none"

    private var mMember = 0

    private var mChips = 0

    private lateinit var mRealm: Realm

    private var doneChecker1 = "NO"
    private var doneChecker2 = "NO"
    private var doneChecker3 = "NO"
    private var doneChecker4 = "NO"
    private var doneChecker5 = "NO"
    private var doneChecker6 = "NO"
    private var doneChecker7 = "NO"
    private var doneChecker8 = "NO"
    private var doneChecker9 = "NO"
    private var doneChecker10 = "NO"


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

            cheackSpinner2()
            cheackChips()

            if (
                doneChecker1 == "OK" && doneChecker2 == "OK" && doneChecker3 == "OK" && doneChecker4 == "OK" && doneChecker5 == "OK" &&
                doneChecker6 == "OK" && doneChecker7 == "OK" && doneChecker8 == "OK" && doneChecker9 == "OK" && doneChecker10 == "OK"
                    ) {
                val intent = Intent(this@TurnActivity, HandActivity::class.java)
//                intent.putExtra("p1", player1)
//                intent.putExtra("p2", player2)
//                intent.putExtra("p3", player3)
//                intent.putExtra("p4", player4)
//                intent.putExtra("p5", player5)
//                intent.putExtra("p6", player6)
//                intent.putExtra("p7", player7)
//                intent.putExtra("p8", player8)
//                intent.putExtra("p9", player9)
//                intent.putExtra("p10", player10)
//
//                intent.putExtra("c1", chips1)
//                intent.putExtra("c2", chips2)
//                intent.putExtra("c3", chips3)
//                intent.putExtra("c4", chips4)
//                intent.putExtra("c5", chips5)
//                intent.putExtra("c6", chips6)
//                intent.putExtra("c7", chips7)
//                intent.putExtra("c8", chips8)
//                intent.putExtra("c9", chips9)
//                intent.putExtra("c10", chips10)

                startActivity(intent)
            }
        }

    }


    //チップを設定
    private fun cheackChips() {
        when (mMember) {
            2 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
            }

            3 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
            }

            4 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
            }

            5 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
                chips5 = turnEdit5.toString()
            }

            6 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
                chips5 = turnEdit5.toString()
                chips6 = turnEdit6.toString()
            }

            7 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
                chips5 = turnEdit5.toString()
                chips6 = turnEdit6.toString()
                chips7 = turnEdit7.toString()
            }

            8 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
                chips5 = turnEdit5.toString()
                chips6 = turnEdit6.toString()
                chips7 = turnEdit7.toString()
                chips8 = turnEdit8.toString()
            }

            9 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
                chips5 = turnEdit5.toString()
                chips6 = turnEdit6.toString()
                chips7 = turnEdit7.toString()
                chips8 = turnEdit8.toString()
                chips9 = turnEdit9.toString()
            }

            10 -> {
                chips1 = turnEdit1.toString()
                chips2 = turnEdit2.toString()
                chips3 = turnEdit3.toString()
                chips4 = turnEdit4.toString()
                chips5 = turnEdit5.toString()
                chips6 = turnEdit6.toString()
                chips7 = turnEdit7.toString()
                chips8 = turnEdit8.toString()
                chips9 = turnEdit9.toString()
                chips10 = turnEdit10.toString()
            }
        }
    }

    private fun cheackSpinner2() {
        when (mMember) {
            2 -> {
                if (spinnerText1 == "") {
                    spinnerText1 = "player1"
                    doneChecker1 = "OK"
                } else {
                    if (spinnerText1 == spinnerText2) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    } else {
                        doneChecker1 = "OK"
                        doneChecker2 = "OK"
                    }
                }

                if (spinnerText2 == "") {
                    spinnerText2 = "player2"
                    doneChecker2 = "OK"
                }

                doneChecker3 = "OK"
                doneChecker4 = "OK"
                doneChecker5 = "OK"
                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"
            }

            3 -> {
                if (spinnerText1 == "") {
                    spinnerText1 = "player1"
                    doneChecker1 = "OK"
                } else {
                    if (spinnerText1 == spinnerText2) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    } else if (spinnerText1 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    } else {
                        doneChecker1 = "OK"
                    }
                }

                if (spinnerText2 == "") {
                    spinnerText2 = "player2"
                    doneChecker2 = "OK"
                } else {
                    if (spinnerText2 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    } else {
                        doneChecker2 = "OK"
                        doneChecker3 = "OK"
                    }
                }

                if (spinnerText3 == "") {
                    spinnerText3 = "player3"
                    doneChecker3 = "OK"
                }

                doneChecker4 = "OK"
                doneChecker5 = "OK"
                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"
            }

            4 -> {
                if (spinnerText1 == "") {
                    spinnerText1 = "player1"
                    doneChecker1 = "OK"
                } else {
                    if (spinnerText1 == spinnerText2) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    } else if (spinnerText1 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText1 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    } else {
                        doneChecker1 = "OK"
                    }
                }

                if (spinnerText2 == "") {
                    spinnerText2 = "player2"
                    doneChecker2 = "OK"
                } else {
                    if (spinnerText2 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText2 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    } else {
                        doneChecker2 = "OK"
                    }
                }

                if (spinnerText3 == "") {
                    spinnerText3 = "player3"
                    doneChecker3 = "OK"
                } else {
                    if (spinnerText3 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    } else {
                        doneChecker3 = "OK"
                        doneChecker4 = "OK"
                    }
                }

                if (spinnerText4 == "") {
                    spinnerText4 = "player4"
                    doneChecker4 = "OK"
                }

                doneChecker5 = "OK"
                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"
            }

            5 -> {
                if (spinnerText1 == "") {
                    spinnerText1 = "player1"
                    doneChecker1 = "OK"
                } else {
                    if (spinnerText1 == spinnerText2) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    } else if (spinnerText1 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText1 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText1 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    } else {
                        doneChecker1 = "OK"
                    }
                }

                if (spinnerText2 == "") {
                    spinnerText2 = "player2"
                    doneChecker2 = "OK"
                } else {
                    if (spinnerText2 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText2 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText2 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    } else {
                        doneChecker2 = "OK"
                    }
                }

                if (spinnerText3 == "") {
                    spinnerText3 = "player3"
                    doneChecker3 = "OK"
                } else {
                    if (spinnerText3 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText3 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    } else {
                        doneChecker3 = "OK"
                    }
                }

                if (spinnerText4 == "") {
                    spinnerText4 = "player4"
                    doneChecker4 = "OK"
                } else {
                    if (spinnerText4 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    } else {
                        doneChecker4 = "OK"
                        doneChecker5 = "OK"
                    }
                }

                if (spinnerText5 == "") {
                    spinnerText5 = "player5"
                    doneChecker5 = "OK"
                }

                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"
            }

            6 -> {
                if (spinnerText1 == "") {
                    spinnerText1 = "player1"
                    doneChecker1 = "OK"
                } else {
                    if (spinnerText1 == spinnerText2) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    } else if (spinnerText1 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText1 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText1 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText1 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    } else {
                        doneChecker1 = "OK"
                    }
                }

                if (spinnerText2 == "") {
                    spinnerText2 = "player2"
                    doneChecker2 = "OK"
                } else {
                    if (spinnerText2 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText2 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText2 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText2 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    } else {
                        doneChecker2 = "OK"
                    }
                }

                if (spinnerText3 == "") {
                    spinnerText3 = "player3"
                    doneChecker3 = "OK"
                } else {
                    if (spinnerText3 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText3 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText3 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    } else {
                        doneChecker3 = "OK"
                    }
                }

                if (spinnerText4 == "") {
                    spinnerText4 = "player4"
                    doneChecker4 = "OK"
                } else {
                    if (spinnerText4 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText4 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    } else {
                        doneChecker4 = "OK"
                    }
                }

                if (spinnerText5 == "") {
                    spinnerText5 = "player5"
                    doneChecker5 = "OK"
                } else {
                    if (spinnerText5 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    } else {
                        doneChecker5 = "OK"
                        doneChecker6 = "OK"
                    }
                }

                if (spinnerText6 == "") {
                    spinnerText6 = "player6"
                    doneChecker6 = "OK"
                }

                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"
            }

            7 -> {
                if (spinnerText1 == "") {
                    spinnerText1 = "player1"
                    doneChecker1 = "OK"
                } else {
                    if (spinnerText1 == spinnerText2) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    } else if (spinnerText1 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText1 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText1 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText1 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    } else if (spinnerText1 == spinnerText7) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker7 = "NO"
                    } else {
                        doneChecker1 = "OK"
                    }
                }

                if (spinnerText2 == "") {
                    spinnerText2 = "player2"
                    doneChecker2 = "OK"
                } else {
                    if (spinnerText2 == spinnerText3) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    } else if (spinnerText2 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText2 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText2 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    } else if (spinnerText2 == spinnerText7) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker7 = "NO"
                    } else {
                        doneChecker2 = "OK"
                    }
                }

                if (spinnerText3 == "") {
                    spinnerText3 = "player3"
                    doneChecker3 = "OK"
                } else {
                    if (spinnerText3 == spinnerText4) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    } else if (spinnerText3 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText3 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    } else if (spinnerText3 == spinnerText7) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker7 = "NO"
                    } else {
                        doneChecker3 = "OK"
                    }
                }

                if (spinnerText4 == "") {
                    spinnerText4 = "player4"
                    doneChecker4 = "OK"
                } else {
                    if (spinnerText4 == spinnerText5) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    } else if (spinnerText4 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    } else if (spinnerText4 == spinnerText7) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker7 = "NO"
                    } else {
                        doneChecker4 = "OK"
                    }
                }

                if (spinnerText5 == "") {
                    spinnerText5 = "player5"
                    doneChecker5 = "OK"
                } else {
                    if (spinnerText5 == spinnerText6) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    } else if (spinnerText5 == spinnerText7) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker7 = "NO"
                    } else {
                        doneChecker5 = "OK"
                    }
                }

                if (spinnerText6 == "") {
                    spinnerText6 = "player6"
                    doneChecker6 = "OK"
                } else {
                    if (spinnerText6 == spinnerText7) {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker7 = "NO"
                    } else {
                        doneChecker6 = "OK"
                        doneChecker7 = "OK"
                    }
                }

                if (spinnerText7 == "") {
                    spinnerText7 = "player7"
                    doneChecker7 = "OK"
                }

                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"
            }

            8 -> {
                if (spinnerText1 == "") {spinnerText1 = "player1"}
                if (spinnerText2 == "") {spinnerText2 = "player2"}
                if (spinnerText3 == "") {spinnerText3 = "player3"}
                if (spinnerText4 == "") {spinnerText4 = "player4"}
                if (spinnerText5 == "") {spinnerText5 = "player5"}
                if (spinnerText6 == "") {spinnerText6 = "player6"}
                if (spinnerText7 == "") {spinnerText7 = "player7"}
                if (spinnerText8 == "") {spinnerText8 = "player8"}
            }

            9 -> {
                if (spinnerText1 == "") {spinnerText1 = "player1"}
                if (spinnerText2 == "") {spinnerText2 = "player2"}
                if (spinnerText3 == "") {spinnerText3 = "player3"}
                if (spinnerText4 == "") {spinnerText4 = "player4"}
                if (spinnerText5 == "") {spinnerText5 = "player5"}
                if (spinnerText6 == "") {spinnerText6 = "player6"}
                if (spinnerText7 == "") {spinnerText7 = "player7"}
                if (spinnerText8 == "") {spinnerText8 = "player8"}
                if (spinnerText9 == "") {spinnerText9 = "player9"}
            }

            10 -> {
                if (spinnerText1 == "") {spinnerText1 = "player1"}
                if (spinnerText2 == "") {spinnerText2 = "player2"}
                if (spinnerText3 == "") {spinnerText3 = "player3"}
                if (spinnerText4 == "") {spinnerText4 = "player4"}
                if (spinnerText5 == "") {spinnerText5 = "player5"}
                if (spinnerText6 == "") {spinnerText6 = "player6"}
                if (spinnerText7 == "") {spinnerText7 = "player7"}
                if (spinnerText8 == "") {spinnerText8 = "player8"}
                if (spinnerText9 == "") {spinnerText9 = "player9"}
                if (spinnerText10 == "") {spinnerText10 = "player10"}
            }

        }
    }

    //プレイヤー名に重複が無いかチェック
    private fun cheackSpinner() {
        when (mMember) {
            2 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                doneChecker3 = "OK"
                doneChecker4 = "OK"
                doneChecker5 = "OK"
                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"


            }

            3 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    else -> {
                        Log.d("kotlintestCheack", "通過しました")
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                doneChecker4 = "OK"
                doneChecker5 = "OK"
                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"

            }

            4 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                        Log.d("kotlintest", "通過7")
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                        Log.d("kotlintest", "通過8")
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                        Log.d("kotlintest", "通過1")
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                        Log.d("kotlintest", "通過2")
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                        Log.d("kotlintest", "通過3")
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                        Log.d("kotlintest", "通過4")
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        Log.d("kotlintest", "通過5")
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        Log.d("kotlintest", "通過6")
                        Log.d("kotlintest", "Text3" + spinnerText3)
                        Log.d("kotlintest", "Text4" + spinnerText4)
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                doneChecker5 = "OK"
                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"

            }

            5 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                    }
                    spinnerText5 -> {
                        player5 = "player5"
                        doneChecker5 = "OK"
                        spinnerText5 = "5"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    }
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                when (spinnerText5) {
                    else -> {
                        player5 = spinnerText5
                        doneChecker5 = "OK"
                    }
                }

                doneChecker6 = "OK"
                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"

            }

            6 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                    }
                    spinnerText5 -> {
                        player5 = "player5"
                        doneChecker5 = "OK"
                        spinnerText5 = "5"
                    }
                    spinnerText6 -> {
                        player6 = "player6"
                        doneChecker6 = "OK"
                        spinnerText6 = "6"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    }
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    }
                    else -> {
                        player5 = spinnerText5
                        doneChecker5 = "OK"
                    }
                }

                when (spinnerText6) {
                    else -> {
                        player6 = spinnerText6
                        doneChecker6 = "OK"
                    }
                }

                doneChecker7 = "OK"
                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"

            }

            7 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                    }
                    spinnerText5 -> {
                        player5 = "player5"
                        doneChecker5 = "OK"
                        spinnerText5 = "5"
                    }
                    spinnerText6 -> {
                        player6 = "player6"
                        doneChecker6 = "OK"
                        spinnerText6 = "6"
                    }
                    spinnerText7 -> {
                        player7 = "player7"
                        doneChecker7 = "OK"
                        spinnerText7 = "7"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker7 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker7 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker7 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker7 = "NO"
                    }
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker7 = "NO"
                    }
                    else -> {
                        player5 = spinnerText5
                        doneChecker5 = "OK"
                    }
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker7 = "NO"
                    }
                    else -> {
                        player6 = spinnerText6
                        doneChecker6 = "OK"
                    }
                }

                when (spinnerText7) {
                    else -> {
                        player7 = spinnerText7
                        doneChecker7 = "OK"
                    }
                }

                doneChecker8 = "OK"
                doneChecker9 = "OK"
                doneChecker10 = "OK"

            }

            8 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                    }
                    spinnerText5 -> {
                        player5 = "player5"
                        doneChecker5 = "OK"
                        spinnerText5 = "5"
                    }
                    spinnerText6 -> {
                        player6 = "player6"
                        doneChecker6 = "OK"
                        spinnerText6 = "6"
                    }
                    spinnerText7 -> {
                        player7 = "player7"
                        doneChecker7 = "OK"
                        spinnerText7 = "7"
                    }
                    spinnerText8 -> {
                        player8 = "player8"
                        doneChecker8 = "OK"
                        spinnerText8 = "8"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2= "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player5 = spinnerText5
                        doneChecker5 = "OK"
                    }
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player6 = spinnerText6
                        doneChecker6 = "OK"
                    }
                }

                when (spinnerText7) {
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker7 = "NO"
                        doneChecker8 = "NO"
                    }
                    else -> {
                        player7 = spinnerText7
                        doneChecker7 = "OK"
                    }
                }

                when (spinnerText8) {
                    else -> {
                        player8 = spinnerText8
                        doneChecker8 = "OK"
                    }
                }

                doneChecker9 = "OK"
                doneChecker10 = "OK"

            }

            9 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                    }
                    spinnerText5 -> {
                        player5 = "player5"
                        doneChecker5 = "OK"
                        spinnerText5 = "5"
                    }
                    spinnerText6 -> {
                        player6 = "player6"
                        doneChecker6 = "OK"
                        spinnerText6 = "6"
                    }
                    spinnerText7 -> {
                        player7 = "player7"
                        doneChecker7 = "OK"
                        spinnerText7 = "7"
                    }
                    spinnerText8 -> {
                        player8 = "player8"
                        doneChecker8 = "OK"
                        spinnerText8 = "8"
                    }
                    spinnerText9 -> {
                        player9 = "player9"
                        doneChecker9 = "OK"
                        spinnerText9 = "9"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player5 = spinnerText5
                        doneChecker5 = "OK"
                    }
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player6 = spinnerText6
                        doneChecker6 = "OK"
                    }
                }

                when (spinnerText7) {
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker7 = "NO"
                        doneChecker8 = "NO"

                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker7 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player7 = spinnerText7
                        doneChecker7 = "OK"
                    }
                }

                when (spinnerText8) {
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker8 = "NO"
                        doneChecker9 = "NO"
                    }
                    else -> {
                        player8 = spinnerText8
                        doneChecker8 = "OK"
                    }
                }

                when (spinnerText9) {
                    else -> {
                        player9 = spinnerText9
                        doneChecker9 = "OK"
                    }
                }

                doneChecker10 = "OK"

            }

            10 -> {
                when ("") {
                    spinnerText1 -> {
                        player1 = "player1"
                        doneChecker1 = "OK"
                        spinnerText1 = "1"
                    }
                    spinnerText2 -> {
                        player2 = "player2"
                        doneChecker2 = "OK"
                        spinnerText2 = "2"
                    }
                    spinnerText3 -> {
                        player3 = "player3"
                        doneChecker3 = "OK"
                        spinnerText3 = "3"
                    }
                    spinnerText4 -> {
                        player4 = "player4"
                        doneChecker4 = "OK"
                        spinnerText4 = "4"
                    }
                    spinnerText5 -> {
                        player5 = "player5"
                        doneChecker5 = "OK"
                        spinnerText5 = "5"
                    }
                    spinnerText6 -> {
                        player6 = "player6"
                        doneChecker6 = "OK"
                        spinnerText6 = "6"
                    }
                    spinnerText7 -> {
                        player7 = "player7"
                        doneChecker7 = "OK"
                        spinnerText7 = "7"
                    }
                    spinnerText8 -> {
                        player8 = "player8"
                        doneChecker8 = "OK"
                        spinnerText8 = "8"
                    }
                    spinnerText9 -> {
                        player9 = "player9"
                        doneChecker9 = "OK"
                        spinnerText9 = "9"
                    }
                    spinnerText10 -> {
                        player10 = "player10"
                        doneChecker10 = "OK"
                        spinnerText10 = "10"
                    }
                }

                when (spinnerText1) {
                    spinnerText2 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker2 = "NO"
                    }
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker1 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player1 = spinnerText1
                        doneChecker1 = "OK"
                    }
                }

                when (spinnerText2) {
                    spinnerText3 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker3 = "NO"
                    }
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker2 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player2 = spinnerText2
                        doneChecker2 = "OK"
                    }
                }

                when (spinnerText3) {
                    spinnerText4 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker4 = "NO"
                    }
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker3 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player3 = spinnerText3
                        doneChecker3 = "OK"
                    }
                }

                when (spinnerText4) {
                    spinnerText5 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker5 = "NO"
                    }
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker4 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player4 = spinnerText4
                        doneChecker4 = "OK"
                    }
                }

                when (spinnerText5) {
                    spinnerText6 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker6 = "NO"
                    }
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker5 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player5 = spinnerText5
                        doneChecker5 = "OK"
                    }
                }

                when (spinnerText6) {
                    spinnerText7 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker7 = "NO"
                    }
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker6 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player6 = spinnerText6
                        doneChecker6 = "OK"
                    }
                }

                when (spinnerText7) {
                    spinnerText8 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker7 = "NO"
                        doneChecker8 = "NO"
                    }
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker7 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker7 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player7 = spinnerText7
                        doneChecker7 = "OK"
                    }
                }

                when (spinnerText8) {
                    spinnerText9 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker8 = "NO"
                        doneChecker9 = "NO"
                    }
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker8 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player8 = spinnerText8
                        doneChecker8 = "OK"
                    }
                }

                when (spinnerText9) {
                    spinnerText10 -> {
                        val toast = Toast.makeText(applicationContext, "プレイヤー名が重複しています", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.CENTER or Gravity.CENTER, 0, 0)
                        toast.show()
                        doneChecker9 = "NO"
                        doneChecker10 = "NO"
                    }
                    else -> {
                        player9 = spinnerText9
                        doneChecker9 = "OK"
                    }
                }

                when (spinnerText10) {
                    else -> {
                        player10 = spinnerText10
                        doneChecker10 = "OK"
                    }
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