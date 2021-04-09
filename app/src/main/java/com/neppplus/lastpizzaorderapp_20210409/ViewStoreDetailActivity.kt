package com.neppplus.lastpizzaorderapp_20210409

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.neppplus.lastpizzaorderapp_20210409.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import java.util.jar.Manifest

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStore : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

        callBtn.setOnClickListener {

            val mPermissionListener = object : PermissionListener {
                override fun onPermissionGranted() {

                    val myUri = Uri.parse("tel:${mStore.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext,"전화 연결이 거부되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            TedPermission.with(mContext)
                .setPermissionListener(mPermissionListener)
                .setDeniedMessage("[설정]에서 [권한]을 허락해주세요")
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()

        }

    }

    override fun setValues() {


        mStore = intent.getSerializableExtra("storeInformation") as Store

        Glide.with(mContext).load(mStore.logoUrl).into(logoImg)
        nameTxt.text = mStore.name
        phoneNumTxt.text = mStore.phoneNum


    }


}