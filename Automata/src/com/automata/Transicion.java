package com.automata;

public class Transicion {
    public char simbolo_inferior;
    public char simbolo_superior;
    public Estado estado_destino; //Estado al cual la transición llega
    
    //Constructores
    public Transicion(){ //Transición vacía
        estado_destino = null;
    }
    
    public Transicion(char symbol, Estado estado){ //Transición con símbolo y estado destino
        simbolo_inferior = symbol;
        simbolo_superior = symbol;
        this.estado_destino = estado;
    }
    
    public Transicion(char simbolo_inferior, char simbolo_superior, Estado estado){ //Transicion con rango de símbolos y estado destino
        this.simbolo_inferior = simbolo_inferior;
        this.simbolo_superior = simbolo_superior;
        this.estado_destino = estado;
    }
    
    //Funciones Getter y Setter (SIN USO YA QUE LAS LAS VARIABLES SON PÚBLICAS)
    public void setTransicion(char simbolo, Estado estado){
        simbolo_inferior = simbolo;
        simbolo_superior = simbolo;
        this.estado_destino = estado;
    }
    
    public void setTransicion(char simbolo_inferior, char simbolo_superior, Estado estado){
        this.simbolo_inferior = simbolo_inferior;
        this.simbolo_superior = simbolo_superior;
        this.estado_destino = estado;
    }
    
    public char getSimboloInferior(){
        return simbolo_inferior;
    }
    
    public char getSimboloSuperior(){
        return simbolo_superior;
    }
    
    public Estado getEstadoDestino(char simbolo){
        if(simbolo_inferior <= simbolo && simbolo <= simbolo_superior)
            return estado_destino;
        
        return null;
    }
}
