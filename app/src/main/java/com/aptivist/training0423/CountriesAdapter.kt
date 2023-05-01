package com.aptivist.training0423

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aptivist.training0423.databinding.CountriesItemBinding

class CountriesAdapter(private val onItemClicked: (Int) -> Unit) : ListAdapter<DTOCountries, CountriesAdapter.CountriesViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<DTOCountries>(){
        override fun areItemsTheSame(oldItem: DTOCountries, newItem: DTOCountries): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: DTOCountries, newItem: DTOCountries): Boolean {
            return oldItem == newItem
        }

    }

    class CountriesViewHolder(private val binding: CountriesItemBinding, private val onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: DTOCountries, position: Int){
            binding.composeView.setContent {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClicked.invoke(position)
                    }
                    .height(60.dp), horizontalArrangement = Arrangement.Center) {
                    Image(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp),
                        painter = painterResource(id = item.image),
                        contentDescription = "desc",
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier.weight(3f)
                            .fillMaxSize()
                    ) {
                        Text(modifier = Modifier.align(Alignment.Center), text = item.name)
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                            .fillMaxSize()
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = item.code,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
          /*  binding.ivFlag.setImageResource(item.image)
            binding.tvCountryCode.text = item.code
            binding.tvCountryName.text = item.name
            binding.root.setOnClickListener {
                onItemClicked.invoke(position)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val binding = CountriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(binding, onItemClicked)
    }


    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}