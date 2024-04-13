package org.example;

import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;


    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public void save(String FaleName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FaleName))) {
            // Запись хедера
            writer.write(String.join(";", header)+ "\n");
            for (int[] dataRow : data) {
                writer.write(String.join(";", convertArrayIntToStringArray(dataRow))+ "\n" );
            }
            System.out.println("Все ок.");
        } catch (IOException e) {}
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String headerLine = reader.readLine();
            if (headerLine != null) {
                header = headerLine.split(";");
            }

            long numRows = reader.lines().count();
            data = new int[(int) numRows][header.length];

            try (BufferedReader dataReader = new BufferedReader(new FileReader(fileName))) {
                dataReader.readLine(); // Пропускаем заголовок

                int row = 0;
                String line;
                while ((line = dataReader.readLine()) != null) {
                    String[] values = line.split(";");
                    for (int i = 0; i < values.length; i++) {
                        data[row][i] = Integer.parseInt(values[i]);
                    }
                    row++;
                }

                System.out.println("Все ок.");
            } catch (IOException e) {
                System.err.println("Ошибка при чтении данных из CSV файла: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при открытии CSV файла: " + e.getMessage());
        }
    }
    private String[] convertArrayIntToStringArray(int[] intArray) {
        String[] stringArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            stringArray[i] = String.valueOf(intArray[i]);
        }
        return stringArray;
    }
}





