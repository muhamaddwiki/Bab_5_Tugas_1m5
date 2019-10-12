import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bab_5_tugas_1.R

class ListOutput(private val list_data: ArrayList<GetSetArray>) : RecyclerView.Adapter<ListOutput.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    //mendeklarasikan OnItemClickCallBack untuk menampilkan data sentuh

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.date_item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int { //mendapatkan data item dari DataArray
        return list_data.size
    }

    override fun onBindViewHolder(holder: ListOutput.ListViewHolder, position: Int) {
        val data = list_data[position]
        Glide.with(holder.itemView.context)
            .load(data.pict)
            .apply(RequestOptions().override(55, 55))
            .into(holder.image)

        holder.Name.text = data.name
        holder.Detail.text = data.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list_data[holder.adapterPosition]) }

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback ) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var Name: TextView = itemView.findViewById(R.id.nama)
        var Detail: TextView = itemView.findViewById(R.id.desk)
        var image: ImageView = itemView.findViewById(R.id.item)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GetSetArray)
    }
}
