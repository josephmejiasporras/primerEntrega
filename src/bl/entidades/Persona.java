package bl.entidades;

public class Persona {

    private String nombre;
    private String segundoNombre;
    private String apellidos;
    private String nickname;
    private String password;
    private String correo;
    private String avatar;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getAppelidos() {
        return getApellidos();
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public Persona() {
     
    }
    
    public Cliente convertirACliente(Persona persona, String fechaNacimiento, String nacionalidad, String id){
        
        Cliente cliente = new Cliente (this.nombre, this.segundoNombre, this.apellidos, this.nickname, this.password, this.correo, this.avatar, fechaNacimiento, nacionalidad, id);
        
        return cliente;
    }
    

    public Persona(String nombre, String segundoNombre, String apellidos, String nickname, String password, String correo, String avatar) {
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellidos = apellidos;
        this.nickname = nickname;
        this.password = password;
        this.correo = correo;
        this.avatar = avatar;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
