package com.argandona.mantenedorusuarios.dto;

public class UserDto {
    private Integer id;
    private String nombre = "";
    private String contrasena = "";

    public UserDto(Integer id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }


    //getters
    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getContrasena() {
        return contrasena;
    }

   //setters
   public void setId(Integer id) {
       if (id != null && id < 0) {
           throw new IllegalArgumentException("El ID no puede ser un número negativo.");
       }
       this.id = id;
   }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        this.contrasena = contrasena;
    }



    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
