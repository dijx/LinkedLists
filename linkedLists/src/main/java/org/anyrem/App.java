package org.anyrem;

import org.anyrem.linkedList.LinkedList;

public class App {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
/*

        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);

        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        linkedList.prepend(7);
*/

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.prepend(4);
        linkedList.prepend(5);
        linkedList.prepend(6);

        System.out.println(linkedList.toString());

        System.out.println(linkedList.get(0).data);
        System.out.println(linkedList.get(4).data);
        System.out.println(linkedList.get(5).data);
        System.out.println(linkedList.get(12).data);


    }
}
