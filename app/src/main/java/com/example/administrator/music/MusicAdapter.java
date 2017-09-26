package com.example.administrator.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.music.db.Music;
import java.util.List;
/**
 * Created by Administrator on 2017/9/26.
 */
public class MusicAdapter extends ArrayAdapter<Music>
{
    private int resourceId;
    private ViewHolder holder=null;
    public MusicAdapter(Context context, int ResourceId, List<Music> musicList)
    {
            super(context,ResourceId,musicList);
            resourceId=ResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Music music=getItem(position);
        View view;
        if(holder==null)
        {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            holder=new ViewHolder(view);
        }
        else  view=convertView;
        holder.musicPic.setImageResource(music.getImageId());
        holder.musicName.setText(music.getMusicName());
        return view;
    }
    class ViewHolder
    {
        public ImageView musicPic;
        public TextView musicName;
        public ViewHolder(View v)
        {
            musicPic=(ImageView)v.findViewById(R.id.musicIcon);
            musicName=(TextView)v.findViewById(R.id.musicName);
        }
    }
}
