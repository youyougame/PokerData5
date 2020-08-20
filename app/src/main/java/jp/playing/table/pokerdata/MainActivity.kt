package jp.playing.table.pokerdata

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.realm.Realm
import io.realm.RealmChangeListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_add_member_list.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mGameAdapter: GameAdapter

    private lateinit var mRealm: Realm

    private val mRealmListener = object : RealmChangeListener<Realm> {
        override fun onChange(t: Realm) {
            reloadListView()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Realmの設定
        mRealm = Realm.getDefaultInstance()
        mRealm.addChangeListener(mRealmListener)

        mGameAdapter = GameAdapter(this@MainActivity)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //新規作成画面に移動する
            val intent = Intent(this@MainActivity, TitleActivity::class.java)
            startActivity(intent)
        }

        dataFab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //データの詳細を開く
        }

        mainListView.setOnItemClickListener { parent, view, position, id ->
            //前回の途中から記録を再開する
        }

        mainListView.setOnItemLongClickListener { parent, view, position, id ->
            //該当記録を削除する
            val game = parent.adapter.getItem(position) as Game

            val results = mRealm.where(Game::class.java).equalTo("id", game.id).findAll()

            mRealm.beginTransaction()
            results.deleteAllFromRealm()
            mRealm.commitTransaction()

            reloadListView()

            true
        }

        reloadListView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun reloadListView() {
        val gameRealmResults = mRealm.where(Game::class.java).findAll()

        mGameAdapter.gameList = mRealm.copyFromRealm(gameRealmResults)

        mainListView.adapter = mGameAdapter

        mGameAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()

        mRealm.close()
    }
}
