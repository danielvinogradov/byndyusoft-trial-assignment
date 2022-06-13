package com.byndyusoft.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Примечание к ТЗ.
 *
 * – Тестирование с 100 млн элементов массива не производится, потому что в контексте задачи
 * как 5 элементов, так и 100 миллионов элементов массива являются базовым сценарием, если только
 * не стоит задачи померить бенчмарки (производительность).
 */
class IntArrayUtilsTest {

    /**
     * Корректно работает, если передать в функцию null. Не использовал аннотацию @NotNull, чтобы
     * написать этот тест :)
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithNull() {
        final int[] given = null;

        final int expected = 0;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Корректно работает с пустым массивом в качестве аргумента.
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithEmptyArray() {
        final int[] given = new int[0];

        final int expected = 0;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Корректно работает с массивом длины меньше необходимой (необходимо минимум 2 элемента).
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithArrayLengthOne() {
        final int[] given = new int[]{10};

        final int expected = 0;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Базовый случай. Корректно работает с массивом уникальных элементов.
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithUniqueMinElements() {
        final int[] given = new int[]{6, 3, 1, 9, 2};

        final int expected = 3;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Корректно работает, когда два минимума – это одинаковые элементы.
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithNonUniqueElements() {
        final int[] given = new int[]{5, 1, 2, 1, 47};

        final int expected = 2;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Корректно работает с массивами, где есть отрицательные числа.
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithNegativeNumbers() {
        final int[] given = new int[]{73, -2, 47, 2, 0, -39};

        final int expected = -41;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Корректно работает с массивом из двух элементов.
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWorkCorrectlyWithTwoElementsArray() {
        final int[] given = new int[]{1, 2};

        final int expected = 3;
        final int actual = IntArrayUtils.findSumOfTwoMinValues(given);

        assertEquals(expected, actual);
    }

    /**
     * Кидает {@link ArithmeticException} в случае переполнения в меньшую сторону (underflow).
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWhenUnderflow() {
        final int[] given = new int[]{10, 38, -38, Integer.MIN_VALUE, 183, 48, 1};

        assertThrows(
                ArithmeticException.class,
                () -> IntArrayUtils.findSumOfTwoMinValues(given)
        );
    }

    /**
     * Кидает {@link ArithmeticException} в случае переполнения в большую сторону (overflow).
     *
     * @see IntArrayUtils#findSumOfTwoMinValues(int[])
     */
    @Test
    void findSumOfTwoMinValuesShouldWhenOverflow() {
        final int[] given = new int[]{19, 37, Integer.MAX_VALUE, 38, 9823, 5};

        assertThrows(
                ArithmeticException.class,
                () -> IntArrayUtils.findSumOfTwoMinValues(given)
        );
    }

}
