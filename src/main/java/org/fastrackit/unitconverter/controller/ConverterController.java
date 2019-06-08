package org.fastrackit.unitconverter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.fastrackit.unitconverter.model.Unit;
import org.fastrackit.unitconverter.service.UnitService;
import org.fastrackit.unitconverter.utility.TimeUtility;
import org.fastrackit.unitconverter.utility.WeightUtility;
import org.fastrackit.unitconverter.utility.TemperatureUtility;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/converter")
public class ConverterController {

    @Autowired
    UnitService unitService;

    @GetMapping(value = "/{type}")
    public ResponseEntity<?> getUnits( @PathVariable("type") String type) {
        List<Unit> units = unitService.getUnits(type);
        if(units==null||units.isEmpty()) {
            return ResponseEntity.badRequest().body("Not available.");
        }
        return ResponseEntity.ok().body(units);
    }

    @GetMapping(value = "/time/{funit}/{tunit}/{value}")
    public ResponseEntity<?> getTimeConvertedValue(@PathVariable("funit") String fromUnit,
                                                   @PathVariable("tunit") String toUnit, @PathVariable("value") Double value) {
        List<Unit> units = unitService.getUnit("TIME", fromUnit, toUnit);
        if(units==null||units.isEmpty()) {
            return ResponseEntity.badRequest().body("Not available.");
        }
        String response=TimeUtility.convert(units.get(0),value);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/weight/{funit}/{tunit}/{value}")
    public ResponseEntity<?> getWeightConvertedValue(@PathVariable("funit") String fromUnit,
                                                     @PathVariable("tunit") String toUnit, @PathVariable("value") Double value) {
        List<Unit> units = unitService.getUnit("WEIGHT", fromUnit, toUnit);
        if(units==null||units.isEmpty()) {
            return ResponseEntity.badRequest().body("Not available.");
        }
        String response=WeightUtility.convert(units.get(0),value);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping(value = "/temperature/{funit}/{tunit}/{value}")
    public ResponseEntity<?> getTemperatureConvertedValue(@PathVariable("funit") String fromUnit,
                                                     @PathVariable("tunit") String toUnit, @PathVariable("value") Double value) {
        List<Unit> units = unitService.getUnit("TEMPERATURE", fromUnit, toUnit);
        if(units==null||units.isEmpty()) {
            return ResponseEntity.badRequest().body("Not available.");
        }
        String response=TemperatureUtility.convert(units.get(0),value);
        return ResponseEntity.ok().body(response);
    }

}