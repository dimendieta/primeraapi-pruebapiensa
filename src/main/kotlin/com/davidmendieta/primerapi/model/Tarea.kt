package com.davidmendieta.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "Tarea")
class Tarea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var descripcion: String? = null
    var dificultad : String? = null
    @Column(name = "docente_id")
    var docenteId: Long? = null


}