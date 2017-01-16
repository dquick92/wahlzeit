package org.wahlzeit.model;



import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.wahlzeit.model.City.buildCityID;
import static org.wahlzeit.utils.AssertNotNull.assertStringNotNull;

/**
 * Created by daniel on 16.01.17.
 */
public class CityManager extends ObjectManager {
    private static CityManager ourInstance = new CityManager();

    private static final Logger log = Logger.getLogger(PhotoManager.class.getName());
    public static CityManager getInstance() {
        return ourInstance;
    }

    private Map<String, City> cities = new HashMap<>();
    private Map<CityType, CityType> cityTypes = new HashMap<>();

    private CityManager() {
    }

    public void init(){
        loadCities();
    }

    private boolean doHasCityType(CityType cityType){
        return cityTypes.containsKey(cityType);
    }

    private void doAddCityType(CityType cityType){
        cityTypes.put(cityType, cityType);
    }

    public void loadCities(){

        Collection<City> existingCities = ObjectifyService.run(new Work<Collection<City>>() {
            @Override
            public Collection<City> run() {
                Collection<City> existingCities = new ArrayList<City>();
                readObjects(existingCities, City.class);
                return existingCities;
            }
        });

        for (City city : existingCities) {
            if (!doHasCity(city.toString())) {
                log.config(LogBuilder.createSystemMessage().
                        addParameter("Load City by name and state", city.toString()).toString());
                doAddCity(city);
            } else {
                log.config(LogBuilder.createSystemMessage().
                        addParameter("Already loaded City", city.toString()).toString());
            }
        }

        log.info(LogBuilder.createSystemMessage().addMessage("All photos loaded.").toString());
    }

    private boolean doHasCity(String cityID){
        return cities.containsKey(cityID);

    }

    private void doAddCity(City city){
        cities.put(city.toString(), city);
    }


    public City createCity(String cityName, String country, CityType.CitySize size, CityType.CityCulture culture) {
        assertStringNotNull(cityName, "CityManager createCity: String cityName");
        assertStringNotNull(country, "CityManager createCity: String country");
        synchronized(cities) {
            if (doHasCity(buildCityID(cityName, country))) {
                return cities.get(buildCityID(cityName, country));
            }
            CityType cityType = getCityType(size, culture);
            City ret = cityType.createInstance();
            ret.setCityName(cityName);
            ret.setCountry(country);

            doAddCity(ret);
            return ret;
        }
    }

    public CityType getCityType(CityType.CitySize size, CityType.CityCulture culture){

        CityType tmp = new CityType(size, culture);

        synchronized(cityTypes) {
        if (doHasCityType(tmp)){
            return cityTypes.get(tmp);
        }
            doAddCityType(tmp);
            return tmp;
        }
    }

}
