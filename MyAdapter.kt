package abled.tstory.room

import abled.tstory.room.databinding.ItemViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var datalist:ArrayList<User> = ArrayList()//리사이클러뷰에서 사용할 데이터 미리 정의

    inner class MyViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun binding(user: User){
            binding.textViewName1.text = user.first_name
            binding.textViewName2.text = user.second_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //레이아웃을 객체형태로 변환(inflate)하고 반환해준다.
        val binding=ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.binding(datalist[position])
    }

    override fun getItemCount(): Int = datalist.size
}