package jp.playing.table.pokerdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class GameAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    var gameList = mutableListOf<String>()

    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return gameList.size
    }

    override fun getItem(position: Int): Any {
        return gameList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}