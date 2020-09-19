package com.raywenderlich.placebook2.adapter

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.raywenderlich.placebook2.R
import com.raywenderlich.placebook2.ui.MapsActivity

class BookmarkInfoWindowAdapter(context: Activity) :
    GoogleMap.InfoWindowAdapter {
    // 2
    private val contents: View
    // 3
    init {
        contents = context.layoutInflater.inflate(
            R.layout.content_bookmark_info, null)
    }
    // 4
    override fun getInfoWindow(marker: Marker): View? {
        // This function is required, but can return null if
        // not replacing the entire info window
        return null
    }
    // 5
    override fun getInfoContents(marker: Marker): View? {
        val titleView = contents.findViewById<TextView>(R.id.title)
        titleView.text = marker.title ?: ""
        val phoneView = contents.findViewById<TextView>(R.id.phone)
        phoneView.text = marker.snippet ?: ""
        val imageView = contents.findViewById< ImageView>(R.id.photo)
        imageView.setImageBitmap((marker.tag as MapsActivity.PlaceInfo).image)
        return contents
    }
}