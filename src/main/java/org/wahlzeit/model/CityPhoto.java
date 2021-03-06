package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.utils.PatternInstance;


@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"ConcreteProduct"}
)
@Subclass
public class CityPhoto extends Photo {



    private City city;

    /**
     *
     *@methodtype constructor
     */
    public CityPhoto(){
        super();
    }

    /**
     *
     *@methodtype constructor
     */
    public CityPhoto(PhotoId myId) {
        super(myId);
    }

    /**
     *
     * @methodtype set
     */
    public void setCity ( City city){
        if (city == null)
            throw new NullPointerException();
        this.city = city;
    }

    /**
     *
     * @methodtype get
     */
    public City getCity() {
        return city;
    }

}
