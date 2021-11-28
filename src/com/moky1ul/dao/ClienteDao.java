package com.moky1ul.dao;


import com.moky1ul.model.Cliente;
import com.moky1ul.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    Connection connection;

    public ClienteDao() {

        //nos conectamos a la base de datos
        connection = ConectorBD.getConnection();
    }

    //CREATE
    public void insertarCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO clientes (nif, nombre, ciudad, direccion, telefono) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, cliente.getNif());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCiudad());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setInt(5, cliente.getTelefono());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al insertar el Cliente. \n" + e);
        }
    }

    //UPDATE
    public void editarCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE clientes SET nif=?, nombre=?, ciudad=?, direccion=?, telefono=? WHERE nif=?");

            preparedStatement.setString(1, cliente.getNif());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCiudad());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setInt(5, cliente.getTelefono());

            preparedStatement.setString(6, cliente.getNif());//pk

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al editar Cliente. " + e);
        }
    }

    //DELETE
    public void eliminarCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM clientes WHERE nif=?");

            preparedStatement.setString(1, cliente.getNif());//pk

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al eliminar Cliente. " + e);
        }
    }

    //READ
    public List<Cliente> listaClientes() {
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
            while (resultSet.next()){
                Cliente cliente = new Cliente();

                cliente.setNif(resultSet.getString("nif"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getInt("telefono"));

                listaClientes.add(cliente);
            }
        }catch (SQLException e){
            System.out.println("Error al listar los Clientes. " + e);
        }

        return listaClientes;
    }

    public Cliente buscarClientesPorNif(String nif) {
        Cliente cliente = null;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM clientes WHERE nif=?");

            preparedStatement.setString(1, nif);//pk

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                cliente = new Cliente();

                cliente.setNif(resultSet.getString("nif"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getInt("telefono"));

            }
        }catch (SQLException e){
            System.out.println("Error al buscar los Clientes por su nif. " + e);
        }

        return cliente;
    }

}
