package com.davidmendieta.primerapi.service





import com.davidmendieta.primerapi.dto.CanchaDto

import com.davidmendieta.primerapi.model.Deporte
import com.davidmendieta.primerapi.model.DeporteView

import com.davidmendieta.primerapi.repository.DeporteRepository
import com.davidmendieta.primerapi.repository.DeporteViewRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional


@Service
class DeporteService {

    @Autowired
    lateinit var deporteRepository: DeporteRepository

    @Autowired
    lateinit var deporteViewRepository: DeporteViewRepository

    fun list():List<Deporte>{
        return deporteRepository.findAll()
    }

    fun getById(id:Long?): Deporte?{
        return deporteRepository.findById(id)
    }

    fun getByDeport(name: String?):List<Deporte>?{
        return deporteRepository.getListadeDeport(name)
    }

    fun getFrecuenciaHora(): List<DeporteView>{
        return deporteViewRepository.findAll()

    }

    fun save(deporte: Deporte): Deporte {
        try {
            deporte.name?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Descripcion no debe ser vacio")
            return deporteRepository.save(deporte)
        } catch (ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun update ( deporte: Deporte): Deporte {
        deporteRepository.findById(deporte.id)?: throw Exception()
        return deporteRepository.save(deporte)
    }

    fun updateName(deporte: Deporte): Deporte{
        try {
            val response = deporteRepository.findById(deporte.id)
                    ?: throw Exception("El id ${deporte.id} del docente no existe")
            response.apply {
                this.name = deporte.name
            }
            return deporteRepository.save(deporte)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

    }


    fun delete (id:Long): Boolean{
        deporteRepository.deleteById(id)
        return true
    }




}