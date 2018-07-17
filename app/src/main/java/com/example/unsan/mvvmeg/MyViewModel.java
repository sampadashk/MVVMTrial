package com.example.unsan.mvvmeg;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyViewModel extends ViewModel {
    private String TAG = MyViewModel.class.getSimpleName();
    private MutableLiveData<List<String>> fruitList;

    public MutableLiveData<List<String>> getFruitList() {
        if(fruitList==null)
        {
            fruitList = new MutableLiveData<>();
            loadFruitList();
        }
        return fruitList;
    }

    private void loadFruitList() {
        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> fruitsStringList = new ArrayList<>();
                fruitsStringList.add("Mango");
                fruitsStringList.add("Apple");
                fruitsStringList.add("Orange");
                fruitsStringList.add("Banana");
                fruitsStringList.add("Grapes");
                long seed = System.nanoTime();
                Collections.shuffle(fruitsStringList, new Random(seed));

                fruitList.setValue(fruitsStringList);
            }


        } , 5000);

    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }
}
