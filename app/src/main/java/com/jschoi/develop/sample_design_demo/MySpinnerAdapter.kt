package com.jschoi.develop.sample_design_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener
import com.skydoves.powerspinner.PowerSpinnerInterface
import com.skydoves.powerspinner.PowerSpinnerView

class MySpinnerAdapter(powerSpinnerView: PowerSpinnerView) :
    RecyclerView.Adapter<MySpinnerAdapter.MySpinnerViewHolder>(),
    PowerSpinnerInterface<String> {

    val arr = arrayOf("aa", "bb", "cc", "dd", "ee")

    override var index: Int = powerSpinnerView.selectedIndex
    override val spinnerView: PowerSpinnerView = powerSpinnerView
    override var onSpinnerItemSelectedListener: OnSpinnerItemSelectedListener<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySpinnerViewHolder {
        return MySpinnerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MySpinnerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return arr.size
    }


    inner class MySpinnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }

    override fun notifyItemSelected(index: Int) {
    }

    override fun setItems(itemList: List<String>) {
        // TODO 리스트 넣기
    }
}
