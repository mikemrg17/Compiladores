package com.automata;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class AFN {
    public static HashSet<AFN> conjunto_afn = new HashSet<AFN>(); //Almacena todos los AFNs creados
    Estado estado_inicial; //Estado incial del AFN
    HashSet<Estado> estados = new HashSet<Estado>(); //Conjunto de estados del AFN
    HashSet<Estado> estados_aceptacion = new HashSet<Estado>(); //Conjunto de estados de aceptación del AFN
    HashSet<Character> alfabeto = new HashSet<Character>();
    boolean afn_agregado; //Bandera para saber si el AFN ha sido agregado
    public int id; //Id de cada AFN
    public char epsilon = '\u0000'; //Caracter que representa a epsilon
    
    //CONSTRUCTORES
    public AFN(){ //Crea un AFN vacío
        id = 0;
        estado_inicial = null;
        estados.clear();
        estados_aceptacion.clear();
        alfabeto.clear();
        afn_agregado = false;
    }
    
    //FUNCIONES
    public AFN crearAFNBasico(char simbolo){ //Crea un AFN básico con solo un símbolo
        Transicion transicion;
        Estado estado1;
        Estado estado2;
        estado1 = new Estado();
        estado2 = new Estado();
        transicion = new Transicion(simbolo, estado2);
        estado1.transiciones.add(transicion);
        estado2.de_aceptacion = true;
        alfabeto.add(simbolo);
        estado_inicial = estado1;
        estados.add(estado1);
        estados.add(estado2);
        estados_aceptacion.add(estado2);
        id = conjunto_afn.size();
        
        if(conjunto_afn.add(this)){
            System.out.println("Automata básico agregado");
        }
        afn_agregado = true;
        imprimirAFN(this);
        return this;
    }
    
    public AFN crearAFNBasico(char simbolo_inferior, char simbolo_superior){ //Crea un AFN básico con un rango de símbolos
        char validacion; //simbolo_inferior <= simbolo_superior
        Transicion transicion;
        Estado estado1;
        Estado estado2;
        estado1 = new Estado();
        estado2 = new Estado();
        transicion = new Transicion(simbolo_inferior, simbolo_superior, estado2);
        estado1.transiciones.add(transicion);
        estado2.de_aceptacion = true;
        
        for(validacion = simbolo_inferior; validacion <= simbolo_superior; validacion++){
            alfabeto.add(validacion);
        }
        
        estado_inicial = estado1;
        estados.add(estado1);
        estados.add(estado2);
        estados_aceptacion.add(estado2);
        id = conjunto_afn.size();
        if(conjunto_afn.add(this)){
            System.out.println("Automata básico agregado ");
        }
        afn_agregado = true;
        imprimirAFN(this);
        return this;
    }
    
    public AFN unirAFN(AFN AFN2){
        Estado estado1 = new Estado();
        Estado estado2 = new Estado();
        //El estado1 tendrá 2 transiciones epsilon, una al estado inicial de this y la otra al estado inicla del AFN2
        Transicion transition1 = new Transicion(epsilon, this.estado_inicial);
        Transicion transition2 = new Transicion(epsilon, AFN2.estado_inicial);
        estado1.transiciones.add(transition1);
        estado1.transiciones.add(transition2);
        this.estado_inicial = estado1;
        //Ahora cada estado de aceptación de this y de AFN2 tendrá una nueva transición epsilon a estado2
        //Aquellos que son estados de aceptación de this, ya no lo serán
        //Aquellos que son estados de aceptación de AFN2, ya no lo serán
        for(Estado estado: this.estados_aceptacion){
            estado.transiciones.add(new Transicion(epsilon, estado2));
            estado.de_aceptacion = false;
        }
        
        for(Estado estado: AFN2.estados_aceptacion){
            estado.transiciones.add(new Transicion(epsilon, estado2));
            estado.de_aceptacion = false;
        }
        
        estado2.de_aceptacion = true;
        this.estados_aceptacion.clear();
        this.estados_aceptacion.add(estado2);
        
        this.estados.addAll(AFN2.estados);
        
        this.estados.add(estado1);
        this.estados.add(estado2);
        
        this.alfabeto.addAll(AFN2.alfabeto); //Juntamos el alfabeto de los automatas
        System.out.println("AFNs unidos correctamente");
        imprimirAFN(this);
        return this;
    }
    
    public AFN concatenarAFN(AFN AFN2){
        /* En esta operación necesitamos modificar los estados mientras iteramos, para esto vamos a usar List de ArrayList
        ya que si seguimos usando HashSet, no se podrá modificar durante la iteración */
        List<Estado> lista_estados = new ArrayList<Estado>(this.estados);
        ListIterator<Estado> iterador_estados = lista_estados.listIterator(); //Podríamos usar la iteración normal o usando un objeto Iterator
        while(iterador_estados.hasNext()){
            Estado estado = iterador_estados.next();
            List<Transicion> lista_transiciones = new ArrayList<Transicion>(estado.transiciones);
            
            ListIterator<Transicion> iterador_transiciones = lista_transiciones.listIterator();
            while(iterador_transiciones.hasNext()){
                Transicion transicion = iterador_transiciones.next();
                if(transicion.estado_destino.de_aceptacion == true){
                    if(transicion.simbolo_inferior != transicion.simbolo_superior){
                        estado.transiciones.add(new Transicion(transicion.simbolo_inferior, transicion.simbolo_superior, AFN2.estado_inicial));
                    }else{
                        estado.transiciones.add(new Transicion(transicion.simbolo_inferior, AFN2.estado_inicial));
                    }
                    estado.transiciones.remove(transicion);
                    this.estados.remove(transicion.estado_destino);
                }
            }
        }
        
        this.estados = new HashSet<Estado>(lista_estados);
        AFN2.estado_inicial.de_aceptacion = false;
        //this.states.remove(absorbed_state);
        
        this.estados_aceptacion.clear();
        this.estados_aceptacion.addAll(AFN2.estados_aceptacion);
        this.estados.addAll(AFN2.estados);
        this.alfabeto.addAll(AFN2.alfabeto);
        System.out.println("AFNs concatenados");
        imprimirAFN(this);
        return this;
    }
    
    public AFN cerraduraKleen(){
        Estado estado1 = new Estado();
        Estado estado2 = new Estado();
        
        estado1.transiciones.add(new Transicion(epsilon, this.estado_inicial));
        estado1.transiciones.add(new Transicion(epsilon, estado2));
        
        for(Estado state: this.estados){
            if(state.de_aceptacion){
                state.transiciones.add(new Transicion(epsilon, this.estado_inicial));
                state.transiciones.add(new Transicion(epsilon, estado2));
                state.de_aceptacion = false;
            }
        }
        
        estado2.de_aceptacion = true;
        
        this.estado_inicial = estado1;
        
        this.estados_aceptacion.clear();
        this.estados_aceptacion.add(estado2);
        
        this.estados.add(estado1);
        this.estados.add(estado2);
        
        System.out.println("Cerradura de Kleen aplicada");
        imprimirAFN(this);
        return this;
    }
    
    public AFN cerraduraTransitiva(){
        Estado estado1 = new Estado();
        Estado estado2 = new Estado();
        
        estado1.transiciones.add(new Transicion(epsilon, this.estado_inicial));
        
        for(Estado state: this.estados){
            if(state.de_aceptacion){
                state.transiciones.add(new Transicion(epsilon, this.estado_inicial));
                state.transiciones.add(new Transicion(epsilon, estado2));
                state.de_aceptacion = false;
            }
        }
        
        estado2.de_aceptacion = true;
        
        this.estado_inicial = estado1;
        
        this.estados_aceptacion.clear();
        this.estados_aceptacion.add(estado2);
        
        this.estados.add(estado1);
        this.estados.add(estado2);
        
        System.out.println("Cerradura transitiva aplicada");
        imprimirAFN(this);
        return this;
    }
    
    public AFN opcional(){
        Estado estado1 = new Estado();
        Estado estado2 = new Estado();
        
        estado1.transiciones.add(new Transicion(epsilon, this.estado_inicial));
        estado1.transiciones.add(new Transicion(epsilon, estado2));
        
        for(Estado state: this.estados){
            if(state.de_aceptacion){
                state.transiciones.add(new Transicion(epsilon, estado2));
                state.de_aceptacion = false;
            }
        }
        
        estado2.de_aceptacion = true;
        
        this.estado_inicial = estado1;
        
        this.estados_aceptacion.clear();
        this.estados_aceptacion.add(estado2);
        
        this.estados.add(estado1);
        this.estados.add(estado2);
        
        System.out.println("Opcional aplicada");
        imprimirAFN(this);
        return this;
    }
    
    public HashSet<Estado> cerraduraEpsilon(Estado estado){ //Cerradura epsilon para un estado
        HashSet<Estado> estados_alcanzables = new HashSet<Estado>();
        Stack<Estado> estados_por_analizar = new Stack<Estado>();
        
        estados_por_analizar.add(estado);
        
        while(!estados_por_analizar.isEmpty()){
            Estado estado_a_analizar = estados_por_analizar.pop();
            
            if(estados_alcanzables.contains(estado_a_analizar))
                continue;
            
            estados_alcanzables.add(estado_a_analizar);
            for(Transicion transicion: estado_a_analizar.transiciones){
                if(transicion.simbolo_inferior == epsilon)
                    estados_por_analizar.push(transicion.estado_destino);
            }
        }
        
        return estados_alcanzables;
    }
    
    public HashSet<Estado> cerraduraEpsilon(HashSet<Estado> estados){ //Cerradura epsilon para un conjunto de estados
        HashSet<Estado> estados_alcanzables = new HashSet<Estado>();
        Stack<Estado> estados_por_analizar = new Stack<Estado>();
        
        for(Estado estado: estados){
            estados_por_analizar.push(estado);
        }
        
        while(!estados_por_analizar.isEmpty()){
            Estado estado = estados_por_analizar.pop();
            
            if(estados_alcanzables.contains(estado))
                continue;
            
            estados_alcanzables.add(estado);
            for(Transicion transicion: estado.transiciones){
                if(transicion.simbolo_inferior == epsilon)
                    estados_por_analizar.push(transicion.estado_destino);
            }
        }
        
        return estados_alcanzables;
    }
    
    public HashSet<Estado> mover(HashSet<Estado> estados, char simbolo){
        HashSet<Estado> estados_alcanzables = new HashSet<Estado>();
        estados_alcanzables.clear();
        
        for(Estado estado: estados){
            for(Transicion transicion: estado.transiciones){
                if(simbolo >= transicion.simbolo_inferior && simbolo <= transicion.simbolo_superior)
                    estados_alcanzables.add(transicion.estado_destino);
            }
        }
        
        return estados_alcanzables;
    }
    
    public HashSet<Estado> ir_a(HashSet<Estado> estados, char simbolo){
        return cerraduraEpsilon(mover(estados, simbolo));
    }
    
    
    public AFD convertirAFNaAFD()throws IOException {
        //Variables para la escritura en archivo
        FileWriter fw = new FileWriter("tabla.txt", true);
        
        List<ConjuntoS> conjuntos_s = new ArrayList<ConjuntoS>(); //Conjunto de estados del AFD
        //Este conjunto de estados será el que se asignará a AFD.estados cuando se terminen de analizar todos los Sj
        
        AFD afd = new AFD(); //Se crea un nuevo AFD vacío
        ConjuntoS s0 = new ConjuntoS(); //Conjunto inicial S0
        Queue<ConjuntoS> conjuntos_por_analizar = new LinkedList<ConjuntoS>(); //Cola que guarda conjuntos por analizar
        
        //Paso 1. Calcular la cerradura epsilon del estado inicial
        s0.estados = cerraduraEpsilon(this.estado_inicial);
        
        //Vamos a ordenar los estados del conjunto S0 para realizar más fácil el saber si ya existe dentro de los conjuntos del AFD
        s0.ordenarEstados();
        
        System.out.println("Estados de S0: {");
        for(Estado estado: s0.estados){
            System.out.println("\tEstado: " + estado.id);
        }
        System.out.println("}");
        
        
        afd.conjunto_inicial = s0;
        conjuntos_por_analizar.add(s0);
        
        //Paso 2. Analizar el conjunto estados de Sj, debemos analizar Sj, con cada letra del alfabeto
        ConjuntoS conjunto_a_analizar = new ConjuntoS(); //Creamos una nueva instancia de ConjuntoS para guardar cada conjunto que vayamos analizando
        while(!conjuntos_por_analizar.isEmpty()){
            conjunto_a_analizar = conjuntos_por_analizar.poll(); //Sacamos el elemento de la cola
            
            //Cálculo de las operaciones Ir_A del conjunto a analizar con cada letra del alfabeto, para encontrar nuevos conjuntos S
            for(char simbolo: this.alfabeto){
                ConjuntoS nuevo_conjunto = new ConjuntoS();
                nuevo_conjunto.estados = ir_a(conjunto_a_analizar.estados, simbolo);
                nuevo_conjunto.ordenarEstados();
                
                if(nuevo_conjunto.estados.isEmpty()){
                    System.out.println("Se encontró un conjunto vacío, por lo que no se agrega");
                    ConjuntoS.contador_conjuntos_s--;
                    ConjuntoS.eliminarConjunto(nuevo_conjunto);
                    continue;
                }
                
                if(contieneConjunto(conjuntos_s, nuevo_conjunto.estados)){
                    System.out.println("El conjunto S ya ha sido analizado previamente");
                    ConjuntoS.contador_conjuntos_s--;
                    ConjuntoS.eliminarConjunto(nuevo_conjunto);
                    continue; //Si el conjunto ya ha sido analizado previamente, entonces lo salta y no lo agrega
                }
                
                //El conjunto no es repetido ni vacío, por lo que vamos a agregarlo a la cola para analizarlo posteriormente
                System.out.println("Se agrega nuevo conjunto S"); 
                conjuntos_por_analizar.offer(nuevo_conjunto);
                System.out.println("El conjunto S" + conjunto_a_analizar.id + " con el caracter " + simbolo + " va al conjunto S" + nuevo_conjunto.id);
                conjunto_a_analizar.transiciones[(int)simbolo] = nuevo_conjunto.id;
            }
            
            conjuntos_s.add(conjunto_a_analizar);
        }
        
        for(ConjuntoS conjunto: conjuntos_s){
            for(int id_conjunto_destino: conjunto.transiciones)
                fw.write(id_conjunto_destino + ",");
                
            fw.write("\n");
            fw.flush();
        }
            
        fw.close();
        
        //Paso 3. Construir el AFD
        HashSet<ConjuntoS> conjuntos_afd = new HashSet<ConjuntoS>(conjuntos_s);
        afd.estados.addAll(conjuntos_afd);
        
        //Paso 4. Asignar los estados de aceptación
        for(ConjuntoS conjunto_s: afd.estados){
            for(Estado estado: conjunto_s.estados){
                if(estado.de_aceptacion == true){
                    conjunto_s.es_de_aceptacion = true;
                    afd.conjuntos_aceptacion.add(conjunto_s);
                }   
            }
        }
        
        //Paso 5. Obtener alfabeto
        afd.alfabeto.addAll(this.alfabeto); //El alfabeto del AFD es igual al del AFN
        imprimirAFD(afd);

        return afd;
    }
    
    public boolean contieneConjunto(List<ConjuntoS> conjuntos, HashSet<Estado> estados_conjunto) {
        return conjuntos.stream().filter(conjunto -> conjunto.estados.equals(estados_conjunto)).findFirst().isPresent();
    }
    
    public void imprimirAFN(AFN afn){
        System.out.println("AFN:");
        System.out.println("Id: " + afn.id);
        System.out.println("Estados:");
        for(Estado estado: afn.estados){
            System.out.println("\tId: " + estado.id);
            System.out.println("\tEs de aceptación?: " +estado.de_aceptacion);
            System.out.println("\tTransiciones:");
            for(Transicion transicion: estado.transiciones){
                System.out.println("\t\tSímbolo inferior: " + transicion.simbolo_inferior);
                System.out.println("\t\tSímbolo superior: " + transicion.simbolo_superior);
                System.out.println("\t\tEstado destino");
                System.out.println("\t\t\tId: " + transicion.estado_destino.id);
            }
        }
        System.out.println("Estado inicial:");
        System.out.println("\tId:" + afn.estado_inicial.id);
        System.out.println("Estados de aceptación:");
        for(Estado estado: afn.estados_aceptacion){
            System.out.println("\tId: " + estado.id);
        }
        System.out.printf("Alfabeto: {");
        for(Character simbolo: afn.alfabeto){
            System.out.printf(simbolo + ",");
        }
        System.out.printf("}\n");
        System.out.println("Ya está agregado al conjunto de AFN?: " + afn.afn_agregado);
    }
    
    public void imprimirAFD(AFD afd){
        System.out.println("AFD:");
        System.out.println("Id: " + afd.id);
        System.out.println("Conjuntos:");
        for(ConjuntoS conjunto: afd.estados){
            System.out.println("\tId: " + conjunto.id);
            System.out.println("\tEs de aceptación: " + conjunto.es_de_aceptacion);
            System.out.println("\tEstados: ");
            for(Estado estado: conjunto.estados){
                System.out.println("\t\tId: " + estado.id);
            }
        }
        System.out.println("Conjunto inicial:");
        System.out.println("\tId:" + afd.conjunto_inicial.id);
        System.out.println("Conjuntos de aceptación:");
        for(ConjuntoS conjunto: afd.conjuntos_aceptacion){
            System.out.println("\tId: " + conjunto.id);
        }
        System.out.printf("Alfabeto: {");
        for(Character simbolo: afd.alfabeto){
            System.out.printf(simbolo + ",");
        }
        System.out.printf("}\n");
    }
    
}
