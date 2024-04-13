package lesson_5.math;

public interface Shape {
    double calculateArea();
    String getFillColor();
    String getBorderColor();
    default double calculatePerimeter() {
        return 0.0; // Для базового интерфейса возвращаем 0.0
    }
}
