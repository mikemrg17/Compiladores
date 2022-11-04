package com.automata;

import java.util.HashSet;

public class AFD {
    public static HashSet<AFD> conjunto_afd = new HashSet<AFD>(); //Conjunto que guarda todos los AFD
    static int contador_afd = 0; //Contador para saber cuántos AFD hay y asignar ID
    public HashSet<ConjuntoS> estados = new HashSet<ConjuntoS>(); //Conjunto de estados S propios del AFD
    public int id;
    HashSet<Character> alfabeto = new HashSet<Character>();
    HashSet<ConjuntoS> conjuntos_aceptacion = new HashSet<ConjuntoS>(); //Conjunto de estados S que son de aceptación
    ConjuntoS conjunto_inicial = new ConjuntoS(); //S0

    public AFD(){
        id = contador_afd++;
        conjunto_inicial = null;
        estados.clear();
        alfabeto.clear();
        conjuntos_aceptacion.clear();
        conjunto_afd.add(this);
    }
}
