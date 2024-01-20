package com.diplomado.springboot.web.rest.controller;

import com.diplomado.springboot.dto.DepartmentDTO;
import com.diplomado.springboot.dto.VacationDTO;
import com.diplomado.springboot.services.VacationsServices;
import com.diplomado.springboot.web.rest.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("v1/vacation")
public class VacationsController {

    private final VacationsServices vacationsServices;

    public VacationsController(VacationsServices vacationsServices) {
        this.vacationsServices = vacationsServices;
    }


    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<VacationDTO>> getVacations() {
        return ResponseEntity.ok().body(vacationsServices.listVacations());
    }

    @GetMapping(path = "/get/{id}")
    public VacationDTO getVacationById(@PathVariable("id") Integer id) {
        return vacationsServices.getVacations(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<VacationDTO> createVacation(@Valid @RequestBody VacationDTO vacationDTO) throws URISyntaxException {
        if (vacationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.created(null).body(vacationsServices.createVacations(vacationDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<VacationDTO> updateVacation(@PathVariable("id") Integer id,
                                                          @RequestBody VacationDTO vacationDTO) {
        if (vacationDTO == null) {
            throw new ApiRequestException("Invalid input data. Please check the provided information.");
        }
        return ResponseEntity.ok().body(vacationsServices.updateVacations(id, vacationDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<VacationDTO> deleteVacation(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(vacationsServices.deleteVacations(id));
    }
}
