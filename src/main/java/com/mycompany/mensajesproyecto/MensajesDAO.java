/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajesproyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tatiana Orjuela R
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
       
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensaje(mensaje, autor_mensaje) VALUES(?,?)"; //los ? signfican que son parametros
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje Creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void leerMensajesDB(){
        Conexion db_conection = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = db_conection.get_connection();
            String query = "SELECT * FROM mensaje";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("----------------------------");
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                
            }
            
        }catch(Exception e){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    
    
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_conection = new Conexion();
        PreparedStatement ps = null;
        try{
            Connection cn = db_conection.get_connection();
            ps = cn.prepareStatement("DELETE FROM mensaje WHERE id_mensaje=?");
            ps.setInt(1, id_mensaje);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("No se pudo borrar el mensaje");    
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_conection = new Conexion();
        PreparedStatement ps = null;
        try{
            Connection cn = db_conection.get_connection();
            ps = cn.prepareStatement("UPDATE mensaje SET mensaje = ? WHERE id_mensaje = ?");
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getId_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje editado");
        }catch(SQLException ex){
            System.out.println("No se pudo editar, problemas con DB");
            System.out.println(ex);
            
        }catch(Exception e){
            System.out.println("No se pudo editar");
            System.out.println(e);
        }
        
    }
}   