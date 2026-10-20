package co.edu.poli.papeleria.excepcion;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(Integer id) {
        super("No existe un producto con id " + id);
    }
}
