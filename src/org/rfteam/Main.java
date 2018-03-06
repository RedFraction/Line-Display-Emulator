package org.rfteam;

import jssc.SerialPort;
import jssc.SerialPortException;
import org.rfteam.utils.Reader;
import org.rfteam.utils.Utils;

/**
 * Created by: Red Fraction
 * 10.02.2018
 */

public class Main {

    public static void main(String[] args){
        SerialPort sp = new SerialPort("CNCB0");
        try {
            boolean breaker = false;
            sp.openPort();
            sp.setParams(9600, 8, 1,2);
            while (!breaker) {
                byte[] a =(sp.readBytes(1));

                System.out.println(a[0] + " <=> " + Utils.decode(a));
            }

            sp.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}