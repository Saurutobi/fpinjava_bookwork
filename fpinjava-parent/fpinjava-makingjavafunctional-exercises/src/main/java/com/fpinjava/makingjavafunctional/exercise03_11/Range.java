package com.fpinjava.makingjavafunctional.exercise03_11;

import com.fpinjava.common.Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Range {
    static Function<Integer, Integer> add1 = x -> x + 1;

    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    private static <T> List<T> copy(List<T> ts) {
        return new ArrayList<>(ts);
    }

    public static <T> List<T> append(List<T> list, T t) {
        List<T> ts = copy(list);
        ts.add(t);
        return Collections.unmodifiableList(ts);
    }

    public static List<Integer> range(int start, int end) {

        //foldLeftModified(list(), list(), add1);

        List<Integer> result = list();
        for (int i = start; i <= end; i++) {
            append(result, add1.apply(i));
        }
        return result;
    }
}
