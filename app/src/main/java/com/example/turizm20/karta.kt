package com.example.turizm20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.turizm20.Goroda.anapa
import com.example.turizm20.Goroda.astrahani
import com.example.turizm20.Goroda.kerch
import com.example.turizm20.Goroda.krasnodar
import com.example.turizm20.Goroda.maikop
import com.example.turizm20.Goroda.novorosisk
import com.example.turizm20.Goroda.rostov_na_donu
import com.example.turizm20.Goroda.sevastopol
import com.example.turizm20.Goroda.sochi
import com.example.turizm20.Goroda.volgograd
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

private lateinit var mapView: MapView
class karta : AppCompatActivity() {
    private val placemarkTapListener1 = MapObjectTapListener { _, point ->
// Переходим на новую активити Майкоп
        val intent = Intent(this@karta, maikop::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener2 = MapObjectTapListener { _, point ->
// Переходим на новую активити Анапа
        val intent = Intent(this@karta, anapa::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener3 = MapObjectTapListener { _, point ->
// Переходим на новую активити Астрахань
        val intent = Intent(this@karta, astrahani::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener4 = MapObjectTapListener { _, point ->
// Переходим на новую активити Керчь
        val intent = Intent(this@karta, kerch::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener5 = MapObjectTapListener { _, point ->
// Переходим на новую активити Краснодар
        val intent = Intent(this@karta, krasnodar::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener6 = MapObjectTapListener { _, point ->
// Переходим на новую активити Новороссийск
        val intent = Intent(this@karta, novorosisk::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener7 = MapObjectTapListener { _, point ->
// Переходим на новую активити Ростов-на-Дону
        val intent = Intent(this@karta, rostov_na_donu::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener8 = MapObjectTapListener { _, point ->
// Переходим на новую активити Севастополь
        val intent = Intent(this@karta, sevastopol::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener9 = MapObjectTapListener { _, point ->
// Переходим на новую активити Сочи
        val intent = Intent(this@karta, sochi::class.java)
        startActivity(intent)
        true
    }
    private val placemarkTapListener10 = MapObjectTapListener { _, point ->
// Переходим на новую активити Волгоград
        val intent = Intent(this@karta, volgograd::class.java)
        startActivity(intent)
        true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("681e96c6-8d85-4f46-91a7-0e091a4eca20")//API токен YandexMapKit(для доступа к карте)
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_karta)
        mapView = findViewById(R.id.mapview)
        mapView.map.move(
            CameraPosition(
                Point(44.609657, 40.069431),
                /* zoom = */ 17.0f,
                /* azimuth = */ 150.0f,
                /* tilt = */ 30.0f
            )
        )
        val imageProvider = ImageProvider.fromResource(this, R.drawable.icon4) // картинка маркера на карте

        val placemark1 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(44.609483, 40.105381)//Майкоп
            setIcon(imageProvider)
        }
        val placemark2 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(44.894818, 37.316367)//Анапа
            setIcon(imageProvider)
        }
        val placemark3 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(46.347614, 48.030178)//Астрахань
            setIcon(imageProvider)
        }
        val placemark4 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(45.356219, 36.467378)//Керчь
            setIcon(imageProvider)
        }
        val placemark5 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(45.035470, 38.975313)//Краснодар
            setIcon(imageProvider)
        }
        val placemark6 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(44.723771, 37.768813)//Новороссийск
            setIcon(imageProvider)
        }
        val placemark7 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(47.222078, 39.720358)//Ростов-на-Дону
            setIcon(imageProvider)
        }
        val placemark8 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(44.556972, 33.526402)//Севастополь
            setIcon(imageProvider)
        }
        val placemark9 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(43.585472, 39.723098)//Сочи
            setIcon(imageProvider)
        }
        val placemark10 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(48.707067, 44.516975)//Волгоград
            setIcon(imageProvider)
        }
        placemark1.addTapListener(placemarkTapListener1)//маркер при нажатии на который открываеться активити
        placemark2.addTapListener(placemarkTapListener2)
        placemark3.addTapListener(placemarkTapListener3)
        placemark4.addTapListener(placemarkTapListener4)
        placemark5.addTapListener(placemarkTapListener5)
        placemark6.addTapListener(placemarkTapListener6)
        placemark7.addTapListener(placemarkTapListener7)
        placemark8.addTapListener(placemarkTapListener8)
        placemark9.addTapListener(placemarkTapListener9)
        placemark10.addTapListener(placemarkTapListener10)
    }
    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}