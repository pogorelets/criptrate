package ru.helen.cript


import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.helen.cript.api.Cript


/**
 * Created by lenap on 04.03.2018.
 */
class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var items: List<Cript> = ArrayList()
    val green: String = "#F44336"
    val red: String = "#4CAF50"
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_cript, parent, false)

        return MainHolder(binding)
    }

    override fun getItemCount(): Int = items!!.size

    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
        var item: Cript = items[position]
        item.priceRub =  "${item.priceRub.substringBefore('.')}.${item.priceRub.substringAfterLast('.').substring(0,2)}"
        when (item.percentChange1h.indexOf("-")){
            -1 -> item.color1h = Color.parseColor(green)
            else -> item.color1h = Color.parseColor(red)
        }
        when (item.percentChange24h.indexOf("-")){
            -1 -> item.color24h = Color.parseColor(green)
            else -> item.color24h = Color.parseColor(red)
        }
        when (item.percentChange7d.indexOf("-")){
            -1 -> item.color7d = Color.parseColor(green)
            else -> item.color7d = Color.parseColor(red)
        }
        holder?.bind(item)
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