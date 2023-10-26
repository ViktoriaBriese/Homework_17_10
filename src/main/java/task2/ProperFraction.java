package task2;

// Создайте класс правильной дроби (например, 1/2, 7/8 и т.д.).
// Числитель и знаменатель будут храниться в отдельных полях типа int.
// Самостоятельно (без генерации в IDE) реализуйте методы equals и hashCode для класса.
// Причём дроби с одинаковым результатом необходимо считать эквивалентными,
// т.е. 1/2 эквивалентна 2/4, эквивалентна 5/10 и т.д.

import java.util.Objects;

public class ProperFraction {
    private int numerator;   // числитель
    private int denominator; // знаменатель

    public ProperFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }

        // Приведение к наименьшему общему делителю (НОД) для упрощения дроби
        int gcd = gcd(numerator, denominator); // вызываем метод 'gcd', который рассчитывает наибольший общий делитель (НОД)
        // для числителя и знаменателя. 'НОД'- это наибольшее число, которое делит и числитель, и знаменатель без остатка.
        // Мы сохраняем это значение в переменной 'gcd'.
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Эта строка проверяет, является ли текущий объект (this) тем же объектом, который передан для сравнения (o).
        // Если это так (т.е., объекты ссылаются на один и тот же участок памяти), метод сразу возвращает true,
        // что означает, что объекты эквивалентны.

        if (o == null || getClass() != o.getClass()) return false;
        //  Эта строка проверяет два условия:
        // 'o == null' проверяет, является ли переданный для сравнения объект 'null'.
        // Если 'o' равен 'null', то сравнение не имеет смысла, и метод возвращает 'false'.
        // 'getClass() != o.getClass()' проверяет, принадлежит ли объект o к тому же классу, что и текущий объект (this).
        // Если объекты принадлежат к разным классам, они не могут быть эквивалентными, и метод также возвращает 'false'.

        ProperFraction other = (ProperFraction) o;
        // Здесь мы выполняем приведение объекта 'o' к типу ProperFraction,
        // так как метод equals ожидает объект этого класса для сравнения.

        return numerator == other.numerator && denominator == other.denominator;
        // Эта строка фактически сравнивает числитель и знаменатель текущего объекта (this)
        // с числителем и знаменателем объекта 'other'.
        // Если оба числителя и оба знаменателя равны, метод возвращает 'true', что означает, что дроби эквивалентны.
    }

    @Override
    public int hashCode() {       // Хеш-код - это целое число, которое служит для идентификации объекта и используется,
        // например, при работе с хеш-таблицами, коллекциями и структурами данных,
        // где быстрый доступ к объектам по их хеш-коду может улучшить производительность.
        return Objects.hash(numerator, denominator);
    }

    // Метод представляет рекурсивное вычисление наибольшего общего делителя (НОД)
    // двух чисел 'a' и 'b' с использованием алгоритма Эвклида.
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static void main(String[] args) {
        ProperFraction fraction1 = new ProperFraction(1, 2);
        ProperFraction fraction2 = new ProperFraction(2, 4);
        ProperFraction fraction3 = new ProperFraction(5, 10);

        System.out.println("fraction1 equals fraction2: " + fraction1.equals(fraction2)); // true
        System.out.println("fraction1 equals fraction3: " + fraction1.equals(fraction3)); // true

        System.out.println("Hash code of fraction1: " + fraction1.hashCode());
        System.out.println("Hash code of fraction2: " + fraction2.hashCode());
        System.out.println("Hash code of fraction3: " + fraction3.hashCode());
    }
}
