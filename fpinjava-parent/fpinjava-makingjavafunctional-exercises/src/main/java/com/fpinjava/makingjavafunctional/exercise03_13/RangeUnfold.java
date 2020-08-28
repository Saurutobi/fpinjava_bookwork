package com.fpinjava.makingjavafunctional.exercise03_13;

import com.fpinjava.common.Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeUnfold {
    private static <T> List<T> copy(List<T> ts) {
        return new ArrayList<>(ts);
    }

    public static <T> List<T> append(List<T> list, T t) {
        List<T> ts = copy(list);
        ts.add(t);
        return Collections.unmodifiableList(ts);
    }

    public static <T> List<T> unfold(T seed,
                                     Function<T, T> f,
                                     Function<T, Boolean> p) {
        List<T> result = new ArrayList<>();
        T temp = seed;
        while (p.apply(temp)) {
            result = append(result, temp);
            temp = f.apply(temp);
        }
        return result;
    }

    public static List<Integer> range(int start, int end) {
        return unfold(start, x -> x + 1, x -> x < end);
    }
}
