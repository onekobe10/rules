package com.gankki.demo.portal.rules.util;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Tool class string handling
 * Time Wed Jan 15 15:27:13 CST 2014
 *
 * @author jinhengbin
 */
public class StringUtils {
    /**
     * Returns true if length() is 0 ,this str is null,this str is "",this str is "null" or this str is "NULL" .
     *
     * @param str a string
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().equalsIgnoreCase("null") || str.trim().equals("");
    }

    public static boolean isEmpty(Object objStr) {
        return ((objStr == null) || (objStr.toString().length() <= 0)) || isEmpty(objStr.toString());
    }

    public static boolean isEmpty(byte[] b) {
        return b == null || b.length < 1 || StringUtils.isEmpty(new String(b));
    }

    /**
     * Filter out  null string; If the str is null,"" ,"null" or "NULL" ,then return "". Otherwise return themselves.
     *
     * @param str source string
     * @return ""
     */
    public static String notNull(String str) {
        if (str == null || str.trim().equals("") || str.equalsIgnoreCase("null"))
            return "";
        return str;
    }

    /**
     * Returns the index within this array of the first occurrence of the specified string.
     * If a string with value str occurs in the string array , then the index (in Unicode code units) of the first such occurrence is returned.
     * In either case, if no such string occurs in this array, then -1 is returned.
     *
     * @param strs a array
     * @param str  a string
     * @return int  the index
     */
    public static int indexOfStringArray(String str, String[] strs) {
        if (str == null) {
            return -1;
        }
        for (int index = 0; index < strs.length; index++) {
            if (str.equals(strs[index])) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Return the count that  the substring appears in the  parentstring
     *
     * @param parentstring
     * @param substring
     * @return appears count
     */
    public static int appearCount(String parentstring, String substring) {
        if (parentstring.indexOf(substring) == -1) {
            return 0;
        } else {
            // "abac"会被截成3段，"abaca"也是3段
            if (parentstring.endsWith(substring))
                return parentstring.split(substring).length;
            else
                return parentstring.split(substring).length - 1;
        }
    }

    /**
     * Return the array from the splited str  by  the separator.The  array's max length is the count;
     *
     * @param str
     * @param separator
     * @param count     the max length of array
     * @return List
     */
    public static List<String> split(String str, String separator, int count) {
        List<String> list = new ArrayList<String>();
        if (str.indexOf(separator) == -1) {
            list.add(str);
            return list;
        }
        String[] array = str.split(separator);
        if (array.length > count) {
            for (int i = 0; i < count; i++) {
                list.add(array[i]);
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
        }
        return list;
    }

    /**
     * Return a array that split the  str by  the separator;
     *
     * @param str
     * @param separator
     * @return List<String>
     */
    public static List<String> split(String str, String separator) {
        List<String> list = new ArrayList<String>();
        if (str.indexOf(separator) == -1) {
            list.add(str);
            return list;
        }
        String[] array = str.split(separator);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    /**
     * Return a substring  that strLeft matchs strRight start with left. If none,then null;
     *
     * @param strLeft  the left string
     * @param strRight the right string
     * @return The  matched substring ;
     */
    public static String regionMatch(String strLeft, String strRight) {
        if ((strLeft == null) || (strRight == null))
            return null;
        char[] chLefts = strLeft.toCharArray();
        char[] chRights = strRight.toCharArray();
        int len = (chLefts.length < chRights.length) ? chLefts.length
                : chRights.length;
        int i = 0;
        for (; i < len; ++i)
            if (chLefts[i] != chRights[i])
                break;

        if (i == 0)
            return null;
        return strLeft.substring(0, i);
    }

    /**
     * Convert string to number.
     *
     * @param aValueString source string
     * @param aDataType    the data type  convert to;
     * @param pattern      the pattern of number. No pattern ,give a null.
     * @return Object
     * @throws Exception
     */
    private static Object convertStringToNumber(String aValueString,
                                                int aDataType, String pattern) throws Exception {
        if (aValueString == null)
            return null;

        String tmp = null;
        if ((pattern == null) || (pattern.trim().equals("")))
            tmp = aValueString;
        else
            try {
                DecimalFormat formatter = new DecimalFormat(pattern);
                Number number = formatter.parse(aValueString);
                tmp = number.toString();
            } catch (Exception e) {
                tmp = aValueString;
            }

        switch (aDataType) {
            case Types.DOUBLE: // 8
                return new Double(tmp);
            case Types.FLOAT: // 6
                return new Float(tmp);
            case Types.INTEGER: // 4
                return new Integer(tmp);
            case 0:
                return null;
            case 2:
                return new BigDecimal(tmp);
            case 3:
                return new BigDecimal(tmp);
            case -5:
                return new Long(tmp);
            case 5:
                return new Integer(tmp);
            case -4:
            case -3:
            case -2:
            case -1:
            case 1:
            case 7:
        }
        String mes = "The type of convertNumberToString is invalidate : "
                + aDataType + "[str = " + aValueString + "]";
        mes = mes + "[pattern = " + pattern + "]";
        throw new Exception(mes);
    }

    private static Object convertStringToNumber(String aValueString, int aDataType) {
        try {
            return (Integer) convertStringToNumber(aValueString, aDataType, "");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Convert String to  int. The characters in the string must all be decimal digits,
     * except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value.
     * If error,this method will not disturb you but prints the error message.
     *
     * @param aValueString
     * @return int
     */
    public static int convertStringToInteger(String aValueString) {
        return (Integer) convertStringToNumber(aValueString, Types.INTEGER);
    }

    /**
     * Convert String to double.Returns a new double initialized to the value represented by the specified String,
     * as performed by the valueOf method of class Double.
     * If error,this method will not disturb you but prints the error message.
     *
     * @param aValueString
     * @return double
     */
    public static double convertStringToDouble(String aValueString) {
        return (Double) convertStringToNumber(aValueString, Types.DOUBLE);
    }

    /**
     * Convert String to float.Returns a new float initialized to the value represented by the specified String,
     * as performed by the valueOf method of class float.
     * If error,this method will not disturb you but prints the error message.
     *
     * @param aValueString
     * @return
     */
    public static float convertStringToFloat(String aValueString) {
        return (Float) convertStringToNumber(aValueString, Types.FLOAT);
    }

    /**
     * Convert String to BigDecimal. Returns a new BigDecimal initialized to the value represented by the specified String,
     * as performed by the valueOf method of class BigDecimal.
     * If error,this method will not disturb you but prints the error message.
     *
     * @param aValueString
     * @return BigDecimal
     */
    public static BigDecimal convertStringToBigDecimal(String aValueString) {
        return (BigDecimal) convertStringToNumber(aValueString, 2);
    }

    /**
     * Convert String to long. Returns a new long initialized to the value represented by the specified String,
     * as performed by the valueOf method of class long.
     * If error,this method will not disturb you but prints the error message.
     *
     * @param aValueString
     * @return
     */
    public static long convertStringToLong(String aValueString) {
        return (Long) convertStringToNumber(aValueString, -5);
    }

    /**
     * Convert one char of a string to uppercase. Returns a new string has changed the char value of this string to up case at the specified index. An index ranges from 0 to length() - 1.
     * The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
     *
     * @param str   The String is to change
     * @param index The index to the char values
     * @return String The String has changed
     */
    public static String changeCaseUp(String str, int index) {
        if (str == null) {
            return null;
        }
        if (str.length() < index + 1) {
            return null;
        }
        String s = String.valueOf((str.charAt(index))).toUpperCase();
        StringBuffer sb = new StringBuffer(str);
        sb.replace(index, index + 1, s);
        return sb.toString();
    }

    /**
     * Convert a substring of string to uppercase.  Returns a new string has changed  chars' value of this string to up case in  specified indexs.
     *
     * @param str        The String is to change
     * @param beginIndex start index
     * @param endIndex   end index
     * @return String The new String has changed
     */

    public static String changeCaseUp(String str, int beginIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        if (str.length() < endIndex + 1) {
            return null;
        }

        String s = str.substring(beginIndex, endIndex).toUpperCase();
        StringBuffer sb = new StringBuffer(str);
        sb.replace(beginIndex, endIndex, s);
        return sb.toString();
    }

    /**
     * Convert one char of a string to lowercase.  Returns a new string has changed the char value of this string to lower case at the specified index. An index ranges from 0 to length() - 1.
     * The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
     *
     * @param str   The String is to change
     * @param index The index to the char values
     * @return String The String has changed
     */
    public static String changeCaseLower(String str, int index) {
        if (str == null) {
            return null;
        }
        if (str.length() < index + 1) {
            return null;
        }
        String s = String.valueOf((str.charAt(index))).toLowerCase();
        StringBuffer sb = new StringBuffer(str);
        sb.replace(index, index + 1, s);
        return sb.toString();
    }

    /**
     * Convert a substring of string to lowercase.  Returns a new string has changed  chars' value of this string to lower case in  specified indexs.
     *
     * @param str        The String is to change
     * @param beginIndex start index
     * @param endIndex   end index
     * @return String The new String has changed
     */
    public static String changeCaseLower(String str, int beginIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        if (str.length() < endIndex + 1) {
            return null;
        }

        String s = str.substring(beginIndex, endIndex).toLowerCase();
        StringBuffer sb = new StringBuffer(str);
        sb.replace(beginIndex, endIndex, s);
        return sb.toString();
    }

    public static Integer notNullZero(String str) {
        if (str == null || str.trim().equals("") || str.equalsIgnoreCase("null"))
            return 0;
        return Integer.parseInt(str);
    }

    public static String nullToZero(Object str) {
        if (StringUtils.isEmpty(str + ""))
            return "0";
        return str.toString();
    }

    public static String nullToString(Object str) {

        try {
            if (StringUtils.isEmpty(str + "")) {
                return "";
            } else {
                return str.toString();
            }

        } catch (Exception e) {
            return "";
        }

    }
}
