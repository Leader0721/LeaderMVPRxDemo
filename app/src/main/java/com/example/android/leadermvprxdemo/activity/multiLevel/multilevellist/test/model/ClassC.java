package com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.model;


import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.lib.model.MultiLevelModel;

/**
 * Created by windows on 2017/12/28.
 */

public class ClassC extends MultiLevelModel {
   private String name;

   public ClassC(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
