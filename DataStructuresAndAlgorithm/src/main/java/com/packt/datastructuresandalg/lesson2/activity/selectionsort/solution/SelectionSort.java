package com.packt.datastructuresandalg.lesson2.activity.selectionsort.solution;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPtr = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minPtr]) minPtr = j;
            }
            swap(array, minPtr, i);
        }
    }

    private static void swap(int[] numbers, int j, int k) {
        int temp = numbers[j];
        numbers[j] = numbers[k];
        numbers[k] = temp;
    }
    
	public static void main(String[] args) {
		int[] a = {5, 6, 2, 1, 8, 7};
		System.out.println(Arrays.toString(a));
		SelectionSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
