# androidMVCdemo
Demo for How to use MVC architecture pattern in android using Java language

[1] **Model** is the model class  
[2] **View** is the view that display data like editText,textView,listView   
[3] **Controller** is the UI controller like activity,fragment

**In this demo** Model is **PlayerModel**, View is **TextView**(tv), Controller is **MainActivity**
# **Usage**
***
[1] **Let Controller implements View.OnClickListener to allow using single onClick to handle all ClickListeners**

    implements View.OnClickListener
    
[2] **Activate onClickListeners in onCreate of the Controller**    

    binding.button1.setOnClickListener(this);
    binding.button2.setOnClickListener(this);
    binding.button3.setOnClickListener(this);
    
[3] **State what will happens onClickListener**

      @Override
      public void onClick(View v) {
          switch (v.getId()){
              /* TextView is view V */
              case R.id.button1: binding.tv.setText(getFullInformation(0));       break;
              case R.id.button2: binding.tv.setText(getPlayerPosition(1));        break;
              case R.id.button3: binding.tv.setText(getPlayerDataOfBirth(1)+"");  break;
          }

      }

[4] **Create [model class](https://github.com/mossssama/androidMVCdemo/blob/main/DemoForAndroidMVC/app/src/main/java/com/example/demoforandroidmvc/pojo/PlayerModel.java) representing the data scheme**
      
[5] **Build a function inside the Controller to handle getting data from Source**    

    /* (5) This function should return data from Source
        Source could be from { JavaObject - SharedPrefs - SQLite - Room - API }  Here the source is plain java object
     */
    public ArrayList<PlayerModel> getDataFromSource(){
        ArrayList<PlayerModel> data = new ArrayList();
        data.add(new PlayerModel("LeoMessi","PlayMaker",1987));
        data.add(new PlayerModel("Cristiano","Striker",1985));
        return data;
    }
    
    
[6] **Build functions inside the Controller to handle using data returned**
    
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
    
  
