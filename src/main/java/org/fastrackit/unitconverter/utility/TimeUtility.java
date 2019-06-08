package org.fastrackit.unitconverter.utility;

import java.text.DecimalFormat;

import org.fastrackit.unitconverter.model.Unit;

public class TimeUtility {

    public static String convert(Unit unit, Double value) {
        if (unit.getFromUnit().equals("s") && unit.getToUnit().equals("m")) {
            double data = value * unit.getRatio();
            return new DecimalFormat("##.##").format(data) + " M ";
        }

        if (unit.getFromUnit().equals("m") && unit.getToUnit().equals("s")) {
            double data = value * unit.getRatio();
            return new DecimalFormat("##.##").format(data) + " S ";
        }
        return null;
    }

}