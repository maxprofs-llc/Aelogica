package com.aelogica.signalvine.mytask.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 24/08/2016.
 */

public class DateHelper {

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date()).toLowerCase() + 'z';
    }
}
