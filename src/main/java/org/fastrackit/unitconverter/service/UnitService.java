package org.fastrackit.unitconverter.service;

import java.util.List;

import org.fastrackit.unitconverter.model.Unit;

public interface UnitService {

    public List<Unit> getUnit(String type,String fromUnit,String toUnit);

    public List<Unit> getUnits(String type);

}