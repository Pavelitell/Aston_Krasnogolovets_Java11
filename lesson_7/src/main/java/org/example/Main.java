package org.example;

import org.example.exeptions.MyArrayDataException;
import org.example.exeptions.MyArraySizeException;

import static org.example.AddArray.stringArrayIntSum;

public class Main {
    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "3"},
                {"2", "2", "2", "3"},
                {"1", "2", "2", "2"},
                {"2", "2", "2", "2"}
        };
        try {
            int result = stringArrayIntSum(array);
            System.out.println("Сумма массива: "+result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

