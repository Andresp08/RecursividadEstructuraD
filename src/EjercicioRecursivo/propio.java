/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioRecursivo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class OperacionesRecursivas {

    public static void main(String[] args) {
        //variables de proceso
        Scanner sc = new Scanner(System.in);
        int i = 0, valores, numeroAMultiplicar = 0;
        int capacidad = 0;
        boolean bol = true;

        //validar que el tamaño de datos sea positivo
        do {
            try {
                capacidad = Integer.parseInt(JOptionPane.showInputDialog("Cuantos numeros desea ingresar?: "));
                if (capacidad > 0) {
                    bol = false;
                } else {
                    System.err.println("POR FAVOR INGRESA VALORES POSITIVOS");
                }
            } catch (NumberFormatException e) {
                System.out.println("NO INGRESE LETRAS: " + e);
            }
        } while (bol);

        //asignarle el tamaño al vector
        int datos[] = new int[capacidad];

        //llenar el array y validar excepciones
        do {
            try {
                valores = Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor: " + (i + 1)));
                if (valores > 0) {
                    datos[i] = valores;
                    i++;
                } else {
                    System.err.println("POR FAVOR INGRESA VALORES POSITIVOS");
                }
            } catch (NumberFormatException e) {
                System.out.println("NO INGRESE LETRAS: " + e);
            }
        } while (i < datos.length);

        //pedir el numero que va a multiplicar al vector
        do {
            bol = true;
            try {
                numeroAMultiplicar = Integer.parseInt(JOptionPane.showInputDialog("ingrese el producto: "));
                if (numeroAMultiplicar > 0) {
                    bol = false;
                } else {
                    System.err.println("POR FAVOR INGRESA VALORES POSITIVOS");
                }
            } catch (NumberFormatException e) {
                System.out.println("NO INGRESE LETRAS: " + e);
            }
        } while (bol);

        // llamar a la funcion para sumar y multiplicar los valores de forma recursiva
        System.out.println("suma: " + sumarPosicionesArray(datos, datos.length - 1));
        System.out.println(
                "multiplicado: " + sumarPosicionesArray(datos, datos.length - 1) * numeroAMultiplicar);
    }

    //metodo que recibe como parametro el array y la posicion del elemento a sumar
    public static int sumarPosicionesArray(int array[], int posArray) {

        Scanner sc = new Scanner(System.in);
        // inicializo la variable con la posicion del arreglo 
        int tamaño = posArray;
        int resultado;

        /*comprubeo que el tamaño no sea cero, ya que si lo es, en una vuelta mas
        intentará llamar a la posicion -1, generado un error
         */
        if (tamaño == 0) {
            return array[tamaño];
        } else {
            /*si el tamaño es != de cero, entonces añado al resultado la suma del valor
            pasado por paramentro, mas el valor de la posicion anterior
             */
            resultado = (array[tamaño]) + (sumarPosicionesArray(array, tamaño - 1));
        }
        //devuelvo la varibable queguarda el resultado
        return resultado;
    }
}
