package com.automata;

import java.util.HashSet;

public class State {
    static int stateIDCounter = 0;
    public int id; //State ID
    public boolean isAcceptance;
    public int token;
    public HashSet<Transition> transitions = new HashSet<Transition>();
    
    //Constructor
    public State(){
        isAcceptance = false;
        token = -1;
        id = stateIDCounter++;
        transitions.clear();
    }
    
    //Getters and Setters functions
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public boolean getIsAcceptance(){
        return isAcceptance;
    }
    
    public void setIsAcceptance(boolean isAcceptance){
        this.isAcceptance = isAcceptance;
    }
    
    public int getToken(){
        return token;
    }
    
    public void setToken(int token){
        this.token = token;
    }
    
    public HashSet<Transition> getTransitions(){
        return transitions;
    }
    
    public void setTransitions(HashSet<Transition> transitions){
        this.transitions = transitions;
    }
    
    
}
