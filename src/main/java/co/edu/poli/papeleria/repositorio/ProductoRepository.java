package co.edu.poli.papeleria.repositorio;

import co.edu.poli.papeleria.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos. Spring Data JPA (ORM) genera las operaciones CRUD.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
