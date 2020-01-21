/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajesproyecto;

import java.util.Scanner;
import static com.mycompany.mensajesproyecto.MensajesDAO.*;
/**
 *
 * @author Tatiana Orjuela R
 */
public class MensajesService {

    public static void crearMensaje(){
        
        System.out.println("Escribe tu mensaje");
        Scanner sc = new Scanner(System.in);
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        crearMensajeDB(registro);
    
    }
    
    public static void listarMensajes(){
    leerMensajesDB();
    }

    public static void borrarMensaje(){
        
        System.out.println("----------------------------");
        System.out.println("Escriba la id del mensaje que desea eliminar:");
        listarMensajes();
        Scanner sc = new Scanner(System.in);
        int id_mensaje = sc.nextInt();
        borrarMensajeDB(id_mensaje);
        System.out.println("----------------------------");
        
    }
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------");
        
       
        System.out.println("Escriba el nuevo mensaje:");
        String nuevoMensaje = sc.nextLine();
        System.out.println("----------------------------"); 
        System.out.println("Escriba la id del mensaje que desea editar:");
        System.out.println("----------------------------");
        listarMensajes();
        int id_mensaje = sc.nextInt();
        System.out.println("----------------------------");
        
        
        Mensajes nuevoM = new Mensajes();
        nuevoM.setMensaje(nuevoMensaje);
        nuevoM.setId_mensaje(id_mensaje);
        
        actualizarMensajeDB(nuevoM);
    }
    
}
