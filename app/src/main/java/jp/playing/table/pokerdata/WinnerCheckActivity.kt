package jp.playing.table.pokerdata

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_show_down.*
import kotlinx.android.synthetic.main.activity_winner_check.*

class WinnerCheckActivity : AppCompatActivity() {

    private lateinit var mRealm: Realm

    private var mMember: Member? = null

    private var memberNum = 0
    private var game_id = 0
    private var count = 0
    private var round = ""
    private var round_count = 0
    private var roundNum = 0
    private var myRound = 0
    private var cardHand1 = ""
    private var cardHand2 = ""
    private var cardCom1 = ""
    private var cardCom2 = ""
    private var cardCom3 = ""
    private var cardCom4 = ""
    private var cardCom5 = ""
    private var bigBlind = 0
    private var smallBlind = 0
    private var tableChips = 0
    private var tableTotalChips = 0
    private var startNum = 0
    private var flopNum = 0
    private var preFlopNum = 0
    private var playingNum = 0
    private var foldPlayer = 0
    private var sameChipsPlayer = 0

    private var firstHand1 = ""
    private var firstHand2 = ""
    private var firstHand3 = ""
    private var firstHand4 = ""
    private var firstHand5 = ""
    private var firstHand6 = ""
    private var firstHand7 = ""
    private var firstHand8 = ""
    private var firstHand9 = ""
    private var firstHand10 = ""

    private var secondHand1 = ""
    private var secondHand2 = ""
    private var secondHand3 = ""
    private var secondHand4 = ""
    private var secondHand5 = ""
    private var secondHand6 = ""
    private var secondHand7 = ""
    private var secondHand8 = ""
    private var secondHand9 = ""
    private var secondHand10 = ""

    private var spinnerSelectItem1 = ""
    private var spinnerSelectItem2 = ""
    private var spinnerSelectItem3 = ""
    private var spinnerSelectItem4 = ""
    private var spinnerSelectItem5 = ""
    private var spinnerSelectItem6 = ""
    private var spinnerSelectItem7 = ""
    private var spinnerSelectItem8 = ""
    private var spinnerSelectItem9 = ""
    private var spinnerSelectItem10 = ""

    private val spinnerItems = arrayOf(
        "High Card",
        "One Pair",
        "Two Pair",
        "Three Card",
        "Straight",
        "Flush",
        "Full House",
        "Four Card",
        "Straight Flush",
        "Royal Flush"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner_check)

        supportActionBar?.title = "WinnerCheck"

        val intent = intent
        memberNum = intent.getIntExtra("memberNum", 0)
        game_id = intent.getIntExtra("game_id", 0)
        count = intent.getIntExtra("count", 0)
        round = intent.getStringExtra("round")
        round_count = intent.getIntExtra("round_count", 0)
        roundNum = intent.getIntExtra("roundNum", 0)
        myRound = intent.getIntExtra("myRound", 0)
        cardHand1 = intent.getStringExtra("cardHand1")
        cardHand2 = intent.getStringExtra("cardHand2")
        cardCom1 = intent.getStringExtra("cardCom1")
        cardCom2 = intent.getStringExtra("cardCom2")
        cardCom3 = intent.getStringExtra("cardCom3")
        cardCom4 = intent.getStringExtra("cardCom4")
        cardCom5 = intent.getStringExtra("cardCom5")
        bigBlind = intent.getIntExtra("bigBlind", 0)
        smallBlind = intent.getIntExtra("smallBlind", 0)
        tableChips = intent.getIntExtra("tableChips", 0)
        tableTotalChips = intent.getIntExtra("tableTotalChips", 0)
        flopNum = intent.getIntExtra("flopNum", 0)
        preFlopNum = intent.getIntExtra("preFlopNum", 0)
        playingNum = intent.getIntExtra("playingNum", 0)
        foldPlayer = intent.getIntExtra("foldPlayer", 0)
        sameChipsPlayer = intent.getIntExtra("sameChipsPlayer", 0)

        activityWinnerCheckText.text = "ポット：" + tableTotalChips.toString()

        //Realmの設定
        mRealm = Realm.getDefaultInstance()

        mMember = Member()

        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item,
            spinnerItems
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        playerWinnerCheckSpinner1.adapter = adapter
        playerWinnerCheckSpinner2.adapter = adapter
        playerWinnerCheckSpinner3.adapter = adapter
        playerWinnerCheckSpinner4.adapter = adapter
        playerWinnerCheckSpinner5.adapter = adapter
        playerWinnerCheckSpinner6.adapter = adapter
        playerWinnerCheckSpinner7.adapter = adapter
        playerWinnerCheckSpinner8.adapter = adapter
        playerWinnerCheckSpinner9.adapter = adapter
        playerWinnerCheckSpinner10.adapter = adapter

        playerWinnerCheckSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem1 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem1 = ""
            }

        }

        playerWinnerCheckSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem2 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem2 = ""
            }

        }

        playerWinnerCheckSpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem3 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem3 = ""
            }

        }

        playerWinnerCheckSpinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem4 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem4 = ""
            }

        }

        playerWinnerCheckSpinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem5 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem5 = ""
            }

        }

        playerWinnerCheckSpinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem6 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem6 = ""
            }

        }

        playerWinnerCheckSpinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem7 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem7 = ""
            }

        }

        playerWinnerCheckSpinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem8 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem8 = ""
            }

        }

        playerWinnerCheckSpinner9.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem9 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem9 = ""
            }

        }

        playerWinnerCheckSpinner10.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinnerSelectItem10 = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerSelectItem10 = ""
            }

        }

        cardSetting1()
        cardSetting2()
        cardSetting3()
        cardSetting4()
        cardSetting5()
        playerSet()

        viewSetting()
        foldSetting()

        winnerCheckDoneButton.setOnClickListener {
            saveData()
            playingNum = flopNum

            //HandActivityへ移動
            val intent = Intent(this@WinnerCheckActivity, HandActivity::class.java)
            Log.d("kotlintest", "MemberPlayingActivity -> CardActivity[count]:" + count.toString())
            Log.d("kotlintest", "MemberPlayingActivity -> CardActivity[myRound]:" + myRound.toString())
            Log.d("kotlintest", "MemberPlayingActivity -> CardActivity[flopNum]:" + flopNum.toString())
            Log.d("kotlintest", "MemberPlayingActivity -> CardActivity[playingNum]:" + playingNum.toString())
            Log.d("kotlintest", "MemberPlayingActivity -> CardActivity[smallBlind]:" + smallBlind.toString())
            Log.d("kotlintest", "MemberPlayingActivity -> CardActivity[bigBlind]:" + bigBlind.toString())

            intent.putExtra("memberNum", memberNum)
            intent.putExtra("flopNum", flopNum)
            intent.putExtra("playingNum", playingNum)
            intent.putExtra("count", count)
            intent.putExtra("bigBlind", bigBlind)
            intent.putExtra("smallBlind", smallBlind)
            intent.putExtra("myRound", myRound)
            startActivity(intent)

        }
    }

    private fun playerSet() {
        val memberRealmResults = mRealm.where(Member::class.java).findAll()

        //プレイヤー名の設定
        when (memberNum) {
            2 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2

                handPlayer1()
                handPlayer2()
            }
            3 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
            }
            4 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
            }
            5 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName
                val player5 = memberRealmResults[playerId5]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4
                playerWinnerCheckTextView5.text = player5

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1
                firstHand5 = memberRealmResults[playerId5]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2
                secondHand5 = memberRealmResults[playerId5]!!.hand2


                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
                handPlayer5()
            }
            6 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName
                val player5 = memberRealmResults[playerId5]!!.memberName
                val player6 = memberRealmResults[playerId6]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4
                playerWinnerCheckTextView5.text = player5
                playerWinnerCheckTextView6.text = player6

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1
                firstHand5 = memberRealmResults[playerId5]!!.hand1
                firstHand6 = memberRealmResults[playerId6]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2
                secondHand5 = memberRealmResults[playerId5]!!.hand2
                secondHand6 = memberRealmResults[playerId6]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
                handPlayer5()
                handPlayer6()
            }
            7 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName
                val player5 = memberRealmResults[playerId5]!!.memberName
                val player6 = memberRealmResults[playerId6]!!.memberName
                val player7 = memberRealmResults[playerId7]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4
                playerWinnerCheckTextView5.text = player5
                playerWinnerCheckTextView6.text = player6
                playerWinnerCheckTextView7.text = player7

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1
                firstHand5 = memberRealmResults[playerId5]!!.hand1
                firstHand6 = memberRealmResults[playerId6]!!.hand1
                firstHand7 = memberRealmResults[playerId7]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2
                secondHand5 = memberRealmResults[playerId5]!!.hand2
                secondHand6 = memberRealmResults[playerId6]!!.hand2
                secondHand7 = memberRealmResults[playerId7]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
                handPlayer5()
                handPlayer6()
                handPlayer7()
            }
            8 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName
                val player5 = memberRealmResults[playerId5]!!.memberName
                val player6 = memberRealmResults[playerId6]!!.memberName
                val player7 = memberRealmResults[playerId7]!!.memberName
                val player8 = memberRealmResults[playerId8]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4
                playerWinnerCheckTextView5.text = player5
                playerWinnerCheckTextView6.text = player6
                playerWinnerCheckTextView7.text = player7
                playerWinnerCheckTextView8.text = player8

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1
                firstHand5 = memberRealmResults[playerId5]!!.hand1
                firstHand6 = memberRealmResults[playerId6]!!.hand1
                firstHand7 = memberRealmResults[playerId7]!!.hand1
                firstHand8 = memberRealmResults[playerId8]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2
                secondHand5 = memberRealmResults[playerId5]!!.hand2
                secondHand6 = memberRealmResults[playerId6]!!.hand2
                secondHand7 = memberRealmResults[playerId7]!!.hand2
                secondHand8 = memberRealmResults[playerId8]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
                handPlayer5()
                handPlayer6()
                handPlayer7()
                handPlayer8()
            }
            9 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()
                val playerNum9 = mRealm.where(Member::class.java).equalTo("memberRound", "9".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()
                val playerId9 = playerNum9.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName
                val player5 = memberRealmResults[playerId5]!!.memberName
                val player6 = memberRealmResults[playerId6]!!.memberName
                val player7 = memberRealmResults[playerId7]!!.memberName
                val player8 = memberRealmResults[playerId8]!!.memberName
                val player9 = memberRealmResults[playerId9]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4
                playerWinnerCheckTextView5.text = player5
                playerWinnerCheckTextView6.text = player6
                playerWinnerCheckTextView7.text = player7
                playerWinnerCheckTextView8.text = player8
                playerWinnerCheckTextView9.text = player9

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1
                firstHand5 = memberRealmResults[playerId5]!!.hand1
                firstHand6 = memberRealmResults[playerId6]!!.hand1
                firstHand7 = memberRealmResults[playerId7]!!.hand1
                firstHand8 = memberRealmResults[playerId8]!!.hand1
                firstHand9 = memberRealmResults[playerId9]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2
                secondHand5 = memberRealmResults[playerId5]!!.hand2
                secondHand6 = memberRealmResults[playerId6]!!.hand2
                secondHand7 = memberRealmResults[playerId7]!!.hand2
                secondHand8 = memberRealmResults[playerId8]!!.hand2
                secondHand9 = memberRealmResults[playerId9]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
                handPlayer5()
                handPlayer6()
                handPlayer7()
                handPlayer8()
                handPlayer9()
            }
            10 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()
                val playerNum9 = mRealm.where(Member::class.java).equalTo("memberRound", "9".toInt()).findAll()
                val playerNum10 = mRealm.where(Member::class.java).equalTo("memberRound", "10".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()
                val playerId9 = playerNum9.max("id")!!.toInt()
                val playerId10 = playerNum10.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.memberName
                val player2 = memberRealmResults[playerId2]!!.memberName
                val player3 = memberRealmResults[playerId3]!!.memberName
                val player4 = memberRealmResults[playerId4]!!.memberName
                val player5 = memberRealmResults[playerId5]!!.memberName
                val player6 = memberRealmResults[playerId6]!!.memberName
                val player7 = memberRealmResults[playerId7]!!.memberName
                val player8 = memberRealmResults[playerId8]!!.memberName
                val player9 = memberRealmResults[playerId9]!!.memberName
                val player10 = memberRealmResults[playerId10]!!.memberName

                playerWinnerCheckTextView1.text = player1
                playerWinnerCheckTextView2.text = player2
                playerWinnerCheckTextView3.text = player3
                playerWinnerCheckTextView4.text = player4
                playerWinnerCheckTextView5.text = player5
                playerWinnerCheckTextView6.text = player6
                playerWinnerCheckTextView7.text = player7
                playerWinnerCheckTextView8.text = player8
                playerWinnerCheckTextView9.text = player9
                playerWinnerCheckTextView10.text = player10

                firstHand1 = memberRealmResults[playerId1]!!.hand1
                firstHand2 = memberRealmResults[playerId2]!!.hand1
                firstHand3 = memberRealmResults[playerId3]!!.hand1
                firstHand4 = memberRealmResults[playerId4]!!.hand1
                firstHand5 = memberRealmResults[playerId5]!!.hand1
                firstHand6 = memberRealmResults[playerId6]!!.hand1
                firstHand7 = memberRealmResults[playerId7]!!.hand1
                firstHand8 = memberRealmResults[playerId8]!!.hand1
                firstHand9 = memberRealmResults[playerId9]!!.hand1
                firstHand10 = memberRealmResults[playerId10]!!.hand1

                secondHand1 = memberRealmResults[playerId1]!!.hand2
                secondHand2 = memberRealmResults[playerId2]!!.hand2
                secondHand3 = memberRealmResults[playerId3]!!.hand2
                secondHand4 = memberRealmResults[playerId4]!!.hand2
                secondHand5 = memberRealmResults[playerId5]!!.hand2
                secondHand6 = memberRealmResults[playerId6]!!.hand2
                secondHand7 = memberRealmResults[playerId7]!!.hand2
                secondHand8 = memberRealmResults[playerId8]!!.hand2
                secondHand9 = memberRealmResults[playerId9]!!.hand2
                secondHand10 = memberRealmResults[playerId10]!!.hand2

                handPlayer1()
                handPlayer2()
                handPlayer3()
                handPlayer4()
                handPlayer5()
                handPlayer6()
                handPlayer7()
                handPlayer8()
                handPlayer9()
                handPlayer10()

            }
        }


    }

    private fun cardSetting1() {
        when (cardCom1){
            "club1" -> comWinnerCheckImageView1.setImageResource(R.drawable.club1)
            "club2" -> comWinnerCheckImageView1.setImageResource(R.drawable.club2)
            "club3" -> comWinnerCheckImageView1.setImageResource(R.drawable.club3)
            "club4" -> comWinnerCheckImageView1.setImageResource(R.drawable.club4)
            "club5" -> comWinnerCheckImageView1.setImageResource(R.drawable.club5)
            "club6" -> comWinnerCheckImageView1.setImageResource(R.drawable.club6)
            "club7" -> comWinnerCheckImageView1.setImageResource(R.drawable.club7)
            "club8" -> comWinnerCheckImageView1.setImageResource(R.drawable.club8)
            "club9" -> comWinnerCheckImageView1.setImageResource(R.drawable.club9)
            "club10" -> comWinnerCheckImageView1.setImageResource(R.drawable.club10)
            "club11" -> comWinnerCheckImageView1.setImageResource(R.drawable.club11)
            "club12" -> comWinnerCheckImageView1.setImageResource(R.drawable.club12)
            "club13" -> comWinnerCheckImageView1.setImageResource(R.drawable.club13)

            "diamond1" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond1)
            "diamond2" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond2)
            "diamond3" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond3)
            "diamond4" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond4)
            "diamond5" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond5)
            "diamond6" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond6)
            "diamond7" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond7)
            "diamond8" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond8)
            "diamond9" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond9)
            "diamond10" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond10)
            "diamond11" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond11)
            "diamond12" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond12)
            "diamond13" -> comWinnerCheckImageView1.setImageResource(R.drawable.diamond13)

            "heart1" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart1)
            "heart2" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart2)
            "heart3" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart3)
            "heart4" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart4)
            "heart5" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart5)
            "heart6" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart6)
            "heart7" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart7)
            "heart8" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart8)
            "heart9" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart9)
            "heart10" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart10)
            "heart11" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart11)
            "heart12" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart12)
            "heart13" -> comWinnerCheckImageView1.setImageResource(R.drawable.heart13)

            "spade1" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade1)
            "spade2" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade2)
            "spade3" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade3)
            "spade4" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade4)
            "spade5" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade5)
            "spade6" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade6)
            "spade7" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade7)
            "spade8" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade8)
            "spade9" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade9)
            "spade10" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade10)
            "spade11" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade11)
            "spade12" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade12)
            "spade13" -> comWinnerCheckImageView1.setImageResource(R.drawable.spade13)

            "" -> comWinnerCheckImageView1.setImageResource(R.drawable.card_back)
        }
    }

    private fun cardSetting2() {
        when (cardCom2){
            "club1" -> comWinnerCheckImageView2.setImageResource(R.drawable.club1)
            "club2" -> comWinnerCheckImageView2.setImageResource(R.drawable.club2)
            "club3" -> comWinnerCheckImageView2.setImageResource(R.drawable.club3)
            "club4" -> comWinnerCheckImageView2.setImageResource(R.drawable.club4)
            "club5" -> comWinnerCheckImageView2.setImageResource(R.drawable.club5)
            "club6" -> comWinnerCheckImageView2.setImageResource(R.drawable.club6)
            "club7" -> comWinnerCheckImageView2.setImageResource(R.drawable.club7)
            "club8" -> comWinnerCheckImageView2.setImageResource(R.drawable.club8)
            "club9" -> comWinnerCheckImageView2.setImageResource(R.drawable.club9)
            "club10" -> comWinnerCheckImageView2.setImageResource(R.drawable.club10)
            "club11" -> comWinnerCheckImageView2.setImageResource(R.drawable.club11)
            "club12" -> comWinnerCheckImageView2.setImageResource(R.drawable.club12)
            "club13" -> comWinnerCheckImageView2.setImageResource(R.drawable.club13)

            "diamond1" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond1)
            "diamond2" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond2)
            "diamond3" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond3)
            "diamond4" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond4)
            "diamond5" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond5)
            "diamond6" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond6)
            "diamond7" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond7)
            "diamond8" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond8)
            "diamond9" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond9)
            "diamond10" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond10)
            "diamond11" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond11)
            "diamond12" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond12)
            "diamond13" -> comWinnerCheckImageView2.setImageResource(R.drawable.diamond13)

            "heart1" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart1)
            "heart2" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart2)
            "heart3" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart3)
            "heart4" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart4)
            "heart5" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart5)
            "heart6" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart6)
            "heart7" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart7)
            "heart8" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart8)
            "heart9" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart9)
            "heart10" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart10)
            "heart11" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart11)
            "heart12" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart12)
            "heart13" -> comWinnerCheckImageView2.setImageResource(R.drawable.heart13)

            "spade1" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade1)
            "spade2" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade2)
            "spade3" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade3)
            "spade4" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade4)
            "spade5" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade5)
            "spade6" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade6)
            "spade7" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade7)
            "spade8" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade8)
            "spade9" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade9)
            "spade10" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade10)
            "spade11" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade11)
            "spade12" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade12)
            "spade13" -> comWinnerCheckImageView2.setImageResource(R.drawable.spade13)

            "" -> comWinnerCheckImageView2.setImageResource(R.drawable.card_back)
        }
    }

    private fun cardSetting3() {
        when (cardCom3){
            "club1" -> comWinnerCheckImageView3.setImageResource(R.drawable.club1)
            "club2" -> comWinnerCheckImageView3.setImageResource(R.drawable.club2)
            "club3" -> comWinnerCheckImageView3.setImageResource(R.drawable.club3)
            "club4" -> comWinnerCheckImageView3.setImageResource(R.drawable.club4)
            "club5" -> comWinnerCheckImageView3.setImageResource(R.drawable.club5)
            "club6" -> comWinnerCheckImageView3.setImageResource(R.drawable.club6)
            "club7" -> comWinnerCheckImageView3.setImageResource(R.drawable.club7)
            "club8" -> comWinnerCheckImageView3.setImageResource(R.drawable.club8)
            "club9" -> comWinnerCheckImageView3.setImageResource(R.drawable.club9)
            "club10" -> comWinnerCheckImageView3.setImageResource(R.drawable.club10)
            "club11" -> comWinnerCheckImageView3.setImageResource(R.drawable.club11)
            "club12" -> comWinnerCheckImageView3.setImageResource(R.drawable.club12)
            "club13" -> comWinnerCheckImageView3.setImageResource(R.drawable.club13)

            "diamond1" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond1)
            "diamond2" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond2)
            "diamond3" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond3)
            "diamond4" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond4)
            "diamond5" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond5)
            "diamond6" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond6)
            "diamond7" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond7)
            "diamond8" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond8)
            "diamond9" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond9)
            "diamond10" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond10)
            "diamond11" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond11)
            "diamond12" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond12)
            "diamond13" -> comWinnerCheckImageView3.setImageResource(R.drawable.diamond13)

            "heart1" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart1)
            "heart2" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart2)
            "heart3" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart3)
            "heart4" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart4)
            "heart5" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart5)
            "heart6" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart6)
            "heart7" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart7)
            "heart8" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart8)
            "heart9" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart9)
            "heart10" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart10)
            "heart11" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart11)
            "heart12" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart12)
            "heart13" -> comWinnerCheckImageView3.setImageResource(R.drawable.heart13)

            "spade1" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade1)
            "spade2" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade2)
            "spade3" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade3)
            "spade4" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade4)
            "spade5" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade5)
            "spade6" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade6)
            "spade7" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade7)
            "spade8" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade8)
            "spade9" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade9)
            "spade10" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade10)
            "spade11" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade11)
            "spade12" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade12)
            "spade13" -> comWinnerCheckImageView3.setImageResource(R.drawable.spade13)

            "" -> comWinnerCheckImageView3.setImageResource(R.drawable.card_back)
        }
    }

    private fun cardSetting4() {
        when (cardCom4){
            "club1" -> comWinnerCheckImageView4.setImageResource(R.drawable.club1)
            "club2" -> comWinnerCheckImageView4.setImageResource(R.drawable.club2)
            "club3" -> comWinnerCheckImageView4.setImageResource(R.drawable.club3)
            "club4" -> comWinnerCheckImageView4.setImageResource(R.drawable.club4)
            "club5" -> comWinnerCheckImageView4.setImageResource(R.drawable.club5)
            "club6" -> comWinnerCheckImageView4.setImageResource(R.drawable.club6)
            "club7" -> comWinnerCheckImageView4.setImageResource(R.drawable.club7)
            "club8" -> comWinnerCheckImageView4.setImageResource(R.drawable.club8)
            "club9" -> comWinnerCheckImageView4.setImageResource(R.drawable.club9)
            "club10" -> comWinnerCheckImageView4.setImageResource(R.drawable.club10)
            "club11" -> comWinnerCheckImageView4.setImageResource(R.drawable.club11)
            "club12" -> comWinnerCheckImageView4.setImageResource(R.drawable.club12)
            "club13" -> comWinnerCheckImageView4.setImageResource(R.drawable.club13)

            "diamond1" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond1)
            "diamond2" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond2)
            "diamond3" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond3)
            "diamond4" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond4)
            "diamond5" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond5)
            "diamond6" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond6)
            "diamond7" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond7)
            "diamond8" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond8)
            "diamond9" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond9)
            "diamond10" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond10)
            "diamond11" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond11)
            "diamond12" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond12)
            "diamond13" -> comWinnerCheckImageView4.setImageResource(R.drawable.diamond13)

            "heart1" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart1)
            "heart2" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart2)
            "heart3" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart3)
            "heart4" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart4)
            "heart5" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart5)
            "heart6" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart6)
            "heart7" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart7)
            "heart8" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart8)
            "heart9" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart9)
            "heart10" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart10)
            "heart11" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart11)
            "heart12" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart12)
            "heart13" -> comWinnerCheckImageView4.setImageResource(R.drawable.heart13)

            "spade1" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade1)
            "spade2" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade2)
            "spade3" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade3)
            "spade4" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade4)
            "spade5" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade5)
            "spade6" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade6)
            "spade7" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade7)
            "spade8" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade8)
            "spade9" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade9)
            "spade10" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade10)
            "spade11" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade11)
            "spade12" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade12)
            "spade13" -> comWinnerCheckImageView4.setImageResource(R.drawable.spade13)

            "" -> comWinnerCheckImageView4.setImageResource(R.drawable.card_back)
        }
    }

    private fun cardSetting5() {
        when (cardCom5){
            "club1" -> comWinnerCheckImageView5.setImageResource(R.drawable.club1)
            "club2" -> comWinnerCheckImageView5.setImageResource(R.drawable.club2)
            "club3" -> comWinnerCheckImageView5.setImageResource(R.drawable.club3)
            "club4" -> comWinnerCheckImageView5.setImageResource(R.drawable.club4)
            "club5" -> comWinnerCheckImageView5.setImageResource(R.drawable.club5)
            "club6" -> comWinnerCheckImageView5.setImageResource(R.drawable.club6)
            "club7" -> comWinnerCheckImageView5.setImageResource(R.drawable.club7)
            "club8" -> comWinnerCheckImageView5.setImageResource(R.drawable.club8)
            "club9" -> comWinnerCheckImageView5.setImageResource(R.drawable.club9)
            "club10" -> comWinnerCheckImageView5.setImageResource(R.drawable.club10)
            "club11" -> comWinnerCheckImageView5.setImageResource(R.drawable.club11)
            "club12" -> comWinnerCheckImageView5.setImageResource(R.drawable.club12)
            "club13" -> comWinnerCheckImageView5.setImageResource(R.drawable.club13)

            "diamond1" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond1)
            "diamond2" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond2)
            "diamond3" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond3)
            "diamond4" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond4)
            "diamond5" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond5)
            "diamond6" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond6)
            "diamond7" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond7)
            "diamond8" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond8)
            "diamond9" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond9)
            "diamond10" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond10)
            "diamond11" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond11)
            "diamond12" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond12)
            "diamond13" -> comWinnerCheckImageView5.setImageResource(R.drawable.diamond13)

            "heart1" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart1)
            "heart2" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart2)
            "heart3" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart3)
            "heart4" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart4)
            "heart5" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart5)
            "heart6" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart6)
            "heart7" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart7)
            "heart8" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart8)
            "heart9" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart9)
            "heart10" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart10)
            "heart11" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart11)
            "heart12" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart12)
            "heart13" -> comWinnerCheckImageView5.setImageResource(R.drawable.heart13)

            "spade1" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade1)
            "spade2" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade2)
            "spade3" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade3)
            "spade4" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade4)
            "spade5" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade5)
            "spade6" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade6)
            "spade7" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade7)
            "spade8" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade8)
            "spade9" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade9)
            "spade10" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade10)
            "spade11" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade11)
            "spade12" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade12)
            "spade13" -> comWinnerCheckImageView5.setImageResource(R.drawable.spade13)

            "" -> comWinnerCheckImageView5.setImageResource(R.drawable.card_back)
        }
    }

    private fun  handPlayer1() {
        if (firstHand1 != "" && secondHand1 != "") {
            when (firstHand1){
                "club1" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView1.setImageResource(R.drawable.spade13)
            }

            when (secondHand1){
                "club1" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView1.setImageResource(R.drawable.spade13)
            }
        } else {
            firstHandWinnerCheckImageView1.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView1.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer2() {
        if (firstHand2 != "" && secondHand2 != "") {
            when (firstHand2){
                "club1" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView2.setImageResource(R.drawable.spade13)
            }

            when (secondHand2){
                "club1" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView2.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView2.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView2.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer3() {
        if (firstHand3 != "" && secondHand3 != "") {
            when (firstHand3){
                "club1" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView3.setImageResource(R.drawable.spade13)
            }

            when (secondHand3){
                "club1" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView3.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView3.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView3.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer4() {
        if (firstHand4 != "" && secondHand4 != "") {
            when (firstHand4){
                "club1" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView4.setImageResource(R.drawable.spade13)
            }

            when (secondHand4){
                "club1" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView4.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView4.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView4.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer5() {
        if (firstHand5 != "" && secondHand5 != "") {
            when (firstHand5){
                "club1" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView5.setImageResource(R.drawable.spade13)
            }

            when (secondHand5){
                "club1" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView5.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView5.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView5.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer6() {
        if (firstHand6 != "" && secondHand6 != "") {
            when (firstHand6){
                "club1" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView6.setImageResource(R.drawable.spade13)
            }

            when (secondHand6){
                "club1" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView6.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView6.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView6.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer7() {
        if (firstHand7 != "" && secondHand7 != "") {
            when (firstHand7){
                "club1" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView7.setImageResource(R.drawable.spade13)
            }

            when (secondHand7){
                "club1" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView7.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView7.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView7.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer8() {
        if (firstHand8 != "" && secondHand8 != "") {
            when (firstHand8){
                "club1" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView8.setImageResource(R.drawable.spade13)
            }

            when (secondHand8){
                "club1" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView8.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView8.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView8.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer9() {
        if (firstHand9 != "" && secondHand9 != "") {
            when (firstHand9){
                "club1" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView9.setImageResource(R.drawable.spade13)
            }

            when (secondHand9){
                "club1" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView9.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView9.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView9.setImageResource(R.drawable.card_back)
        }
    }
    private fun  handPlayer10() {
        if (firstHand10 != "" && secondHand10 != "") {
            when (firstHand10){
                "club1" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club1)
                "club2" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club2)
                "club3" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club3)
                "club4" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club4)
                "club5" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club5)
                "club6" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club6)
                "club7" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club7)
                "club8" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club8)
                "club9" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club9)
                "club10" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club10)
                "club11" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club11)
                "club12" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club12)
                "club13" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.club13)

                "diamond1" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond1)
                "diamond2" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond2)
                "diamond3" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond3)
                "diamond4" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond4)
                "diamond5" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond5)
                "diamond6" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond6)
                "diamond7" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond7)
                "diamond8" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond8)
                "diamond9" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond9)
                "diamond10" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond10)
                "diamond11" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond11)
                "diamond12" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond12)
                "diamond13" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.diamond13)

                "heart1" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart1)
                "heart2" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart2)
                "heart3" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart3)
                "heart4" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart4)
                "heart5" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart5)
                "heart6" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart6)
                "heart7" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart7)
                "heart8" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart8)
                "heart9" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart9)
                "heart10" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart10)
                "heart11" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart11)
                "heart12" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart12)
                "heart13" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.heart13)

                "spade1" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade1)
                "spade2" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade2)
                "spade3" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade3)
                "spade4" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade4)
                "spade5" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade5)
                "spade6" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade6)
                "spade7" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade7)
                "spade8" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade8)
                "spade9" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade9)
                "spade10" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade10)
                "spade11" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade11)
                "spade12" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade12)
                "spade13" -> firstHandWinnerCheckImageView10.setImageResource(R.drawable.spade13)
            }

            when (secondHand10){
                "club1" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club1)
                "club2" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club2)
                "club3" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club3)
                "club4" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club4)
                "club5" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club5)
                "club6" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club6)
                "club7" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club7)
                "club8" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club8)
                "club9" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club9)
                "club10" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club10)
                "club11" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club11)
                "club12" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club12)
                "club13" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.club13)

                "diamond1" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond1)
                "diamond2" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond2)
                "diamond3" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond3)
                "diamond4" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond4)
                "diamond5" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond5)
                "diamond6" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond6)
                "diamond7" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond7)
                "diamond8" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond8)
                "diamond9" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond9)
                "diamond10" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond10)
                "diamond11" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond11)
                "diamond12" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond12)
                "diamond13" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.diamond13)

                "heart1" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart1)
                "heart2" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart2)
                "heart3" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart3)
                "heart4" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart4)
                "heart5" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart5)
                "heart6" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart6)
                "heart7" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart7)
                "heart8" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart8)
                "heart9" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart9)
                "heart10" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart10)
                "heart11" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart11)
                "heart12" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart12)
                "heart13" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.heart13)

                "spade1" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade1)
                "spade2" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade2)
                "spade3" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade3)
                "spade4" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade4)
                "spade5" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade5)
                "spade6" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade6)
                "spade7" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade7)
                "spade8" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade8)
                "spade9" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade9)
                "spade10" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade10)
                "spade11" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade11)
                "spade12" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade12)
                "spade13" -> secondHandWinnerCheckImageView10.setImageResource(R.drawable.spade13)
            }

        } else {
            firstHandWinnerCheckImageView10.setImageResource(R.drawable.card_back)
            secondHandWinnerCheckImageView10.setImageResource(R.drawable.card_back)
        }
    }

    private fun viewSetting() {
        when(memberNum) {
            2 -> {
                playerWinnerCheckTextView3.visibility = View.INVISIBLE
                playerWinnerCheckTextView4.visibility = View.INVISIBLE
                playerWinnerCheckTextView5.visibility = View.INVISIBLE
                playerWinnerCheckTextView6.visibility = View.INVISIBLE
                playerWinnerCheckTextView7.visibility = View.INVISIBLE
                playerWinnerCheckTextView8.visibility = View.INVISIBLE
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView3.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView4.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView5.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView6.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView7.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView8.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView3.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView4.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView5.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView6.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView7.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView8.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText3.visibility = View.INVISIBLE
                playerWinnerCheckEditText4.visibility = View.INVISIBLE
                playerWinnerCheckEditText5.visibility = View.INVISIBLE
                playerWinnerCheckEditText6.visibility = View.INVISIBLE
                playerWinnerCheckEditText7.visibility = View.INVISIBLE
                playerWinnerCheckEditText8.visibility = View.INVISIBLE
                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            3 -> {
                playerWinnerCheckTextView4.visibility = View.INVISIBLE
                playerWinnerCheckTextView5.visibility = View.INVISIBLE
                playerWinnerCheckTextView6.visibility = View.INVISIBLE
                playerWinnerCheckTextView7.visibility = View.INVISIBLE
                playerWinnerCheckTextView8.visibility = View.INVISIBLE
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView4.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView5.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView6.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView7.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView8.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView4.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView5.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView6.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView7.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView8.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText4.visibility = View.INVISIBLE
                playerWinnerCheckEditText5.visibility = View.INVISIBLE
                playerWinnerCheckEditText6.visibility = View.INVISIBLE
                playerWinnerCheckEditText7.visibility = View.INVISIBLE
                playerWinnerCheckEditText8.visibility = View.INVISIBLE
                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            4 -> {
                playerWinnerCheckTextView5.visibility = View.INVISIBLE
                playerWinnerCheckTextView6.visibility = View.INVISIBLE
                playerWinnerCheckTextView7.visibility = View.INVISIBLE
                playerWinnerCheckTextView8.visibility = View.INVISIBLE
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView5.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView6.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView7.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView8.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView5.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView6.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView7.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView8.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText5.visibility = View.INVISIBLE
                playerWinnerCheckEditText6.visibility = View.INVISIBLE
                playerWinnerCheckEditText7.visibility = View.INVISIBLE
                playerWinnerCheckEditText8.visibility = View.INVISIBLE
                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            5 -> {
                playerWinnerCheckTextView6.visibility = View.INVISIBLE
                playerWinnerCheckTextView7.visibility = View.INVISIBLE
                playerWinnerCheckTextView8.visibility = View.INVISIBLE
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView6.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView7.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView8.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView6.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView7.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView8.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText6.visibility = View.INVISIBLE
                playerWinnerCheckEditText7.visibility = View.INVISIBLE
                playerWinnerCheckEditText8.visibility = View.INVISIBLE
                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            6 -> {
                playerWinnerCheckTextView7.visibility = View.INVISIBLE
                playerWinnerCheckTextView8.visibility = View.INVISIBLE
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView7.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView8.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView7.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView8.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText7.visibility = View.INVISIBLE
                playerWinnerCheckEditText8.visibility = View.INVISIBLE
                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            7 -> {
                playerWinnerCheckTextView8.visibility = View.INVISIBLE
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView8.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView8.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText8.visibility = View.INVISIBLE
                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            8 -> {
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }

            9 -> {
                playerWinnerCheckTextView9.visibility = View.INVISIBLE
                playerWinnerCheckTextView10.visibility = View.INVISIBLE

                firstHandWinnerCheckImageView9.visibility = View.INVISIBLE
                firstHandWinnerCheckImageView10.visibility = View.INVISIBLE

                secondHandWinnerCheckImageView9.visibility = View.INVISIBLE
                secondHandWinnerCheckImageView10.visibility = View.INVISIBLE

                playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                playerWinnerCheckSpinner10.visibility = View.INVISIBLE

                playerWinnerCheckEditText9.visibility = View.INVISIBLE
                playerWinnerCheckEditText10.visibility = View.INVISIBLE
            }
        }
    }

    private fun foldSetting() {
        val memberRealmResults = mRealm.where(Member::class.java).findAll()

        when(memberNum) {
            2 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

            }

            3 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

            }

            4 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

            }

            5 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck
                val player5 = memberRealmResults[playerId5]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

                if (player5 == "fold") {
                    playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                    playerWinnerCheckEditText5.visibility = View.INVISIBLE
                }

            }

            6 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck
                val player5 = memberRealmResults[playerId5]!!.playingCheck
                val player6 = memberRealmResults[playerId6]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

                if (player5 == "fold") {
                    playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                    playerWinnerCheckEditText5.visibility = View.INVISIBLE
                }

                if (player6 == "fold") {
                    playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                    playerWinnerCheckEditText6.visibility = View.INVISIBLE
                }

            }

            7 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck
                val player5 = memberRealmResults[playerId5]!!.playingCheck
                val player6 = memberRealmResults[playerId6]!!.playingCheck
                val player7 = memberRealmResults[playerId7]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

                if (player5 == "fold") {
                    playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                    playerWinnerCheckEditText5.visibility = View.INVISIBLE
                }

                if (player6 == "fold") {
                    playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                    playerWinnerCheckEditText6.visibility = View.INVISIBLE
                }

                if (player7 == "fold") {
                    playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                    playerWinnerCheckEditText7.visibility = View.INVISIBLE
                }

            }

            8 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck
                val player5 = memberRealmResults[playerId5]!!.playingCheck
                val player6 = memberRealmResults[playerId6]!!.playingCheck
                val player7 = memberRealmResults[playerId7]!!.playingCheck
                val player8 = memberRealmResults[playerId8]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

                if (player5 == "fold") {
                    playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                    playerWinnerCheckEditText5.visibility = View.INVISIBLE
                }

                if (player6 == "fold") {
                    playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                    playerWinnerCheckEditText6.visibility = View.INVISIBLE
                }

                if (player7 == "fold") {
                    playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                    playerWinnerCheckEditText7.visibility = View.INVISIBLE
                }

                if (player8 == "fold") {
                    playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                    playerWinnerCheckEditText8.visibility = View.INVISIBLE
                }

            }

            9 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()
                val playerNum9 = mRealm.where(Member::class.java).equalTo("memberRound", "9".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()
                val playerId9 = playerNum9.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck
                val player5 = memberRealmResults[playerId5]!!.playingCheck
                val player6 = memberRealmResults[playerId6]!!.playingCheck
                val player7 = memberRealmResults[playerId7]!!.playingCheck
                val player8 = memberRealmResults[playerId8]!!.playingCheck
                val player9 = memberRealmResults[playerId9]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

                if (player5 == "fold") {
                    playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                    playerWinnerCheckEditText5.visibility = View.INVISIBLE
                }

                if (player6 == "fold") {
                    playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                    playerWinnerCheckEditText6.visibility = View.INVISIBLE
                }

                if (player7 == "fold") {
                    playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                    playerWinnerCheckEditText7.visibility = View.INVISIBLE
                }

                if (player8 == "fold") {
                    playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                    playerWinnerCheckEditText8.visibility = View.INVISIBLE
                }

                if (player9 == "fold") {
                    playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                    playerWinnerCheckEditText9.visibility = View.INVISIBLE
                }

            }

            10 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()
                val playerNum9 = mRealm.where(Member::class.java).equalTo("memberRound", "9".toInt()).findAll()
                val playerNum10 = mRealm.where(Member::class.java).equalTo("memberRound", "10".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()
                val playerId9 = playerNum9.max("id")!!.toInt()
                val palyerId10 = playerNum10.max("id")!!.toInt()

                val player1 = memberRealmResults[playerId1]!!.playingCheck
                val player2 = memberRealmResults[playerId2]!!.playingCheck
                val player3 = memberRealmResults[playerId3]!!.playingCheck
                val player4 = memberRealmResults[playerId4]!!.playingCheck
                val player5 = memberRealmResults[playerId5]!!.playingCheck
                val player6 = memberRealmResults[playerId6]!!.playingCheck
                val player7 = memberRealmResults[playerId7]!!.playingCheck
                val player8 = memberRealmResults[playerId8]!!.playingCheck
                val player9 = memberRealmResults[playerId9]!!.playingCheck
                val player10 = memberRealmResults[palyerId10]!!.playingCheck

                if (player1 == "fold") {
                    playerWinnerCheckSpinner1.visibility = View.INVISIBLE
                    playerWinnerCheckEditText1.visibility = View.INVISIBLE
                }

                if (player2 == "fold") {
                    playerWinnerCheckSpinner2.visibility = View.INVISIBLE
                    playerWinnerCheckEditText2.visibility = View.INVISIBLE
                }

                if (player3 == "fold") {
                    playerWinnerCheckSpinner3.visibility = View.INVISIBLE
                    playerWinnerCheckEditText3.visibility = View.INVISIBLE
                }

                if (player4 == "fold") {
                    playerWinnerCheckSpinner4.visibility = View.INVISIBLE
                    playerWinnerCheckEditText4.visibility = View.INVISIBLE
                }

                if (player5 == "fold") {
                    playerWinnerCheckSpinner5.visibility = View.INVISIBLE
                    playerWinnerCheckEditText5.visibility = View.INVISIBLE
                }

                if (player6 == "fold") {
                    playerWinnerCheckSpinner6.visibility = View.INVISIBLE
                    playerWinnerCheckEditText6.visibility = View.INVISIBLE
                }

                if (player7 == "fold") {
                    playerWinnerCheckSpinner7.visibility = View.INVISIBLE
                    playerWinnerCheckEditText7.visibility = View.INVISIBLE
                }

                if (player8 == "fold") {
                    playerWinnerCheckSpinner8.visibility = View.INVISIBLE
                    playerWinnerCheckEditText8.visibility = View.INVISIBLE
                }

                if (player9 == "fold") {
                    playerWinnerCheckSpinner9.visibility = View.INVISIBLE
                    playerWinnerCheckEditText9.visibility = View.INVISIBLE
                }

                if (player10 == "fold") {
                    playerWinnerCheckSpinner10.visibility = View.INVISIBLE
                    playerWinnerCheckEditText10.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun saveData() {
        val memberRealmResults = mRealm.where(Member::class.java).findAll()
        val turnRealmResults = mRealm.where(Turn::class.java).findAll()

        mRealm.beginTransaction()
        mMember = Member()

        when(memberNum) {
            1 -> {

                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()


                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

            }

            2 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }
            }

            3 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }
            }

            4 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }
            }

            5 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck
                val playerFold5 = memberRealmResults[playerId5]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips
                val playerChips5 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()
                val player5 = mRealm.where(Member::class.java).equalTo("id", playerId5).findFirst()


                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }


                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }

                if (playerFold5 == "fold") {
                    player5!!.winnerHand = "fold"
                } else {
                    player5!!.winnerHand = spinnerSelectItem5
                    if (playerWinnerCheckEditText5.text.toString() != "") {
                        player5!!.memberChips = playerChips5 + playerWinnerCheckEditText5.text.toString().toInt()
                    }
                }

            }

            6 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck
                val playerFold5 = memberRealmResults[playerId5]!!.playingCheck
                val playerFold6 = memberRealmResults[playerId6]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips
                val playerChips5 = memberRealmResults[playerId2]!!.memberChips
                val playerChips6 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()
                val player5 = mRealm.where(Member::class.java).equalTo("id", playerId5).findFirst()
                val player6 = mRealm.where(Member::class.java).equalTo("id", playerId6).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }

                if (playerFold5 == "fold") {
                    player5!!.winnerHand = "fold"
                } else {
                    player5!!.winnerHand = spinnerSelectItem5
                    if (playerWinnerCheckEditText5.text.toString() != "") {
                        player5!!.memberChips = playerChips5 + playerWinnerCheckEditText5.text.toString().toInt()
                    }
                }

                if (playerFold6 == "fold") {
                    player6!!.winnerHand = "fold"
                } else {
                    player6!!.winnerHand = spinnerSelectItem6
                    if (playerWinnerCheckEditText6.text.toString() != "") {
                        player6!!.memberChips = playerChips6 + playerWinnerCheckEditText6.text.toString().toInt()
                    }
                }
            }

            7 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck
                val playerFold5 = memberRealmResults[playerId5]!!.playingCheck
                val playerFold6 = memberRealmResults[playerId6]!!.playingCheck
                val playerFold7 = memberRealmResults[playerId7]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips
                val playerChips5 = memberRealmResults[playerId2]!!.memberChips
                val playerChips6 = memberRealmResults[playerId2]!!.memberChips
                val playerChips7 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()
                val player5 = mRealm.where(Member::class.java).equalTo("id", playerId5).findFirst()
                val player6 = mRealm.where(Member::class.java).equalTo("id", playerId6).findFirst()
                val player7 = mRealm.where(Member::class.java).equalTo("id", playerId7).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }

                if (playerFold5 == "fold") {
                    player5!!.winnerHand = "fold"
                } else {
                    player5!!.winnerHand = spinnerSelectItem5
                    if (playerWinnerCheckEditText5.text.toString() != "") {
                        player5!!.memberChips = playerChips5 + playerWinnerCheckEditText5.text.toString().toInt()
                    }
                }

                if (playerFold6 == "fold") {
                    player6!!.winnerHand = "fold"
                } else {
                    player6!!.winnerHand = spinnerSelectItem6
                    if (playerWinnerCheckEditText6.text.toString() != "") {
                        player6!!.memberChips = playerChips6 + playerWinnerCheckEditText6.text.toString().toInt()
                    }
                }

                if (playerFold7 == "fold") {
                    player7!!.winnerHand = "fold"
                } else {
                    player7!!.winnerHand = spinnerSelectItem7
                    if (playerWinnerCheckEditText7.text.toString() != "") {
                        player7!!.memberChips = playerChips7 + playerWinnerCheckEditText7.text.toString().toInt()
                    }
                }
            }

            8 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck
                val playerFold5 = memberRealmResults[playerId5]!!.playingCheck
                val playerFold6 = memberRealmResults[playerId6]!!.playingCheck
                val playerFold7 = memberRealmResults[playerId7]!!.playingCheck
                val playerFold8 = memberRealmResults[playerId8]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips
                val playerChips5 = memberRealmResults[playerId2]!!.memberChips
                val playerChips6 = memberRealmResults[playerId2]!!.memberChips
                val playerChips7 = memberRealmResults[playerId2]!!.memberChips
                val playerChips8 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()
                val player5 = mRealm.where(Member::class.java).equalTo("id", playerId5).findFirst()
                val player6 = mRealm.where(Member::class.java).equalTo("id", playerId6).findFirst()
                val player7 = mRealm.where(Member::class.java).equalTo("id", playerId7).findFirst()
                val player8 = mRealm.where(Member::class.java).equalTo("id", playerId8).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }

                if (playerFold5 == "fold") {
                    player5!!.winnerHand = "fold"
                } else {
                    player5!!.winnerHand = spinnerSelectItem5
                    if (playerWinnerCheckEditText5.text.toString() != "") {
                        player5!!.memberChips = playerChips5 + playerWinnerCheckEditText5.text.toString().toInt()
                    }
                }

                if (playerFold6 == "fold") {
                    player6!!.winnerHand = "fold"
                } else {
                    player6!!.winnerHand = spinnerSelectItem6
                    if (playerWinnerCheckEditText6.text.toString() != "") {
                        player6!!.memberChips = playerChips6 + playerWinnerCheckEditText6.text.toString().toInt()
                    }
                }

                if (playerFold7 == "fold") {
                    player7!!.winnerHand = "fold"
                } else {
                    player7!!.winnerHand = spinnerSelectItem7
                    if (playerWinnerCheckEditText7.text.toString() != "") {
                        player7!!.memberChips = playerChips7 + playerWinnerCheckEditText7.text.toString().toInt()
                    }
                }

                if (playerFold8 == "fold") {
                    player8!!.winnerHand = "fold"
                } else {
                    player8!!.winnerHand = spinnerSelectItem8
                    if (playerWinnerCheckEditText8.text.toString() != "") {
                        player8!!.memberChips = playerChips8 + playerWinnerCheckEditText8.text.toString().toInt()
                    }
                }
            }

            9 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()
                val playerNum9 = mRealm.where(Member::class.java).equalTo("memberRound", "9".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()
                val playerId9 = playerNum9.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck
                val playerFold5 = memberRealmResults[playerId5]!!.playingCheck
                val playerFold6 = memberRealmResults[playerId6]!!.playingCheck
                val playerFold7 = memberRealmResults[playerId7]!!.playingCheck
                val playerFold8 = memberRealmResults[playerId8]!!.playingCheck
                val playerFold9 = memberRealmResults[playerId9]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips
                val playerChips5 = memberRealmResults[playerId2]!!.memberChips
                val playerChips6 = memberRealmResults[playerId2]!!.memberChips
                val playerChips7 = memberRealmResults[playerId2]!!.memberChips
                val playerChips8 = memberRealmResults[playerId2]!!.memberChips
                val playerChips9 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()
                val player5 = mRealm.where(Member::class.java).equalTo("id", playerId5).findFirst()
                val player6 = mRealm.where(Member::class.java).equalTo("id", playerId6).findFirst()
                val player7 = mRealm.where(Member::class.java).equalTo("id", playerId7).findFirst()
                val player8 = mRealm.where(Member::class.java).equalTo("id", playerId8).findFirst()
                val player9 = mRealm.where(Member::class.java).equalTo("id", playerId9).findFirst()

                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }

                if (playerFold5 == "fold") {
                    player5!!.winnerHand = "fold"
                } else {
                    player5!!.winnerHand = spinnerSelectItem5
                    if (playerWinnerCheckEditText5.text.toString() != "") {
                        player5!!.memberChips = playerChips5 + playerWinnerCheckEditText5.text.toString().toInt()
                    }
                }

                if (playerFold6 == "fold") {
                    player6!!.winnerHand = "fold"
                } else {
                    player6!!.winnerHand = spinnerSelectItem6
                    if (playerWinnerCheckEditText6.text.toString() != "") {
                        player6!!.memberChips = playerChips6 + playerWinnerCheckEditText6.text.toString().toInt()
                    }
                }

                if (playerFold7 == "fold") {
                    player7!!.winnerHand = "fold"
                } else {
                    player7!!.winnerHand = spinnerSelectItem7
                    if (playerWinnerCheckEditText7.text.toString() != "") {
                        player7!!.memberChips = playerChips7 + playerWinnerCheckEditText7.text.toString().toInt()
                    }
                }

                if (playerFold8 == "fold") {
                    player8!!.winnerHand = "fold"
                } else {
                    player8!!.winnerHand = spinnerSelectItem8
                    if (playerWinnerCheckEditText8.text.toString() != "") {
                        player8!!.memberChips = playerChips8 + playerWinnerCheckEditText8.text.toString().toInt()
                    }
                }

                if (playerFold9 == "fold") {
                    player9!!.winnerHand = "fold"
                } else {
                    player9!!.winnerHand = spinnerSelectItem9
                    if (playerWinnerCheckEditText9.text.toString() != "") {
                        player9!!.memberChips = playerChips9 + playerWinnerCheckEditText9.text.toString().toInt()
                    }
                }
            }

            10 -> {
                val playerNum1 = mRealm.where(Member::class.java).equalTo("memberRound", "1".toInt()).findAll()
                val playerNum2 = mRealm.where(Member::class.java).equalTo("memberRound", "2".toInt()).findAll()
                val playerNum3 = mRealm.where(Member::class.java).equalTo("memberRound", "3".toInt()).findAll()
                val playerNum4 = mRealm.where(Member::class.java).equalTo("memberRound", "4".toInt()).findAll()
                val playerNum5 = mRealm.where(Member::class.java).equalTo("memberRound", "5".toInt()).findAll()
                val playerNum6 = mRealm.where(Member::class.java).equalTo("memberRound", "6".toInt()).findAll()
                val playerNum7 = mRealm.where(Member::class.java).equalTo("memberRound", "7".toInt()).findAll()
                val playerNum8 = mRealm.where(Member::class.java).equalTo("memberRound", "8".toInt()).findAll()
                val playerNum9 = mRealm.where(Member::class.java).equalTo("memberRound", "9".toInt()).findAll()
                val playerNum10 = mRealm.where(Member::class.java).equalTo("memberRound", "10".toInt()).findAll()

                val playerId1 = playerNum1.max("id")!!.toInt()
                val playerId2 = playerNum2.max("id")!!.toInt()
                val playerId3 = playerNum3.max("id")!!.toInt()
                val playerId4 = playerNum4.max("id")!!.toInt()
                val playerId5 = playerNum5.max("id")!!.toInt()
                val playerId6 = playerNum6.max("id")!!.toInt()
                val playerId7 = playerNum7.max("id")!!.toInt()
                val playerId8 = playerNum8.max("id")!!.toInt()
                val playerId9 = playerNum9.max("id")!!.toInt()
                val playerId10 = playerNum10.max("id")!!.toInt()

                val playerFold1 = memberRealmResults[playerId1]!!.playingCheck
                val playerFold2 = memberRealmResults[playerId2]!!.playingCheck
                val playerFold3 = memberRealmResults[playerId3]!!.playingCheck
                val playerFold4 = memberRealmResults[playerId4]!!.playingCheck
                val playerFold5 = memberRealmResults[playerId5]!!.playingCheck
                val playerFold6 = memberRealmResults[playerId6]!!.playingCheck
                val playerFold7 = memberRealmResults[playerId7]!!.playingCheck
                val playerFold8 = memberRealmResults[playerId8]!!.playingCheck
                val playerFold9 = memberRealmResults[playerId9]!!.playingCheck
                val playerFold10 = memberRealmResults[playerId10]!!.playingCheck

                val playerChips1 = memberRealmResults[playerId1]!!.memberChips
                val playerChips2 = memberRealmResults[playerId2]!!.memberChips
                val playerChips3 = memberRealmResults[playerId2]!!.memberChips
                val playerChips4 = memberRealmResults[playerId2]!!.memberChips
                val playerChips5 = memberRealmResults[playerId2]!!.memberChips
                val playerChips6 = memberRealmResults[playerId2]!!.memberChips
                val playerChips7 = memberRealmResults[playerId2]!!.memberChips
                val playerChips8 = memberRealmResults[playerId2]!!.memberChips
                val playerChips9 = memberRealmResults[playerId2]!!.memberChips
                val playerChips10 = memberRealmResults[playerId2]!!.memberChips

                val player1 = mRealm.where(Member::class.java).equalTo("id", playerId1).findFirst()
                val player2 = mRealm.where(Member::class.java).equalTo("id", playerId2).findFirst()
                val player3 = mRealm.where(Member::class.java).equalTo("id", playerId3).findFirst()
                val player4 = mRealm.where(Member::class.java).equalTo("id", playerId4).findFirst()
                val player5 = mRealm.where(Member::class.java).equalTo("id", playerId5).findFirst()
                val player6 = mRealm.where(Member::class.java).equalTo("id", playerId6).findFirst()
                val player7 = mRealm.where(Member::class.java).equalTo("id", playerId7).findFirst()
                val player8 = mRealm.where(Member::class.java).equalTo("id", playerId8).findFirst()
                val player9 = mRealm.where(Member::class.java).equalTo("id", playerId9).findFirst()
                val player10 = mRealm.where(Member::class.java).equalTo("id", playerId10).findFirst()


                if (playerFold1 == "fold") {
                    player1!!.winnerHand = "fold"
                } else {
                    player1!!.winnerHand = spinnerSelectItem1
                    if (playerWinnerCheckEditText1.text.toString() != "") {
                        player1!!.memberChips = playerChips1 + playerWinnerCheckEditText1.text.toString().toInt()
                    }
                }

                if (playerFold2 == "fold") {
                    player2!!.winnerHand = "fold"
                } else {
                    player2!!.winnerHand = spinnerSelectItem2
                    if (playerWinnerCheckEditText2.text.toString() != "") {
                        player2!!.memberChips = playerChips2 + playerWinnerCheckEditText2.text.toString().toInt()
                    }
                }

                if (playerFold3 == "fold") {
                    player3!!.winnerHand = "fold"
                } else {
                    player3!!.winnerHand = spinnerSelectItem3
                    if (playerWinnerCheckEditText3.text.toString() != "") {
                        player3!!.memberChips = playerChips3 + playerWinnerCheckEditText3.text.toString().toInt()
                    }
                }

                if (playerFold4 == "fold") {
                    player4!!.winnerHand = "fold"
                } else {
                    player4!!.winnerHand = spinnerSelectItem4
                    if (playerWinnerCheckEditText4.text.toString() != "") {
                        player4!!.memberChips = playerChips4 + playerWinnerCheckEditText4.text.toString().toInt()
                    }
                }

                if (playerFold5 == "fold") {
                    player5!!.winnerHand = "fold"
                } else {
                    player5!!.winnerHand = spinnerSelectItem5
                    if (playerWinnerCheckEditText5.text.toString() != "") {
                        player5!!.memberChips = playerChips5 + playerWinnerCheckEditText5.text.toString().toInt()
                    }
                }

                if (playerFold6 == "fold") {
                    player6!!.winnerHand = "fold"
                } else {
                    player6!!.winnerHand = spinnerSelectItem6
                    if (playerWinnerCheckEditText6.text.toString() != "") {
                        player6!!.memberChips = playerChips6 + playerWinnerCheckEditText6.text.toString().toInt()
                    }
                }

                if (playerFold7 == "fold") {
                    player7!!.winnerHand = "fold"
                } else {
                    player7!!.winnerHand = spinnerSelectItem7
                    if (playerWinnerCheckEditText7.text.toString() != "") {
                        player7!!.memberChips = playerChips7 + playerWinnerCheckEditText7.text.toString().toInt()
                    }
                }

                if (playerFold8 == "fold") {
                    player8!!.winnerHand = "fold"
                } else {
                    player8!!.winnerHand = spinnerSelectItem8
                    if (playerWinnerCheckEditText8.text.toString() != "") {
                        player8!!.memberChips = playerChips8 + playerWinnerCheckEditText8.text.toString().toInt()
                    }
                }

                if (playerFold9 == "fold") {
                    player9!!.winnerHand = "fold"
                } else {
                    player9!!.winnerHand = spinnerSelectItem9
                    if (playerWinnerCheckEditText9.text.toString() != "") {
                        player9!!.memberChips = playerChips9 + playerWinnerCheckEditText9.text.toString().toInt()
                    }
                }

                if (playerFold10 == "fold") {
                    player10!!.winnerHand = "fold"
                } else {
                    player10!!.winnerHand = spinnerSelectItem10
                    if (playerWinnerCheckEditText10.text.toString() != "") {
                        player10!!.memberChips = playerChips10 + playerWinnerCheckEditText10.text.toString().toInt()
                    }
                }
            }
        }

        mRealm.copyToRealmOrUpdate(mMember)
        mRealm.commitTransaction()
    }


}