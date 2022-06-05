package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the list if that city does exit
     * @param city
     *       This is the city to delete
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * This method counts the cities in the list
     * @return the size of the list
     */
    public int testCount(){
        return cities.size();
    }

    /**
     * This returns a sorted list of cities by city name and province
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(String param) {
        List<City> cityList = cities;
        if(param == "city")
        {Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City city, City t1) {
                return city.getCityName().compareTo(t1.getCityName());
            }
        });}
        if(param=="province")
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

}
