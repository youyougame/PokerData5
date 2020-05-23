package jp.playing.table.pokerdata

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_hand.*
import kotlinx.android.synthetic.main.activity_main.*

class HandActivity : AppCompatActivity() {

    private var firstNum:Int = 1

    private var secondNum:String = ""

    private var cardSuit = ""

    private var cardNumber1 = ""

    private var cardNumber2 = ""

    private var cardSelect = "hand1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hand)

        supportActionBar?.title = "HAND"


        if (secondNum == "") {
            handChipsText.text = firstNum.toString()
        } else {
            handChipsText.text = firstNum.toString() + secondNum
        }


        //ボタンのリスナー
        //終了ボタンのリスナー
        handEndButton.setOnClickListener {
            finish()
        }

        //メンバー数変更ボタンのリスナー
        handMemberChangeButton.setOnClickListener {
            val intent = Intent(this@HandActivity, MemberChangeActivity::class.java)
            startActivity(intent)
        }

        //チップ上ボタン
        handUpButton.setOnClickListener {
            if (firstNum != 9) {
                firstNum++
            } else {
                firstNum = 1
            }

            if (secondNum == "") {
                handChipsText.text = firstNum.toString()
            } else {
                handChipsText.text = firstNum.toString() + secondNum
            }
        }

        //チップ下ボタン
        handDownButton.setOnClickListener {
            if (firstNum != 1) {
                firstNum--
            } else {
                firstNum = 9
            }

            if (secondNum == "") {
                handChipsText.text = firstNum.toString()
            } else {
                handChipsText.text = firstNum.toString() + secondNum
            }
        }

        //チップ右ボタン
        handRightButton.setOnClickListener {
            when(secondNum) {
                "" -> secondNum = "0"
                "0" -> secondNum = "00"
                "00" -> secondNum = "000"
                "000" -> secondNum = "0000"
                "0000" -> secondNum = "00000"
                "00000" -> secondNum = "000000"
                "000000" -> secondNum = "0000000"
                "0000000" -> secondNum = ""
            }

            if (secondNum == "") {
                handChipsText.text = firstNum.toString()
            } else {
                handChipsText.text = firstNum.toString() + secondNum
            }
        }

        //チップ左ボタン
        handLeftButton.setOnClickListener {
            when(secondNum) {
                "" -> secondNum = "0000000"
                "0" -> secondNum = ""
                "00" -> secondNum = "0"
                "000" -> secondNum = "00"
                "0000" -> secondNum = "000"
                "00000" -> secondNum = "0000"
                "000000" -> secondNum = "00000"
                "0000000" -> secondNum = "000000"
            }

            if (secondNum == "") {
                handChipsText.text = firstNum.toString()
            } else {
                handChipsText.text = firstNum.toString() + secondNum
            }
        }

        //ハートボタン
        handCardHeart.setOnClickListener {
            cardSuit = "heart"

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //スペードボタン
        handCardSpade.setOnClickListener {
            cardSuit = "spade"

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //クラブボタン
        handCardClub.setOnClickListener {
            cardSuit = "club"

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //ダイヤボタン
        handCardDiamond.setOnClickListener {
            cardSuit = "diamond"

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //1ボタン
        handNum1.setOnClickListener {
            if (cardNumber1 != "1") {
                cardNumber1 = "1"
            } else {
                if (cardNumber2 == "") {
                    cardNumber2 = "1"
                } else {
                    cardNumber2 = ""
                    cardNumber1 = "1"
                }
            }

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //2ボタン
        handNum2.setOnClickListener {
            if (cardNumber1 != "1") {
                cardNumber1 = "2"
            } else {
                if (cardNumber2 == "") {
                    cardNumber2 = "2"
                } else {
                    cardNumber2 = ""
                    cardNumber1 = "2"
                }
            }

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //3ボタン
        handNum3.setOnClickListener {
            if (cardNumber1 != "1") {
                cardNumber1 = "3"
            } else {
                if (cardNumber2 == "") {
                    cardNumber2 = "3"
                } else {
                    cardNumber2 = ""
                    cardNumber1 = "3"
                }
            }

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //4ボタン
        handNum4.setOnClickListener {
            cardNumber1 = "4"
            cardNumber2 = ""

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //5ボタン
        handNum5.setOnClickListener {
            cardNumber1 = "5"
            cardNumber2 = ""

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //6ボタン
        handNum6.setOnClickListener {
            cardNumber1 = "6"
            cardNumber2 = ""

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //7ボタン
        handNum7.setOnClickListener {
            cardNumber1 = "7"
            cardNumber2 = ""

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //8ボタン
        handNum8.setOnClickListener {
            cardNumber1 = "8"
            cardNumber2 = ""

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //9ボタン
        handNum9.setOnClickListener {
            cardNumber1 = "9"
            cardNumber2 = ""

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //0ボタン
        handNum0.setOnClickListener {
            if (cardNumber1 == "1") {
                cardNumber2 = "0"
            }

            if (cardSuit != "" && cardNumber1 != "") {
                if (cardSelect == "hand1") {
                    cardSetting1()
                } else {
                    cardSetting2()
                }
            }
        }

        //デリートボタン
        handDaleteButton.setOnClickListener {
            cardSuit = ""
            cardNumber1 = ""
            cardNumber2 = ""

            handCard1.setImageResource(R.drawable.card_back)
            handCard2.setImageResource(R.drawable.card_back)

            cardSelect = "hand1"
            handDoneButton.text = "1枚目決定"
        }

        handDoneButton.setOnClickListener {
            when(cardSelect) {
                "hand1" -> {
                    cardSelect = "hand2"
                    handDoneButton.text = "2枚目決定"
                }

                "hand2" -> {
                    //Todo 自分のプレイ画面または他のプレイヤー画面に移動する
                }
            }
        }

    }

    private fun cardSetting1() {
        when(cardSuit + cardNumber1 + cardNumber2) {
            "club1" -> handCard1.setImageResource(R.drawable.club1)
            "club2" -> handCard1.setImageResource(R.drawable.club2)
            "club3" -> handCard1.setImageResource(R.drawable.club3)
            "club4" -> handCard1.setImageResource(R.drawable.club4)
            "club5" -> handCard1.setImageResource(R.drawable.club5)
            "club6" -> handCard1.setImageResource(R.drawable.club6)
            "club7" -> handCard1.setImageResource(R.drawable.club7)
            "club8" -> handCard1.setImageResource(R.drawable.club8)
            "club9" -> handCard1.setImageResource(R.drawable.club9)
            "club10" -> handCard1.setImageResource(R.drawable.club10)
            "club11" -> handCard1.setImageResource(R.drawable.club11)
            "club12" -> handCard1.setImageResource(R.drawable.club12)
            "club13" -> handCard1.setImageResource(R.drawable.club13)

            "diamond1" -> handCard1.setImageResource(R.drawable.diamond1)
            "diamond2" -> handCard1.setImageResource(R.drawable.diamond2)
            "diamond3" -> handCard1.setImageResource(R.drawable.diamond3)
            "diamond4" -> handCard1.setImageResource(R.drawable.diamond4)
            "diamond5" -> handCard1.setImageResource(R.drawable.diamond5)
            "diamond6" -> handCard1.setImageResource(R.drawable.diamond6)
            "diamond7" -> handCard1.setImageResource(R.drawable.diamond7)
            "diamond8" -> handCard1.setImageResource(R.drawable.diamond8)
            "diamond9" -> handCard1.setImageResource(R.drawable.diamond9)
            "diamond10" -> handCard1.setImageResource(R.drawable.diamond10)
            "diamond11" -> handCard1.setImageResource(R.drawable.diamond11)
            "diamond12" -> handCard1.setImageResource(R.drawable.diamond12)
            "diamond13" -> handCard1.setImageResource(R.drawable.diamond13)

            "heart1" -> handCard1.setImageResource(R.drawable.heart1)
            "heart2" -> handCard1.setImageResource(R.drawable.heart2)
            "heart3" -> handCard1.setImageResource(R.drawable.heart3)
            "heart4" -> handCard1.setImageResource(R.drawable.heart4)
            "heart5" -> handCard1.setImageResource(R.drawable.heart5)
            "heart6" -> handCard1.setImageResource(R.drawable.heart6)
            "heart7" -> handCard1.setImageResource(R.drawable.heart7)
            "heart8" -> handCard1.setImageResource(R.drawable.heart8)
            "heart9" -> handCard1.setImageResource(R.drawable.heart9)
            "heart10" -> handCard1.setImageResource(R.drawable.heart10)
            "heart11" -> handCard1.setImageResource(R.drawable.heart11)
            "heart12" -> handCard1.setImageResource(R.drawable.heart12)
            "heart13" -> handCard1.setImageResource(R.drawable.heart13)

            "spade1" -> handCard1.setImageResource(R.drawable.spade1)
            "spade2" -> handCard1.setImageResource(R.drawable.spade2)
            "spade3" -> handCard1.setImageResource(R.drawable.spade3)
            "spade4" -> handCard1.setImageResource(R.drawable.spade4)
            "spade5" -> handCard1.setImageResource(R.drawable.spade5)
            "spade6" -> handCard1.setImageResource(R.drawable.spade6)
            "spade7" -> handCard1.setImageResource(R.drawable.spade7)
            "spade8" -> handCard1.setImageResource(R.drawable.spade8)
            "spade9" -> handCard1.setImageResource(R.drawable.spade9)
            "spade10" -> handCard1.setImageResource(R.drawable.spade10)
            "spade11" -> handCard1.setImageResource(R.drawable.spade11)
            "spade12" -> handCard1.setImageResource(R.drawable.spade12)
            "spade13" -> handCard1.setImageResource(R.drawable.spade13)

        }
    }

    private fun cardSetting2() {
        when(cardSuit + cardNumber1 + cardNumber2) {
            "club1" -> handCard2.setImageResource(R.drawable.club1)
            "club2" -> handCard2.setImageResource(R.drawable.club2)
            "club3" -> handCard2.setImageResource(R.drawable.club3)
            "club4" -> handCard2.setImageResource(R.drawable.club4)
            "club5" -> handCard2.setImageResource(R.drawable.club5)
            "club6" -> handCard2.setImageResource(R.drawable.club6)
            "club7" -> handCard2.setImageResource(R.drawable.club7)
            "club8" -> handCard2.setImageResource(R.drawable.club8)
            "club9" -> handCard2.setImageResource(R.drawable.club9)
            "club10" -> handCard2.setImageResource(R.drawable.club10)
            "club11" -> handCard2.setImageResource(R.drawable.club11)
            "club12" -> handCard2.setImageResource(R.drawable.club12)
            "club13" -> handCard2.setImageResource(R.drawable.club13)

            "diamond1" -> handCard2.setImageResource(R.drawable.diamond1)
            "diamond2" -> handCard2.setImageResource(R.drawable.diamond2)
            "diamond3" -> handCard2.setImageResource(R.drawable.diamond3)
            "diamond4" -> handCard2.setImageResource(R.drawable.diamond4)
            "diamond5" -> handCard2.setImageResource(R.drawable.diamond5)
            "diamond6" -> handCard2.setImageResource(R.drawable.diamond6)
            "diamond7" -> handCard2.setImageResource(R.drawable.diamond7)
            "diamond8" -> handCard2.setImageResource(R.drawable.diamond8)
            "diamond9" -> handCard2.setImageResource(R.drawable.diamond9)
            "diamond10" -> handCard2.setImageResource(R.drawable.diamond10)
            "diamond11" -> handCard2.setImageResource(R.drawable.diamond11)
            "diamond12" -> handCard2.setImageResource(R.drawable.diamond12)
            "diamond13" -> handCard2.setImageResource(R.drawable.diamond13)

            "heart1" -> handCard2.setImageResource(R.drawable.heart1)
            "heart2" -> handCard2.setImageResource(R.drawable.heart2)
            "heart3" -> handCard2.setImageResource(R.drawable.heart3)
            "heart4" -> handCard2.setImageResource(R.drawable.heart4)
            "heart5" -> handCard2.setImageResource(R.drawable.heart5)
            "heart6" -> handCard2.setImageResource(R.drawable.heart6)
            "heart7" -> handCard2.setImageResource(R.drawable.heart7)
            "heart8" -> handCard2.setImageResource(R.drawable.heart8)
            "heart9" -> handCard2.setImageResource(R.drawable.heart9)
            "heart10" -> handCard2.setImageResource(R.drawable.heart10)
            "heart11" -> handCard2.setImageResource(R.drawable.heart11)
            "heart12" -> handCard2.setImageResource(R.drawable.heart12)
            "heart13" -> handCard2.setImageResource(R.drawable.heart13)

            "spade1" -> handCard2.setImageResource(R.drawable.spade1)
            "spade2" -> handCard2.setImageResource(R.drawable.spade2)
            "spade3" -> handCard2.setImageResource(R.drawable.spade3)
            "spade4" -> handCard2.setImageResource(R.drawable.spade4)
            "spade5" -> handCard2.setImageResource(R.drawable.spade5)
            "spade6" -> handCard2.setImageResource(R.drawable.spade6)
            "spade7" -> handCard2.setImageResource(R.drawable.spade7)
            "spade8" -> handCard2.setImageResource(R.drawable.spade8)
            "spade9" -> handCard2.setImageResource(R.drawable.spade9)
            "spade10" -> handCard2.setImageResource(R.drawable.spade10)
            "spade11" -> handCard2.setImageResource(R.drawable.spade11)
            "spade12" -> handCard2.setImageResource(R.drawable.spade12)
            "spade13" -> handCard2.setImageResource(R.drawable.spade13)

        }
    }
}
