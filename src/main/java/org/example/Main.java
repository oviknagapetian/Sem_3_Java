package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем пустой список целых чисел
        List<Integer> numbers = new ArrayList<>();

        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод чисел и добавляем их в список,
        // пока пользователь не введет "done"
        System.out.println("Введите список целых чисел (для завершения введите 'done'): ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число или 'done'");
            }
        }

        // Задание 1: Удалить четные числа из списка
        List<Integer> oddNumbers = removeEvenNumbers(numbers);

        // Задание 2: Найти минимальное значение
        int minValue = findMinValue(oddNumbers);

        // Задание 3: Найти максимальное значение
        int maxValue = findMaxValue(oddNumbers);

        // Задание 4: Найти среднее значение
        double averageValue = findAverageValue(oddNumbers);

        // Вывод результатов
        System.out.println("Исходный список: " + numbers);
        System.out.println("Список без четных чисел: " + oddNumbers);
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Среднее значение: " + averageValue);
    }

    // Метод для удаления четных чисел из списка
    private static List<Integer> removeEvenNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 != 0) {
                oddNumbers.add(num);
            }
        }
        return oddNumbers;
    }

    // Метод для нахождения минимального значения
    private static int findMinValue(List<Integer> numbers) {
        int minValue = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    // Метод для нахождения максимального значения
    private static int findMaxValue(List<Integer> numbers) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }

    // Метод для нахождения среднего значения
    private static double findAverageValue(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }
}
