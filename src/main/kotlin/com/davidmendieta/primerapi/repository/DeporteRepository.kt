package com.davidmendieta.primerapi.repository

import com.davidmendieta.primerapi.model.Deporte
//import com.davidmendieta.primerapi.model.DeporteView

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface DeporteRepository: JpaRepository<Deporte, Long> {

    fun findById(id: Long?): Deporte?

    @Query(nativeQuery = true)
    fun getListadeDeport(@Param("name") name: String?):List <Deporte>?


    @Modifying
    @Query(nativeQuery = true)
    fun setOtherdeportes(@Param("cancha") cancha: String?, @Param("frecuencia") frecuencia: String?): Integer?
}