    package com.automata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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
    
    public void ordenarEstados() { //Vamos a usar la clase Comparator para poder ordenar los estados
        List<Estado> estados_a_ordenar = new ArrayList<Estado>(this.estados);
        estados_a_ordenar.sort(new OrdenarEstados());
        HashSet<Estado> estados_ordenados = new HashSet<Estado>(estados_a_ordenar);
        this.estados = estados_ordenados;
    }
    
    public static void eliminarConjunto(ConjuntoS conjunto_a_eliminar) {
        conjuntos_s.remove(conjunto_a_eliminar);
    }
    
    public HashSet<Estado> getEstados() {
        return this.estados;
    }
    
}
