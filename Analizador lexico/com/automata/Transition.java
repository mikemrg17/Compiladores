package com.automata;

public class Transition {
    public char lowerSymbol;
    public char upperSymbol;
    public State state; //State where the transition arrives
    
    //Constructors
    public Transition(){
        state = null;
    }
    
    public Transition(char symbol, State state){
        lowerSymbol = symbol;
        upperSymbol = symbol;
        this.state = state;
    }
    
    public Transition(char lowerSymbol, char upperSymbol, State state){
        this.lowerSymbol = lowerSymbol;
        this.upperSymbol = upperSymbol;
        this.state = state;
    }
    
    //Getter and Setter functions
    public void setTransition(char symbol, State state){
        lowerSymbol = symbol;
        upperSymbol = symbol;
        this.state = state;
    }
    
    public void setTransition(char lowerSymbol, char upperSymbol, State state){
        this.lowerSymbol = lowerSymbol;
        this.upperSymbol = upperSymbol;
        this.state = state;
    }
    
    public char getLowerSymbol(){
        return lowerSymbol;
    }
    
    public char getUpperSymbol(){
        return upperSymbol;
    }
    
    public State getState(char symbol){
        if(lowerSymbol <= symbol && symbol <= upperSymbol)
            return state;
        
        return null;
    }
}
