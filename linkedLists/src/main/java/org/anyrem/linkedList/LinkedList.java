package org.anyrem.linkedList;

public class LinkedList {

    private Node header;
    private Node lastNode;
    private int size;

    public LinkedList() {
        header = new Node(null);
        lastNode = header;
    }

    public void prepend(Integer data) {

        Node n = new Node(data);

        if(size == 0) {

            header.next = n;
            lastNode = n;
//            size++;

        } else {

            Node temp = header.next;
            header.next = n;
            n.next = temp;
//            size++;
        }

        size++;
    }

    public void append(Integer data) {

        Node n = new Node(data);
        lastNode.next = n;
        lastNode = n;
        size++;
    }

    public int getSize() {
        return size;
    }

    public String toString() {

        Node n = header.next;
        String ret = "";
        while (n != null) {
            ret += n.data + " ";
            n = n.next;
        }
     return  ret;
    }

}
