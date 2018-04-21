package com.example.lucas.kotlinyoutube

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

/**
 * Created by Lucas on 19/04/2018.
 */

class MainAdapter(val homeFeed: Models.HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf<String>("First Title", "Second Title", "Third Title")

    //numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //usa-se '?' pois é um parametro opcional da funcao
        val layoutInflater = LayoutInflater.from(parent?.context) //cria objeto do tipo inflate
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false) //infla o layout criado para mostrar na tela
        return CustomViewHolder(cellForRow) //retorna layout
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos.get(position)
        holder?.view?.textView_thumb_nail?.text = video.name
        holder?.view?.textView_channel_name?.text = video.channel.name + "  •    " + "20K Views \n4 days ago"

        val channelProfileImageView = holder?.view?.imageView_profile
        Picasso.get().load(video.imageUrl).into(channelProfileImageView)

        val channelThumbNail = holder?.view?.imageView_channel_thumbnail
        Picasso.get().load(video.channel.profileImageUrl).into(channelThumbNail)

    }
}

// -> subclassing uma classe...
class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    init {
       view.setOnClickListener { //usar o segundo metodo onclicklistener
                      
           val intent = Intent(view.context, MainActivity::class.java)
           view.context.startActivity(intent)
       }
    }

}
