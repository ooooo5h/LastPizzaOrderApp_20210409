package com.neppplus.lastpizzaorderapp_20210409.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.neppplus.lastpizzaorderapp_20210409.R
import com.neppplus.lastpizzaorderapp_20210409.datas.Store
import java.util.zip.Inflater

class StoreAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

    val inflate = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null) {
            tempRow = inflate.inflate(R.layout.store_list_item, null)
        }

        val row = tempRow!!

        val storeData = mList[position]

        val logoUrl = row.findViewById<ImageView>(R.id.logoUrl)
        val nameTxt = row.findViewById<ImageView>(R.id.nameTxt)

//        왜 text에 오류가 뜨지???
        nameTxt.text = storeData.name


        return row
    }
}