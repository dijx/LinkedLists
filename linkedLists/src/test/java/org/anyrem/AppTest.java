package org.anyrem;

import static org.junit.Assert.assertTrue;
import jdk.jfr.Name;
import org.anyrem.linkedList.LinkedList;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;



/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private LinkedList linkedList = new LinkedList();

    @Test
    @DisplayName("Prepend single element")
    public void prependFirst() {

        linkedList.prepend(0);
        Assertions.assertThat(0 == linkedList.getData(0));

    }

    @Test
    @DisplayName("Prepend second element")
    public void prependSecond() {

        linkedList.prepend(1);
        Assertions.assertThat(1 == linkedList.getData(0));
        Assertions.assertThat(0 == linkedList.getData(1));
        Assertions.assertThatThrownBy(() -> linkedList.getData(2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("index out of bound");
    }



}
