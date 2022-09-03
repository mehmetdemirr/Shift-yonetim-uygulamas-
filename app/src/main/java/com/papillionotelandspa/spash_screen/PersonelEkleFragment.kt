package com.papillionotelandspa.spash_screen

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_personel_ekle.*
import kotlinx.android.synthetic.main.fragment_personel_ekle.view.*

class PersonelEkleFragment : Fragment() {
    var secilen_fotograf: Uri?=null
    var secilen_bitmap:Bitmap?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val tasarim = inflater.inflate(R.layout.fragment_personel_ekle, container, false)
        val fotograf = tasarim.edit_fotograf.setOnClickListener {
           // Toast.makeText(requireContext(), "Fotoğraf seçeme", Toast.LENGTH_SHORT).show()
            if(ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }
            else{
                val gecis=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(gecis,2)
            }
        }
        tasarim.personel_ekle.setOnClickListener {
            //val fotograf = tasarim.edit_fotograf.txt
            val ad = tasarim.edit_ad.text.toString()
            val soyad = tasarim.edit_soyad.text.toString()
            val shift = tasarim.edit_shift.text.toString()
            val departman = tasarim.edit_departman.text.toString()
            if (ad != "" && soyad != "" && shift != "" && departman != "") {
                Toast.makeText(requireContext(), "Kayıt Başarılı", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(it).navigate(R.id.personelGecis)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Kayıt gerçekleşmedi!\nTekrar Deneyiniz.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return tasarim
    }

    //izin alındı mı kontolu
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode==1 && grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            val gecis=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(gecis,2)
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    //önceden izin verilmişse
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==2 && resultCode==Activity.RESULT_OK && data!= null){
            secilen_fotograf=data.data
            if(secilen_fotograf!=null ){
                if(Build.VERSION.SDK_INT>=28){
                    var source=ImageDecoder.createSource(requireContext().contentResolver,secilen_fotograf!!)
                    secilen_bitmap=ImageDecoder.decodeBitmap(source)
                    edit_fotograf.setImageBitmap(secilen_bitmap)
                }
                else{
                    secilen_bitmap=MediaStore.Images.Media.getBitmap(requireContext().contentResolver,secilen_fotograf)
                    edit_fotograf.setImageBitmap(secilen_bitmap)
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}


