/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automata;

import java.util.Stack;

/**
 *
 * @author alan
 */
public class ClassEstadoAnalizLexico {
    public int token, EdoActual, EdoTransicion;
    public String CadenaSigma;
    public String Lexema;
    public boolean PasoPorEdoAcept;
    public int IniLexema, FinLexema, IndiceCaracterActual;
    public char CaracterActual;
    Stack<Integer> Pila = new Stack<Integer>();

    public ClassEstadoAnalizLexico() {
    }

    public ClassEstadoAnalizLexico(int token, int EdoActual, int EdoTransicion, String CadenaSigma, String Lexema, boolean PasoPorEdoAcept, int IniLexema, int FinLexema, int IndiceCaracterActual, char CaracterActual) {
        this.token = token;
        this.EdoActual = EdoActual;
        this.EdoTransicion = EdoTransicion;
        this.CadenaSigma = CadenaSigma;
        this.Lexema = Lexema;
        this.PasoPorEdoAcept = PasoPorEdoAcept;
        this.IniLexema = IniLexema;
        this.FinLexema = FinLexema;
        this.IndiceCaracterActual = IndiceCaracterActual;
        this.CaracterActual = CaracterActual;
    }
    
    
}