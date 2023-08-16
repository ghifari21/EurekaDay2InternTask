package com.gosty.listpengguna

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gosty.listpengguna.databinding.ItemBinding

class UserListAdapter : ListAdapter<UserModel, UserListAdapter.MyViewHolder>(DIFF_CALLBACK) {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
        holder.binding.root.setOnClickListener {
            onItemClickCallback.onItemClicked(user)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(user: UserModel)
    }

    class MyViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(user: UserModel) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(user.photo)
                    .placeholder(R.drawable.ic_image)
                    .error(R.drawable.ic_broken_image)
                    .into(ivAvatar)
                tvFullname.text = user.name
                tvEmail.text = user.email
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<UserModel> =
            object : DiffUtil.ItemCallback<UserModel>() {
                override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                    return oldItem == newItem
                }
            }
    }
}