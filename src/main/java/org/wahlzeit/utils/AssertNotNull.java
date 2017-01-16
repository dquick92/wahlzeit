package org.wahlzeit.utils;

/**
 * Created by daniel on 16.01.17.
 */
public class AssertNotNull {

    public static void assertStringNotNull(String strToTest, String arg){
        if (strToTest == null)
            throw new IllegalArgumentException("The argument "+ arg + " must not be null!");
    }
}
