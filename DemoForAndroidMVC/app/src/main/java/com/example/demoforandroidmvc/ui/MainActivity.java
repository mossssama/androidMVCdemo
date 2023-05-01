package com.example.demoforandroidmvc.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.example.demoforandroidmvc.R;
import com.example.demoforandroidmvc.databinding.ActivityMainBinding;
import com.example.demoforandroidmvc.pojo.PlayerModel;

import java.util.ArrayList;

/* (1) MainActivity is controller C */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        /* (2) Activate onclickListeners for all buttons */
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
    }

    /* (3) Handling what happens onClick Listeners */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /* TextView is view V */
            case R.id.button1: binding.tv.setText(getFullInformation(0));       break;
            case R.id.button2: binding.tv.setText(getPlayerPosition(1));        break;
            case R.id.button3: binding.tv.setText(getPlayerDataOfBirth(1)+"");  break;
        }

    }

    /* (5) This function should return data from Source
        Source could be from { JavaObject - SharedPrefs - SQLite - Room - API }  Here the source is plain java object
     */
    public ArrayList<PlayerModel> getDataFromSource(){
        ArrayList<PlayerModel> data = new ArrayList();
        data.add(new PlayerModel("LeoMessi","PlayMaker",1987));
        data.add(new PlayerModel("Cristiano","Striker",1985));
        return data;
    }


    /* (6) Functions to handle the returned data */
    public String getFullInformation(int index){
        return "Name: "+getDataFromSource().get(index).getName()+", Position: "+getDataFromSource().get(index).getPosition()+", BirthYear: "+getDataFromSource().get(index).getYearOfBirth();
    }
    public String getPlayerPosition(int index){
        return getDataFromSource().get(index).getPosition();
    }
    public int getPlayerDataOfBirth(int index){
        return getDataFromSource().get(index).getYearOfBirth();
    }

}












// [1] let Controller implements View.OnClickListener to allow using single onClick to handle all ClickListeners
// [2] Active onClickListeners in onCreate of the Controller
// [3] State what will happens onClickListener
// [4] create modelClass for the data you want to be viewed in the views inside your controller
// [5] build a function inside the Controller to handle getting data from Source
// [6] build functions inside the Controller to handle using data returned