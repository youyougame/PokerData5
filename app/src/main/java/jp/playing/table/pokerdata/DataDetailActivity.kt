package jp.playing.table.pokerdata

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_data_detail.*
import kotlinx.android.synthetic.main.content_add_member_list.*

class DataDetailActivity : AppCompatActivity() {

    private lateinit var mRealm: Realm

    private lateinit var mDataDetailAdapter: DataDetailAdapter

    private var mGame: Game? = null

    private var mTurn: Turn? = null

    private var dataId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_detail)

        mRealm = Realm.getDefaultInstance()

        mDataDetailAdapter = DataDetailAdapter(this@DataDetailActivity)

        val intent = intent
        dataId = intent.getIntExtra("dataId", 0)

        val gameData = mRealm.where(Game::class.java).equalTo("id", dataId).findFirst()
        val gameTitle = gameData!!.title
        val gameDateString = gameData!!.dateString

        supportActionBar?.title = gameTitle + "：" + gameDateString

    }

    private fun reLoadListView() {
        val turnRealmResults = mRealm.where(Turn::class.java).equalTo("id", dataId).findAll()

        mDataDetailAdapter.turnList = mRealm.copyFromRealm(turnRealmResults)

        dataDetailListView.adapter = mDataDetailAdapter

        mDataDetailAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()

        mRealm.close()
    }
}
