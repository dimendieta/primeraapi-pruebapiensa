package com.davidmendieta.primerapi.repository


import com.davidmendieta.primerapi.model.Tarea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional


interface TareaRepository:JpaRepository<Tarea,Long> {

    fun findById(id:Long?):Tarea?

    @Query(nativeQuery = true)
    fun getListadeTarea(@Param("descripcion") descripcion:String?):List<Tarea>?

    @Query(nativeQuery = true)
    fun getListadeTareas(@Param ("dificultad") dificultad:String?): List<Tarea>?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherTareas(@Param ("nombreDificultad") nombreTarea:String?,@Param ("actualizarDificultad") actualizarDificultad:String?): Integer?
}