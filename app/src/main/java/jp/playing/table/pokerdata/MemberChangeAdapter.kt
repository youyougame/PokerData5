package jp.playing.table.pokerdata

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MemberChangeAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    var memberChangeList = mutableListOf<Member>()

    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return memberChangeList.size
    }

    override fun getItem(position: Int): Any {
        return memberChangeList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView ?: mLayoutInflater.inflate(R.layout.list_member_change, null)

        val nameText = convertView!!.findViewById<View>(R.id.memberChangeListText) as TextView
        nameText.text = memberChangeList[position].memberName

        return convertView
    }

}