package GFG_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Searching {
    public int binarySearch(int[] arr, int key)
    {
        int start = 0;
        int end = arr.length;
        int mid;
        while(start<end)
        {
            mid = (int) (start+end)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[mid]<key)
                start = mid + 1;
            else
                end = mid -1;
        }
        return -1;
    }
    public int indexFirstOccurence(int[] arr, int key)
    {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while(start<=end)
        {
            mid = (int) (start+end)/2;
            if(arr[mid]<key)
                start = mid+1;
            else if(arr[mid]>key)
                end = mid-1;
            else if(arr[mid]==key)
            {
                if(mid==0 || arr[mid]!=arr[mid-1])
                    return mid;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
    public int indexLastOccurence(int[] arr, int key)
    {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while(start<=end)
        {
            mid = (int) (start+end)/2;
            if(arr[mid]<key)
                start = mid+1;
            else if(arr[mid]>key)
                end = mid-1;
            else
            {
                if(mid==arr.length-1 || arr[mid]!=arr[mid+1])
                    return mid;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
    public int countOccurence(int[] arr, int key)
    {
        int a = indexFirstOccurence(arr,key);
        if(a==-1)
            return a;
        int b = indexLastOccurence(arr,key);
        return b-a+1;
    }
    public int peakElement(int[] arr)

    {

        int start = 0;

        int end = arr.length-1;

        int mid = (start+end)/2;

        while(start<=end)

        {

            mid = (start+end)/2;

            if(mid==0 && arr[0]>arr[1])

                return mid;

            else if(mid==arr.length-1 && arr[arr.length-1]>arr[arr.length-2])

                return mid;

            if(arr[mid]>=arr[mid-1] && arr[mid]>=arr[mid+1])

                return mid;

            else {

                if(arr[mid-1]>=arr[mid])

                    end = mid - 1;

                else

                    start = mid + 1;

            }

        }

        return mid;

    }
    public ArrayList<Integer> tripletSum(int[] arr, int x)

    {

        int size = arr.length;

        if(size<3)

            return new ArrayList<Integer>(Arrays.asList(-1));

        int i = 0;

        int j = size-1;

        int sum;

        while(i<j)

        {

            sum = arr[i]+arr[j];

            if(sum<x)

            {

                int m = binarySearch(arr,x-sum);

                if(m!=-1)

                    return new ArrayList<Integer>(Arrays.asList(arr[i],arr[m],arr[j]));

                else

                    i++;

            }

            else

                j--;

        }

        return new ArrayList<Integer>(Arrays.asList(-1));

    }

    public ArrayList<Integer> PairSum(int arr[], int key)

    {

        int size = arr.length;

        if(size<2)

            return null;

        int sum;

        int i,j; //the 2 pointers we'll be using

        i = 0; j = size-1;

        sum = arr[i]+arr[j];

        if(sum==key)

            return new ArrayList<Integer>(Arrays.asList(i,j));

        while(i<j)

        {

            sum = arr[i]+arr[j];

            if(sum==key)

                return new ArrayList<Integer>(Arrays.asList(i,j));

            if(sum<key)

                i++;

            else

                j--;

        }

        return new ArrayList<Integer>(Arrays.asList(-1));

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++)
            arr[i] = Integer.parseInt(scan.next());
        int key = scan.nextInt();
        Searching test = new Searching();
        System.out.println(test.countOccurence(arr,key));
    }
}
