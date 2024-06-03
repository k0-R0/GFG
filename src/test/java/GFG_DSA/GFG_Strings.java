package GFG_DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GFG_Strings {
    public boolean palindrome(String s){
        int l,h;
        l=0;h=s.length()-1;
        while(l<h) {
            if (s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
    public boolean subsequence(String s1, String s2)
    {
        int size1 = s1.length();
        int size2 = s2.length();
        int i=0;int j=0;
        while(i<size1 && j<size2){
            if(s1.charAt(i)==s2.charAt(j))
            {
                j++; i++;
            }
            else
                i++;
        }
        return j == size2;
    }
    public boolean anagram(String a,String b)
    {
        if(a.length()!=b.length())
            return false;
        else
        {
            /* hashing solution
            HashMap<Character,Integer> mapA = new HashMap<>(a.length());
            HashMap<Character,Integer> mapB = new HashMap<>(b.length());
            for(int i=0;i<a.length();i++)
            {
                mapA.put(a.charAt(i),mapA.getOrDefault(a.charAt(i),0)+1);
            }
            for(int i=0;i<b.length();i++)
            {
                mapB.put(b.charAt(i),mapB.getOrDefault(b.charAt(i),0)+1);
            }
            for(Map.Entry<Character,Integer> e : mapA.entrySet())
            {
                if(!e.getValue().equals(mapB.get(e.getKey())))
                    return false;
            }
            return true;
            */
            //better solution
            int[] count = new int[123];
            for(int i=0;i<a.length();i++)
            {
                count[a.charAt(i)]++;
                count[b.charAt(i)]--;
            }
            for(int x:count)
            {
                if(x!=0)
                    return false;
            }
            return true;
        }
    }
    public int leftmostrepeat(String s)

    {

        int[] count = new int[123];

        int i;

        for(i=0;i<s.length();i++)

        {

            count[s.charAt(i)]++;

        }

        for(i=0;i<s.length();i++)

        {

            if(count[s.charAt(i)]>1)

                break;

        }

        return i;

    }

    public StringBuffer reverse(StringBuffer s,int l,int h)

    {

        StringBuffer res = new StringBuffer(s);

        while(l<h)

        {

            char temp = res.charAt(l);

            res.setCharAt(l,res.charAt(h));

            res.setCharAt(h,temp);

            l++;

            h--;

        }

        return res;

    }

    public StringBuffer reversewords(String s)

    {

        StringBuffer str = new StringBuffer(s);

        int l=0;

        str = reverse(str,0,str.length()-1);

        for(int i=0;i<str.length();i++)

        {

            if(' ' == str.charAt(i))

            {

                str = reverse(str,l,i-1);

                l=i+1;

            }

        }

        str = reverse(str,l,str.length()-1);

        return str;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = scan.nextLine();
        String sub = scan.nextLine();
        GFG_Strings obj = new GFG_Strings();
        System.out.println(obj.anagram(text,sub));
    }
}
