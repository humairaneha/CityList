package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This creates a new city and then adds it to the list.
 */
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * This creates a new city
     * @return the city that is created
     */
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**This test method check if adding city to the list works propelry
     *
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities("city").size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities("city").size());
        assertTrue(cityList.getCities("city").contains(city));
    }
    /**This test method check if deleting city from the list works propelry.
     *
     */
    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities("city").size());
        City city = new City("Regina", "SK");
        cityList.add(city);
        assertEquals(2, cityList.getCities("city").size());
        cityList.delete(city);
        assertEquals(1, cityList.getCities("city").size());
        assertTrue(!cityList.getCities("city").contains(city));
    }
    /**This test method check if any exception occurs while adding city to the list.
     *
     */
    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    /**This test method check if any exception occurs while deleting city from the list.
     *
     */
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
    /**This test method check if counting citites works properly.
     *
     */
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        assertEquals(1, cityList.testCount());
        City city1 = new City("Regina", "SK");
        cityList.add(city1);
        assertEquals(2, cityList.testCount());
    }
    /**This test method check if sorting citites by city name works properly.
     *
     */
    @Test
    public void testGetCitiesByCity() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities("city").get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities("city").get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities("city").get(1)));
    }
    /**This test method check if sorting citites by province name works properly.
     *
     */
    @Test
    public void testGetCitiesByProvince() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities("province").get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities("province").get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities("province").get(0)));
    }
}
