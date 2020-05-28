/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.*;
import DTO.*;
import java.util.List;

/**
 *
 * @author kose_
 */
public class TiendaU {

    Conexion con = Conexion.getConexion();
    ClienteJpaController clienteDAO = new ClienteJpaController(con.getBd());
    List<Cliente> clientes = clienteDAO.findClienteEntities();
    TiendaJpaController tiendaDAO = new TiendaJpaController(con.getBd());
    List<Tienda> tiendas = tiendaDAO.findTiendaEntities();

    public boolean registrarTienda(String nombre, String lema, String descripcion, String email, String clave, String propietario, String facebook, String web, String imagen) {
        boolean result = false;
        Tienda t = new Tienda();
        t = checkEmailTienda(email);
        Cliente c = new Cliente();
        c = checkEmailCliente(email);
        if (t == null && c == null) {
            try {
                Tienda tn = new Tienda();
                tn.setNombre(nombre);
                tn.setLema(lema);
                tn.setDescripcion(descripcion);
                tn.setEmail(email);
                tn.setClave(clave);
                tn.setPropietario(propietario);
                tn.setFacebook(facebook);
                tn.setWeb(web);
                tn.setImagen(imagen);
                tiendaDAO.create(tn);
                result = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.err.println(e.getMessage());

            }

        }else  {
            System.err.println("El email ya esta en uso");
        }
        
        return result;
    }

    public Tienda checkEmailTienda(String email) {
        for (Tienda t : tiendas) {
            if (t.getEmail().equalsIgnoreCase(email)) {
                return t;
            }
        }
        return null;
    }

    public Cliente checkEmailCliente(String email) {
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }
}
