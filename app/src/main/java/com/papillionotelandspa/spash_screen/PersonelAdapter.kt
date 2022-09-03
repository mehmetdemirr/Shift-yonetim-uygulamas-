package com.papillionotelandspa.spash_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class PersonelAdapter(var mcontex:Context,var list:List<Personel>)
    :RecyclerView.Adapter<PersonelAdapter.cvtutucu>() {
    inner class cvtutucu(view:View):RecyclerView.ViewHolder(view){
        var fotograf:ImageView
        var ad_soyad:TextView
        var departman:TextView
        var cv:CardView

        init {
            fotograf=view.findViewById(R.id.kullanici_fotograf)
            ad_soyad=view.findViewById(R.id.ad_soyad)
            departman=view.findViewById(R.id.departman)
            cv=view.findViewById(R.id.cv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cvtutucu {
       val tasarim=LayoutInflater.from(mcontex).inflate(R.layout.cardview,parent,false)
        return cvtutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cvtutucu, position: Int) {
        val personel=list[position]
        holder.ad_soyad.text="${personel.id} ${personel.ad} ${personel.soyad}"
        holder.departman.text="${personel.departman}"
        if(personel.kullanici_fotograf!=""){
           holder.fotograf.resources.getIdentifier(personel.kullanici_fotograf,
               "drawable","com.papillionotelandspa.spash_screen")
        }
       holder.cv.setOnClickListener {
            val gecis=PersonelFragmentDirections.gecis(personel)
            Navigation.findNavController(it).navigate(gecis)
        }


        holder.fotograf.setImageResource(holder.fotograf.resources.getIdentifier("yemek","drawable","com.papillionotelandspa.spash_screen"))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}