package com.moky1ul;

import com.moky1ul.dao.ClienteDao;
import com.moky1ul.model.Cliente;
import com.moky1ul.model.Coche;
import com.moky1ul.util.ConectorBD;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Cliente JuanPerez = new Cliente("1234","Juan Perez Alcides", "Cochabamba", "Av Ayacucho #210",4441234);
        //Cliente MariaBaldez = new Cliente("1235","Maria Baldez Caceres", "Cochabamba", "Av Heroinas #157",4012345);
        //Cliente JoseCamargo = new Cliente("1236","Jose Camargo Santana", "Santa Cruz", "Calle Bolivar #118",4678910);
        //Cliente MarceloParedes = new Cliente("1237","Marcelo Paredes Zurita", "La Paz", "Calle Calama #301",4445468);
        //Cliente RodrigoNavia = new Cliente("1238","Rodrigo Navia Alcon", "Santa Cruz", "Av Peru #224",4482153);
        //Cliente AliciaMartinez = new Cliente("1239","Alicia Martinez Rocha", "Cochabamba", "Av Beiging #180",4492761);
        //Cliente MonicaGalindo = new Cliente("12310","Monica Galindo Rosado", "Cochabamba", "Av Blanco Galindo #149",4765547);
        //Cliente RogerLopez = new Cliente("1123","Roger Lopez Arce", "Tarija", "Calle Gral. Marzana #322",4947315);
        //Cliente AlmaRojas = new Cliente("1124","Alma Rojas Salas", "Cochabamba", "Av Ingavi #114",4527811);
        //Cliente XimenaCortes = new Cliente("1125","Ximena Cortes Flores", "Oruro", "Calle Ballivian #211",4184124);



        ClienteDao clienteDao = new ClienteDao();

        //Create
        //clienteDao.insertarCliente(MariaBaldez);
        //clienteDao.insertarCliente(JoseCamargo);
        //clienteDao.insertarCliente(MarceloParedes);
        //clienteDao.insertarCliente(RodrigoNavia);
        //clienteDao.insertarCliente(AliciaMartinez);
        //clienteDao.insertarCliente(MonicaGalindo);
        //clienteDao.insertarCliente(RogerLopez);
        //clienteDao.insertarCliente(AlmaRojas);
        //clienteDao.insertarCliente(XimenaCortes);

        //Read
        /*
        List<Cliente> clientes = clienteDao.listaClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);

            System.out.println(cliente);
        }
         */

        //Update
        //Cliente JuanPerez = new Cliente("1111","Juan Perez Rodriguez", "Cochabamba", "Av Chaco #210",4441234);
        //clienteDao.editarCliente(JuanPerez);

        //Delete
        clienteDao.eliminarCliente("1235");
    }
}
