package com.algorithm.DivideAndConquer;

/*
After performing q = RandomizedPartition(A, 0, n - 1), all elements ≤ A[q] will be
placed before the pivot and therefore A[q] is now in it’s correct order statistic, which is q + 1.
Then, there are only 3 possibilities:
1. q + 1 = k, A[q] is the desired answer. We return this value and stop.
2. q + 1 > k, the desired answer is inside the left partition, e.g. in A[0..q-1].
3. q + 1 < k, the desired answer is inside the right partition, e.g. in A[q+1..n-1].
 */
/*
int RandomizedSelect(int A[], int l, int r, int k) {
	if (l == r) return A[l];
	int q = RandomizedPartition(A, l, r);
	if (q + 1 == k) 
		return A[q];
	else if (q + 1 > k) 
		return RandomizedSelect(A, l, q - 1, k);
	else 
		return RandomizedSelect(A, q + 1, r, k);
}

algorithm radomizedpartition(A, lo, hi) is
    pivot := A[hi]
    i := lo    
    for j := lo to hi - 1 do
        if A[j] < pivot then
            swap A[i] with A[j]
            i := i + 1
    swap A[i] with A[hi]
    return i
 */
public class SelectionProblem {
	
	public int randomizedSelection(int[] a,int lo,int hi, int k) {
		if(lo == hi) {
			return a[lo];
		}
		int q = randomizedPartition(a,lo,hi);
		if((q+1) == k){
			return a[q];
		}else if (q+1>k) {
			return randomizedSelection(a,lo,q-1,k);
		}else {
			return randomizedSelection(a,q+1,hi,k);
		}
	}
	
	public int randomizedPartition(int[] a, int lo, int hi) {
		int pivot = a[hi];
		int i = lo;
		for(int j=lo;j<hi;j++) {
			if(a[j]<pivot) {
				// swap
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
