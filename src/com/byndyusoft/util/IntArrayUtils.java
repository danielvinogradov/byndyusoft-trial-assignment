package com.byndyusoft.util;

/**
 * Утилитарные функции для работы с int[].
 */
public final class IntArrayUtils {

    private static final int DEFAULT_INT_VALUE = 0;

    /**
     * Находит сумму двух минимальных элементов массива. Минимальные элементы могут быть одинаковыми.
     * <p>
     * Например, <code>findSumOfTwoMinValues(new int[]{1, 2, 3, 1}) == 2</code>, а
     * <code>findSumOfTwoMinValues(new int[]{1, 2, 3, 4}) == 3</code>.
     * <p>
     * Последовательность чисел в массиве может быть неупорядоченной.
     * <p>
     * В случае overflow или underflow при сложении минимальных элементов будет
     * выброшено исключение {@link ArithmeticException}.
     * <p>
     * Ассимптотика тут будет O(n) – для нахождения двух минимальных элементов потребуется 1 обход массива.
     *
     * @param arr массив, в котором необходимо найти сумму минимальных элементов.
     * @return сумма минимальных элементов массива
     */
    public static int findSumOfTwoMinValues(final int[] arr) {
        final int minExpectedLength = 2;
        if (arr == null || arr.length < minExpectedLength) return DEFAULT_INT_VALUE;

        int min1 = arr[0];
        int min2 = arr[1];

        for (int i = minExpectedLength; i < arr.length; i++) {
            final int newValue = arr[i];
            final int currentMax = Math.max(min1, min2);

            if (newValue < currentMax) {
                min1 = Math.min(min1, min2);
                min2 = newValue;
            }
        }

        return Math.addExact(min1, min2);
    }

    private IntArrayUtils() {
    }

}
