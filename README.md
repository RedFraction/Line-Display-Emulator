# Line-Display-Emulator / Эмулятор дисплея покупателя
EN: Line display emulator for 1C:Enterprise 8.3 : Retail 2.2 .
RU: Эмулятор дисплея покупателя для 1С:Предприятия 8.3 : Розница 2.2

### This project using: / Для проекта потребуется
EN:

- [jSSC](https://github.com/scream3r/java-simple-serial-connector) - Java Simple Serial Connector, to listen COM-port.
- [com0com](http://com0com.sourceforge.net/) - Null-modem emulator - For redirect data from 1C:Enterprise
RU: 

- [jSSC](https://github.com/scream3r/java-simple-serial-connector) - Библиотека для считывания данных с последовательно порта.
- [com0com](http://com0com.sourceforge.net/) - Null-modem emulator - Для перенаправления данных из 1С на сторону Java.

## Install / Установка
EN:
1. Install com0com, and add new pair, using "add pair" button.
2. Add new "Customer Display"(Дисплей покупателя). Configure it to first of created port in com0com.
3. Connect lib in your IDE, set - port(second created port), speed, stop bit, parity like in 1C:Enterprise, than just compile it and run.

Oh yeah, it works.

RU: 
1. Установите com0com, и создайте новую пару используя - "add pair".
2. Добавьте новый "Дисплей покупателя" и настройте на первый из созданных в com0com портов.
3. Подключите библиотеку в вашу IDE, установите - порт(второй созданый порт), скорость, стоп бит, четность как в 1С:Предприятии, скопилируйте и запускайте.

О дааа, оно работает.

## P.S.
I wish it could help you.

Я надеюсь это вам поможет.
