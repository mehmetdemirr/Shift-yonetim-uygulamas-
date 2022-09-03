package com.papillionotelandspa.spash_screen

import java.io.Serializable

data class Personel(var id:Int,
                    var ad:String,
                    var soyad:String,
                    var kullanici_fotograf:String,
                    var departman:String,
                    var vardiya:String,
                    var calisiyor_mu:Boolean,
                    var izin_gunleri:Array<String>,
                    var aylik_calisma_gunleri:Array<String>,
                    var gorevleri:String,
                    var ic_lojman_mi:Boolean):Serializable{

}
