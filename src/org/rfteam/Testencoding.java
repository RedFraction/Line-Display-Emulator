package org.rfteam;

/**
 * Created by: Red Fraction
 * 11.02.2018
 */

import org.rfteam.utils.Utils;

public class Testencoding {

    public static void main(String ... args){
        byte[] a = new byte[1];
        for(int i = -128; i < 129; i++){

            a[0] = (byte) i;

            System.out.println((byte) i + "<=>" + Utils.decode(a));
        }
    }
}
