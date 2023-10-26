package task1;

// Напишите метод, который убирает из списка целых чисел все дубликаты.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        // Создаем множество (HashSet), чтобы хранить уникальные значения
        HashSet<Integer> uniqueSet = new HashSet<>(list);

        // Создаем новый список и добавляем уникальные значения
        List<Integer> result = new ArrayList<>(uniqueSet);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("Исходный список: " + numbers);
        System.out.println("Список без дубликатов: " + uniqueNumbers);
    }
}
