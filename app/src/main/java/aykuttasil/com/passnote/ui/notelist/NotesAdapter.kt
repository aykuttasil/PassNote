package aykuttasil.com.passnote.ui.notelist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.data.Storage
import aykuttasil.com.passnote.util.extension.inflate
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat

class NotesAdapter(
        private var secrets: List<Storage.SecretData>,
        private val listener: (Storage.SecretData) -> Unit) : RecyclerView.Adapter<NotesAdapter.Holder>() {

    private val dateFormatter = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM)

    override fun getItemCount() = secrets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(parent.inflate(R.layout.item_note))

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(secrets[position], listener, dateFormatter)

    fun update(secrets: List<Storage.SecretData>) {
        this.secrets = secrets
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Storage.SecretData, listener: (Storage.SecretData) -> Unit, dateFormatter: DateFormat) = with(itemView) {
            titleView.text = item.alias
            dateView.text = dateFormatter.format(item.createDate)
            setOnClickListener { listener(item) }
        }
    }
}