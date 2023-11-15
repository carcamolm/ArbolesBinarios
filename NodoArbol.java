
package arbolesbinarios;

/*Primera clase para llenar*/
public class NodoArbol {
    int dato;//la clase nodo se compone de un tipo de dato entero
    String nombre;//Es el nombre del nodo
    NodoArbol hijoIzquierdo,hijoDerecho;//También se compone de hijo izquierdo y derecho, DE TIPO NODO ARBOL
   
    public NodoArbol(int d,String nom){
      this.dato=d;
      this.nombre=nom;
      this.hijoDerecho=null;//Cada que se cree un nodo, sus hijos no van a tener ningun nodo
      this.hijoIzquierdo=null;
    }
     //Metodo toString es para permitir la informacion completa del objeto
    public String toString(){
        return nombre+"Su Dato es "+dato;
            
    }
}
