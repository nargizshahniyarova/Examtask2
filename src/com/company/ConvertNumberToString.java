//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public class ConvertNumberToString {
    public ConvertNumberToString() {
    }

    private static String currName(String cur) {
        if ( !cur.equals("AZN")) {
            if (cur.equals("USD")) {
                return "ABŞ dolları";
            } else if (cur.equals("EUR")) {
                return "avro";
            } else {
                return cur.equals("GBP") ? "funt sterlingi" : "";
            }
        } else {
            return "manat";
        }
    }

    private static String currencyPart(String cur) {
        if (!cur.equals("AZN")) {
            if (cur.equals("USD")) {
                return "sent";
            } else if (cur.equals("EUR")) {
                return "sent";
            } else {
                return cur.equals("GBP") ? "pens" : "";
            }
        } else {
            return "qəpik";
        }
    }

    public static String convertToWritingAmount(Double amount, String cur) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String[][] lWord = new String[][]{{"", "bir", "iki", "üç", "dörd", "beş", "altı", "yeddi", "səkkiz", "doqquz"}, {"", "on", "iyirmi", "otuz", "qırx", "əlli", "altmış", "yetmiş", "səksən", "doxsan"}, {"", "min", "million", "milliard", "trillion"}};
       // int size = true;
        BigDecimal[] amnt = new BigDecimal[2];
        String strWriting = "";
        int dec = 0;
        int other = 0;
        if (amount.equals(0)) {
            return "0.00";
        } else {
            BigDecimal tmpAmount = BigDecimal.valueOf(amount);
            amnt = tmpAmount.divideAndRemainder(new BigDecimal(1));
            long intPart = amnt[0].longValue();
            long fractPart = amnt[1].multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).longValue();

            for(strWriting = currName(cur) + " " + fractPart + " " + currencyPart(cur); intPart != 0L; intPart /= 10L) {
                int dig = (new Long(intPart % 10L)).intValue();
                if (dec > 2) {
                    dec = 0;
                }

                if (dec == 2) {
                    ++other;
                    if (dig == 1) {
                        strWriting = lWord[0][dig] + " yüz " + strWriting;
                    } else if (dig == 0) {
                        strWriting = " " + strWriting;
                    } else {
                        strWriting = lWord[0][dig] + " yüz " + strWriting;
                    }
                } else if (dec == 0) {
                    strWriting = lWord[dec][dig] + " " + lWord[2][other] + " " + strWriting;
                } else {
                    strWriting = lWord[dec][dig] + " " + strWriting;
                }

                ++dec;
            }

            return strWriting;
        }
    }
}
