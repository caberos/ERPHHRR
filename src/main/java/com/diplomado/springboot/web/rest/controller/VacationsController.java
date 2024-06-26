package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.VacationDTO;
import com.diplomado.springboot.services.VacationsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/vacation")
@Tag(name = "Vacaciones de Empleado")
public class VacationsController {

    private final VacationsServices vacationsServices;

    public VacationsController(VacationsServices vacationsServices) {
        this.vacationsServices = vacationsServices;
    }


    @GetMapping(path = "/getAllObjects")
    @Operation(summary = "Obtiene la lista de vacaciones de todos los empleados")
    public ResponseEntity<List<VacationDTO>> getVacations() {
        return ResponseEntity.ok().body(vacationsServices.listVacations());
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Obtiene la vacacion de un empleado")
    public VacationDTO getVacationById(@PathVariable("id") Integer id) {
        return vacationsServices.getVacations(id);
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Crea una vacacion de un empleado")
    public ResponseEntity<VacationDTO> createVacation(@Valid @RequestBody VacationDTO vacationDTO) throws URISyntaxException {
        if (vacationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(vacationsServices.createVacations(vacationDTO));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Actualiza una vacacion de un empleado")
    public ResponseEntity<VacationDTO> updateVacation(@PathVariable("id") Integer id,
                                                          @RequestBody VacationDTO vacationDTO) {
        if (vacationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(vacationsServices.updateVacations(id, vacationDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Elimina una vacacion de un empleado")
    public ResponseEntity<VacationDTO> deleteVacation(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(vacationsServices.deleteVacations(id));
    }
}
