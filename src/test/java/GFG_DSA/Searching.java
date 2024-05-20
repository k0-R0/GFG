package GFG_DSA;

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
