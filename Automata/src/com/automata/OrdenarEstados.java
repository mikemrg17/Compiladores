package com.automata;

import java.util.Comparator;

public class OrdenarEstados implements Comparator<Estado> {
    @Override
    public int compare(Estado estado1, Estado estado2) {
        return Integer.valueOf(estado1.id).compareTo(Integer.valueOf(estado2.id));
    }
}
