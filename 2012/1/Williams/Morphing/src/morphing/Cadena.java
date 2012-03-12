/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package morphing;


import java.util.Iterator;

/**
 *
 * @author Williams
 */
public class Cadena<E> {
    protected Nodo<E> raiz;

    public Cadena() {
        this.raiz = null;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }
    public void insertar(E obj){
        Nodo<E> n =new Nodo<E>(obj);
        if (raiz==null){
            raiz=n;
            return;
        }
        else{
            n.setSiguiente(raiz);
            raiz=n;
        }
    }    
    public int tamano(){
        int contador=0;
        Nodo <E> actual=raiz;
        while(actual!=null){
            contador++;
            actual=actual.getSiguiente();
        }
        return contador;
    }
    public Iterator <E> iterator(){
        return new IteratorCadena<E>(raiz);
    }
    @Override
    public String toString() {
        StringBuffer result= new StringBuffer();
        if(raiz == null)return "[VACIO]";
        Nodo<E> actual=raiz;
        while(actual!=null){
            result.append(actual.toString());
            actual=actual.getSiguiente();
        } 
            
        return result.toString();
    }
    
    static class IteratorCadena <E> implements Iterator<E> {
        private Nodo <E> actual;

        public IteratorCadena(Nodo<E> actual) {
            this.actual = actual;
        }

        public Nodo<E> getActual() {
            return actual;
        }

        public void setActual(Nodo<E> actual) {
            this.actual = actual;
        }
        
        public boolean hasNext() {
            return (actual != null);
        }

        public E next() {
            Nodo <E> nodoActual = actual;
            actual = actual.getSiguiente();
            return nodoActual.getContenido();
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
    }

    static public class Nodo<E> {
        private Nodo<E> siguiente;
        private E contenido;
        public Nodo(E o) {
            siguiente=null;
            contenido=o;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public String toString() {
            return "( " + contenido+ " )->";
        }
  
    }
    
}

        