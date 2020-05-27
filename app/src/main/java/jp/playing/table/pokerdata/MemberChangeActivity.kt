package jp.playing.table.pokerdata

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_add_member_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.toolbar

import kotlinx.android.synthetic.main.activity_member_change.*
import kotlinx.android.synthetic.main.content_member_change.*

class MemberChangeActivity : AppCompatActivity() {

    private lateinit var mRealm: Realm

    private lateinit var mMemberChangeAdapter: MemberChangeAdapter

    private val mRealmListener = object : RealmChangeListener<Realm> {
        override fun onChange(t: Realm) {
            reloadListView()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_change)
        setSupportActionBar(toolbar)

        fabMemberBack.setOnClickListener { view ->
            val intent = Intent(this@MemberChangeActivity, HandActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Realmの設定
        mRealm = Realm.getDefaultInstance()

        mMemberChangeAdapter = MemberChangeAdapter(this@MemberChangeActivity)

        reloadListView()

    }

    private fun reloadListView() {
        val memberIdRealmResults = mRealm.where(Game::class.java).findAll()

        val gameId = memberIdRealmResults.max("id").toString()

        val memberRealmResults = mRealm.where(Member::class.java).equalTo("game_id", gameId).findAll()

        mMemberChangeAdapter.memberChangeList = mRealm.copyFromRealm(memberRealmResults)

        memberChangeListView.adapter = mMemberChangeAdapter

        mMemberChangeAdapter.notifyDataSetChanged()

    }

    override fun onDestroy() {
        super.onDestroy()

        mRealm.close()
    }

}
