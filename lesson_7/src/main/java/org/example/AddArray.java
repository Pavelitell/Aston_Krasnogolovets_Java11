package org.example;

import org.example.exeptions.MyArrayDataException;
import org.example.exeptions.MyArraySizeException;

public class AddArray  {
    public static int stringArrayIntSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (array.length > 4){
          throw new MyArraySizeException("Размер кол-ва строк больше нужного");
         } else if (array.length < 4){
            throw new MyArraySizeException("Размер кол-ва строк меньше нужного");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length > 4){
                throw new MyArraySizeException("Размер кол-ва столбцов больше нужного");
            } else if (array[i].length < 4) {
               throw new MyArraySizeException("Размер  кол-ва столбцов  нужного ");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count += Integer.parseInt(array[i][j]);

                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Неправильная дата (В строке "+i+"и в столбце "+j+")");
                }
            }
        }
        return count ;
    }

}
