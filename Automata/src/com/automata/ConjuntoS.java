package com.automata;

import java.util.HashSet;

//Equivalente a clase ConjIJ
public class ConjuntoS { //Esta clase sirve para poder guardar los estados del AFD
    public static HashSet<ConjuntoS> conjuntos_s = new HashSet<ConjuntoS>();
    public HashSet<Estado> estados = new HashSet<Estado>();
    public int id;
    static int contador_conjuntos_s = 0;
    public boolean es_de_aceptacion = false;
    
    //CONSTRUCTORES
    public ConjuntoS(){
        id = contador_conjuntos_s++;
        estados.clear();
        es_de_aceptacion = false;
        conjuntos_s.add(this);
    }
    
    public ConjuntoS(HashSet<Estado> estados){
        id = contador_conjuntos_s++;
        estados = estados;
        es_de_aceptacion = false;
        conjuntos_s.add(this);
    }
    
}
