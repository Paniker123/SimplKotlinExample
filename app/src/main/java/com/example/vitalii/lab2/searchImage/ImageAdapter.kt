package com.example.vitalii.lab2.searchImage

import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.vitalii.lab2.R
import com.example.vitalii.lab2.model.Image
import kotlinx.android.synthetic.main.image_item.view.*

class ImageAdapter:RecyclerView.Adapter<ImageAdapter.ImageHolder>(){

    lateinit var mImageList:List<Image>


    override fun onBindViewHolder(holder: ImageAdapter.ImageHolder, position: Int) {
        Glide.with(holder.itemView.findingImageView).load(mImageList[position].imageUrl).into(holder.itemView.findingImageView)
        holder.itemView.dislikeImageView.setOnClickListener{dislike(position)}
        holder.itemView.likeImageView.setOnClickListener{like(position)}
        shackIsImageLike(holder,position)
    }

    private fun like(position: Int){
        mImageList[position].isLike=true
        notifyItemChanged(position)
    }

    private fun dislike(position: Int){
        mImageList[position].isLike=false
        notifyItemChanged(position)
    }

    private fun shackIsImageLike(holder: ImageAdapter.ImageHolder, position: Int){
        if (mImageList[position].isLike){
            holder.itemView.likeImageView.drawable.setTint(ContextCompat.getColor(holder.itemView.context,R.color.colorPrimary))
            holder.itemView.dislikeImageView.drawable.setTint(ContextCompat.getColor(holder.itemView.context,R.color.black))
        }else{
            holder.itemView.likeImageView.drawable.setTint(ContextCompat.getColor(holder.itemView.context,R.color.black))
            holder.itemView.dislikeImageView.drawable.setTint(ContextCompat.getColor(holder.itemView.context,R.color.colorPrimary))
        }
    }

    override fun getItemCount(): Int {
       return mImageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ImageAdapter.ImageHolder {
        return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false))
    }

    class ImageHolder(viewItem: View):RecyclerView.ViewHolder(viewItem)

}