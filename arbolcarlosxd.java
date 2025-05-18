package com.mycompany.proyyecto;

import java.awt.*;
import javax.swing.*;
import java.util.*;

class Nodo {
    Nodo(String valor, boolean esRaiz) {
        this.valor = valor;
        this.esRaiz = esRaiz;
        this.izquierdo = null;
        this.derecho = null;
    }

    private String valor;
    private boolean esRaiz;
    public Nodo izquierdo;
    public Nodo derecho;

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public void setEsRaiz(boolean esRaiz) {
        this.esRaiz = esRaiz;
    }

    public boolean getEsRaiz() {
        return this.esRaiz;
    }
}

class Arbol {
    private Nodo raiz;

    Arbol(String valorRaiz) {
        this.raiz = new Nodo(valorRaiz, true);
    }

    public void insertarNodoIzquierdo(Nodo padre, String valor) {
        padre.izquierdo = new Nodo(valor, false);
    }

    public void insertarNodoDerecho(Nodo padre, String valor) {
        padre.derecho = new Nodo(valor, false);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public Nodo buscarNodo(Nodo nodo, String valor) {
        if (nodo == null) return null;
        if (nodo.getValor().equals(valor)) return nodo;
        Nodo encontrado = buscarNodo(nodo.izquierdo, valor);
        if (encontrado == null)
            encontrado = buscarNodo(nodo.derecho, valor);
        return encontrado;
    }

    public void eliminarNodo(Nodo padre, String valor) {
        if (padre == null) return;
        if (padre.izquierdo != null && padre.izquierdo.getValor().equals(valor)) {
            padre.izquierdo = null;
        } else if (padre.derecho != null && padre.derecho.getValor().equals(valor)) {
            padre.derecho = null;
        } else {
            eliminarNodo(padre.izquierdo, valor);
            eliminarNodo(padre.derecho, valor);
        }
    }

    public void recorridoPreOrden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.getValor()).append(" ");
            recorridoPreOrden(nodo.izquierdo, sb);
            recorridoPreOrden(nodo.derecho, sb);
        }
    }

    public void recorridoInOrden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoInOrden(nodo.izquierdo, sb);
            sb.append(nodo.getValor()).append(" ");
            recorridoInOrden(nodo.derecho, sb);
        }
    }

    public void recorridoPostOrden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoPostOrden(nodo.izquierdo, sb);
            recorridoPostOrden(nodo.derecho, sb);
            sb.append(nodo.getValor()).append(" ");
        }
    }
}

class GraficoArbol extends JPanel {
    private final Arbol arbol;
    private final int DISTANCIA_ENTRE_NIVELES = 120;

    public GraficoArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        Graphics2D grafico2D = (Graphics2D) grafico;
        grafico2D.setStroke(new BasicStroke(2));
        graficarArbol(grafico2D, getWidth() / 2, 50, arbol.getRaiz(), getWidth() / 4);
    }

    private void graficarArbol(Graphics2D grafico, int x, int y, Nodo nodo, int xOffset) {
        int radio = 20;
        if (nodo != null) {
            grafico.drawOval(x - radio, y - radio, radio * 2, radio * 2);
            grafico.drawString(nodo.getValor(), x - 2, y + 5);
        } else {
            return;
        }

        if (nodo.izquierdo != null) {
            grafico.drawLine (x - 20, y + 5, x - xOffset + 20, y + DISTANCIA_ENTRE_NIVELES);
            graficarArbol(grafico, x - xOffset, y + DISTANCIA_ENTRE_NIVELES, nodo.izquierdo, xOffset / 2);
        }

        if (nodo.derecho != null) {
            grafico.drawLine(x + 20, y + 5, x + xOffset - 20, y + DISTANCIA_ENTRE_NIVELES);
            graficarArbol(grafico, x + xOffset, y + DISTANCIA_ENTRE_NIVELES, nodo.derecho, xOffset / 2);
        }
    }
}

public class arbolcarlosxd {
    static GraficoArbol graficoPanel;

    public static void main(String[] args) {
        String valorRaiz = JOptionPane.showInputDialog("Ingresa el valor de la raíz:");
        if (valorRaiz == null || valorRaiz.trim().isEmpty()) return;

        Arbol arbol = new Arbol(valorRaiz);
        Nodo raiz = arbol.getRaiz();

        Queue<Nodo> nodoCola = new LinkedList<>();
        nodoCola.add(raiz);

        JFrame frame = mostrarGrafico(arbol); // Mostrar una sola vez

        // Construcción del árbol
        while (!nodoCola.isEmpty()) {
            Nodo nodoReferencia = nodoCola.poll();

            String valorIzquierdo = JOptionPane.showInputDialog("Hijo izquierdo de " + nodoReferencia.getValor() + ":");
            if (valorIzquierdo != null && !valorIzquierdo.trim().isEmpty()) {
                if (arbol.buscarNodo(arbol.getRaiz(), valorIzquierdo) == null) {
                    arbol.insertarNodoIzquierdo(nodoReferencia, valorIzquierdo);
                    nodoCola.add(nodoReferencia.izquierdo);
                    graficoPanel.repaint(); // Actualizar gráfico
                } else {
                    JOptionPane.showMessageDialog(null, "Este valor ya existe");
                }
            }

            String valorDerecho = JOptionPane.showInputDialog("Hijo derecho de " + nodoReferencia.getValor() + ":");
            if (valorDerecho != null && !valorDerecho.trim().isEmpty()) {
                if (arbol.buscarNodo(arbol.getRaiz(), valorDerecho) == null) {
                    arbol.insertarNodoDerecho(nodoReferencia, valorDerecho);
                    nodoCola.add(nodoReferencia.derecho);
                    graficoPanel.repaint(); // Actualizar gráfico
                } else {
                    JOptionPane.showMessageDialog(null, "Este valor ya existe");
                }
            }
        }

        // Menú principal
        while (true) {
            String[] opciones = {"Agregar Nodo", "Editar Nodo", "Eliminar Nodo", "Mostrar Recorrido", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Qué deseas hacer?", "Menú", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> {
                    String buscar = JOptionPane.showInputDialog("Padre del nodo nuevo:");
                    if (buscar == null || buscar.trim().isEmpty()) break;

                    Nodo nodoNuevo = arbol.buscarNodo(raiz, buscar);
                    if (nodoNuevo == null) {
                        JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
                        break;
                    }

                    String valorIzquierdo;
                    String valorDerecho;
                    
                    if(nodoNuevo.izquierdo == null){
                        valorIzquierdo = JOptionPane.showInputDialog("Hijo izquierdo de " + nodoNuevo.getValor() + ":");
                        if (valorIzquierdo != null && !valorIzquierdo.trim().isEmpty()) {
                            if (arbol.buscarNodo(raiz, valorIzquierdo) == null) {
                                arbol.insertarNodoIzquierdo(nodoNuevo, valorIzquierdo);
                                graficoPanel.repaint();
                            } else {
                                JOptionPane.showMessageDialog(null, "Este valor ya existe");
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Este nodo ya tiene un hijo izquierdo");
                    }
                    
                    if(nodoNuevo.derecho == null){
                        valorDerecho = JOptionPane.showInputDialog("Hijo derecho de " + nodoNuevo.getValor() + ":");
                        if (valorDerecho != null && !valorDerecho.trim().isEmpty()) {
                            if (arbol.buscarNodo(raiz, valorDerecho) == null) {
                                arbol.insertarNodoDerecho(nodoNuevo, valorDerecho);
                                graficoPanel.repaint();
                            } else {
                                JOptionPane.showMessageDialog(null, "Este valor ya existe");
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Este nodo ya tiene un hijo derecho");
                    }
                }
                case 1 -> {
                    String buscar = JOptionPane.showInputDialog("Valor del nodo a editar:");
                    Nodo nodoEditar = arbol.buscarNodo(raiz, buscar);
                    if (nodoEditar != null) {
                        String nuevoValor = JOptionPane.showInputDialog("Nuevo valor:");
                        if (nuevoValor != null && !nuevoValor.trim().isEmpty()) {
                            if (arbol.buscarNodo(raiz, nuevoValor) == null) {
                                nodoEditar.setValor(nuevoValor);
                                graficoPanel.repaint();
                            } else {
                                JOptionPane.showMessageDialog(null, "Este valor ya existe");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nodo no encontrado");
                    }
                }
                case 2 -> {
                    String eliminar = JOptionPane.showInputDialog("Valor del nodo a eliminar:");
                    if (!raiz.getValor().equals(eliminar)) {
                        arbol.eliminarNodo(raiz, eliminar);
                        graficoPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes eliminar la raíz.");
                    }
                }
                case 3 -> {
                    String[] recorridos = {"Pre-Orden", "In-Orden", "Post-Orden"};
                    int seleccion = JOptionPane.showOptionDialog(null, "Selecciona tipo de recorrido:",
                            "Recorridos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, recorridos, recorridos[0]);

                    StringBuilder sb = new StringBuilder();
                    switch (seleccion) {
                        case 0 -> arbol.recorridoPreOrden(raiz, sb);
                        case 1 -> arbol.recorridoInOrden(raiz, sb);
                        case 2 -> arbol.recorridoPostOrden(raiz, sb);
                    }

                    JOptionPane.showMessageDialog(null, "Recorrido seleccionado:\n" + sb.toString());
                }
                case 4, JOptionPane.CLOSED_OPTION -> System.exit(0);
            }
        }
    }

    public static JFrame mostrarGrafico(Arbol arbol) {
        JFrame graficoArbol = new JFrame("Gráfico del Árbol");
        graficoArbol.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        graficoArbol.setSize(1280, 720);
        graficoPanel = new GraficoArbol(arbol);
        graficoArbol.add(graficoPanel);
        graficoArbol.setVisible(true);
        return graficoArbol;
    }
} 