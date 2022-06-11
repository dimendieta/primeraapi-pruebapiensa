package com.davidmendieta.primerapi.controller

import com.davidmendieta.primerapi.dto.ActualizarDocente
import com.davidmendieta.primerapi.dto.ActualizarTarea

import com.davidmendieta.primerapi.model.Tarea
import com.davidmendieta.primerapi.service.TareaService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/tarea")

class TareaController {

    @Autowired
    lateinit var tareaService: TareaService

    @GetMapping
    fun list(): List <Tarea>{
        return tareaService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Tarea?{
        return tareaService.getById(id)
    }

    //Query String NombreTarea
    //Localhosto:8081/tarea/nombretarea/memoria
    @GetMapping("/descripcion/{descripcion}")
    fun listByTarea(@PathVariable("descripcion") descripcion: String): List<Tarea>?{
        return tareaService.getByTarea(descripcion)
    }

    //Quey String Tareas
    //localhost:8081/tarea/dificultad/facil
    @GetMapping("/dificultad/{dificultad}")
   fun lisByTareas(@PathVariable("dificultad") dificultad:String): List<Tarea>?{
    return tareaService.getByTareas(dificultad)

}

    //Query String Tarea
    //localhost:8081/tarea/cambiardificultad
    @PostMapping("/update/nombre")
    fun updateOtherDificultad(@RequestBody actualizarTarea: ActualizarTarea):String?{
        return tareaService.updateOtherDificultad(actualizarTarea)
    }

    @PostMapping
    fun save (@RequestBody tarea: Tarea):Tarea{
        return tareaService.save(tarea)
    }
    @PutMapping
    fun update(@RequestBody tarea: Tarea):Tarea{
        return tareaService.update(tarea)
    }
    @PatchMapping
    fun updateName(@RequestBody tarea: Tarea): Tarea{
        return tareaService.updateName(tarea)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return tareaService.delete(id)
    }





}