package com.automata;

import java.util.HashSet;

public class Estado {
    static int contador_estados = 0; //Nos sirve para poder definir IDs únicos
    public int id;
    public boolean de_aceptacion; //Bandera para saber si el estado es de aceptación
    public int token;
    public HashSet<Transicion> transiciones = new HashSet<Transicion>(); //Conjunto de transiciones del estado
    public static HashSet<Integer> tokens = new HashSet<Integer>();
    public static int contador_tokens = 1;
    
    //Constructor
    public Estado(){
        de_aceptacion = false;
        token = -1;
        id = contador_estados++;
        transiciones.clear();
    }
    
    //Funciones getter y setter (SIN USO YA QUE LAS VARIABLES SON PÚBLICAS)
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public boolean getDeAceptacion(){
        return de_aceptacion;
    }
    
    public void setDeAceptacion(boolean DeAceptacion){
        this.de_aceptacion = DeAceptacion;
    }
    
    public int getToken(){
        return token;
    }
    
    public void setToken(int token){
        this.token = token;
    }
    
    public HashSet<Transicion> getTransiciones(){
        return transiciones;
    }
    
    public void setTransiciones(HashSet<Transicion> transiciones){
        this.transiciones = transiciones;
    }
    
    
}
