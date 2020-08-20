package jp.playing.table.pokerdata

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_playing.*

class DataDetailAdapter(context: Context) : BaseAdapter() {
    private val mLayoutInflater: LayoutInflater

    private lateinit var mRealm: Realm

    private var mMember: Member? = null

    private var mHand: Hand? = null

    private var mPlayer: Player? = null

    private var hand1 = ""
    private var hand2 = ""
    private var table1 = ""
    private var table2 = ""
    private var table3 = ""
    private var table4 = ""
    private var table5 = ""

    private lateinit var hand1Image: ImageView
    private lateinit var hand2Image: ImageView
    private lateinit var table1Image: ImageView
    private lateinit var table2Image: ImageView
    private lateinit var table3Image: ImageView
    private lateinit var table4Image: ImageView
    private lateinit var table5Image: ImageView


    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    var turnList = mutableListOf<Turn>()

    override fun getCount(): Int {
        return turnList.size
    }

    override fun getItem(position: Int): Any {
        return turnList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        mRealm = Realm.getDefaultInstance()
        mMember = Member()
        var convertView = convertView

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_data_detail, parent, false)
        }

        val playerNameText = convertView!!.findViewById<View>(R.id.dataDetailPlayerText) as TextView
        val roundText = convertView!!.findViewById<View>(R.id.dataDetailTableText) as TextView
        val playerTotalChipsText = convertView!!.findViewById<View>(R.id.dataDetailActionText) as TextView
        val playChipsText = convertView!!.findViewById<View>(R.id.dataDetailChipsText) as TextView
        hand1Image = convertView!!.findViewById<View>(R.id.dataDetailHandCard1) as ImageView
        hand2Image = convertView!!.findViewById<View>(R.id.dataDetailHandCard2) as ImageView
        table1Image = convertView!!.findViewById<View>(R.id.dataDetailTableCard1) as ImageView
        table2Image = convertView!!.findViewById<View>(R.id.dataDetailTableCard2) as ImageView
        table3Image = convertView!!.findViewById<View>(R.id.dataDetailTableCard3) as ImageView
        table4Image = convertView!!.findViewById<View>(R.id.dataDetailTableCard4) as ImageView
        table5Image = convertView!!.findViewById<View>(R.id.dataDetailTableCard5) as ImageView

        val turnGameId = turnList[position].game_id
        val count = turnList[position].count
        val playerName = turnList[position].player
        val playerRound = turnList[position].playerRound
        Log.d("kotlintest", playerName)
        Log.d("kotlintest", playerRound.toString())

        var memberId = 0

        when (playerRound) {
            1 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 1.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            2 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 2.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            3 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 3.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            4 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 4.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            5 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 5.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            6 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 6.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            7 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 7.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            8 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 8.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            9 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 9.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

            10 -> {
                val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", turnGameId).and().equalTo("hand_count", count).and().equalTo("memberRound", 10.toInt()).findAll()
                memberId = memberRealmResults.max("id")!!.toInt()
            }

        }
        val memberData = mRealm.where(Member::class.java).equalTo("id", memberId).findFirst()
        hand1 = memberData!!.hand1

        playerNameText.text = turnList[position].player
        roundText.text = turnList[position].round
        playerTotalChipsText.text = turnList[position].memberChips.toString()
        playChipsText.text = turnList[position].playChips.toString()
        handSetting1()

        mRealm.close()

        return convertView
    }

    private fun handSetting1() {
        when (hand1){
            "club1" -> hand1Image.setImageResource(R.drawable.club1)
            "club2" -> hand1Image.setImageResource(R.drawable.club2)
            "club3" -> hand1Image.setImageResource(R.drawable.club3)
            "club4" -> hand1Image.setImageResource(R.drawable.club4)
            "club5" -> hand1Image.setImageResource(R.drawable.club5)
            "club6" -> hand1Image.setImageResource(R.drawable.club6)
            "club7" -> hand1Image.setImageResource(R.drawable.club7)
            "club8" -> hand1Image.setImageResource(R.drawable.club8)
            "club9" -> hand1Image.setImageResource(R.drawable.club9)
            "club10" -> hand1Image.setImageResource(R.drawable.club10)
            "club11" -> hand1Image.setImageResource(R.drawable.club11)
            "club12" -> hand1Image.setImageResource(R.drawable.club12)
            "club13" -> hand1Image.setImageResource(R.drawable.club13)

            "diamond1" -> hand1Image.setImageResource(R.drawable.diamond1)
            "diamond2" -> hand1Image.setImageResource(R.drawable.diamond2)
            "diamond3" -> hand1Image.setImageResource(R.drawable.diamond3)
            "diamond4" -> hand1Image.setImageResource(R.drawable.diamond4)
            "diamond5" -> hand1Image.setImageResource(R.drawable.diamond5)
            "diamond6" -> hand1Image.setImageResource(R.drawable.diamond6)
            "diamond7" -> hand1Image.setImageResource(R.drawable.diamond7)
            "diamond8" -> hand1Image.setImageResource(R.drawable.diamond8)
            "diamond9" -> hand1Image.setImageResource(R.drawable.diamond9)
            "diamond10" -> hand1Image.setImageResource(R.drawable.diamond10)
            "diamond11" -> hand1Image.setImageResource(R.drawable.diamond11)
            "diamond12" -> hand1Image.setImageResource(R.drawable.diamond12)
            "diamond13" -> hand1Image.setImageResource(R.drawable.diamond13)

            "heart1" -> hand1Image.setImageResource(R.drawable.heart1)
            "heart2" -> hand1Image.setImageResource(R.drawable.heart2)
            "heart3" -> hand1Image.setImageResource(R.drawable.heart3)
            "heart4" -> hand1Image.setImageResource(R.drawable.heart4)
            "heart5" -> hand1Image.setImageResource(R.drawable.heart5)
            "heart6" -> hand1Image.setImageResource(R.drawable.heart6)
            "heart7" -> hand1Image.setImageResource(R.drawable.heart7)
            "heart8" -> hand1Image.setImageResource(R.drawable.heart8)
            "heart9" -> hand1Image.setImageResource(R.drawable.heart9)
            "heart10" -> hand1Image.setImageResource(R.drawable.heart10)
            "heart11" -> hand1Image.setImageResource(R.drawable.heart11)
            "heart12" -> hand1Image.setImageResource(R.drawable.heart12)
            "heart13" -> hand1Image.setImageResource(R.drawable.heart13)

            "spade1" -> hand1Image.setImageResource(R.drawable.spade1)
            "spade2" -> hand1Image.setImageResource(R.drawable.spade2)
            "spade3" -> hand1Image.setImageResource(R.drawable.spade3)
            "spade4" -> hand1Image.setImageResource(R.drawable.spade4)
            "spade5" -> hand1Image.setImageResource(R.drawable.spade5)
            "spade6" -> hand1Image.setImageResource(R.drawable.spade6)
            "spade7" -> hand1Image.setImageResource(R.drawable.spade7)
            "spade8" -> hand1Image.setImageResource(R.drawable.spade8)
            "spade9" -> hand1Image.setImageResource(R.drawable.spade9)
            "spade10" -> hand1Image.setImageResource(R.drawable.spade10)
            "spade11" -> hand1Image.setImageResource(R.drawable.spade11)
            "spade12" -> hand1Image.setImageResource(R.drawable.spade12)
            "spade13" -> hand1Image.setImageResource(R.drawable.spade13)
        }
    }

}
