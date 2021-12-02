package com.reactive.shopreactive.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "categorias")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private boolean estado;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> listaProductos;
}
