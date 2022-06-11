package com.davidmendieta.primerapi.service

import com.davidmendieta.primerapi.dto.ActualizarTarea
import com.davidmendieta.primerapi.model.Tarea
import com.davidmendieta.primerapi.repository.TareaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional


@Service
class TareaService {

    @Autowired
    lateinit var tareaRepository: TareaRepository

    fun list(): List <Tarea>{
        return tareaRepository.findAll()
    }

    fun getById(id :Long?): Tarea?{
        return tareaRepository.findById(id)
    }

    fun getByTarea (descripcion: String?): List<Tarea>?{
        return tareaRepository.getListadeTarea(descripcion)

    }

    fun getByTareas(dificultad: String?): List<Tarea>?{
        return tareaRepository.getListadeTareas(dificultad)
    }

    fun save(tarea: Tarea): Tarea{
        try {
            tarea.descripcion?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception ("Descripcion no debe ser vacio")

            return tareaRepository.save(tarea)
        }catch (ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun update(tarea: Tarea):Tarea{
        tareaRepository.findById(tarea.id)?:throw Exception()
        return tareaRepository.save(tarea)
    }

    fun updateName(tarea: Tarea): Tarea{
        try {
            val response= tareaRepository.findById(tarea.id)
                    ?: throw Exception("El id ${tarea.id} de la tarea no existe")
            response.apply {
                this.descripcion=tarea.descripcion
            }
            return tareaRepository.save(tarea)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
    @Transactional
    fun updateOtherDificultad (actualizarTarea: ActualizarTarea): String{
        val  rowsUpdate=tareaRepository.setOtherTareas(actualizarTarea.nombreDificultad,actualizarTarea.actualizarDificultad)
        return "${rowsUpdate} rows updated"
    }

    fun delete(id:Long): Boolean{
        tareaRepository.deleteById(id)
        return true
    }

}