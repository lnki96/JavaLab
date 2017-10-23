package com.lnki96;

public class Algo {
//Search

	public static int binarySearch(int[] arr, int o) {
		final int n = arr.length;
		int m = 0, l = 0, r = n - 1;
    	do {
    		if (r >= 0 && l < n)
    			m = l + r >> 1;
    		if (o == arr[m])
    			return m;
    		else if (o < arr[m])
    			r = m - 1;
    		else
    			l = m + 1;
    	} while (l <= r);
    	return -1;
	}

//Sort

	public static void bubbleSort(int[] arr) {
        boolean flag;
        int i, j, t;
        for (i = arr.length, flag = true; flag && --i > 0; )
            for (j = 0, flag = false; j < i; j++)
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
    }

    public static void quickSort(int[] arr) {
        final int n = arr.length;
        boolean flag;
        int[] ind = new int[n];
    	int i, j, l, r, key, t;
        for (ind[0] = n, flag = true; flag;) {
            for (i = 0, flag = false; i < n; i = r) {
                if ((l = i) < (j = (r = ind[i]) - 1)) {
                    if (!flag)
                        flag = true;
                    key = arr[l];
                    while (true) {
                        while (arr[i] <= key && i < j)
                            i++;
                        while (arr[j] > key && i <= j)
                            j--;
                        if (i >= j)
                            break;
                        t = arr[i];
                        arr[i] = arr[j];
                        arr[j] = t;
                    }
                    arr[l] = arr[j];
                    arr[j] = key;
                    ind[l] = i;
                    ind[i] = r;
                }
            }
        }
    }

	public static void mergeSort(int[] arr) {
        final int n = arr.length;
		int[][] cand = new int[2][];
        int[] next, prev;
        int c, i, j, k, s;
        next = cand[0] = (int[]) arr.clone();
        cand[1] = new int[n];
        for (c = 0, s = 1; s < n; s <<= 1) {
            prev = cand[c];
            next = cand[c = ++c % 2];
            for (i = 0, j = s, k = 0; k < n;) {
                next[k++] = (j >= n || prev[i] < prev[j]) ? prev[i++] : prev[j++];
                if (i % (s << 1) == s) {
                    i += s;
                    for (; k < n && j < i; j++)
                        next[k++] = prev[j];
                    j += s;
                }
                if (j % (s << 1) == 0) {
                    j -= s;
                    for (; k < n && i < j; i++)
                        next[k++] = prev[i];
                    i += s;
                    j += s << 1;
                }
            }
        }
        for (i = 0; i < n; i++)
            arr[i] = next[i];
	}

    public static void heapSort(int[] arr) {
        final int n = arr.length;
        int c, i, j, k, m, t;
        for (i = (j = n / 2) - 1; i >= 0; i--)
            for (k = i, m = k; k < j; k = m) {
                if (arr[m] < arr[c = (k << 1) + 1])
                    m = c;
                if ((c = k + 1 << 1) < i && arr[m] < arr[c])
                    m = c;
                if (k != m) {
                    t = arr[k];
                    arr[k] = arr[m];
                    arr[m] = t;
                } else
                    break;
            }
        for (i = n; i > 0;) {
            t = arr[0];
            arr[0] = arr[--i];
            arr[i] = t;
            j = i / 2;
            for (k = 0, m = 0; k < j; k = m) {
                if (arr[m] < arr[c = (k << 1) + 1])
                    m = c;
                if ((c = k + 1 << 1) < i && arr[m] < arr[c])
                    m = c;
                if (k != m) {
                    t = arr[k];
                    arr[k] = arr[m];
                    arr[m] = t;
                } else
                    break;
            }
        }
    }
}