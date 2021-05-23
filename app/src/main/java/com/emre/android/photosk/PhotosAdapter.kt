package com.emre.android.photosk

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.emre.android.photosk.databinding.ItemPhotoBinding
import com.squareup.picasso.Picasso

class PhotosAdapter(private var photoList: List<String> = listOf()) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    fun setList(photoList: List<String>) {
        this.photoList = photoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(layoutInflater)

        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photoUrl = photoList[position]
        if (photoUrl != "") {
            Picasso.get()
                .load(photoUrl)
                .placeholder(ColorDrawable(ContextCompat.getColor(holder.itemView.context, R.color.colorItemPhotoPlaceholder)))
                .fit()
                .into(holder.binding.photo)
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    class PhotosViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)
}