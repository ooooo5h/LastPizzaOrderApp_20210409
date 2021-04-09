package com.neppplus.lastpizzaorderapp_20210409

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.lastpizzaorderapp_20210409.fragments.MyProfileFragment
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {

        okBtn.setOnClickListener {

            val inputNickname = newNickNameEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNickname)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }

    }

    override fun setValues() {

    }


}