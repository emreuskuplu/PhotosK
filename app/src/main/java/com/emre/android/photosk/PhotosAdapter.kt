package com.emre.android.photosk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emre.android.photosk.databinding.ItemPhotoBinding

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
        holder.binding.photo.text = photoList[position]
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    class PhotosViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)
}