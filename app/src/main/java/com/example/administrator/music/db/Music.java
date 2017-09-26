package com.example.administrator.music.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/9/26.
 */

public class Music extends DataSupport
{
    private int id;
    private String musicName;
    private String words;
    public void setId(int id) {
        this.id = id;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getWords() {
        return words;
    }

}
