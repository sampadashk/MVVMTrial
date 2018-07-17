package com.example.unsan.mvvmeg;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        MyViewModel myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        if(myViewModel==null)
        {
            Log.d("heythere","I am null" );
        }
        myViewModel.getFruitList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> fruitlist) {
                ArrayAdapter<String> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,fruitlist);
                // Assign adapter to ListView
                listView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);


            }
        });


        // Assign adapter to ListView





    }
}
