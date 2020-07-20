package jp.playing.table.pokerdata

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_member_playing.*
import kotlinx.android.synthetic.main.activity_playing.*

class MemberPlayingActivity : AppCompatActivity() {

    private var mTurn: Turn? = null

    private var mMember: Member? = null

    private lateinit var mRealm: Realm

    //ハンド選択

    private var chipsNum1 = ""
    private var chipsNum2 = ""
    private var chipsNum3 = ""
    private var chipsNum4 = ""
    private var chipsNum5 = ""
    private var chipsNum6 = ""
    private var chipsNum7 = ""

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

    private var memberChips = 0
    private var playChips = 0
    private var playingCheck = ""

    private var playerName = ""
    private var player_id = ""

    private var turnDataChips = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_playing)

        //Realmの設定
        mRealm = Realm.getDefaultInstance()

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

        if (round == "flop") {
            startNum = flopNum
        } else {
            startNum = preFlopNum
        }

        val memberPlayerRealmResults = mRealm.where(Member::class.java).findAll()
        val memberPlayerRoundRealmResults = mRealm.where(Member::class.java).equalTo("memberRound", playingNum).findAll()
        val memberPlayerRealmResultsId = memberPlayerRoundRealmResults.max("id")!!.toInt()
        playerName = memberPlayerRealmResults[memberPlayerRealmResultsId]!!.memberName
        val dataPlayerId = memberPlayerRealmResults[memberPlayerRealmResultsId]!!.member_id
        val memberPlayingCheck = memberPlayerRealmResults[memberPlayerRealmResultsId]!!.playingCheck

        Log.d("kotlintest", "playerName：" + playerName)
        Log.d("kotlintest", "playerId" + memberPlayerRealmResultsId)

        if (memberPlayingCheck == "fold") {
            if (sameChipsPlayer == memberNum - foldPlayer) {
                when (round) {
                    "preflop" -> round = "flop"
                    "flop" -> round = "turn"
                    "turn" -> round = "river"
                    "turn" -> round = "showdown"
                }

                //CardActivityへ移動
                val intent = Intent(this@MemberPlayingActivity, CardActivity::class.java)
                intent.putExtra("memberNum", memberNum)
                intent.putExtra("game_id", game_id)
                intent.putExtra("count", count)
                intent.putExtra("round", round)
                intent.putExtra("round_count", round_count)
                intent.putExtra("roundNum", roundNum)
                intent.putExtra("myRound", myRound)
                intent.putExtra("cardHand1", cardHand1)
                intent.putExtra("cardHand2", cardHand2)
                intent.putExtra("cardCom1", cardCom1)
                intent.putExtra("cardCom2", cardCom2)
                intent.putExtra("cardCom3", cardCom3)
                intent.putExtra("cardCom4", cardCom4)
                intent.putExtra("cardCom5", cardCom5)
                intent.putExtra("bigBlind", bigBlind)
                intent.putExtra("smallBlind", smallBlind)
                intent.putExtra("tableChips", tableChips)
                intent.putExtra("tableTotalChips", tableTotalChips)
                intent.putExtra("flopNum", flopNum)
                intent.putExtra("preFlopNum", preFlopNum)
                intent.putExtra("playingNum", playingNum)
                intent.putExtra("foldPlayer", foldPlayer)
                intent.putExtra("sameChipsPlayer", sameChipsPlayer)
                startActivity(intent)
            }

            if (roundNum == memberNum) {
                round_count++
                roundNum = 1
            } else {
                roundNum++
            }

            if (playingNum == memberNum) {
                playingNum = 1
            } else {
                playingNum++
            }

            val memberPlayerNumRealm = mRealm.where(Member::class.java).equalTo("memberRound", playingNum).findAll()
            val memberPlayerNumRealmId = memberPlayerNumRealm.max("id")!!.toInt()
            val nextPlayerName = memberPlayerRealmResults[memberPlayerNumRealmId]!!.memberName

            if (nextPlayerName == "自分") {
                //PlayingActivityに移動
                val intent = Intent(this@MemberPlayingActivity, PlayingActivity::class.java)
                intent.putExtra("memberNum", memberNum)
                intent.putExtra("game_id", game_id)
                intent.putExtra("count", count)
                intent.putExtra("round", round)
                intent.putExtra("round_count", round_count)
                intent.putExtra("roundNum", roundNum)
                intent.putExtra("myRound", myRound)
                intent.putExtra("cardHand1", cardHand1)
                intent.putExtra("cardHand2", cardHand2)
                intent.putExtra("cardCom1", cardCom1)
                intent.putExtra("cardCom2", cardCom2)
                intent.putExtra("cardCom3", cardCom3)
                intent.putExtra("cardCom4", cardCom4)
                intent.putExtra("cardCom5", cardCom5)
                intent.putExtra("bigBlind", bigBlind)
                intent.putExtra("smallBlind", smallBlind)
                intent.putExtra("tableChips", tableChips)
                intent.putExtra("tableTotalChips", tableTotalChips)
                intent.putExtra("flopNum", flopNum)
                intent.putExtra("preFlopNum", preFlopNum)
                intent.putExtra("playingNum", playingNum)
                intent.putExtra("foldPlayer", foldPlayer)
                intent.putExtra("sameChipsPlayer", sameChipsPlayer)
                startActivity(intent)
            } else {
                //MemberPlayingActivityに移動
                val intent = Intent(this@MemberPlayingActivity, MemberPlayingActivity::class.java)
                intent.putExtra("memberNum", memberNum)
                intent.putExtra("game_id", game_id)
                intent.putExtra("count", count)
                intent.putExtra("round", round)
                intent.putExtra("round_count", round_count)
                intent.putExtra("roundNum", roundNum)
                intent.putExtra("myRound", myRound)
                intent.putExtra("cardHand1", cardHand1)
                intent.putExtra("cardHand2", cardHand2)
                intent.putExtra("cardCom1", cardCom1)
                intent.putExtra("cardCom2", cardCom2)
                intent.putExtra("cardCom3", cardCom3)
                intent.putExtra("cardCom4", cardCom4)
                intent.putExtra("cardCom5", cardCom5)
                intent.putExtra("bigBlind", bigBlind)
                intent.putExtra("smallBlind", smallBlind)
                intent.putExtra("tableChips", tableChips)
                intent.putExtra("tableTotalChips", tableTotalChips)
                intent.putExtra("flopNum", flopNum)
                intent.putExtra("preFlopNum", preFlopNum)
                intent.putExtra("playingNum", playingNum)
                intent.putExtra("foldPlayer", foldPlayer)
                intent.putExtra("sameChipsPlayer", sameChipsPlayer)
                startActivity(intent)
            }
        }


        val turnRealmResults = mRealm.where(Turn::class.java).findAll()
        val turnDataRealmResults = mRealm.where(Turn::class.java).equalTo("player_id", dataPlayerId).findAll()
        if (turnDataRealmResults.toString() != "[]") {
            val turnDataRealmResultsId = turnDataRealmResults.max("id")!!.toInt()
            turnDataChips = turnRealmResults[turnDataRealmResultsId]!!.playChips
            var turnDataRound = turnRealmResults[turnDataRealmResultsId]!!.round //前回の自分のラウンド

            if (turnDataChips == null || turnDataRound != round) {
                turnDataChips = 0
            }
        }

        supportActionBar?.title = playerName

        memberPlayingNameText.text = "ミニマムベット：" + tableChips + "  " + "ミニマムレイズ：" + tableChips * 2

        if (round == "preflop" && round_count == 1) {
            memberChangeChipsText.text = "0"
        } else {
            memberChangeChipsText.text = turnDataChips.toString()
        }


        //アクションボタンのUI表示設定
        if (tableChips != memberChangeChipsText.text.toString().toInt()) {
            memberPlayingCheckButton.isEnabled = false
        } else {
            memberPlayingCheckButton.isEnabled = true
        }

        if (memberChangeChipsText.text.toString().toInt() < tableChips) {
            memberPlayingCallButton.isEnabled = true
        } else {
            memberPlayingCallButton.isEnabled = false
        }



        //UI部品の設定
        memberPlayingCheckButton.setOnClickListener {
            memberChangeChipsText.text = playChips.toString()
            playingCheck = "play"
        }

        memberPlayingCallButton.setOnClickListener {
            playChips = tableChips
            memberChangeChipsText.text = playChips.toString()
            playingCheck = "play"
        }

        memberPlayingFoldButton.setOnClickListener {
            memberChangeChipsText.text = "0"
            playingCheck = "fold"
        }

        memberPlayingAllInButton.setOnClickListener {
            playChips = memberChips
            memberChangeChipsText.text = playChips.toString()
            playingCheck = "play"
        }

        memberPlayingNumButton1.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "1"
                chipsNum2 == "" -> chipsNum2 = "1"
                chipsNum3 == "" -> chipsNum3 = "1"
                chipsNum4 == "" -> chipsNum4 = "1"
                chipsNum5 == "" -> chipsNum5 = "1"
                chipsNum6 == "" -> chipsNum6 = "1"
                chipsNum7 == "" -> chipsNum7 = "1"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton2.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "2"
                chipsNum2 == "" -> chipsNum2 = "2"
                chipsNum3 == "" -> chipsNum3 = "2"
                chipsNum4 == "" -> chipsNum4 = "2"
                chipsNum5 == "" -> chipsNum5 = "2"
                chipsNum6 == "" -> chipsNum6 = "2"
                chipsNum7 == "" -> chipsNum7 = "2"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton3.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "3"
                chipsNum2 == "" -> chipsNum2 = "3"
                chipsNum3 == "" -> chipsNum3 = "3"
                chipsNum4 == "" -> chipsNum4 = "3"
                chipsNum5 == "" -> chipsNum5 = "3"
                chipsNum6 == "" -> chipsNum6 = "3"
                chipsNum7 == "" -> chipsNum7 = "3"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton4.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "4"
                chipsNum2 == "" -> chipsNum2 = "4"
                chipsNum3 == "" -> chipsNum3 = "4"
                chipsNum4 == "" -> chipsNum4 = "4"
                chipsNum5 == "" -> chipsNum5 = "4"
                chipsNum6 == "" -> chipsNum6 = "4"
                chipsNum7 == "" -> chipsNum7 = "4"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton5.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "5"
                chipsNum2 == "" -> chipsNum2 = "5"
                chipsNum3 == "" -> chipsNum3 = "5"
                chipsNum4 == "" -> chipsNum4 = "5"
                chipsNum5 == "" -> chipsNum5 = "5"
                chipsNum6 == "" -> chipsNum6 = "5"
                chipsNum7 == "" -> chipsNum7 = "5"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton6.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "6"
                chipsNum2 == "" -> chipsNum2 = "6"
                chipsNum3 == "" -> chipsNum3 = "6"
                chipsNum4 == "" -> chipsNum4 = "6"
                chipsNum5 == "" -> chipsNum5 = "6"
                chipsNum6 == "" -> chipsNum6 = "6"
                chipsNum7 == "" -> chipsNum7 = "6"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton7.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "7"
                chipsNum2 == "" -> chipsNum2 = "7"
                chipsNum3 == "" -> chipsNum3 = "7"
                chipsNum4 == "" -> chipsNum4 = "7"
                chipsNum5 == "" -> chipsNum5 = "7"
                chipsNum6 == "" -> chipsNum6 = "7"
                chipsNum7 == "" -> chipsNum7 = "7"

            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton8.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "8"
                chipsNum2 == "" -> chipsNum2 = "8"
                chipsNum3 == "" -> chipsNum3 = "8"
                chipsNum4 == "" -> chipsNum4 = "8"
                chipsNum5 == "" -> chipsNum5 = "8"
                chipsNum6 == "" -> chipsNum6 = "8"
                chipsNum7 == "" -> chipsNum7 = "8"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton9.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "9"
                chipsNum2 == "" -> chipsNum2 = "9"
                chipsNum3 == "" -> chipsNum3 = "9"
                chipsNum4 == "" -> chipsNum4 = "9"
                chipsNum5 == "" -> chipsNum5 = "9"
                chipsNum6 == "" -> chipsNum6 = "9"
                chipsNum7 == "" -> chipsNum7 = "9"


            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton0.setOnClickListener {
            when {
                chipsNum2 == "" -> chipsNum2 = "0"
                chipsNum3 == "" -> chipsNum3 = "0"
                chipsNum4 == "" -> chipsNum4 = "0"
                chipsNum5 == "" -> chipsNum5 = "0"
                chipsNum6 == "" -> chipsNum6 = "0"
                chipsNum7 == "" -> chipsNum7 = "0"
            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton00.setOnClickListener {
            when {
                chipsNum2 == "" -> {
                    chipsNum2 = "0"
                    chipsNum3 = "0"
                }
                chipsNum3 == "" -> {
                    chipsNum3 = "0"
                    chipsNum4 = "0"
                }
                chipsNum4 == "" -> {
                    chipsNum4 = "0"
                    chipsNum5 = "0"
                }
                chipsNum5 == "" -> {
                    chipsNum5 = "0"
                    chipsNum6 = "0"
                }
                chipsNum6 == "" -> {
                    chipsNum6 = "0"
                    chipsNum7 = "0"
                }
                chipsNum7 == "" -> {
                    chipsNum7 = "0"
                }
            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton000.setOnClickListener {
            when {
                chipsNum2 == "" -> {
                    chipsNum2 = "0"
                    chipsNum3 = "0"
                    chipsNum4 = "0"
                }
                chipsNum3 == "" -> {
                    chipsNum3 = "0"
                    chipsNum4 = "0"
                    chipsNum5 = "0"
                }
                chipsNum4 == "" -> {
                    chipsNum4 = "0"
                    chipsNum5 = "0"
                    chipsNum6 = "0"
                }
                chipsNum5 == "" -> {
                    chipsNum5 = "0"
                    chipsNum6 = "0"
                    chipsNum7 = "0"
                }
                chipsNum6 == "" -> {
                    chipsNum6 = "0"
                    chipsNum7 = "0"
                }
                chipsNum7 == "" -> {
                    chipsNum7 = "0"
                }
            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPlayingNumButton0000.setOnClickListener {
            when {
                chipsNum2 == "" -> {
                    chipsNum2 = "0"
                    chipsNum3 = "0"
                    chipsNum4 = "0"
                    chipsNum5 = "0"
                }
                chipsNum3 == "" -> {
                    chipsNum3 = "0"
                    chipsNum4 = "0"
                    chipsNum5 = "0"
                    chipsNum6 = "0"
                }
                chipsNum4 == "" -> {
                    chipsNum4 = "0"
                    chipsNum5 = "0"
                    chipsNum6 = "0"
                    chipsNum7 = "0"
                }
                chipsNum5 == "" -> {
                    chipsNum5 = "0"
                    chipsNum6 = "0"
                    chipsNum7 = "0"
                }
                chipsNum6 == "" -> {
                    chipsNum6 = "0"
                    chipsNum7 = "0"
                }
                chipsNum7 == "" -> {
                    chipsNum7 = "0"
                }
            }
            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
            playingCheck = "play"
        }

        memberPalyingDeleteButton.setOnClickListener {
            chipsNum1 = ""
            chipsNum2 = ""
            chipsNum3 = ""
            chipsNum4 = ""
            chipsNum5 = ""
            chipsNum6 = ""
            chipsNum7 = ""
            playingCheck = "fold"

            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
        }

        memberPlayingDoneButton.setOnClickListener {
            //チップ値が入力されているか確認
            if (memberChangeChipsText.text != "") {
                tableTotalChips = tableTotalChips + memberChangeChipsText.text.toString().toInt()
                Log.d("kotlintest", "他人合計" + tableTotalChips)

                //テーブルチップとの比較
                when {
                    memberChangeChipsText.text.toString().toInt() == tableChips -> {
                        sameChipsPlayer++
                    }
                    memberChangeChipsText.text.toString().toInt() > tableChips -> {
                        sameChipsPlayer = 1
                        tableChips = memberChangeChipsText.text.toString().toInt()
                    }
                }

                mRealm.beginTransaction()
                val turnRealmResults = mRealm.where(Turn::class.java).findAll()

                //Turnへデータ保存
                if (mTurn == null) {
                    mTurn = Turn()

                    val identifier: Int =
                        if (turnRealmResults.max("id") != null) {
                            turnRealmResults.max("id")!!.toInt() + 1
                        } else {
                            0
                        }
                    mTurn!!.id = identifier
                }

                mMember = Member()

                val memberRealmResults = mRealm.where(Member::class.java).findAll()
                //player_idを取得
                val memberPlayerNumRealmResults = mRealm.where(Member::class.java).equalTo("memberRound", playingNum).findAll()
                val playerNumId = memberPlayerNumRealmResults.max("id")!!.toInt()
                player_id = memberRealmResults[playerNumId]!!.member_id
                val playerTotalChips = memberRealmResults[playerNumId]!!.memberChips

                //Turnを新規登録
                mTurn!!.game_id = game_id
                mTurn!!.count = count
                mTurn!!.round = round
                mTurn!!.round_count = round_count
                mTurn!!.player = playerName
                mTurn!!.player_id = player_id
                mTurn!!.playChips = memberChangeChipsText.text.toString().toInt() - turnDataChips.toString().toInt()
                mTurn!!.memberChips = playerTotalChips - memberChangeChipsText.text.toString().toInt()
                mTurn!!.tableChips = tableChips
                mTurn!!.tableTotalChips = tableTotalChips

                //Memberを更新
                var member = mRealm.where(Member::class.java).equalTo("id", playerNumId).findFirst()

                if (playingCheck == "fold") {
                    member!!.playingCheck = "fold"
                    foldPlayer++
                }

                member!!.memberChips = playerTotalChips - memberChangeChipsText.text.toString().toInt()

                mRealm.copyToRealmOrUpdate(mTurn!!)
                mRealm.copyToRealmOrUpdate(mMember!!)
                mRealm.commitTransaction()

                if (foldPlayer == memberNum - 1) {
                    count++
                    if (flopNum == memberNum) {
                        flopNum = 1
                        playingNum = 1
                    } else {
                        flopNum++
                        playingNum = flopNum
                    }
                    //HandActivityへの移動
                    val intent = Intent(this@MemberPlayingActivity, HandActivity::class.java)
                    intent.putExtra("memberNum", memberNum)
                    intent.putExtra("count", count)
                    intent.putExtra("myRound", myRound)
                    intent.putExtra("bigBlind", bigBlind)
                    intent.putExtra("smallBlind", smallBlind)
                    intent.putExtra("flopNum", flopNum)
                    intent.putExtra("playingNum", playingNum)
                    startActivity(intent)
                } else {
                    if (sameChipsPlayer == memberNum - foldPlayer) {
                        when (round) {
                            "preflop" -> round = "flop"
                            "flop" -> round = "turn"
                            "turn" -> round = "river"
                            "river" -> round = "showdown"
                        }

                        playingNum = preFlopNum
                        roundNum = 1
                        round_count = 1
                        tableChips = 0
                        sameChipsPlayer = 0

                        //CardActivityへ移動
                        Log.d("kotlintest", "他人・" + "memberNum：" + memberNum)
                        Log.d("kotlintest", "他人・" + "count：" + count)
                        Log.d("kotlintest", "他人・" + "round：" + round)
                        Log.d("kotlintest", "他人・" + "round_count：" + round_count)
                        Log.d("kotlintest", "他人・" + "roundNum：" + roundNum)
                        Log.d("kotlintest", "他人・" + "myRound：" + myRound)
                        Log.d("kotlintest", "他人・" + "tableChips：" + tableChips)
                        Log.d("kotlintest", "他人・" + "tableTotalChips：" + tableTotalChips)
                        Log.d("kotlintest", "他人・" + "playingNum：" + playingNum)
                        Log.d("kotlintest", "他人・" + "foldPlayer：" + foldPlayer)
                        Log.d("kotlintest", "他人・" + "sameChipsPlayer：" + sameChipsPlayer)

                        val intent =
                            Intent(this@MemberPlayingActivity, CardActivity::class.java)
                        intent.putExtra("memberNum", memberNum)
                        intent.putExtra("game_id", game_id)
                        intent.putExtra("count", count)
                        intent.putExtra("round", round)
                        intent.putExtra("round_count", round_count)
                        intent.putExtra("roundNum", roundNum)
                        intent.putExtra("myRound", myRound)
                        intent.putExtra("cardHand1", cardHand1)
                        intent.putExtra("cardHand2", cardHand2)
                        intent.putExtra("cardCom1", cardCom1)
                        intent.putExtra("cardCom2", cardCom2)
                        intent.putExtra("cardCom3", cardCom3)
                        intent.putExtra("cardCom4", cardCom4)
                        intent.putExtra("cardCom5", cardCom5)
                        intent.putExtra("bigBlind", bigBlind)
                        intent.putExtra("smallBlind", smallBlind)
                        intent.putExtra("tableChips", tableChips)
                        intent.putExtra("tableTotalChips", tableTotalChips)
                        intent.putExtra("flopNum", flopNum)
                        intent.putExtra("preFlopNum", preFlopNum)
                        intent.putExtra("playingNum", playingNum)
                        intent.putExtra("foldPlayer", foldPlayer)
                        intent.putExtra("sameChipsPlayer", sameChipsPlayer)
                        startActivity(intent)

                    } else {

                        if (roundNum == memberNum) {
                            round_count++
                            roundNum = 1
                        } else {
                            roundNum++
                        }

                        if (playingNum == memberNum) {
                            playingNum = 1
                        } else {
                            playingNum++
                        }

                        val memberPlayerNumRealm =
                            mRealm.where(Member::class.java).equalTo("memberRound", playingNum)
                                .findAll()
                        val memberPlayerNumRealmId = memberPlayerNumRealm.max("id")!!.toInt()
                        val nextPlayerName = memberRealmResults[memberPlayerNumRealmId]!!.memberName

                        if (nextPlayerName == "自分") {
                            //PlayingActivityに移動
                            Log.d("kotlintest", "他人・" + "memberNum：" + memberNum)
                            Log.d("kotlintest", "他人・" + "count：" + count)
                            Log.d("kotlintest", "他人・" + "round：" + round)
                            Log.d("kotlintest", "他人・" + "round_count：" + round_count)
                            Log.d("kotlintest", "他人・" + "roundNum：" + roundNum)
                            Log.d("kotlintest", "他人・" + "myRound：" + myRound)
                            Log.d("kotlintest", "他人・" + "tableChips：" + tableChips)
                            Log.d("kotlintest", "他人・" + "tableTotalChips：" + tableTotalChips)
                            Log.d("kotlintest", "他人・" + "playingNum：" + playingNum)
                            Log.d("kotlintest", "他人・" + "foldPlayer：" + foldPlayer)
                            Log.d("kotlintest", "他人・" + "sameChipsPlayer：" + sameChipsPlayer)

                            val intent =
                                Intent(this@MemberPlayingActivity, PlayingActivity::class.java)
                            intent.putExtra("memberNum", memberNum)
                            intent.putExtra("game_id", game_id)
                            intent.putExtra("count", count)
                            intent.putExtra("round", round)
                            intent.putExtra("round_count", round_count)
                            intent.putExtra("roundNum", roundNum)
                            intent.putExtra("myRound", myRound)
                            intent.putExtra("cardHand1", cardHand1)
                            intent.putExtra("cardHand2", cardHand2)
                            intent.putExtra("cardCom1", cardCom1)
                            intent.putExtra("cardCom2", cardCom2)
                            intent.putExtra("cardCom3", cardCom3)
                            intent.putExtra("cardCom4", cardCom4)
                            intent.putExtra("cardCom5", cardCom5)
                            intent.putExtra("bigBlind", bigBlind)
                            intent.putExtra("smallBlind", smallBlind)
                            intent.putExtra("tableChips", tableChips)
                            intent.putExtra("tableTotalChips", tableTotalChips)
                            intent.putExtra("flopNum", flopNum)
                            intent.putExtra("preFlopNum", preFlopNum)
                            intent.putExtra("playingNum", playingNum)
                            intent.putExtra("foldPlayer", foldPlayer)
                            intent.putExtra("sameChipsPlayer", sameChipsPlayer)
                            startActivity(intent)
                        } else {
                            //MemberPlayingActivityに移動
                            Log.d("kotlintest", "他人・" + "memberNum：" + memberNum)
                            Log.d("kotlintest", "他人・" + "count：" + count)
                            Log.d("kotlintest", "他人・" + "round：" + round)
                            Log.d("kotlintest", "他人・" + "round_count：" + round_count)
                            Log.d("kotlintest", "他人・" + "roundNum：" + roundNum)
                            Log.d("kotlintest", "他人・" + "myRound：" + myRound)
                            Log.d("kotlintest", "他人・" + "tableChips：" + tableChips)
                            Log.d("kotlintest", "他人・" + "tableTotalChips：" + tableTotalChips)
                            Log.d("kotlintest", "他人・" + "playingNum：" + playingNum)
                            Log.d("kotlintest", "他人・" + "foldPlayer：" + foldPlayer)
                            Log.d("kotlintest", "他人・" + "sameChipsPlayer：" + sameChipsPlayer)

                            val intent = Intent(
                                this@MemberPlayingActivity,
                                MemberPlayingActivity::class.java
                            )
                            intent.putExtra("memberNum", memberNum)
                            intent.putExtra("game_id", game_id)
                            intent.putExtra("count", count)
                            intent.putExtra("round", round)
                            intent.putExtra("round_count", round_count)
                            intent.putExtra("roundNum", roundNum)
                            intent.putExtra("myRound", myRound)
                            intent.putExtra("cardHand1", cardHand1)
                            intent.putExtra("cardHand2", cardHand2)
                            intent.putExtra("cardCom1", cardCom1)
                            intent.putExtra("cardCom2", cardCom2)
                            intent.putExtra("cardCom3", cardCom3)
                            intent.putExtra("cardCom4", cardCom4)
                            intent.putExtra("cardCom5", cardCom5)
                            intent.putExtra("bigBlind", bigBlind)
                            intent.putExtra("smallBlind", smallBlind)
                            intent.putExtra("tableChips", tableChips)
                            intent.putExtra("tableTotalChips", tableTotalChips)
                            intent.putExtra("flopNum", flopNum)
                            intent.putExtra("preFlopNum", preFlopNum)
                            intent.putExtra("playingNum", playingNum)
                            intent.putExtra("foldPlayer", foldPlayer)
                            intent.putExtra("sameChipsPlayer", sameChipsPlayer)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }
}
