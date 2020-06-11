package jp.playing.table.pokerdata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_member_playing.*
import kotlinx.android.synthetic.main.activity_playing.*

class MemberPlayingActivity : AppCompatActivity() {

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
    private var tableChips = 0
    private var tableTotalChips = 0
    private var startNum = 0
    private var playingNum = 0
    private var foldPlayer = 0
    private var sameChipsPlayer = 0

    private var memberChips = 0
    private var playChips = 0
    private var playingCheck = ""

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
        tableChips = intent.getIntExtra("tableChips", 0)
        tableTotalChips = intent.getIntExtra("tableTotalChips", 0)
        startNum = intent.getIntExtra("startNum", 0)
        playingNum = intent.getIntExtra("playingNum", 0)
        foldPlayer = intent.getIntExtra("foldPlayer", 0)
        sameChipsPlayer = intent.getIntExtra("sameChipsPlayer", 0)

        //アクションボタンのUI表示設定
        if (tableChips != playChips) {
            memberPlayingCheckButton.isEnabled = false
        } else {
            memberPlayingCheckButton.isEnabled = true
        }

        if (playChips < tableChips) {
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
            memberChangeChipsText.text = "fold"
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

            memberChangeChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
        }

        memberPlayingDoneButton.setOnClickListener {  }

    }
}
