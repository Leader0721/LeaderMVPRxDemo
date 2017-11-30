package com.example.pub.view.drowdownmenu;

/**
 * @Description:实体类
 * @Prject:
 * @Package: com.example.pub.view.drowdownmenu
 * @author: Leader
 * @date: 2017/11/22   9:20
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class TabEntity {

    private String name;
    private int type;
    private String typeStr = "";

    public TabEntity() {
    }

    public TabEntity(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }
}
