package com.neppplus.lastpizzaorderapp_20210409.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
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

        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)


        nameTxt.text = storeData.name

        Glide.with(mContext).load(storeData.logoUrl).into(logoImg)



        return row
    }
}