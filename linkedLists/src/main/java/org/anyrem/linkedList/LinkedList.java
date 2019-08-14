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


    public boolean instertAt(int position, int data) {

        Node newNode = new Node(data);

        if (position == 0) {

            newNode.next = header.next;
            header.next = newNode;
            size++;

            return true;

        } else if (position == size) {

            append(data);

            return true;

        } else if (position > 0 && position < size ) {

            Node prev = get(position -1);
            Node next = get(position);

            prev.next = newNode;
            newNode.next = next;
            size++;

            return true;

        }

        throw new RuntimeException("index out of bounds");
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

    public boolean removeAt(int position) {

        if (position == 0) {

            removeFirst();

        } else if (position == size -1) {

            removeLast();

        } else if (position > 0 && position < size - 1) {

            get(position -1).next = get(position + 1);
            size--;

            return true;
        }

        throw new RuntimeException("index out of bounds");
    }


    public Node get(int number) {

        if (number == size - 1) {

            return lastNode;

        } else if (number >= size || number < 0) {

            throw new RuntimeException("index out of bound");

        } else {

            Node nodeNr = header;
            int counter = 0;

            while (counter <= number && number < size) {
                nodeNr = nodeNr.next;
                counter++;
            }
            return nodeNr;
        }
    }

    public int getData(int position) {

        return get(position).data;
    }

    public int size() {
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
