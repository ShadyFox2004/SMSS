package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MomentTest {
    @Test
    public void testAdd() {
        Moment moment = new Moment(new Vector(1, 1), 1);
        String expected = "Moment [angular=" + 2.0 + ", linear=" + new Vector(2, 2) + "]";
        String actual = moment.add(moment).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testScalar() {
        Moment moment = new Moment(new Vector(1, 1), 1);
        String expected = "Moment [angular=" + 2.0 + ", linear=" + new Vector(2, 2) + "]";
        String actual = moment.scalar(2).toString();

        assertEquals(expected, actual);
    }
}
