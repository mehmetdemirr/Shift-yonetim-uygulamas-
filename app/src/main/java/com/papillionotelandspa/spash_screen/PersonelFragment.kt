package com.papillionotelandspa.spash_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_personel.view.*
import kotlinx.android.synthetic.main.fragment_personel.view.personel_ekle
import kotlinx.android.synthetic.main.fragment_personel_ekle.view.*

class PersonelFragment : Fragment() {
    lateinit var personel_listesi:ArrayList<Personel>
    lateinit var adapter:PersonelAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tasarim=inflater.inflate(R.layout.fragment_personel, container, false)


        personel_listesi=ArrayList()

        var calisma_gunleri=Array<String>(30){""}
        var izin_gunleri=Array<String>(4){""}
        val personel=Personel(1,"Mehmet","Demir","",
            "Order Taker","A",true,izin_gunleri,
            calisma_gunleri, "",true)

        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)
        personel_listesi.add(personel)

        adapter= PersonelAdapter(requireContext(),personel_listesi)



        tasarim.rv.setHasFixedSize(true)
        tasarim.rv.layoutManager=LinearLayoutManager(requireContext())
        tasarim.rv.adapter=adapter

        tasarim.personel_ekle.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.ekleGecis)
        }

        return tasarim
    }

}