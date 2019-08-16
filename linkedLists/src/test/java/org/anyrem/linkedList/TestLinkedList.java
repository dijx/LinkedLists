package org.anyrem.linkedList;

import org.anyrem.linkedList.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;


/**
 * Unit test for simple App.
 */
public class TestLinkedList {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private static LinkedList linkedList = new LinkedList();

    @Test
    @DisplayName("Prepend and append test")
    public void prependAppendTest() {

        linkedList = new LinkedList();

        linkedList.prepend(0);
        Assertions.assertThat(linkedList.getData(0))
                .isEqualTo(0);


        linkedList.prepend(1);

        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.getData(0))
                .isEqualTo(1);

        Assertions.assertThat(linkedList.getData(1))
                .isEqualTo(0);

        Assertions.assertThatThrownBy(() -> linkedList.getData(2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("index out of bounds");

        linkedList.append(2);

        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.getData(2))
                .isEqualTo(2);

        linkedList.insertAt(1,3);

        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.getData(2))
                .isEqualTo(0);

        Assertions.assertThat(linkedList.size())
                .isEqualTo(4);

        Assertions.assertThatThrownBy(() -> linkedList.insertAt(5,4))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("index out of bounds");

    }

    @Test
    @DisplayName("Insert test")
    public void insertTest() {

        linkedList = new LinkedList();

        for (int i = 0; i < 11 ; i++) {

            linkedList.insertAt(i, i);
        }

        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.size()).isEqualTo(11);

        linkedList.insertAt(5,12);

        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.getData(4)).isEqualTo(4);
        Assertions.assertThat(linkedList.getData(5)).isEqualTo(12);
        Assertions.assertThat(linkedList.getData(6)).isEqualTo(5);
        Assertions.assertThat(linkedList.getData(7)).isEqualTo(6);
        Assertions.assertThat(linkedList.getData(11)).isEqualTo(10);
        Assertions.assertThat(linkedList.size()).isEqualTo(12);

        Assertions.assertThatThrownBy(() -> linkedList.getData(12))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("index out of bounds");

    }

    @Test
    @DisplayName("Remove test")
    public void removeTest() {

        linkedList = new LinkedList();

        for (int i = 0; i < 11; i++) {

            linkedList.insertAt(i, i);
        }

        logger.info(linkedList.toString());

        linkedList.removeLast();
        linkedList.removeFirst();

        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.size()).isEqualTo(9);
        Assertions.assertThat(linkedList.getData(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getData(linkedList.size()-1)).isEqualTo(9);

        linkedList.removeAt(3);
        logger.info(linkedList.toString());

        Assertions.assertThat(linkedList.size()).isEqualTo(8);
        Assertions.assertThat(linkedList.getData(3)).isEqualTo(5);
        Assertions.assertThat(linkedList.getData(7)).isEqualTo(9);

        Assertions.assertThatThrownBy(() -> linkedList.get(8))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("index out of bounds");
    }

}
