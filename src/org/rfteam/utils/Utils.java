package org.rfteam.utils;

/**
 * Created by: Red Fraction
 * 10.02.2018
 */

import jssc.SerialPortList;

import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Utils {

    /**
     * Decode byte[] buffer from CP866 to text(UTF-8) as String
     * Декодирование массива байт из CP866 в UTF-8 как String
     * @param buffer @NotNull
     * @return Decoded String // Декодированная строка(String)
     */
    public static String decode(@NotNull byte[] buffer){
        return decode(buffer, "CP866");
    }

    /**
     * Decode byte buffer from entered Charset to text as String
     * Декодирование массива байт из введенной кодировки в UTF-8 как String
     * @param buffer - byte[]
     * @param charset - Charset as default use CP866, CP1251
     * @return Decoded String // Декодированная строка(String)
     */
    public static String decode(@NotNull byte[] buffer,@NotNull String charset){
        //Возврат строки с переводом в заданую в @charset кодировку
        try {
            return new String(buffer, "CP866");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Decode byte buffer from entered Charset to text as String
     * Декодирование массива байт из введенной кодировки в UTF-8 как String
     * @param charset encoding // кодировка
     * @return Decoded String // Декодированная строка(String)
     */

    public static String decode(@NotNull byte[] buffer,@NotNull String charset){

        char[] a = new char[buffer.length];
        String output = "";
        for(int i = 0; i < buffer.length; i++){
            a[i] = (char) buffer[i];
        }
        try {
            output = output + new String(Arrays.toString(a).getBytes(), charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * SOUT all enabled and not hidden COM-ports
     * Вывод всех имеющихся и не скрытых COM-портов
     */
    public static void portListSOUT(){
        //Получение списка портов
        String[] list = SerialPortList.getPortNames();
        //Строка для отделения
        System.out.println("===Port=List===");
        //Вывод списка портов построчно
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
        //Строка для отделения
        System.out.println("===============");
    }

    /**
     * Return all enabled and not hidden COM-ports
     * Вывод всех имеющихся и не скрытых COM-портов
     */
    public static String[] portList(){
        //Получение списка портов
        return SerialPortList.getPortNames();
    }
}