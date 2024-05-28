package GFG_DSA;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.Scanner;

public class GFG_Sorting {

    public void swapArrEle(int[] arr,int i, int j)

    {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public void bubbleSort(int[] arr)

    {

        int size = arr.length;

        for(int i = 0; i<size; i++)

        {

            boolean swapped = false;

            for(int j=0;j<size-i-1;j++)

            {

                if(arr[j]>arr[j+1])

                {

                    swapArrEle(arr,j,j+1);

                    swapped = true;

                }

            }

            if(!swapped)

                break;

        }

    }

    public void selectionSort(int[] arr)

    {

        int size = arr.length;

        int curr_min_index = 0;

        for(int i = 0;i<size-1;i++)

        {

            for(int j = i;j<size;j++)

            {

                if(arr[j]<arr[curr_min_index])

                    curr_min_index = j;

            }

            swapArrEle(arr,i,curr_min_index);

        }

    }

    public void insertionSort(int[] arr)

    {

        int size = arr.length;

        for(int i = 1;i<size;i++)

        {

            int key = arr[i];

            int j = i-1;

            while(j>=0 && arr[j]>key)

            {
                arr[j+1] = arr[j];

                j--;

            }
            arr[j+1] = key;

        }

    }

    public int[] mergeArrays(int[] a, int[] b)

    {

        int size_a = a.length;

        int size_b = b.length;

        int[] merged = new int[size_b + size_a];

        int i,j,l;

        i=0;j=0;l=0;

        while(i<size_a && j<size_b)

        {

            if(a[i]<=b[j])

            {

                merged[l] = a[i];

                i++;

                l++;

            }

            else

            {

                merged[l] = b[j];

                j++;

                l++;

            }

        }

        while(i!=size_a)

        {

            merged[l] = a[i];

            i++;

            l++;

        }

        while(j!=size_b)

        {

            merged[l] = b[j];

            j++;

            l++;

        }

        return merged;

    }

    public void merge(int[] a , int l, int m, int r)

    {

        int[] left = new int[m-l+1];

        int[] right = new int[r-m];

        for(int i=0;i<left.length;i++)

            left[i] = a[i+l];

        for(int i=0;i<right.length;i++)

            right[i] = a[i+m+1];

        int i,j,k; i=0;j=0;k=l;

        while(j<right.length && i<left.length)

        {

            if(left[i]<=right[j])

            {
                a[k] = left[i]; i++; k++;

            }

            else

            {
                a[k] = right[j]; j++; k++;

            }

        }

        while(i<left.length)

        {
            a[k] = left[i]; i++; k++;

        }

        while(j<right.length)

        {
            a[k] = right[j]; j++; k++;

        }

    }

    public void mergeSort(int[] a,int l, int r)

    {

        int m = (l+r)/2;

        if(r>l)

        {

            mergeSort(a,l,m);

            mergeSort(a,m+1,r);

            merge(a,l,m,r);

        }

    }

    public ArrayList<Integer> arrayIntersection(int[] a,int[] b)

    {

        int size_a = a.length;

        int size_b = b.length;

        ArrayList<Integer> intersection_elements = new ArrayList<Integer>();

        int i,j; i=0; j=0;

        while(i<size_a || j<size_b)

        {

            if(i>0 && a[i]==a[i-1])

                i++;

            else if(a[i]<b[j])

                i++;

            else if(a[i]>b[j])

                j++;

            else if(a[i]==b[j])

            {

                intersection_elements.add(a[i]);

            }

        }

        return intersection_elements;

    }

    public ArrayList<Integer> arrayUnion(int[] a,int[] b)

    {

        int size_a = a.length;

        int size_b = b.length;

        ArrayList<Integer> union_elements = new ArrayList<Integer>();

        int i,j;i=0;j=0;

        while(i<size_a || j<size_b)

        {

            if(a[i]==a[i-1])

                i++;

            else if(a[i]<b[j])

            {

                union_elements.add(a[i]); i++;

            }

            else if(a[i]>b[j])

            {

                union_elements.add(b[j]); j++;

            }

            else

            {

                union_elements.add(a[i]); i++;

            }

        }

        while(i!=size_a)

        {

            if(a[i]!=a[i-1])

            {

                union_elements.add(a[i]);i++;

            }

            else

                i++;

        }

        while(j!=size_b)

        {

            if(b[j]!=b[j-1])

            {

                union_elements.add(b[j]);j++;

            }

            else

                j++;

        }

        return union_elements;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size1 = scan.nextInt();

        int[] arr1 = new int[size1];

        for(int i = 0; i<size1; i++)

        {

            arr1[i] = Integer.parseInt(scan.next());

        }

        GFG_Sorting test = new GFG_Sorting();

        test.mergeSort(arr1,0,arr1.length-1);

        System.out.println(Arrays.toString(arr1));

    }

}
