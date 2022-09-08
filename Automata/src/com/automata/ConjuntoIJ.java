package com.automata;

import java.util.HashSet;

public class ConjuntoIJ {
    public int j;
    public HashSet<Estado> conjunto_ij;
    public int[] transiciones_afd;
    
    //Constructor
    public ConjuntoIJ(int cardinalidad_alfabeto){
        j = -1;
        conjunto_ij = new HashSet<Estado>();
        conjunto_ij.clear();
        transiciones_afd = new int[cardinalidad_alfabeto + 1];
        for(int i = 0; i < cardinalidad_alfabeto; i++){
            transiciones_afd[i] = -1;
        }
    }
    
}
