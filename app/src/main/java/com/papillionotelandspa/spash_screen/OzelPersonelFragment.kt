package com.papillionotelandspa.spash_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_ozel_personel.*
import kotlinx.android.synthetic.main.fragment_ozel_personel.view.*
import kotlinx.android.synthetic.main.fragment_personel.view.*
import kotlinx.android.synthetic.main.fragment_personel_ekle.view.*
import kotlinx.android.synthetic.main.fragment_personel_ekle.view.personel_ekle

class OzelPersonelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val tasarim=inflater.inflate(R.layout.fragment_ozel_personel, container, false)
        val bundle:OzelPersonelFragmentArgs by navArgs()
        val personel=bundle.personelBilgi
        if(personel.kullanici_fotograf!="") {
            tasarim.k_fotograf.resources.getIdentifier(
                personel.kullanici_fotograf,
                "drawable", "com.papillionotelandspa.spash_screen"
            )
        }
        else{
            tasarim.k_fotograf.setImageResource(R.drawable.personel)
        }
        tasarim.ad.text="${personel.ad} ${personel.soyad}"
        tasarim.departman.text="${personel.departman}"
        tasarim.shift.text="${personel.vardiya}"
        if(personel.calisiyor_mu){
                tasarim.calisiyor_mu.text="Çalışıyor"
        }
        else{
                tasarim.calisiyor_mu.text="Çalışmıyor"
        }



        return tasarim
    }
}