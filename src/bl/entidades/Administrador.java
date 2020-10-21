/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.entidades;

/**
 *
 * @author capri
 */
public class Administrador extends Persona{
    
    public Administrador(String nombre, String segundoNombre, String apellidos, String nickname, String password, String correo, String avatar) {
     this.setNombre(nombre);
     this.setSegundoNombre(segundoNombre);
     this.setApellidos(apellidos);
     this.setNickname(nickname);
     this.setPassword(password);
     this.setNombre(correo);
     this.setNombre(avatar);
    }
    
    public Administrador(){
        
    }

    
}
