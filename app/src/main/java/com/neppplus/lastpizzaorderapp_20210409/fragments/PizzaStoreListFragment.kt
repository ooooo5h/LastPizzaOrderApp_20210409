package com.neppplus.lastpizzaorderapp_20210409.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.lastpizzaorderapp_20210409.MainActivity
import com.neppplus.lastpizzaorderapp_20210409.R
import com.neppplus.lastpizzaorderapp_20210409.ViewStoreDetailActivity
import com.neppplus.lastpizzaorderapp_20210409.adapters.StoreAdapter
import com.neppplus.lastpizzaorderapp_20210409.datas.Store
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*
import java.util.ArrayList

class PizzaStoreListFragment : Fragment() {

    val mStoreList = ArrayList<Store>()

    lateinit var mStoreAdapter: StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mStoreList.add(Store("피자헛", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg", "1588-5588"))
        mStoreList.add(Store("파파존스", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800", "1577-8080"))
        mStoreList.add(Store("미스터피자", "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200", "1577-0077"))
        mStoreList.add(Store("도미노피자", "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png", "1577-3082"))

        mStoreAdapter = StoreAdapter(activity!!, R.layout.store_list_item, mStoreList)
        storeListView.adapter = mStoreAdapter

        storeListView.setOnItemClickListener { adapterView, view, position, l ->
            val clickedStore = mStoreList[position]

            val myIntent = Intent(activity, ViewStoreDetailActivity::class.java)
            myIntent.putExtra("storeInformation", clickedStore)
            startActivity(myIntent)
        }


    }
}