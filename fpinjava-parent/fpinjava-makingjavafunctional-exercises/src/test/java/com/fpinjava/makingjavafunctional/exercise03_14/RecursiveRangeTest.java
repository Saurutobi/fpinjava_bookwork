package com.fpinjava.makingjavafunctional.exercise03_14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursiveRangeTest {
    @Test
    public void testRange() {
        assertEquals("[]", RecursiveRange.range(0, 0).toString());
        assertEquals("[0]", RecursiveRange.range(0, 1).toString());
        assertEquals("[0, 1, 2, 3, 4]", RecursiveRange.range(0, 5).toString());
        assertEquals("[]", RecursiveRange.range(5, 1).toString());
    }
}
