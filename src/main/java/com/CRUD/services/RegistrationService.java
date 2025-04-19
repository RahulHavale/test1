package com.CRUD.services;

import com.CRUD.Repositories.RegistrationRepository;
import com.CRUD.dtos.RegistrationDto;
import com.CRUD.entities.Registration;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class RegistrationService {

    private RegistrationRepository rp;
    private ModelMapper mm;

    public RegistrationService(RegistrationRepository rp,ModelMapper mm){
        this.mm = mm;
        this.rp = rp;
    }

    public Registration saveRegistration(Registration reg) {
        // You don't need to set the id manually, just use the incoming reg object
        return rp.save(reg);
    }


    public void deleteRegistration(long id) {
        rp.deleteById(id);
    }

    public void updateRegistration(
            long id, Registration reg
    ){
        Optional<Registration> opReg = rp.findById(id);
        Registration registration = opReg.get();
        registration.setId(reg.getId());
        registration.setName(reg.getName());
        registration.setEmail(reg.getEmail());
        registration.setMobile(reg.getMobile());
        rp.save(registration);
    }
}
