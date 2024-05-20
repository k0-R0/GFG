package GFG_DSA;

import java.util.Scanner;

public class Mathematics_Bitwise_Arrays {
    public void primeTill(int N){
    boolean[] primes = new boolean[N+1];
    for(int i =0;i<=N;i++)
        primes[i] = true;
    for(int j=2; j<=N; j++)
    {
        if(primes[j])
            System.out.println(j);
        for(int k=j*j;k<=N;k=k+j)
            primes[k]=false;
    }
    }
    public int power(int N , int L){
        if(L==0)
            return 1;
        if(L%2==0)
            return power(N,L/2)*power(N,L/2);
        else
            return power(N,L-1)*N;
    }
    public void SecMax(int[] arr, int d)
    {
        int size = arr.length;
        reverse(arr,0,d-1);
        reverse(arr,d,size-1);
        reverse(arr,0,size-1);
    }
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr, int low, int high)
    {
        int size = arr.length;
        while(low<high)
        {
            swap(arr,low,high);
            low++;
            high--;
        }
    }
    public int[] leader(int[] arr)
    {
        int size = arr.length;
        int[] res = new int[size];
        int max = arr[size-1];
        res[0] = max;
        int j = 1;
        for(int i=size-1; i>=0 ; i--)
        {
            if(arr[i]>max)
            {
                max = arr[i];
                res[j] = max;
                j++;
            }
        }
        reverse(res,0,res.length-1);
        return res;
    }
    public void frequencies(int[] arr)
    {
        int size = arr.length;
        int n = 0;
        int count = 0;
        for(int i = 0; i<size;i++)
        {
            n = arr[i];
            count = 0;
            while(arr[i]==n)
            {
                count++;
                i++;
                if(i>=size)
                    break;
            }
            i--;
            System.out.println(n + " is present " + count + " times");
        }
    }
    public void StockProfit(int arr[])
    {
        int size = arr.length;
        int profit = 0;
        for(int i = 0; i<size-1; i++)
        {
            if(arr[i]<arr[i+1]){
                int j = i+1;
                while(j<size-1 && arr[j]<arr[j+1]){
                    j++;
                }
                profit += arr[j]-arr[i];
                i=j;
            }
        }
        System.out.println(profit);
    }
    public void waterStorage(int[] arr)
    {
        int size = arr.length;
        int[] lmax = new int[size];
        int[] rmax = new int[size];
        int storage = 0;
        lmax[0] = arr[0];
        rmax[size-1] = arr[size-1];
        for(int i = 1;i<size;i++)
        {
            lmax[i] = Integer.max(arr[i],lmax[i-1]);
        }
        for(int i=size-2;i>=0;i--)
        {
            rmax[i] = Integer.max(arr[i],rmax[i+1]);
        }
        for(int i=1;i<size-1;i++)
        {
            storage+=Integer.min(lmax[i],rmax[i])-arr[i];
        }
        System.out.println(storage);
    }
    public void boolMaxCons(Boolean[] arr)
    {
        int size = arr.length;
        int maxCons = 0;
        int count = 0;
        for(int i = 0; i<size; i++)
        {
            if(!arr[i])
                count = 0;
            else
            {
                count++;
                maxCons = Integer.max(maxCons,count);
            }
        }
        System.out.println(maxCons);
    }
    public void maxSumsub(int[] arr)
    {
        int size = arr.length;
        int res = arr[0];
        int max = arr[0];
        for(int i = 1; i<size; i++)
        {
            max = Integer.max(max+arr[i],arr[i]);
            res = Integer.max(res,max);
        }
        System.out.println(res);
    }
    public void maxEvenOdd(int[] arr)
    {
        int size = arr.length;
        int count = 0;
        int maxCons = 0;
        for(int i = 0;i<size-1;i++)
        {
            if(((arr[i]^arr[i+1])&1) == 0)
                count = 0;
            else
            {
                count++;
                maxCons = Math.max(count,maxCons);
            }
        }
        System.out.println(maxCons+1);
    }
    public void maxCircsub(int[] arr)
    {
        int size = arr.length;
        int max = arr[0];
        int resLine = arr[0];
        for(int i=1;i<size;i++)
        {
            max = Math.max(max+arr[i],arr[i]);
            resLine = Math.max(max,resLine);
        }
        int minLine = arr[0];
        int min = arr[0];
        for(int i=1;i<size;i++)
        {
            min = Math.min(min+arr[i],arr[i]);
            minLine = Math.min(min,minLine);
        }
        int total = 0;
        for(int i=0;i<size;i++)
            total+=arr[i];
        int resCirc = total-minLine;
        System.out.println(Math.max(resCirc,resLine));
    }
    public void majority(int[] arr)
    {
        int size =  arr.length;
        int candInd = 0;
        int voteCount = 0;
        for(int i = 0;i<size;i++)
        {
            if(arr[i]==arr[candInd])
                voteCount++;
            else
                voteCount--;
            if(voteCount==0)
            {
                candInd = i;
                voteCount = 1;
            }
        }
        voteCount = 0;
        for(int i = 0;i<size;i++)
        {
            if(arr[candInd]==arr[i])
                voteCount++;
        }
        if(voteCount<=(size/2))
            System.out.println(-1);
        else
            System.out.println(arr[candInd] + " wins by " + voteCount);
    }
    public void minFlips(int[] arr)
    {
        int size = arr.length;
        for(int i=1;i<size;i++)
        {
            if(arr[i]!=arr[i-1])
            {
                if(arr[i]!=arr[0])
                    System.out.printf("from " + i + " to ");
                else
                    System.out.println(i-1);
            }
        }
        if(arr[size-1]!=arr[0])
            System.out.println(size-1);
    }
    public void maxSumK(int[] arr, int k)
    {
        int size = arr.length;
        int sum = 0;
        for(int i=0;i<k;i++)
            sum+=arr[i];
        int max = sum;
        for(int i = k;i<size;i++)
        {
            sum+=arr[i] - arr[i-k];
            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
    public void subgivenSum(int[] arr, int value)
    {
        int size = arr.length;
        int sum = arr[0];
        int tracker = 0;
        for(int i = 1;i<size;i++)
        {
            if(sum<value)
                sum+=arr[i];
            if(sum==value)
            {
                System.out.println("Yes from " + tracker);
                break;
            }
            if(sum>value)
            {
                sum-=arr[tracker];
                tracker++;
            }
        }
        if(sum!=value)
            System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int[] arr = new int[N];
        for(int i = 0; i< N; i++) {
            arr[i] = Integer.parseInt(scan.next());
        }
        Mathematics_Bitwise_Arrays test = new Mathematics_Bitwise_Arrays();
    }
}
