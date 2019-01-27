package com.algorithm.sort;
/*
The steps are:
1: Pick an element, called a pivot, from the array.
2: Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, 
while all elements with values greater than the pivot come after it (equal values can go either way). 
After this partitioning, the pivot is in its final position. This is called the partition operation.
3: Recursively apply the above steps to the sub-array of elements with smaller values and
 separately to the sub-array of elements with greater values.

The base case of the recursion is arrays of size zero or one, 
which are in order by definition, so they never need to be sorted.

The pivot selection and partitioning steps can be done in several different ways; 
the choice of specific implementation schemes greatly affects the algorithm's performance. 
 */
/*
algorithm quicksort(A, lo, hi) is
    if lo < hi then
        p := partition(A, lo, hi)
        quicksort(A, lo, p - 1 )
        quicksort(A, p + 1, hi)

algorithm partition(A, lo, hi) is
    pivot := A[hi]
    i := lo    
    for j := lo to hi - 1 do
        if A[j] < pivot then
            swap A[i] with A[j]
            i := i + 1
    swap A[i] with A[hi]
    return i
 */
public class QuickSort {
	
	void quicksort(int[] a,int lo,int hi) {
		if(lo<hi) {
			int p = partition(a,lo,hi);
			quicksort(a,lo,p-1);
			quicksort(a,p+1,hi);
		}
	}
	
	int partition(int[] a,int lo, int hi) {
		int pivot  = a[hi];
		int i = lo;
		for(int j = lo;j< hi;j++) {
			if(a[j]<pivot){
				swap(a,i,j);
				i = i+1;
			}
		}
		swap(a,i,hi);
		return i;
	}
	
	void swap(int[] a,int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
