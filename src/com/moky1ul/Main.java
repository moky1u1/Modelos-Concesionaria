package com.moky1ul;

import com.moky1ul.dao.ClienteDao;
import com.moky1ul.model.Cliente;
import com.moky1ul.model.Coche;
import com.moky1ul.util.ConectorBD;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = ConectorBD.getConnection();
    }
}
