package com.davidmendieta.primerapi.repository

import com.davidmendieta.primerapi.model.Docente

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional


interface DocenteRepository:JpaRepository<Docente,Long> {
    fun findById(id: Long?): Docente?

    @Query(nativeQuery = true)
    fun getListadeDocente(@Param("nombre") nombre: String?):List <Docente>?

    @Query(nativeQuery = true)
    fun getListadeDocentes(@Param("direccion") direccion: String?): List<Docente>?

    @Query(nativeQuery = true)
    fun getListasdeDocent(@Param("correo") correo: String?): List<Docente>?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherNombreDocente(@Param("nombreDocente") nombreDocente: String?, @Param("actualizarDocente") actualizarDocente: String?):Integer?


}
