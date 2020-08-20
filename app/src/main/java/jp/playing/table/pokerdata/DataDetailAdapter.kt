package jp.playing.table.pokerdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import io.realm.Realm

class DataDetailAdapter(context: Context) : BaseAdapter() {
    private val mLayoutInflater: LayoutInflater

    private lateinit var mRealm: Realm

    private var mMember: Member? = null

    private var mHand: Hand? = null

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
        TODO("Not yet implemented")
    }

}