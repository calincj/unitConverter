package org.fastrackit.unitconverter.utility;

import java.text.DecimalFormat;
import org.fastrackit.unitconverter.model.Unit;

public class WeightUtility {

    public static String convert(Unit unit, Double value) {
        if (unit.getFromUnit().equals("k") && unit.getToUnit().equals("p")) {
            double data = value * unit.getRatio();
            return new DecimalFormat("##.##").format(data) + " P ";
        }

        if (unit.getFromUnit().equals("k") && unit.getToUnit().equals("s")) {
            double data = value * unit.getRatio();
            return new DecimalFormat("##.##").format(data) + " S ";
        }
        return null;
    }

}
