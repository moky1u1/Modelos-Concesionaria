package com.moky1ul.dao;

import com.moky1ul.model.Cliente;
import com.moky1ul.model.Revision;
import com.moky1ul.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {
    Connection connection;

    public RevisionDao() {
        connection = ConectorBD.getConnection();
    }

    //CREATE
    public void insertarRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO revisiones (codigo, filtro, aceite, frenos) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, revision.getCodigo());
            preparedStatement.setString(2, revision.getFiltro());
            preparedStatement.setString(3, revision.getAceite());
            preparedStatement.setString(4, revision.getFrenos());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al insertar el revision. \n" + e);
        }
    }

    //UPDATE
    public void editarRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE revisiones SET codigo=?, filtro=?, aceite=?, frenos=?  WHERE codigo=?");

            preparedStatement.setString(1, revision.getCodigo());
            preparedStatement.setString(2, revision.getFiltro());
            preparedStatement.setString(3, revision.getAceite());
            preparedStatement.setString(4, revision.getFrenos());


            preparedStatement.setString(5, revision.getCodigo());//pk

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al editar revision. " + e);
        }
    }

    //DELETE
    public void eliminarRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM revisiones WHERE codigo=?");

            preparedStatement.setString(1, revision.getCodigo());//pk

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al eliminar revision. " + e);
        }
    }

    //READ
    public List<Revision> listaRevisiones() {
        List<Revision> listaRevisiones = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
            while (resultSet.next()){
                Revision revision = new Revision();

                revision.setCodigo(resultSet.getString("codigo"));
                revision.setFiltro(resultSet.getString("filtro"));
                revision.setAceite(resultSet.getString("aceite"));
                revision.setFrenos(resultSet.getString("frenos"));

                listaRevisiones.add(revision);
            }
        }catch (SQLException e){
            System.out.println("Error al listar las Revisiones. " + e);
        }

        return listaRevisiones;
    }

    public Revision buscarRevisionesPorCodigo(String codigo) {
        Revision revision = null;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM revisiones WHERE codigo=?");

            preparedStatement.setString(1, codigo);//pk

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                revision = new Revision();

                revision.setCodigo(resultSet.getString("codigo"));
                revision.setFiltro(resultSet.getString("filtro"));
                revision.setAceite(resultSet.getString("aceite"));
                revision.setFrenos(resultSet.getString("frenos"));

            }
        }catch (SQLException e){
            System.out.println("Error al buscar las revisiones por su codigo. " + e);
        }

        return revision;
    }
}
