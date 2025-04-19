package com.CRUD.controllers;

import com.CRUD.dtos.RegistrationDto;
import com.CRUD.entities.Registration;
import com.CRUD.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    private RegistrationService rs;

    public RegistrationController(RegistrationService rs){
        this.rs = rs;
    }

    //http://localhost:8080/api/v1/saveData
    @PostMapping("/saveData")
    public ResponseEntity<Registration> saveRegistration(@RequestBody Registration reg) {
        // Call the service to save the registration
        Registration registration = rs.saveRegistration(reg);
        // Return a CREATED status with the saved registration data
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/deleted/2
    @DeleteMapping("/deleted/{id}")
    public String deleteRegistration(
         @PathVariable long id
    ){
        rs.deleteRegistration(id);
        return "deleted";
    }

    //http://localhost:8080/api/v1/updated/2
    @PutMapping("/updated/{id}")
    public String updateRegistration(
            @PathVariable long id, @RequestBody Registration reg
    ){
        rs.updateRegistration(id, reg);
        return "updated";
    }
}
