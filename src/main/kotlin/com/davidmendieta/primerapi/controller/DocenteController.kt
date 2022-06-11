package com.davidmendieta.primerapi.controller


import com.davidmendieta.primerapi.dto.ActualizarDocente
import com.davidmendieta.primerapi.model.Docente
import com.davidmendieta.primerapi.service.DocenteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/docente")
class DocenteController {

   @Autowired
   lateinit var docenteService: DocenteService

   @GetMapping
   fun list(): List<Docente>{
       return docenteService.list()
   }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Docente?{
        return docenteService.getById(id)
    }

    //Query String Nombre
    //localhost:8081/docente/nombre/David
    @GetMapping("/nombre/{nombre}")
    fun listByNombresD(@PathVariable ("nombre") nombre:String): List<Docente>?{
        return docenteService.getByDocente(nombre)
    }


    //Query String Direccion
    //localhost:8081/docente/direccion/Cebollar
    @GetMapping("/direccion/{direccion}")
    fun lisByDocente(@PathVariable ("direccion") direccion : String): List<Docente>?{
        return docenteService.getByDocentes(direccion)
    }

    //Query String Correo
    //localhost:8082/docente/correo/david@gmail.com
    @GetMapping("/correo/{correo}")
    fun lisByDocent(@PathVariable("correo") correo: String): List<Docente>?{
        return docenteService.getByDocent(correo)
    }

    @PostMapping("/update/nombre")
    fun updateOtherNombreDocente(@RequestBody actualizarDocente: ActualizarDocente): String?{
     return docenteService.updateOtherNombreDocente(actualizarDocente)
    }

    @PostMapping
    fun save(@RequestBody docente: Docente): Docente{
        return docenteService.save(docente)
    }

    @PutMapping
    fun update(@RequestBody docente: Docente): Docente{
        return docenteService.update(docente)
    }

    @PatchMapping
    fun updateName(@RequestBody docente: Docente): Docente{
        return docenteService.updateName(docente)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return docenteService.delete(id)
    }















}




