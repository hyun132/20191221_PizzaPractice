package com.example.a20191221_pizzapractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.a20191221_pizzapractice.datas.PizzaStore
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_pizza_stroe_info.*
import java.net.URI

class PizzaStroeInfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_stroe_info)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        storeNameImageView.setOnClickListener {
//            var intent = Intent(mContext,PhotoViewActivity::class.java)
//            intent.putExtra("imgUri",intent.getStringExtra())
//        }

        callBtn.setOnClickListener {

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel:${phoneNumTxt.text}")
                    var intent = Intent(Intent.ACTION_CALL, uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                }

            }
            TedPermission.with(mContext).setPermissionListener(permissionListener).setDeniedMessage("권한 설정이 필요합니다.")
                .setRationaleMessage("바로 전화를 걸기 위해 필요합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE).check()  // 쓸데없이 임포트된 클래스 제거 단축키

        }

    }

    override fun setValues() {

        var data = intent.getSerializableExtra("PizzaStore") as PizzaStore

        phoneNumTxt.text = data.phoneNum
        pizzaStoreNameTxt.text = data.storeName
        Glide.with(mContext).load(data.logoUrl).into(storeNameImageView)
    }


}
