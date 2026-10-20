package co.edu.poli.papeleria.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad de negocio Producto (según el diagrama de clases).
 * Reglas de negocio: precio >= 0 y cantidad >= 0.
 * Pendiente: validaciones, constructores, getters y setters.
 */
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
}
