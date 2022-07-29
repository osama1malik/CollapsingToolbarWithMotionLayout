package com.scorpio.collapsingtoolbarwithmotionlayout.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scorpio.collapsingtoolbarwithmotionlayout.databinding.RowItemBinding

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var repo: ArrayList<String> = arrayListOf()
    var mOnMusicListener: OnMusicListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mRepo = repo[position]
        with(holder.binding) {
            this.holderText.text = mRepo
        }

    }

    fun setData(list: ArrayList<String>) {
        repo.clear()
        repo.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return repo.size
    }

    class ViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnMusicListener {
        fun selectMusic(position: Int)
        fun optionsClick(position: Int, view: View)
        fun doneClick(position: Int)
    }
}