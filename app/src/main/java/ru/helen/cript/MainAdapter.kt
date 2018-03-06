package ru.helen.cript
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.helen.cript.api.Cript
import kotlinx.android.synthetic.main.item_cript.view.*

/**
 * Created by lenap on 04.03.2018.
 */
class MainAdapter(var items : List<Cript>?) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_cript, parent, false))
    }

    override fun getItemCount(): Int = items!!.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.tvCriptName.text = items!![position].name
    }

    class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){

        val tvCriptName = itemView.tvCriptName
    }
}