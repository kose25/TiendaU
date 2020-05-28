/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import DAO.ClienteJpaController;
import DAO.Conexion;
import DAO.ServicioJpaController;
import DAO.TiendaJpaController;
import DTO.Cliente;
import DTO.Servicio;
import DTO.Tienda;
import java.util.List;

/**
 *
 * @author kose_
 */
public class Test {

    public static void main(String[] args) {
        Conexion con = Conexion.getConexion();
        ClienteJpaController clienteDAO = new ClienteJpaController(con.getBd());
        TiendaJpaController tiendaDAO = new TiendaJpaController(con.getBd());
        ServicioJpaController servicioDAO = new ServicioJpaController(con.getBd());
        List<Cliente> clientes = clienteDAO.findClienteEntities();
        Cliente nuevo = new Cliente(1, "pablos", "carlosjosepg@ufps.edu.co", "clave");

        clienteDAO.create(nuevo);

        Tienda t = new Tienda(4, "tienda test", "lema", "tienda@gmail.com", "clave", "propietario", "facebook", "web", "imagen");
        tiendaDAO.create(t);

        Servicio s = new Servicio(2, "servicio prueba", "descripcion", tiendaDAO.findTienda(3));
        servicioDAO.create(s);

        try {
            Tienda nuevaTienda = tiendaDAO.findTienda(4);
            nuevaTienda.setDescripcion("descripcion editada");
            tiendaDAO.edit(nuevaTienda);
        } catch (Exception e) {
            System.err.println("hubo un error:" + e);

        }

    }

}
