package co.edu.poli.papeleria.servicio;

import co.edu.poli.papeleria.excepcion.ProductoNoEncontradoException;
import co.edu.poli.papeleria.modelo.Producto;
import co.edu.poli.papeleria.repositorio.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repositorio;

    public ProductoServiceImpl(ProductoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto buscarPorId(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    @Override
    public Producto crear(Producto producto) {
        producto.setId(null);
        return repositorio.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto datos) {
        Producto existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setDescripcion(datos.getDescripcion());
        existente.setPrecio(datos.getPrecio());
        existente.setCantidad(datos.getCantidad());
        return repositorio.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        Producto existente = buscarPorId(id);
        repositorio.delete(existente);
    }
}
