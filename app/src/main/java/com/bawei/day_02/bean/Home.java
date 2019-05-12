package com.bawei.day_02.bean;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class Home {
    public String message;
    public String status;
    public Result result;

    public static class Result {
        public Life rxxp;
        public Life pzsh;
    }

    public static class Life {

        public int id;
        public String name;
        public List<ShopInfo> commodityList;
    }

    public static class ShopInfo {
        public String commodityName;
        public String masterPic;
    }
}
