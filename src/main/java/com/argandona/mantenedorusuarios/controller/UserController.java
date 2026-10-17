package com.argandona.mantenedorusuarios.controller;

import com.argandona.mantenedorusuarios.dto.UserDto;
import com.argandona.mantenedorusuarios.model.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class UserController {

    // 1. Conectamos los elementos de la pantalla (deben llamarse igual que en el fx:id)
    @FXML private TextField txtNombre;
    @FXML private TextField txtContrasena;
    @FXML private TableView<UserDto> tblUsuarios;

    // 2. Llamamos a tu modelo, que es el que hace el trabajo pesado
    private UserModel modelo = new UserModel();

    // 3. Método que se ejecuta al hacer clic en "Agregar"
    @FXML
    public void agregarUsuario() {
        // Capturar los textos de la pantalla
        String nombre = txtNombre.getText();
        String contrasena = txtContrasena.getText();

        // Armar el objeto DTO (el ID se generará solo en tu UserModel)
        UserDto nuevoUsuario = new UserDto();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(contrasena);

        // Guardarlo usando tu modelo
        modelo.agregarUsuario(nuevoUsuario);

        // Limpiar las cajas de texto para el siguiente
        txtNombre.clear();
        txtContrasena.clear();
        tblUsuarios.getItems().setAll(modelo.getUsuarios());
        System.out.println("¡Usuario agregado con éxito: " + nombre + "!");
    }

    @FXML
    public void modificarUsuario() {
        // 1. Obtiene el usuario que marcaste en la tabla
        UserDto seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            // 2. Armamos un usuario con los datos nuevos, pero manteniendo el ID antiguo
            UserDto usuarioActualizado = new UserDto();
            usuarioActualizado.setId(seleccionado.getId());
            usuarioActualizado.setNombre(txtNombre.getText());
            usuarioActualizado.setContrasena(txtContrasena.getText());

            // 3. Enviamos el antiguo y el nuevo a tu modelo para que haga el cambio
            modelo.modificarUsuario(seleccionado, usuarioActualizado);

            // 4. Actualizamos la tabla y limpiamos los textos
            tblUsuarios.getItems().setAll(modelo.getUsuarios());
            txtNombre.clear();
            txtContrasena.clear();
            System.out.println("¡Usuario modificado!");
        }
    }

    @FXML
    public void eliminarUsuario() {
        // 1. Obtiene el usuario que marcaste con el clic en la tabla
        UserDto seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            modelo.eliminarUsuario(seleccionado); // Lo borra del modelo
            tblUsuarios.getItems().setAll(modelo.getUsuarios()); // Actualiza la vista de la tabla
            System.out.println("¡Usuario eliminado!");
        }
    }
    @FXML
    public void initialize() {
        // Enlazamos cada columna con el nombre exacto de la variable en UserDto
        TableColumn<UserDto, Integer> colId = (TableColumn<UserDto, Integer>) tblUsuarios.getColumns().get(0);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<UserDto, String> colNombre = (TableColumn<UserDto, String>) tblUsuarios.getColumns().get(1);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<UserDto, String> colContrasena = (TableColumn<UserDto, String>) tblUsuarios.getColumns().get(2);
        colContrasena.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
    }
}