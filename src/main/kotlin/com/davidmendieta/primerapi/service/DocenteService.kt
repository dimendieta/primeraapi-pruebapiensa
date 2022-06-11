package com.davidmendieta.primerapi.service


import com.davidmendieta.primerapi.dto.ActualizarDocente
import com.davidmendieta.primerapi.model.Docente
import com.davidmendieta.primerapi.repository.DocenteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional


@Service
class DocenteService {

    @Autowired
    lateinit var docenteRepository: DocenteRepository

    fun list():List<Docente>{
        return docenteRepository.findAll()
    }

    fun getById(id:Long?): Docente?{
        return docenteRepository.findById(id)
    }

    fun getByDocente(nombre: String?):List<Docente>?{
        return docenteRepository.getListadeDocente(nombre)
    }

    fun getByDocentes (direccion: String?): List<Docente>?{
        return docenteRepository.getListadeDocentes(direccion)

    }
    fun getByDocent (correo: String?): List<Docente>?{
        return docenteRepository.getListasdeDocent(correo)

    }

    fun save(docente: Docente): Docente{
        try {
            docente.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Descripcion no debe ser vacio")
            return docenteRepository.save(docente)
        } catch (ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun update ( docente: Docente):Docente{
        docenteRepository.findById(docente.id)?: throw Exception()
        return docenteRepository.save(docente)
    }

    fun updateName(docente: Docente): Docente{
        try {
            val response = docenteRepository.findById(docente.id)
                    ?: throw Exception("El id ${docente.id} del docente no existe")
            response.apply {
                this.nombre = docente.nombre
            }
            return docenteRepository.save(docente)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

    }
        @Transactional
        fun updateOtherNombreDocente(actualizarDocente: ActualizarDocente): String{
            val rowsUpdate=docenteRepository.setOtherNombreDocente(actualizarDocente.nombreDocente, actualizarDocente.actualizarDocente)
            return "${rowsUpdate} rows updated"
        }

        fun delete (id:Long): Boolean{
            docenteRepository.deleteById(id)
            return true
        }




}











