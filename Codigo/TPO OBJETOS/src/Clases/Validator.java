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

    public static boolean isFloat(String importe){
        if (importe == null) return false;
        try {
            Float.parseFloat(importe);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isDateBeforeNow(Date date) {
        return date.before(new Date());
    }

    public static boolean isCuit(String cuit) {
        if (cuit.length() == 0 || cuit.length() > 11){ return false; }
        try{
            Long.parseLong(cuit);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
