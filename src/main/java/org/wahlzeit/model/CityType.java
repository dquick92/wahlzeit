package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Set;

/**
 * @brief
 * Defines the type of a city
 */
public class CityType extends DataObject{

    /**
     *Explanation:
     *the City Type shall be given wrt. to the cities country. For example:
     *A city with 700k inhabitants is a CITY (or METROPOLIS) in Germany, but a TOWN in China
     *
     */
    enum CitySize {
        METROPOLIS, CITY, TOWN, VILLAGE
    }

    /**
     * Explanation:
     * Describes the culture of this city. E.G. touristic, business, students city etc.
     * Example: Erlangen is a typical student city but Frankfurt is a business city. Berlin
     * is a student, business and touristic city
     * So a city can have more than one culture types
     */
    enum CityCulture {
        STUDENT_CITY, BUSINESS_CITY, TOURIST_CITY
    }

    private CityType supertype = null;
    private Set<CityType> subtypes = new HashSet<>();

    private final CitySize size;
    private final CityCulture culture;

    /**
     *
     *@methodtype constructor
     */
    public CityType(CitySize size, CityCulture culture){
        this.size = size;
        this.culture = culture;
    }

    /**
     *
     * @methodtype get
     */
    public CityType getSupertype(){
        return this.supertype;
    }

    /**
     *
     * @methodtype set
     */
    public void setSupertype(CityType supertype){
        assert supertype != null;
        this.supertype = supertype;
    }

    /**
     *
     * @methodtype factory
     */
    public void addSubtype(CityType sub){
        assert sub != null;

        if (sub.getSupertype() != null)
            sub.getSupertype().removeSubtype(sub);

        sub.setSupertype(this);
        subtypes.add(sub);

    }

    /**
     *
     * @methodtype factory
     */
    public void removeSubtype(CityType sub){
        subtypes.remove(sub);
    }

    /**
     *
     * @methodtype query
     */
    public boolean hasSubtype(CityType sub) {
        return subtypes.contains(sub);
    }

    /**
     *
     * @methodtype query
     */
    public boolean isSubtype(){
        return (this.supertype != null);
    }

    /**
     *
     * @methodtype query
     */
    public boolean hasInstance(City city){
        assert city != null;

        if (city.getCityType() == this)
            return true;

        for (CityType type : subtypes){
            if (type.hasInstance(city))
                    return true;
        }

        return false;
    }

    /**
     *
     * @methodtype command
     */
    public City createInstance(){
        return new City(this);
    }

}
