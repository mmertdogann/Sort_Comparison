
/*
Name: Mert Doðan
ID: 041701041
Date: 22.12.2018
Explanation: This class is the main class whose project name is Sorting with Heap.
This program has three methods which are main, heapSort() and a default class which is Arrays.sort 
The program compares the sorting time of a given integer array. The array is cloning two times 
and each array pass by their reference to 3 different methods 
and the program print out each sorting times of arrays.
 */

import java.util.Arrays;
import java.util.Random;

public class mert_dogan {
	public static void main(String[] args) {

		Random rand = new Random(); // Create a random object
		int[] arrayHeap = new int[70000]; // Array for heap
		int[] arraySelection = new int[70000]; // Array for selection sort
		int[] arrayJava = new int[70000]; // Array for Java array sort
		int arraySize = arrayHeap.length; // Getting arrayHeap's size

		int i, j; // For indexing
		double start = 0.0; // starting time
		double finish = 0.0; // ending time
		double elapsedTimeMilliSeconds = 0.0; // the elapsed time
		// Arrays for storing elapsed times
		double[] elapsedTimeHeap = new double[10];
		double[] elapsedTimeSelection = new double[10];
		double[] elapsedTimeJavasrt = new double[10];

		for (i = 0; i < 10; i++) { // First loop for call the function 10 times
			for (j = 0; j < arraySize; j++) { // Second loop for assign random integers
				arrayHeap[j] = rand.nextInt(10000000); // Assign random integers to array
			}
			System.arraycopy(arrayHeap, 0, arraySelection, 0, arraySize); // Copy array for Selection sort
			System.arraycopy(arrayHeap, 0, arrayJava, 0, arraySize); // Copy array for Java sort

			// Time calculate for heapSort
			start = System.nanoTime();
			heapSort(arrayHeap); // Calling the heapSort function arrayHeap as an argument
			finish = System.nanoTime();
			elapsedTimeMilliSeconds = (finish - start) / 1000000f;
			elapsedTimeHeap[i] = elapsedTimeMilliSeconds;

			// Time calculate for Arrays.sort
			start = System.nanoTime();
			Arrays.sort(arrayJava); // Calling the Arrays.sort function arrayJava as an argument
			finish = System.nanoTime();
			elapsedTimeMilliSeconds = (finish - start) / 1000000f;
			elapsedTimeJavasrt[i] = elapsedTimeMilliSeconds;

			// Time calculate for selectionSort
			start = System.nanoTime();
			selectionSort(arraySelection); // Calling the selectionSort function arraySelection as an argument
			finish = System.nanoTime();
			elapsedTimeMilliSeconds = (finish - start) / 1000000f;
			elapsedTimeSelection[i] = elapsedTimeMilliSeconds;

		}

		System.out.println("Array Size: " + arraySize);

		elapsedTimeMilliSeconds = 0.0;
		// print Heap Sort
		for (i = 0; i < 10; i++) {
			elapsedTimeMilliSeconds += elapsedTimeHeap[i];
			System.out.printf("%2d: %5.2f msec\n", i + 1, elapsedTimeHeap[i]);
		}
		System.out.printf(" Average Sort Time for Heap Sort%20.2f\n", elapsedTimeMilliSeconds / 10f);
		System.out.println();
		elapsedTimeMilliSeconds = 0.0;
		// print Java Sort
		for (i = 0; i < 10; i++) {
			elapsedTimeMilliSeconds += elapsedTimeJavasrt[i];
			System.out.printf("%2d: %5.2f msec\n", i + 1, elapsedTimeJavasrt[i]);

		}
		System.out.printf(" Average Sort Time for Java Array Sort%14.2f\n", elapsedTimeMilliSeconds / 10f);
		System.out.println();
		elapsedTimeMilliSeconds = 0.0;
		// print Selection Sort
		for (i = 0; i < 10; i++) {
			elapsedTimeMilliSeconds += elapsedTimeSelection[i];
			System.out.printf("%2d: %5.2f msec\n", i + 1, elapsedTimeSelection[i]);

		}
		System.out.printf(" Average Sort Time for Selection Sort%16.2f\n", elapsedTimeMilliSeconds / 10f);

	}

	public static void heapSort(int[] list) {

		Heap<Integer> myHeap = new Heap<>();
		int size = list.length;
		int i; // For indexing

		for (i = 0; i < size; i++) {
			myHeap.add(list[i]);
		}
		// Create a new Heap object for Heap sort
		int[] arraySorted = new int[size];

		// Heap Sorting as removing
		for (i = 0; i < size; i++) {
			arraySorted[i] = (Integer) myHeap.remove(); // Remove element from Heap
		}
	}

	public static void selectionSort(int[] list) {
		int i, j; // Indexes for loop
		int temp;
		int min_idx; // minimum index
		int size = list.length;
		// One by one move boundary of unsorted subarray
		for (i = 0; i < size - 1; i++) {
			// Find the minimum element in unsorted array
			min_idx = i;
			for (j = i + 1; j < size; j++)
				if (list[j] < list[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first element
			temp = list[min_idx];
			list[min_idx] = list[i];
			list[i] = temp;
		}
	}
}
