package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public class DaoFactory {
    private static Ads adsDao;
    private static User userDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

//    public static User getUserDao() {
//        if (userDao == null) {
//            userDao = new User(config);
//        }
//        return userDao;
//    }
}
