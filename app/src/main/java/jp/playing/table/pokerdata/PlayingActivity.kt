package jp.playing.table.pokerdata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hand.*
import kotlinx.android.synthetic.main.activity_playing.*

class PlayingActivity : AppCompatActivity() {

    //スート
    private var cardSuit = ""

    //カード1桁目
    private var cardNumber1 = ""

    //カード2桁目
    private var cardNumber2 = ""

    //ハンド選択
    private var cardSelect = "hand1"

    private var chipsNum1 = ""
    private var chipsNum2 = ""
    private var chipsNum3 = ""
    private var chipsNum4 = ""
    private var chipsNum5 = ""
    private var chipsNum6 = ""
    private var chipsNum7 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)

        supportActionBar?.title = "あなたの順番です"

        val intent = intent
        val memberNum = intent.getStringExtra("memberNum")
        val game_id = intent.getStringExtra("game_id")

        //UI部品の設定
        playingCheckButton.setOnClickListener {  }

        playingCallButton.setOnClickListener {  }

        playingFoldButton.setOnClickListener {  }

        playingAllInButton.setOnClickListener {  }

        playingNum1.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "1"
                chipsNum2 == "" -> chipsNum2 = "1"
                chipsNum3 == "" -> chipsNum3 = "1"
                chipsNum4 == "" -> chipsNum4 = "1"
                chipsNum5 == "" -> chipsNum5 = "1"
                chipsNum6 == "" -> chipsNum6 = "1"
                chipsNum7 == "" -> chipsNum7 = "1"


            }
            playingChipsText.text = chipsNum1 + chipsNum2 + chipsNum3 + chipsNum4 + chipsNum5 + chipsNum6 + chipsNum7
        }

        playingNum2.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "2"
                chipsNum2 == "" -> chipsNum2 = "2"
                chipsNum3 == "" -> chipsNum3 = "2"
                chipsNum4 == "" -> chipsNum4 = "2"
                chipsNum5 == "" -> chipsNum5 = "2"
                chipsNum6 == "" -> chipsNum6 = "2"
                chipsNum7 == "" -> chipsNum7 = "2"


            }
        }

        playingNum3.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "3"
                chipsNum2 == "" -> chipsNum2 = "3"
                chipsNum3 == "" -> chipsNum3 = "3"
                chipsNum4 == "" -> chipsNum4 = "3"
                chipsNum5 == "" -> chipsNum5 = "3"
                chipsNum6 == "" -> chipsNum6 = "3"
                chipsNum7 == "" -> chipsNum7 = "3"


            }
        }

        playingNum4.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "4"
                chipsNum2 == "" -> chipsNum2 = "4"
                chipsNum3 == "" -> chipsNum3 = "4"
                chipsNum4 == "" -> chipsNum4 = "4"
                chipsNum5 == "" -> chipsNum5 = "4"
                chipsNum6 == "" -> chipsNum6 = "4"
                chipsNum7 == "" -> chipsNum7 = "4"


            }
        }

        playingNum5.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "5"
                chipsNum2 == "" -> chipsNum2 = "5"
                chipsNum3 == "" -> chipsNum3 = "5"
                chipsNum4 == "" -> chipsNum4 = "5"
                chipsNum5 == "" -> chipsNum5 = "5"
                chipsNum6 == "" -> chipsNum6 = "5"
                chipsNum7 == "" -> chipsNum7 = "5"


            }
        }

        playingNum6.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "6"
                chipsNum2 == "" -> chipsNum2 = "6"
                chipsNum3 == "" -> chipsNum3 = "6"
                chipsNum4 == "" -> chipsNum4 = "6"
                chipsNum5 == "" -> chipsNum5 = "6"
                chipsNum6 == "" -> chipsNum6 = "6"
                chipsNum7 == "" -> chipsNum7 = "6"


            }
        }

        playingNum7.setOnClickListener {
            when {
            chipsNum1 == "" -> chipsNum1 = "7"
            chipsNum2 == "" -> chipsNum2 = "7"
            chipsNum3 == "" -> chipsNum3 = "7"
            chipsNum4 == "" -> chipsNum4 = "7"
            chipsNum5 == "" -> chipsNum5 = "7"
            chipsNum6 == "" -> chipsNum6 = "7"
            chipsNum7 == "" -> chipsNum7 = "7"


        } }

        playingNum8.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "8"
                chipsNum2 == "" -> chipsNum2 = "8"
                chipsNum3 == "" -> chipsNum3 = "8"
                chipsNum4 == "" -> chipsNum4 = "8"
                chipsNum5 == "" -> chipsNum5 = "8"
                chipsNum6 == "" -> chipsNum6 = "8"
                chipsNum7 == "" -> chipsNum7 = "8"


            }
        }

        playingNum9.setOnClickListener {
            when {
                chipsNum1 == "" -> chipsNum1 = "9"
                chipsNum2 == "" -> chipsNum2 = "9"
                chipsNum3 == "" -> chipsNum3 = "9"
                chipsNum4 == "" -> chipsNum4 = "9"
                chipsNum5 == "" -> chipsNum5 = "9"
                chipsNum6 == "" -> chipsNum6 = "9"
                chipsNum7 == "" -> chipsNum7 = "9"


            }
        }

        playingNum0.setOnClickListener {
            when {
                chipsNum2 == "" -> chipsNum2 = "0"
                chipsNum3 == "" -> chipsNum3 = "0"
                chipsNum4 == "" -> chipsNum4 = "0"
                chipsNum5 == "" -> chipsNum5 = "0"
                chipsNum6 == "" -> chipsNum6 = "0"
                chipsNum7 == "" -> chipsNum7 = "0"
            }
        }

        playingNum00.setOnClickListener {
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
        }

        playingNum000.setOnClickListener {
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
        }

        playingNum0000.setOnClickListener {
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
        }

    }

    private fun cardSetting1() {
        when (cardSuit + cardNumber1 + cardNumber2){
            "club1" -> playingHand1.setImageResource(R.drawable.club1)
            "club2" -> playingHand1.setImageResource(R.drawable.club2)
            "club3" -> playingHand1.setImageResource(R.drawable.club3)
            "club4" -> playingHand1.setImageResource(R.drawable.club4)
            "club5" -> playingHand1.setImageResource(R.drawable.club5)
            "club6" -> playingHand1.setImageResource(R.drawable.club6)
            "club7" -> playingHand1.setImageResource(R.drawable.club7)
            "club8" -> playingHand1.setImageResource(R.drawable.club8)
            "club9" -> playingHand1.setImageResource(R.drawable.club9)
            "club10" -> playingHand1.setImageResource(R.drawable.club10)
            "club11" -> playingHand1.setImageResource(R.drawable.club11)
            "club12" -> playingHand1.setImageResource(R.drawable.club12)
            "club13" -> playingHand1.setImageResource(R.drawable.club13)

            "diamond1" -> playingHand1.setImageResource(R.drawable.diamond1)
            "diamond2" -> playingHand1.setImageResource(R.drawable.diamond2)
            "diamond3" -> playingHand1.setImageResource(R.drawable.diamond3)
            "diamond4" -> playingHand1.setImageResource(R.drawable.diamond4)
            "diamond5" -> playingHand1.setImageResource(R.drawable.diamond5)
            "diamond6" -> playingHand1.setImageResource(R.drawable.diamond6)
            "diamond7" -> playingHand1.setImageResource(R.drawable.diamond7)
            "diamond8" -> playingHand1.setImageResource(R.drawable.diamond8)
            "diamond9" -> playingHand1.setImageResource(R.drawable.diamond9)
            "diamond10" -> playingHand1.setImageResource(R.drawable.diamond10)
            "diamond11" -> playingHand1.setImageResource(R.drawable.diamond11)
            "diamond12" -> playingHand1.setImageResource(R.drawable.diamond12)
            "diamond13" -> playingHand1.setImageResource(R.drawable.diamond13)

            "heart1" -> playingHand1.setImageResource(R.drawable.heart1)
            "heart2" -> playingHand1.setImageResource(R.drawable.heart2)
            "heart3" -> playingHand1.setImageResource(R.drawable.heart3)
            "heart4" -> playingHand1.setImageResource(R.drawable.heart4)
            "heart5" -> playingHand1.setImageResource(R.drawable.heart5)
            "heart6" -> playingHand1.setImageResource(R.drawable.heart6)
            "heart7" -> playingHand1.setImageResource(R.drawable.heart7)
            "heart8" -> playingHand1.setImageResource(R.drawable.heart8)
            "heart9" -> playingHand1.setImageResource(R.drawable.heart9)
            "heart10" -> playingHand1.setImageResource(R.drawable.heart10)
            "heart11" -> playingHand1.setImageResource(R.drawable.heart11)
            "heart12" -> playingHand1.setImageResource(R.drawable.heart12)
            "heart13" -> playingHand1.setImageResource(R.drawable.heart13)

            "spade1" -> playingHand1.setImageResource(R.drawable.spade1)
            "spade2" -> playingHand1.setImageResource(R.drawable.spade2)
            "spade3" -> playingHand1.setImageResource(R.drawable.spade3)
            "spade4" -> playingHand1.setImageResource(R.drawable.spade4)
            "spade5" -> playingHand1.setImageResource(R.drawable.spade5)
            "spade6" -> playingHand1.setImageResource(R.drawable.spade6)
            "spade7" -> playingHand1.setImageResource(R.drawable.spade7)
            "spade8" -> playingHand1.setImageResource(R.drawable.spade8)
            "spade9" -> playingHand1.setImageResource(R.drawable.spade9)
            "spade10" -> playingHand1.setImageResource(R.drawable.spade10)
            "spade11" -> playingHand1.setImageResource(R.drawable.spade11)
            "spade12" -> playingHand1.setImageResource(R.drawable.spade12)
            "spade13" -> playingHand1.setImageResource(R.drawable.spade13)
        }
    }

    private fun cardSetting2() {
        when(cardSuit + cardNumber1 + cardNumber2) {
            "club1" -> playingHand2.setImageResource(R.drawable.club1)
            "club2" -> playingHand2.setImageResource(R.drawable.club2)
            "club3" -> playingHand2.setImageResource(R.drawable.club3)
            "club4" -> playingHand2.setImageResource(R.drawable.club4)
            "club5" -> playingHand2.setImageResource(R.drawable.club5)
            "club6" -> playingHand2.setImageResource(R.drawable.club6)
            "club7" -> playingHand2.setImageResource(R.drawable.club7)
            "club8" -> playingHand2.setImageResource(R.drawable.club8)
            "club9" -> playingHand2.setImageResource(R.drawable.club9)
            "club10" -> playingHand2.setImageResource(R.drawable.club10)
            "club11" -> playingHand2.setImageResource(R.drawable.club11)
            "club12" -> playingHand2.setImageResource(R.drawable.club12)
            "club13" -> playingHand2.setImageResource(R.drawable.club13)

            "diamond1" -> playingHand2.setImageResource(R.drawable.diamond1)
            "diamond2" -> playingHand2.setImageResource(R.drawable.diamond2)
            "diamond3" -> playingHand2.setImageResource(R.drawable.diamond3)
            "diamond4" -> playingHand2.setImageResource(R.drawable.diamond4)
            "diamond5" -> playingHand2.setImageResource(R.drawable.diamond5)
            "diamond6" -> playingHand2.setImageResource(R.drawable.diamond6)
            "diamond7" -> playingHand2.setImageResource(R.drawable.diamond7)
            "diamond8" -> playingHand2.setImageResource(R.drawable.diamond8)
            "diamond9" -> playingHand2.setImageResource(R.drawable.diamond9)
            "diamond10" -> playingHand2.setImageResource(R.drawable.diamond10)
            "diamond11" -> playingHand2.setImageResource(R.drawable.diamond11)
            "diamond12" -> playingHand2.setImageResource(R.drawable.diamond12)
            "diamond13" -> playingHand2.setImageResource(R.drawable.diamond13)

            "heart1" -> playingHand2.setImageResource(R.drawable.heart1)
            "heart2" -> playingHand2.setImageResource(R.drawable.heart2)
            "heart3" -> playingHand2.setImageResource(R.drawable.heart3)
            "heart4" -> playingHand2.setImageResource(R.drawable.heart4)
            "heart5" -> playingHand2.setImageResource(R.drawable.heart5)
            "heart6" -> playingHand2.setImageResource(R.drawable.heart6)
            "heart7" -> playingHand2.setImageResource(R.drawable.heart7)
            "heart8" -> playingHand2.setImageResource(R.drawable.heart8)
            "heart9" -> playingHand2.setImageResource(R.drawable.heart9)
            "heart10" -> playingHand2.setImageResource(R.drawable.heart10)
            "heart11" -> playingHand2.setImageResource(R.drawable.heart11)
            "heart12" -> playingHand2.setImageResource(R.drawable.heart12)
            "heart13" -> playingHand2.setImageResource(R.drawable.heart13)

            "spade1" -> playingHand2.setImageResource(R.drawable.spade1)
            "spade2" -> playingHand2.setImageResource(R.drawable.spade2)
            "spade3" -> playingHand2.setImageResource(R.drawable.spade3)
            "spade4" -> playingHand2.setImageResource(R.drawable.spade4)
            "spade5" -> playingHand2.setImageResource(R.drawable.spade5)
            "spade6" -> playingHand2.setImageResource(R.drawable.spade6)
            "spade7" -> playingHand2.setImageResource(R.drawable.spade7)
            "spade8" -> playingHand2.setImageResource(R.drawable.spade8)
            "spade9" -> playingHand2.setImageResource(R.drawable.spade9)
            "spade10" -> playingHand2.setImageResource(R.drawable.spade10)
            "spade11" -> playingHand2.setImageResource(R.drawable.spade11)
            "spade12" -> playingHand2.setImageResource(R.drawable.spade12)
            "spade13" -> playingHand2.setImageResource(R.drawable.spade13)
        }
    }
}
