package com.jayklef.reddito.controller;

import com.jayklef.reddito.dtos.EarningsDTO;
import com.jayklef.reddito.error.EarningNotFoundException;
import com.jayklef.reddito.model.Earnings;
import com.jayklef.reddito.service.EarningsService;
import com.jayklef.reddito.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EarningsController {

    private EarningsService earningsService;
    private ProfileService profileService;

    @Autowired
    public EarningsController(EarningsService earningsService, ProfileService profileService) {
        this.earningsService = earningsService;
        this.profileService = profileService;
    }

    @PostMapping("/earnings")
    public Earnings saveEarning(@RequestBody @Valid EarningsDTO earningsDto){
        return earningsService.saveEarning(earningsDto);
    }

    @GetMapping("/earnings")
    public List<Earnings> getEarningsList(){
        return earningsService.getEarningsList();
    }

    @GetMapping("/earnings/{id}")
    public Earnings getEarningById(@PathVariable("id") Long Id) throws EarningNotFoundException {
        return earningsService.getEarningById(Id);
    }


    @DeleteMapping("/earnings/{id}")
    public String deleteEarning(@PathVariable ("id") Long Id){
        earningsService.deleteEarning(Id);
        return "Earning deleted successfully";
    }
}
