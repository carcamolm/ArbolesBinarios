package arbolesbinarios;

import javax.swing.JOptionPane;

public class ArbolesBinarios {

    public static void main(String[] args) {
        int opcion = 0, elemento;

        String nombre;
        ArbolBinarioMetodos arbol = new ArbolBinarioMetodos();
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar un Nodo\n"
                        + "2.Recorrer el Árbol InOrden\n "
                        + "3.Recorrer el Árbol PreOrden\n "
                        + "4.Recorrer el Árbol PostOrden\n "
                        + "5.Buscar un Nodo en el Árbol\n "
                        + "6.Eliminar un Nodo del Árbol\n "
                        + "7. Salir\n"
                        + "Elige una Opción..", "Árboles Binarios",
                         JOptionPane.QUESTION_MESSAGE));

                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el número del Nodo...", "Agregando Nodo",
                                 JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del Nodo",
                                 "Agregando Nodo",
                                 JOptionPane.QUESTION_MESSAGE);

                        arbol.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        
                        if (!arbol.estaVacio()) {
                            System.out.println("");
                            arbol.inOrden(arbol.raiz);
                            System.out.println("");
                        } else {
                            JOptionPane.showMessageDialog(null, "El Árbol está Vacío",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 3:
                       
                        if (!arbol.estaVacio()) {
                             System.out.println("");
                            arbol.preOrden(arbol.raiz);
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "El Árbol está Vacío",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 4:
                        
                        if (!arbol.estaVacio()) {
                            System.out.println("");
                            arbol.postOrden(arbol.raiz);
                           
                        } else {
                            JOptionPane.showMessageDialog(null, "El Árbol está Vacío",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 5:
                        System.out.println("");
                        if (!arbol.estaVacio()) {
                            System.out.println("");
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del Nodo Buscado...", "Buscando Nodo",
                                     JOptionPane.QUESTION_MESSAGE));

                            if (arbol.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el Árbol",
                                        "Nodo no enconrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println("Nodo encontrado, su elemento es:  " + arbol.buscarNodo(elemento));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El Árbol está Vacío",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 6:
                        
                        //Copiamos el elemento del caso 5
                        if (!arbol.estaVacio()) {
                            System.out.println("");
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del Nodo a Eliminar...", "Eliminando Nodo",
                                     JOptionPane.QUESTION_MESSAGE));

                            if (arbol.eliminar(elemento)==false) {
                                JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el Árbol",
                                        "Nodo no enconrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El Nodo ha sido Eliminado del Árbol",
                                        "Nodo Elilminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El Árbol está Vacío",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicación finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }

        } while (opcion != 7);
    }

}
