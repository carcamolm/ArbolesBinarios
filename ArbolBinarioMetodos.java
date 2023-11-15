package arbolesbinarios;

public class ArbolBinarioMetodos {

    /*Nuevo puntero del tipo nodoArbol
      al cual le vamos a poner raiz, si es nula esta vacia  
     */

    NodoArbol raiz;

    public ArbolBinarioMetodos() {
        raiz = null;
    }

    //Método para insertar un Nodo en el árbol
 
    public void agregarNodo(int d, String nom) {
        //Crear nodo nuevo de tipo NodoArbol
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null) {
            //Si la raiz es nula quiere decir que se convierte en el nuevo nodo
            raiz = nuevo;
        } else {
            //Crear dos nodos mas que nos ayudaran a ingresar los nodos siguiente 
            NodoArbol auxiliar = raiz;
            NodoArbol padre;//este es padre si tiene hijos, el padre esta nulo no apunta a nada
            while (true) {
                //padre lo apunto a la raiz
                padre = auxiliar;
                //Si es menor se va hacia la izquierda
                if (d < auxiliar.dato) {
                    //si es así recorrete hacia la izquierda, lo apuntamos a hijoIzqierdo
                    auxiliar = auxiliar.hijoIzquierdo;
                    //Si este auxiliar que ya recorrimos es nulo
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;//cuando el metodo es vacio, el return se sale
                        //return finaliza la ejecucion del metodo
                    }

                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }

                }
            }

        }

    }

    //Metodo para saber cuando el arbol esta vacio
    public boolean estaVacio() {
        return raiz == null;
    }

    //Método para recorrer el Árbol InOrden
    public void inOrden(NodoArbol r) {//La raiz es de tipo nodoarbol
        if (r != null) {
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato + " ,");
            inOrden(r.hijoDerecho);
        }
    }

    //Método para recorrer el Árbol Preorden
    public void preOrden(NodoArbol r) {
        if (r != null) {
            System.out.print(r.dato + " ,");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }

    }

    //Metodo para recorrer el Árbol PostOrden
    public void postOrden(NodoArbol r) {
        if (r != null) {
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.print(r.dato + " ,");
        }

    }
    //Método para buscar un nodo en el árbol

    public NodoArbol buscarNodo(int d) {
        NodoArbol aux = raiz;
        while (aux.dato != d) {
            if (d < aux.dato) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }

        }
        return aux;

    }

    //Metodo para eliminar un nodo del árbol
    public boolean eliminar(int d) {
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;
        while (auxiliar.dato != d) {
            padre = auxiliar;
            if (d < auxiliar.dato) {
                esHijoIzquierdo = true;
                auxiliar = auxiliar.hijoIzquierdo;

            } else {
                esHijoIzquierdo = false;
                auxiliar = auxiliar.hijoDerecho;

            }
            if (auxiliar == null) {
                return false;
            }

        }//Fin del while
        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else {
                if (esHijoIzquierdo) {
                    padre.hijoIzquierdo = null;
                } else {
                    padre.hijoDerecho = null;
                }
            }
        } else if (auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoIzquierdo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else if (auxiliar.hijoIzquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoDerecho;
            } else if (esHijoIzquierdo) {
                padre.hijoDerecho = auxiliar.hijoDerecho;
            } else {
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            }

        } else {
            //Aqui se busca el reemplazo nodo a eliminar
            NodoArbol reemplazo = obtenerNodoReemplado(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = reemplazo;
            } else {

                padre.hijoDerecho = reemplazo;

            }
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;

    }
    //Método encargado de reemplazar el que se va a eliminar

    public NodoArbol obtenerNodoReemplado(NodoArbol nodoReemp) {
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.hijoDerecho;
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (reemplazo != nodoReemp.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazarPadre.hijoDerecho = nodoReemp.hijoDerecho;

        }
        System.out.println("El nodo reemplazo es " + reemplazo);
        return reemplazo;
    }

}
