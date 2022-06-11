package com.davidmendieta.primerapi.repository


import com.davidmendieta.primerapi.model.DeporteView

import org.springframework.data.jpa.repository.JpaRepository


interface DeporteViewRepository: JpaRepository<DeporteView, String> {



}