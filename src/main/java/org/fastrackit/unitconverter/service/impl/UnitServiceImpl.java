package org.fastrackit.unitconverter.service.impl;

import java.util.List;

import org.fastrackit.unitconverter.model.Unit;
import org.fastrackit.unitconverter.repo.UnitRepo;
import org.fastrackit.unitconverter.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "unitservice")
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitRepo unitRepo;

    @Override
    public List<Unit> getUnit(String type, String fromUnit, String toUnit) {
        return unitRepo.findUnitByTypeAndName(type, fromUnit, toUnit);
    }

    @Override
    public List<Unit> getUnits(String type) {
        return unitRepo.findUnitByType(type);
    }

}