package GFG_DSA;
class node{

    int data;

    node next;

    node(int x)

    {
        data = x;
        next = null;

    }

}

public class GFG_LinkedList {

    public void recursiveLink(node head)

    {

        if(head==null)

            return;

        else

        {

            System.out.println(head.data);

            recursiveLink(head.next);

        }

    }

    public node insertbegin(node head, int data)

    {

        node temp = new node(data);

        temp.next = head;

        return temp;

    }

    public node insertend(node head, int data)

    {

        node temp = new node(data);

        if(head==null)

            return temp;

        node curr = head;

        while(curr.next!=null)

        {

            curr = curr.next;

        }

        curr.next = temp;

        return head;

    }

    public node insertmid(node head,int data,int index)

    {

        node temp = new node(data);

        int i=1;

        if(head==null)

            return temp;

        node curr = head;

        while(curr!=null)

        {

            if(i==index-1)

            {

                temp.next = curr.next;

                curr.next = temp;

                break;

            }

            i++; curr = curr.next;

        }

        return head;

    }

    public static void main(String[] args) {

        node head = new node(10);

        head.next = new node(20);

        head.next.next = new node(30);

        head.next.next.next = new node(40);

        GFG_LinkedList test = new GFG_LinkedList();

        head = test.insertbegin(head,0);

        head = test.insertend(head,50);

        head = test.insertmid(head,15,3);

        test.recursiveLink(head);

    }

}
