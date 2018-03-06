package org.rfteam.utils;

/**
 * Created by: Red Fraction
 * 10.02.2018
 */

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import jssc.SerialPort;
import jssc.SerialPortException;

public class Reader {

    //Объявление общего объекта для работы с COM-портом
    private SerialPort serialPort;

    public Reader(String port){
        new Reader(port, "CP866");
    }

    public Reader(String port, String charset){
        new Reader(port, charset, 9600, 1, 1, SerialPort.PARITY_EVEN);
    }

    public Reader(String port, String charset, int baudrate, int dataBits, int stopBits, int parity){

        //Объявление порта
        serialPort = new SerialPort(port);

        //Открытие порта
        open();

        //Установка параметров порта
        setup(baudrate, dataBits, stopBits, parity);
    }

    public String read(){

        return Utils.decode(getByte());
    }

    public byte[] getByte(){
        byte[] a = null;

        try {
            a = this.serialPort.readBytes(1);
            if(a != null && a.length != 0)
            return this.serialPort.readBytes(1);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Open COM-port
     * Открытие COM-порта
     */
    public void open(){

        //Открытие порта
        try {
            this.serialPort.openPort();
        } catch (SerialPortException e) {
            e.printStackTrace();
            //TODO: Логирование
        }
    }

    /**
     * Use to change baudrate & etc
     * Изменение параметров
     *
     * @param baudrate - baud rate // Частота
     * @param dataBits - data bits // Количество считываемых бит
     * @param stopBits - stop bits // Стоповые биты
     * @param parity - parity // Четность
     */
    public void setup(int baudrate, int dataBits, int stopBits, int parity){

        //Установка параметров порта
        try {
            this.serialPort.setParams(baudrate, dataBits, stopBits, parity);
        } catch (SerialPortException e) {
            e.printStackTrace();
            //TODO: Логирование
        }
    }

    /**
     * Сlose COM-port
     * Закрытие COM-порта
     */
    public void close(){
        //Открытие порта
        try {
            this.serialPort.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
            //TODO: Логирование
        }
    }

}