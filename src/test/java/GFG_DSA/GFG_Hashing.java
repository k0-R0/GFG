package GFG_DSA;
import java.util.*;

public class GFG_Hashing {

    public int countDistinct(int[] arr){

        int size = arr.length;

        HashSet<Integer> h = new HashSet<Integer>(size);

        for(int i=0;i<size;i++)

            h.add(arr[i]);

        return h.size();

    }

    public HashMap<Integer,Integer> elementFrequency(int[] arr)

    {

        int size = arr.length;

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(size);

        for(int i=0;i<size;i++)

        {

            if(map.containsKey(arr[i]))

                map.put(arr[i],map.get(arr[i])+1);

            else

                map.put(arr[i],1);

        }

        return map;

    }

    public ArrayList<Integer> arrayIntersection(int[] a, int[] b)

    {

        int sizea = a.length;

        ArrayList<Integer> res = new ArrayList<Integer>();

        HashSet<Integer> set = new HashSet<Integer>(sizea);

        for(int v:b)

        {

            set.add(v);

        }

        for(int v:a)

        {

            if(set.contains(v))

                res.add(v);

        }

        return res;

    }

    public HashSet<Integer> unionArray(int[] a,int[] b)

    {

        HashSet<Integer> res = new HashSet<Integer>(a.length + b.length);

        for(int v:a)

            res.add(v);

        for(int v:b)

            res.add(v);

        return res;

    }

    public ArrayList<Integer> pairSum(int[] a,int key)

    {

        HashSet<Integer> set = new HashSet<Integer>(a.length);

        set.add(a[0]);

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=1;i<a.length;i++)

        {

            if(set.contains(key-a[i]))

            {

                res.add(a[i]);

                res.add(key-a[i]);

                break;

            }

            set.add(a[i]);

        }

        if(res.isEmpty())

            return null;

        else return res;

    }

    public ArrayList<Integer> sumZero(int[] arr)

    {

        ArrayList<Integer> res = new ArrayList<Integer>();

        HashSet<Integer> set = new HashSet<Integer>();

        int pre_sum = 0;

        for(int i=0;i< arr.length;i++)

        {

            pre_sum += arr[i];

            if(set.contains(pre_sum))

            {

                res.add(i); break;

            }

            else if(pre_sum==0)

            {

                res.add(0); res.add(i); return res;

            }

            set.add(pre_sum);

        }

        if(res.isEmpty())

            return new ArrayList<Integer>(Arrays.asList(-1,-1));

        else

        {

            int j = res.get(0);

            int sum = 0;

            while(j>=0)

            {

                sum += arr[j];

                if(sum==0)

                {

                    res.add(j); break;

                }

                j--;

            }

            res.sort(Comparator.naturalOrder());

            return res;

        }

    }

    public ArrayList<Integer> subarraySum(int[] arr, int sum)

    {

        HashSet<Integer> set = new HashSet<>();

        ArrayList<Integer> res = new ArrayList<>();

        int pre_sum = 0;

        for(int i = 0; i<arr.length;i++)

        {

            pre_sum += arr[i];

            if(set.contains(sum-pre_sum))

            {

                res.add(i); break;

            }

            if(pre_sum == sum)

            {

                res.add(0); res.add(i); return res;

            }

            set.add(pre_sum);

        }

        if(res.isEmpty())

            return new ArrayList<Integer>(Arrays.asList(-1,-1));

        else

        {

            int j = res.get(0);

            pre_sum = 0;

            while(j>=0)

            {

                pre_sum += arr[j];

                if(pre_sum==sum)

                {

                    res.add(j); break;

                }

            }

            res.sort(Comparator.naturalOrder());

            return res;

        }

    }

    public int longestsubarraySum(int[] arr, int sum)

    {

        ArrayList<Integer> res = new ArrayList<>();

        int presum = 0;

        int max_length = -1;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)

        {

            if(presum == sum)

            {

                map.put(presum,i); max_length = Integer.max(max_length,i);

            }

            else if(map.containsKey(presum-sum))

            {

                map.put(presum,i-map.get(presum-sum));

                max_length = Integer.max(max_length,i-map.get(presum-sum));

            }

            map.put(presum,i);

        }

        return max_length;

    }

    public int longestConsSub(int[] arr)

    {

        HashSet<Integer> set = new HashSet<>();

        for(int i:arr)

            set.add(i);

        int res = 1;

        for(Integer i:set)

        {

            if(!set.contains(i-1))

            {

                int curr = 1;

                while(set.contains(i+curr))

                    curr++;

                res = Math.max(res,curr);

            }

        }

        return res;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of the first array: ");

        int size1 = scan.nextInt();

        System.out.println("Enter the array elements of first array: ");

        int[] arr1 = new int[size1];

        for(int i=0;i<size1;i++)

        {

            arr1[i] = Integer.parseInt(scan.next());

        }

        System.out.println("Enter the sum: ");

        int sum = scan.nextInt();

        GFG_Hashing test = new GFG_Hashing();

        System.out.println(test.subarraySum(arr1,sum));

    }

}