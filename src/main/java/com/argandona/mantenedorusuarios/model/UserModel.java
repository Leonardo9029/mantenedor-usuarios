package com.argandona.mantenedorusuarios.model;
import java.util.ArrayList;
import com.argandona.mantenedorusuarios.dto.UserDto;
public class UserModel {

    private final ArrayList<UserDto> usuarios = new ArrayList<>();
    private int contadorId = 1;
    public ArrayList<UserDto> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(UserDto usuario) {
        usuario.setId(contadorId);
        contadorId=contadorId+1;
        usuarios.add(usuario);
    }

    public void eliminarUsuario(UserDto usuario) {
        usuarios.remove(usuario);
    }


    public void modificarUsuario(UserDto usuarioAntiguo, UserDto usuarioNuevo) {
        int index = usuarios.indexOf(usuarioAntiguo);
        if (index != -1) {
            usuarios.set(index, usuarioNuevo);
        }
    }
}
