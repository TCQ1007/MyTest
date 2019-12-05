package com.example.myapplication000;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import android.app.Fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContentFragment extends Fragment {
    EnglishDatabaseHelper helper;
    SQLiteDatabase db;
    Cursor cursor = null;
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //目录ListVIew
        //在这里加上文章切割，以及每个列表给与一个锚点，用于点击章节时的切换内容
        //要解决的问题，读取本地文件并加载
        ListView listview = (ListView)getActivity().findViewById(R.id.chapter_listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String chapterName = adapterView.getItemAtPosition(position).toString();
                TextView article = (TextView)getActivity().findViewById(R.id.article);
                article.setText(load("test"));
                Toast.makeText(getActivity(),"You are reading the "+chapterName,Toast.LENGTH_SHORT).show();
            }
        });
        TextView scet4 = (TextView)getActivity().findViewById(R.id.select_cet4);
        scet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("cet4","数据库操作");
//
                helper = new EnglishDatabaseHelper(getActivity(),"english.db",null,1);
                db = helper.getWritableDatabase();
                String sql = "select * from cet4";
                cursor = db.rawQuery(sql,null);
                cursor.moveToFirst();
                String holo;
                String para;
                while(!cursor.isAfterLast()){
                    holo = cursor.getString(cursor.getColumnIndex("holo"));
                    para = cursor.getString(cursor.getColumnIndex("para"));
                    Log.d("cet4",holo+para);
                    cursor.moveToNext();
                }
            }
        });
    }


    public String load(String filename){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = getActivity().openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine())!= null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return content.toString();
    }
}
