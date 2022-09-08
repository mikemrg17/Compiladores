package com.automata;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.ListIterator;
import java.util.ArrayList;

public class NFA {
    public static HashSet<NFA> nfaSet = new HashSet<NFA>();
    State initialState;
    HashSet<State> states = new HashSet<State>();
    HashSet<State> acceptanceStates = new HashSet<State>();
    HashSet<Character> alphabet = new HashSet<Character>();
    boolean nfaAdded;
    public int id;
    public char epsilon = '\u0000';
    
    //Constructors
    public NFA(){
        id = 0;
        initialState = null;
        states.clear();
        acceptanceStates.clear();
        alphabet.clear();
        nfaAdded = false;
    }
    
    //Functions
    public NFA createBasicNFA(char symbol){
        Transition transition;
        State state1, state2;
        state1 = new State();
        state2 = new State();
        transition = new Transition(symbol, state2);
        state1.transitions.add(transition);
        state2.isAcceptance = true;
        alphabet.add(symbol);
        initialState = state1;
        states.add(state1);
        states.add(state2);
        acceptanceStates.add(state2);
        id = nfaSet.size();
        
        if(nfaSet.add(this)){
            System.out.println("Automata básico agregado ");
        }
        nfaAdded = true;
        printAutomata(this);
        return this;
    }
    
    public NFA createBasicNFA(char lowerSymbol, char upperSymbol){
        char validation; //lowerSymbol <= upperSymbol
        Transition transition;
        State state1, state2;
        state1 = new State();
        state2 = new State();
        transition = new Transition(lowerSymbol, upperSymbol, state2);
        state1.transitions.add(transition);
        state2.isAcceptance = true;
        
        for(validation = lowerSymbol; validation <= upperSymbol; validation++){
            alphabet.add(validation);
        }
        
        initialState = state1;
        states.add(state1);
        states.add(state2);
        acceptanceStates.add(state2);
        id = nfaSet.size();
        if(nfaSet.add(this)){
            System.out.println("Automata básico agregado ");
        }
        nfaAdded = true;
        printAutomata(this);
        return this;
    }
    
    public NFA mergeNFA(NFA NFA2){
        State state1 = new State();
        State state2 = new State();
        //state1 will have 2 epsilon transitions; one to this NFA initial state and the other one to the initial state of NFA2
        Transition transition1 = new Transition(epsilon, this.initialState);
        Transition transition2 = new Transition(epsilon, NFA2.initialState);
        state1.transitions.add(transition1);
        state1.transitions.add(transition2);
        this.initialState = state1;
        //Now every acceptance state of this and NFA2 will have an epsilon transition to the new state
        //Those who were acceptance states of this, they won't be anymore
        //Those who were aceeptance states of NFA2, they won't be anymore
        for(State state: this.acceptanceStates){
            state.transitions.add(new Transition(epsilon, state2));
            state.isAcceptance = false;
        }
        
        for(State state: NFA2.acceptanceStates){
            state.transitions.add(new Transition(epsilon, state2));
            state.isAcceptance = false;
        }
        
        state2.isAcceptance = true;
        this.acceptanceStates.clear();
        this.acceptanceStates.add(state2);
        
        this.states.addAll(NFA2.states);
        
        this.states.add(state1);
        this.states.add(state2);
        
        this.alphabet.addAll(NFA2.alphabet);
        System.out.println("AFNs unidos correctamente");
        printAutomata(this);
        return this;
    }
    
    public NFA concatenateNFA(NFA NFA2){
        List<State> nfa_states = new ArrayList<State>(this.states);
        
        
        ListIterator<State> states_iterator = nfa_states.listIterator();
        while(states_iterator.hasNext()){
            State state = states_iterator.next();
            List<Transition> state_transitions = new ArrayList<Transition>(state.transitions);
            
            ListIterator<Transition> transitions_iterator = state_transitions.listIterator();
            while(transitions_iterator.hasNext()){
                Transition transition = transitions_iterator.next();
                if(transition.state.isAcceptance == true){
                    if(transition.lowerSymbol != transition.upperSymbol){
                        state.transitions.add(new Transition(transition.lowerSymbol, transition.upperSymbol, NFA2.initialState));
                    }else{
                        state.transitions.add(new Transition(transition.lowerSymbol, NFA2.initialState));
                    }
                    state.transitions.remove(transition);
                    this.states.remove(transition.state);
                }
            }
        }
        
        this.states = new HashSet<State>(nfa_states);
        NFA2.initialState.isAcceptance = false;
        //this.states.remove(absorbed_state);
        
        this.acceptanceStates.clear();
        this.acceptanceStates.addAll(NFA2.acceptanceStates);
        this.states.addAll(NFA2.states);
        this.alphabet.addAll(NFA2.alphabet);
        System.out.println("AFNs concatenados");
        printAutomata(this);
        return this;
    }
    
    public NFA kleenClosure(NFA nfa){
        State state1 = new State();
        State state2 = new State();
        
        state1.transitions.add(new Transition(epsilon, nfa.initialState));
        state1.transitions.add(new Transition(epsilon, state2));
        
        for(State state: nfa.states){
            if(state.isAcceptance){
                state.transitions.add(new Transition(epsilon, nfa.initialState));
                state.transitions.add(new Transition(epsilon, state2));
                state.isAcceptance = false;
            }
        }
        
        state2.isAcceptance = true;
        
        nfa.initialState = state1;
        
        nfa.acceptanceStates.clear();
        nfa.acceptanceStates.add(state2);
        
        nfa.states.add(state1);
        nfa.states.add(state2);
        
        System.out.println("Cerradura de Kleen aplicada");
        printAutomata(this);
        return this;
    }
    
    public NFA transitiveClosure(NFA nfa){
        State state1 = new State();
        State state2 = new State();
        
        state1.transitions.add(new Transition(epsilon, nfa.initialState));
        
        for(State state: nfa.states){
            if(state.isAcceptance){
                state.transitions.add(new Transition(epsilon, nfa.initialState));
                state.transitions.add(new Transition(epsilon, state2));
                state.isAcceptance = false;
            }
        }
        
        state2.isAcceptance = true;
        
        nfa.initialState = state1;
        
        nfa.acceptanceStates.clear();
        nfa.acceptanceStates.add(state2);
        
        nfa.states.add(state1);
        nfa.states.add(state2);
        
        System.out.println("Cerradura transitiva aplicada");
        printAutomata(this);
        return this;
    }
    
    public NFA optional(NFA nfa){
        State state1 = new State();
        State state2 = new State();
        
        state1.transitions.add(new Transition(epsilon, nfa.initialState));
        state1.transitions.add(new Transition(epsilon, state2));
        
        for(State state: nfa.states){
            if(state.isAcceptance){
                state.transitions.add(new Transition(epsilon, state2));
                state.isAcceptance = false;
            }
        }
        
        state2.isAcceptance = true;
        
        nfa.initialState = state1;
        
        nfa.acceptanceStates.clear();
        nfa.acceptanceStates.add(state2);
        
        nfa.states.add(state1);
        nfa.states.add(state2);
        
        System.out.println("Opcional aplicada");
        printAutomata(this);
        return this;
    }
    
    public HashSet<State> epsilonClosure(State state){
        HashSet<State> reachedStates = new HashSet<State>();
        Stack<State> statesToAnalyze = new Stack<State>();
        State auxiliar, nextState;
        reachedStates.clear();
        statesToAnalyze.clear();
        
        statesToAnalyze.push(state);
        while(!statesToAnalyze.isEmpty()){
            auxiliar = statesToAnalyze.pop();
            reachedStates.add(auxiliar);
            for(Transition transition: auxiliar.transitions){
                if((nextState = transition.getState(epsilon)) != null)
                    if(!reachedStates.contains(nextState))
                        statesToAnalyze.push(nextState);
            }
        }
        
        return reachedStates;
    }
    
    public HashSet<State> move(State state, char symbol){
        HashSet<State> reachedStates = new HashSet<State>();
        State auxiliar;
        reachedStates.clear();
        
        for(Transition transition: state.transitions){
            auxiliar = transition.getState(symbol);
            if(auxiliar != null)
                reachedStates.add(auxiliar);
        }
        
        return reachedStates;
    }
    
    public HashSet<State> move(HashSet<State> states, char symbol){
        HashSet<State> reachedStates = new HashSet<State>();
        State auxiliar;
        reachedStates.clear();
        
        for(State state: states){
            for(Transition transition: state.transitions){
                auxiliar = transition.getState(symbol);
                if(auxiliar != null)
                    reachedStates.add(auxiliar);
            }
        }
        
        return reachedStates;
    }
    
    //TODO: go_to function, convert from NFA to DFA, function to mergeNFAs
    /*public HashSet<State> go_to(HashSet<State> states, char symbol){
        HashSet<State> reachedStates = new HashSet<State>();
        reachedStates.clear();
        reachedStates = epsilonClosure(move(states, symbol));
        return reachedStates;
    }*/
    
    public void printAutomata(NFA nfa){
        System.out.println("NFA:");
        System.out.println("Id: " + nfa.id);
        System.out.println("Estados:");
        for(State state: nfa.states){
            System.out.println("\tId: " + state.id);
            System.out.println("\tEs de aceptación?: " +state.isAcceptance);
            System.out.println("\tTransiciones:");
            for(Transition transition: state.transitions){
                System.out.println("\t\tSímbolo inferior: " + transition.lowerSymbol);
                System.out.println("\t\tSímbolo superior: " + transition.upperSymbol);
                System.out.println("\t\tEstado destino");
                System.out.println("\t\t\tId: " + transition.state.id);
            }
        }
        System.out.println("Estado inicial:");
        System.out.println("\tId:" + nfa.initialState.id);
        System.out.println("Estados de aceptación:");
        for(State state: nfa.acceptanceStates){
            System.out.println("\tId: " + state.id);
        }
        System.out.printf("Alfabeto: {");
        for(Character symbol: nfa.alphabet){
            System.out.printf(symbol + ",");
        }
        System.out.printf("}\n");
        System.out.println("Ya está agregado al conjunto de NFA?: " + nfa.nfaAdded);
    }
    
    
}
