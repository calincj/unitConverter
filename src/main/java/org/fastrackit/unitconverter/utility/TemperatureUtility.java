package org.fastrackit.unitconverter.utility;

import java.text.DecimalFormat;

import org.fastrackit.unitconverter.model.Unit;

public class TemperatureUtility {

    public static String convert(Unit unit, Double value) {
        if (unit.getFromUnit().equals("c") && unit.getToUnit().equals("f")) {
            double data = value * unit.getRatio();
            return new DecimalFormat("##.##").format(data) + " F ";
        }

        if (unit.getFromUnit().equals("f") && unit.getToUnit().equals("c")) {
            double data = value * unit.getRatio();
            return new DecimalFormat("##.##").format(data) + " C ";
        }
        return null;
    }

}
