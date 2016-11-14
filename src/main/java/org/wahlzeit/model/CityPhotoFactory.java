package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class CityPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(CityPhotoFactory.class.getName());
    private static CityPhotoFactory instance = null;

    public static void initialize() {
        getInstance();
    }

    ;

    public static synchronized CityPhotoFactory getInstance() {
        if (instance == null) {

            log.config(LogBuilder.createSystemMessage().addAction("setting generic CityPhotoFactory").toString());
            setInstance(new CityPhotoFactory());
        }

        return instance;
    }

    protected static synchronized void setInstance(CityPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize CityPhotoFactory twice");
        }

        instance = photoFactory;
    }

    @Override
    public Photo createPhoto() {
        return new CityPhoto();
    }

    @Override
    public Photo createPhoto(PhotoId id) {
        return new CityPhoto(id);
    }

}

