/**
 * ValidatorUtils.java
 * 
 * @screen core
 * @author ma_b
 */
package com.msk.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.msk.core.consts.NumberConst.IntDef;

/**
 * The utils for validator.
 */
public final class ValidatorUtils {
    /** The regex for mail */
    private static String MAIL_REGEX = "^([a-z0-9A-Z]+[-_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /** The regex for number */
    private static String NUMBER_REGEX = "^(0|[1-9][0-9]*)$";
    /** The regex for decimal */
    private static String DECIMAL_REGEX = "([1-9]+[0-9]*|0)(\\.[\\d]+)?";
    /** The regex for phone */
    private static String PHONE_REGEX = "^(\\+[0-9]+|[0-9]+)([0-9]|-)+[0-9]$";

    /**
     * Check the mail address.
     * 
     * @param mail mail address
     * @return check result (true is check ok)
     */
    public static boolean checkMail(String mail) {
        return RegexUtils.checkRegex(MAIL_REGEX, mail);
    }

    /**
     * Check is this a number.
     * 
     * @param num check target
     * @return check result (true is check ok)
     */
    public static boolean checkNumber(String num) {
        return RegexUtils.checkRegex(NUMBER_REGEX, num);
    }

    /**
     * Check is this a decimal.
     * 
     * @param value check target
     * @return check result (true is check ok)
     */
    public static boolean checkDecimal(String value) {
        return RegexUtils.checkRegex(DECIMAL_REGEX, value);
    }

    /**
     * Check is this a phone number.
     * 
     * @param value check target
     * @return check result (true is check ok)
     */
    public static boolean checkPhone(String value) {
        return RegexUtils.checkRegex(PHONE_REGEX, value);
    }

    /**
     * Check is this a date with format.
     * 
     * @param value check target
     * @param format date format
     * @return check result (true is check ok)
     */
    public static boolean checkDateStr(String value, String format) {

        SimpleDateFormat formatter = new SimpleDateFormat(format);

        formatter.setLenient(false);

        try {

            formatter.format(formatter.parse(value));
        } catch (Exception e) {

            return false;
        }
        return true;
    }

    /**
     * Check is this a date with year and month and day.
     * 
     * @param year year
     * @param month month
     * @param day day
     * @return check result (true is check ok)
     */
    public static boolean isLegalDate(int year, int month, int day) {

        String monthStr = Integer.toString(month);
        String dayStr = Integer.toString(day);
        if (month < IntDef.INT_TEN) {
            monthStr = "0" + monthStr;
        }
        if (day < IntDef.INT_TEN) {
            dayStr = "0" + dayStr;
        }
        String dtStr = year + "-" + monthStr + "-" + dayStr;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(dtStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String result = sdf.format(d);
        // check the value before convert and the value after converted
        return result.equals(dtStr);
    }
}
