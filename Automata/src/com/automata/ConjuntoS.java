package com.automata;

import java.util.Arrays;
import java.util.HashSet;

//Equivalente a clase ConjIJ
public class ConjuntoS { //Esta clase sirve para poder guardar los estados del AFD
    private static HashSet<ConjuntoS> conjuntos_s = new HashSet<ConjuntoS>();
    public HashSet<Estado> estados = new HashSet<Estado>();
    public int id;
    public static int contador_conjuntos_s = 0;
    public boolean es_de_aceptacion = false;
    public int[] transiciones = new int[256];
    
    //CONSTRUCTORES
    public ConjuntoS(){
        id = contador_conjuntos_s++;
        estados.clear();
        es_de_aceptacion = false;
        conjuntos_s.add(this);
        Arrays.fill(transiciones, -1);
    }
    
    public ConjuntoS(HashSet<Estado> estados){
        id = contador_conjuntos_s++;
        this.estados = estados;
        es_de_aceptacion = false;
        conjuntos_s.add(this);
        Arrays.fill(transiciones, -1);
    }
    
    public void SetTransicion(char simbolo, Estado estado){
        transiciones[(int)simbolo] = estado.id;
    }
    
    public void setToken(int token){
        transiciones[255] = token;
    }
    
}
