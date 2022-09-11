package com.automata;

import java.util.HashSet;

public class AFD {
    static HashSet<AFD> conjunto_afd = new HashSet<AFD>();
    static int contador_afd = 0;
    public HashSet<ConjuntoS> estados = new HashSet<ConjuntoS>();
    public int id;
    HashSet<Character> alfabeto = new HashSet<Character>();
    HashSet<ConjuntoS> conjuntos_aceptacion = new HashSet<ConjuntoS>();
    ConjuntoS conjunto_inicial = new ConjuntoS();

    
    public AFD(){
        id = contador_afd++;
        conjunto_inicial = null;
        estados.clear();
        alfabeto.clear();
        conjuntos_aceptacion.clear();
        conjunto_afd.add(this);
    }
}
