package com.davidmendieta.primerapi.controller




import com.davidmendieta.primerapi.model.Deporte
import com.davidmendieta.primerapi.model.DeporteView
import com.davidmendieta.primerapi.service.DeporteService
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
@RequestMapping("/deporte")
class DeporteController {

    @Autowired
    lateinit var deporteService: DeporteService

    @GetMapping
    fun list(): List<Deporte>{
        return deporteService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Deporte?{
        return deporteService.getById(id)
    }

    //Query String Nombre
    //localhost:8081/docente/nombre/David
    @GetMapping("/name/{name}")
    fun listByNombresDeport(@PathVariable ("name") name:String): List<Deporte>?{
        return deporteService.getByDeport(name)
    }









    @GetMapping("/frecuencia/hora")
    fun getFrecuenciaHora (): List<DeporteView>?{
        return deporteService.getFrecuenciaHora()
    }


    @PostMapping
    fun save(@RequestBody deporte: Deporte): Deporte{
        return deporteService.save(deporte)
    }

    @PutMapping
    fun update(@RequestBody deporte: Deporte): Deporte{
        return deporteService.update(deporte)
    }

    @PatchMapping
    fun updateName(@RequestBody deporte: Deporte): Deporte{
        return deporteService.updateName(deporte)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return deporteService.delete(id)
    }




}