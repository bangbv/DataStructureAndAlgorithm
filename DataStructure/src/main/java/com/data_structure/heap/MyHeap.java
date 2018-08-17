package com.data_structure.heap;

public class MyHeap {

	private int[] heapArray;
	private int maxSize;
	private int heapSize;

	public MyHeap(int mx) {
		maxSize = mx;
		heapSize = 0;
		heapArray = new int[maxSize];
	}

	public boolean insert(int x) {
		if (heapSize + 1 == maxSize) {
			return false;
		}
		heapArray[++heapSize] = x;
		int pos = heapSize;
		while (pos != 1 && x > heapArray[pos / 2]) {
			System.out.println(heapArray[pos] +"vs"+ heapArray[pos / 2]);
			heapArray[pos] = heapArray[pos / 2];
			pos /= 2;
		}
		heapArray[pos] = x;
		return true;
	}

	public void test() {
		int pos = 100;
		while(pos != 1 && pos >0) {
			System.out.println(pos /= 2);
		}
	}
	
	public boolean isEmpty() {
		return heapSize == 0;
	}

	public int remove() {
		int parent, child;
		int item, temp;
		if (isEmpty())
			throw new RuntimeException("Error : Heap empty!");

		item = heapArray[1];
		temp = heapArray[heapSize--];
		parent = 1;
		child = 2;
		while (child <= heapSize) {
			if (child < heapSize && heapArray[child] < heapArray[child + 1])
				child++;
			if (temp >= heapArray[child])
				break;

			heapArray[parent] = heapArray[child];
			parent = child;
			child *= 2;
		}
		heapArray[parent] = temp;
		return item;
	}

	public void displayHeap() {
		System.out.println("Heap Array:");
		for (int i = 1; i <= heapSize; i++) {
			System.out.println(heapArray[i] + " ");
		}
		System.out.println();
	}

}
