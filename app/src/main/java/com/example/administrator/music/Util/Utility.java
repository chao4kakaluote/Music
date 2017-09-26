package com.example.administrator.music.Util;

import android.os.Environment;
import android.util.Log;

import com.example.administrator.music.R;
import com.example.administrator.music.db.Music;
import java.io.File;
/**
 * Created by Administrator on 2017/9/26.
 */
public class Utility
{
    public static String localMusicPath= Environment.getExternalStorageDirectory()+"/music";
    public static boolean initMusicList()
    {
        try
        {
            String musicPath= localMusicPath.toString();
            File mfile=new File(musicPath);
            File[] files=mfile.listFiles();
            for(int i=0;i<files.length;i++)
            {
                if(checkIsMusicFile(files[i].getPath())) {
                    Music music=new Music();
                    music.setMusicName(files[i].getName());
                    music.save();
                }
            }
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkIsMusicFile(String fName) {
        boolean isMusicFile = false;
        // 获取扩展名
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("mp3") || FileEnd.equals("mp4")
                || FileEnd.equals("wmv") ) {
            isMusicFile = true;
        } else
        {
            isMusicFile = false;
        }
        return isMusicFile;
    }
}
