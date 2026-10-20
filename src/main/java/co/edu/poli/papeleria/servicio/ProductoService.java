package co.edu.poli.papeleria.servicio;

import co.edu.poli.papeleria.modelo.Producto;

import java.util.List;

/**
 * Capa de negocio: contrato de las operaciones CRUD sobre Producto.
 */
public interface ProductoService {

    List<Producto> listar();

    Producto buscarPorId(Integer id);

    Producto crear(Producto producto);

    Producto actualizar(Integer id, Producto producto);

    void eliminar(Integer id);
}
