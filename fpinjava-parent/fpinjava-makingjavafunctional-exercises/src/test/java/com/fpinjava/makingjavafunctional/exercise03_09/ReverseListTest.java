package com.fpinjava.makingjavafunctional.exercise03_09;

import static org.junit.Assert.*;
import static com.fpinjava.makingjavafunctional.exercise03_09.ReverseList.*;

import org.junit.Test;

public class ReverseListTest {
  @Test
  public void testPrepend() {
    assertEquals("[0, 1, 2, 3]", prepend("0", list("1", "2", "3")).toString());
    assertEquals("[0]", prepend("0", list()).toString());
  }

  @Test
  public void testReverse() {
    assertEquals("[]", reverse(list()).toString());
    assertEquals("[1]", reverse(list(1)).toString());
    assertEquals("[3, 2, 1]", reverse(list(1, 2, 3)).toString());
  }

  @Test
  public void testReverse2Append() {
    assertEquals("[]", reverse2Append(list()).toString());
    assertEquals("[1]", reverse2Append(list(1)).toString());
    assertEquals("[3, 2, 1]", reverse2Append(list(1, 2, 3)).toString());
  }
}
