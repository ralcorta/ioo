package Clases;

import Enums.CommonFormatsDefine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static boolean isDate(String dateString) {
        SimpleDateFormat sdfrmt = new SimpleDateFormat(CommonFormatsDefine.FULL_DATE);
        sdfrmt.setLenient(false);
        try {
            sdfrmt.parse(dateString);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}