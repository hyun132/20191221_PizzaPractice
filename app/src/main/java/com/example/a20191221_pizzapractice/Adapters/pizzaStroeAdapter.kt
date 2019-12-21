package com.example.a20191221_pizzapractice.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.a20191221_pizzapractice.R
import com.example.a20191221_pizzapractice.datas.PizzaStore
import java.util.zip.Inflater

class pizzaStroeAdapter(context: Context, resId: Int, list:ArrayList<PizzaStore>):ArrayAdapter<PizzaStore>(context,resId,list) {

    var mContext = context

//    실수했던부분 ** list 는 어답터의 파라미터로 가져온 것을 넣어줘야 함.
    var PizzaStoreList = list
    var inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {




        var tempRow = convertView

        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.pizza_store_item,null)
        }

        var row = tempRow!!

        var PizzaStoreNameTxt = row.findViewById<TextView>(R.id.pizzaStoreNameTxt)
        var PizzaStoreImgView = row.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.storeNameImageView)


//         실수했던 부분 ** 리스트에서 값 가져올때 get으로 가져옴
        var data = PizzaStoreList.get(position)

        PizzaStoreNameTxt.text = data.storeName
        Glide.with(mContext).load(data.logoUrl).into(PizzaStoreImgView)

        return row
    }

}