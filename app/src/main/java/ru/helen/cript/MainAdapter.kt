package ru.helen.cript


import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.helen.cript.api.Cript


/**
 * Created by lenap on 04.03.2018.
 */
class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var items: List<Cript> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_cript, parent, false)

        return MainHolder(binding)
    }

    override fun getItemCount(): Int = items!!.size

    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
        holder?.bind(items[position])
    }

    fun swapList(items : List<Cript>) {
        this.items = items
        notifyDataSetChanged()
    }

    class MainHolder(val binding: ViewDataBinding) :  RecyclerView.ViewHolder(binding.root){
        fun bind(data: Any) {
            binding.setVariable( BR.cript, data)
            binding.executePendingBindings()
        }
    }
}