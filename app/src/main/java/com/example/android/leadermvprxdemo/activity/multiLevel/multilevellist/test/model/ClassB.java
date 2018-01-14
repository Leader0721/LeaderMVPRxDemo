package com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.model;


import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.lib.model.MultiLevelModel;

/**
 * Created by windows on 2017/12/28.
 */

public class ClassB extends MultiLevelModel {
   private int id;
   private String label;

   public ClassB(int id, String label) {
      this.id = id;
      this.label = label;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }
}
