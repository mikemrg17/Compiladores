/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automata;

import static java.lang.Integer.parseInt;
import java.util.Stack;

/**
 *
 * @author alan
 */
public class AnalizadorLexico {
    public int token, EdoActual, EdoTransicion;
    public String CadenaSigma;
    public String Lexema;
    public boolean PasoPorEdoAcept;
    public int IniLexema, FinLexema, IndiceCaracterActual;
    public char CaracterActual;
    Stack<Integer> Pila = new Stack<Integer>();
    AFD AutomataFD;
    String[][] AFD;

    public AnalizadorLexico() {
        CadenaSigma = "";
        PasoPorEdoAcept = false;
        IniLexema = FinLexema = -1;
        IndiceCaracterActual = -1;
        token = -1;
        Pila.clear();
        AutomataFD = null;
    }
                                              //archivo AFD
        public AnalizadorLexico(String sigma, String[][] AFD) {
        AutomataFD = new AFD();
        CadenaSigma = sigma;
        PasoPorEdoAcept = false;
        IniLexema = 0;
        FinLexema = -1;
        IndiceCaracterActual = 0;
        token = -1;
        Pila.clear();
        AFD = AFD;
        
    }
    
    public ClassEstadoAnalizLexico GetEdoAnalizLexico(){
        ClassEstadoAnalizLexico EdoActualAnaliz = new ClassEstadoAnalizLexico();
        EdoActualAnaliz.CaracterActual = CaracterActual;
        EdoActualAnaliz.EdoActual = EdoActual;
        EdoActualAnaliz.EdoTransicion = EdoTransicion;
        EdoActualAnaliz.FinLexema = FinLexema;
        EdoActualAnaliz.IndiceCaracterActual = IndiceCaracterActual;
        EdoActualAnaliz.IniLexema = IniLexema;
        EdoActualAnaliz.Lexema = Lexema;
        EdoActualAnaliz.PasoPorEdoAcept = PasoPorEdoAcept;
        EdoActualAnaliz.token = token;
        EdoActualAnaliz.Pila = Pila;
        return EdoActualAnaliz;
    }
    
    public boolean SetEdoAnalizLexico(ClassEstadoAnalizLexico e){
        CaracterActual = e.CaracterActual;
        EdoActual = e.EdoActual;
        EdoTransicion = e.EdoTransicion;
        FinLexema = e.FinLexema;
        IndiceCaracterActual = e.IndiceCaracterActual;
        IniLexema = e.IniLexema;
        Lexema = e.Lexema;
        PasoPorEdoAcept = e.PasoPorEdoAcept;
        token = e.token;
        Pila = e.Pila;
        return true;
    }
    
    public void SetSigma(String sigma){
        CadenaSigma = sigma;
        PasoPorEdoAcept = false;
        IniLexema = 0;
        FinLexema = -1;
        IndiceCaracterActual = 0;
        token = -1;
        Pila.clear();
    }
    
    public int yylex(){
        while(true){
            Pila.push(IndiceCaracterActual);
            if (IndiceCaracterActual >= CadenaSigma.length()){
                Lexema = "";
                return SimbolosEspeciales.FIN;
            }
            IniLexema = IndiceCaracterActual;
            EdoActual = 0;
            PasoPorEdoAcept = false;
            FinLexema = -1;
            token = -1;
            while(IndiceCaracterActual < CadenaSigma.length()){
                CaracterActual = CadenaSigma.charAt(IndiceCaracterActual);
                EdoTransicion = parseInt(AFD[EdoActual][CaracterActual]);
                if (EdoTransicion != -1){
                    if (parseInt(AFD[EdoActual][256]) != -1){
                        PasoPorEdoAcept = true;
                        token = parseInt(AFD[EdoActual][256]);
                        FinLexema = IndiceCaracterActual;
                    }
                    IndiceCaracterActual++;
                    EdoActual = EdoTransicion;
                    continue;
                }
                break;
            }   //No hay transicion del estado actual con el caracter actual
            if (!PasoPorEdoAcept){
                IndiceCaracterActual = IniLexema + 1;
                Lexema = CadenaSigma.substring(IniLexema, 1);
                token = SimbolosEspeciales.ERROR;
                return token; //ERROR
            }
            //No hay transicion el caracter actual, pero ya se habia pasado por estado de aceptacion
            Lexema = CadenaSigma.substring(IniLexema,(FinLexema-IniLexema+1));
            IndiceCaracterActual = FinLexema + 1;
            if (token == SimbolosEspeciales.OMITIR) //Omite espacios
                continue;
            else
                return token;
        }   
    }
    
    public boolean undoToken(){
        //En la pila irá guardando la posición donde se inicia el análsisi de un nuevo lexema.
        if (Pila.size() == 0)
            return false;
        IndiceCaracterActual = Pila.pop(); 
        return true;
    }
}
