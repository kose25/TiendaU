/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import DAO.ClienteJpaController;
import DAO.Conexion;
import DTO.Cliente;
import java.util.List;

/**
 *
 * @author kose_
 */
public class Test {
    Conexion con=Conexion.getConexion();
        ClienteJpaController clienteDAO=new ClienteJpaController(con.getBd());
        List<Cliente> clientes=clienteDAO.findClienteEntities();
        Cliente nuevo = new Cliente(1,"pablos","carlosjosepg@ufps.edu.co","clave");

}
