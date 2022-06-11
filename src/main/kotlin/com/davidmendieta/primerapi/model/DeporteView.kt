package com.davidmendieta.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "deporte_view")
class DeporteView {

    @Id
    @Column(updatable = false)
    var hora: String? = null
    var frecuencia: Long?= null
}