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

        if (size == 0) {

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

    public boolean removeFirst() {

        if (size > 0) {
            header.next = header.next.next;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeLast() {

        boolean ret = false;
        Node n = header;

        while (n != null) {

            Node temp = n;
            n = n.next;

            if (n == lastNode) {
                lastNode = temp;
                lastNode.next = null;
                size--;
                ret = true;
            }
        }
        return ret;
    }

    public Node get(int number) {

        Node nodeNr = header;
        int counter = 0;

        while (counter <= number && number < size) {
            nodeNr = nodeNr.next;
            counter++;
        }

        return nodeNr;
    }

    public int getSize() {
        return size;
    }

    public String toString() {

        Node n = header.next;
        String ret = size + "::[ ";
        while (n != null) {
            ret += n.data + " ";
            n = n.next;
        }
        ret += "]";
        return ret;
    }

}
