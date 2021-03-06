package com.example.administrator.music.Adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.music.R;
import com.example.administrator.music.db.Music;
import org.w3c.dom.Text;
import java.util.List;
/**
 * Created by Administrator on 2017/9/26.
 */
public class MusicAdapter extends ArrayAdapter<Music>
{
    private int resourceId;
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
        ViewHolder holder;
        if(convertView==null)
        {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            holder=new ViewHolder();
            holder.musicName=(TextView)view.findViewById(R.id.musicName);
            holder.musicPic=(ImageView)view.findViewById(R.id.musicIcon);
            view.setTag(holder);
        }
        else
        {
            view=convertView;
            holder=(ViewHolder)view.getTag();
        }
        holder.musicName.setText(music.getMusicName());
        holder.musicPic.setImageResource(music.getImageId());
        return view;
    }
    class ViewHolder
    {
        public ImageView musicPic;
        public TextView musicName;
    }
}