package com.moky1ul.dao;

import com.moky1ul.model.Cliente;
import com.moky1ul.model.Coche;
import com.moky1ul.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDao {

    Connection connection;


    public CocheDao(){

        connection = ConectorBD.getConnection();

    }

    //CREATE
    public void InsertarCoche (Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO coches (matricula, marca, modelo, color, precio) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, coche.getMatricula());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4, coche.getColor());
            preparedStatement.setDouble(5, coche.getPrecio());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al insertar el Coche. \n" + e);
        }
    }

    //UPDATE
    public void editarCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE coches SET matricula=?, marca=?, modelo=?, color=?, precio=? WHERE matricula=?");

            preparedStatement.setString(1, coche.getMatricula());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4, coche.getColor());
            preparedStatement.setDouble(5, coche.getPrecio());

            preparedStatement.setString(6, coche.getMatricula());//pk

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al editar Coche. " + e);
        }
    }

    //DELETE
    public void eliminarCoche(String matricula){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM coches WHERE matricula=?");

            preparedStatement.setString(1, matricula);//pk

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al eliminar Coche. " + e);
        }
    }

    //READ
    public List<Coche> listaCoches() {
        List<Coche> listaCoches = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coches");
            while (resultSet.next()){
                Coche coche = new Coche();

                coche.setMatricula(resultSet.getString("matricula"));
                coche.setMarca(resultSet.getString("marca"));
                coche.setModelo(resultSet.getString("modelo"));
                coche.setColor(resultSet.getString("color"));
                coche.setPrecio(resultSet.getDouble("precio"));

                listaCoches.add(coche);
            }
        }catch (SQLException e){
            System.out.println("Error al listar los Coches. " + e);
        }

        return listaCoches;
    }

    public Coche buscarCochesPorMatricula(String matricula) {
        Coche coche = null;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM coches WHERE matricula=?");

            preparedStatement.setString(1, matricula);//pk

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                coche = new Coche();

                coche.setMatricula(resultSet.getString("matricula"));
                coche.setMarca(resultSet.getString("marca"));
                coche.setModelo(resultSet.getString("modelo"));
                coche.setColor(resultSet.getString("color"));
                coche.setPrecio(resultSet.getDouble("precio"));

            }
        }catch (SQLException e){
            System.out.println("Error al buscar los coches por matricula. " + e);
        }

        return coche;
    }
}
