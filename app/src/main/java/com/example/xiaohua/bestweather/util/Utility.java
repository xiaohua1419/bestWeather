package com.example.xiaohua.bestweather.util;

import android.text.TextUtils;

import com.example.xiaohua.bestweather.db.bestWeatherDB;
import com.example.xiaohua.bestweather.model.City;
import com.example.xiaohua.bestweather.model.County;
import com.example.xiaohua.bestweather.model.Province;

/**
 * Created by xiaohua on 2016/11/8.
 */

public class Utility {

    public synchronized static boolean handleProvinceResponse(bestWeatherDB bestWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    bestWeatherDB.saveProvince(province);
                }
                return true;
            }
        }

        return false;
    }

    public static boolean handleCitiesResponse(bestWeatherDB bestWeatherDB,
                                               String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
// 将解析出来的数据存储到City表
                    bestWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCountiesResponse(bestWeatherDB bestWeatherDB,
                                                 String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
// 将解析出来的数据存储到County表
                    bestWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }


    public synchronized static boolean handleProvincesResponse(bestWeatherDB bestWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
// 将解析出来的数据存储到Province表
                    bestWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }


}
