package org.example;

import java.io.*;
import java.util.Arrays;

/*
Реализовать сохранение данных в csv файл;
2.
Реализовать загрузку данных из csv файла. Файл читается целиком.

Структура csv файла:
Строка заголовок с набором столбцовx`
Набор строк с целочисленными значениями
Разделитель между столбцами - символ точка с запятой (;)
(Пример: смотреть прикреплённый файл)

Для хранения данных использовать класс вида:
public class AppData {
   private String[] header;
   private int[][] data;
   // ...
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 */
public class Main {
    public static void main(String[] args) {


        // Создаем экземпляр класса AppData
        AppData appData = new AppData();

        // Задаем заголовок и данные
        appData.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        appData.setData(new int[][]{{100, 200, 123}, {300, 400, 500}});

        // Сохраняем данные в CSV файл
        appData.save("data.csv");

        // Загружаем данные из CSV файла
        appData.load("data.csv");
    }
    }

