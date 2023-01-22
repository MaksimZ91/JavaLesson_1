package org.example;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int limit = 2001;
        Random random = new Random();
        int i = random.nextInt(limit);
        System.out.printf("Сгенерировано число: %d \n", i);
        int n = Integer.highestOneBit(i);  //getMSBNumber(i) ,   getMSBNumberSecond(i)
        System.out.printf("MSB: %d \n", n);
        System.out.printf("Массив всех кратные числа n = %d  в диапазоне от %d до %d : \n", n,i,Short.MAX_VALUE);
        System.out.println(Arrays.toString(getArrayMultiple(n,i)));
        //System.out.println(Arrays.toString(getArrayMultipleSecond(n,i)));
        System.out.printf("Массив всех некратные числа n = %d  в диапазоне от %d до %d : \n", n,Short.MIN_VALUE,i);
        System.out.println(Arrays.toString(getArrayNotMultiple(n,i)));
    }
    private static int getMSBNumber(int number) {
        int x = 1 << 30;
        while (x > number) x >>= 1;
        return x;
    }

    private static int getMSBNumberSecond(int number) {
        int x = Integer.toBinaryString(number).length() - 1;
        return (int) Math.pow(2, x);
    }

    private static int[] getArrayNotMultiple (int MSBNumber, int number) {
        int k = 0;
        int[] m2 = new int[Short.MAX_VALUE - ((Short.MAX_VALUE) / MSBNumber) + number - 1];
        int buffer = Short.MIN_VALUE;
        while (buffer <= number){
            if (buffer % MSBNumber != 0){
                m2[k] = buffer;
                k++;
            }
            buffer++;
        }
        return m2;
    }

    private static int[] getArrayMultiple (int MSBNumber, int number) {
        int[] m1 = new int[Short.MAX_VALUE / MSBNumber-1];
        int buffer = MSBNumber;
        for (int i = 0; i <= m1.length - 1; i++){
            if (number == buffer){
                m1[i] = buffer;
                buffer += MSBNumber;
            } else {
                buffer += MSBNumber;
                m1[i] = buffer;
            }
        }
        return m1;
    }

    private static int[] getArrayMultipleSecond (int MSBNumber, int number) {
        int k = 0;
        int[] m1 = new int[Short.MAX_VALUE / MSBNumber-1];
        while (number <= Short.MAX_VALUE){
            if (number % MSBNumber == 0){
                m1[k] = number;
                k++;
            }
            number++;
        }
        return m1;
    }
}

