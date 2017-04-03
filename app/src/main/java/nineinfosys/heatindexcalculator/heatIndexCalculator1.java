package nineinfosys.heatindexcalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class heatIndexCalculator1 {

    private int temperature;
    private double humidity;
    private double heatIndex;
    String spinner;
    //private IncomeTaxResults incomeTaxResults;
    public static final String RESULT_FORMAT = "#.#";

    public double calculateHeatIndex ( double currentTemp, double currentHumidity ,String spinner) {
        //Setting parameters for Function
    	// double Hindex;
        double temperature = currentTemp;
        double humidity = currentHumidity;
        double answer;
        final double C1 = -42.379;
        final double C2 = 2.04901523;
        final double C3 = 10.14333127;
        final double C4 = -0.22475541;
        final double C5 = -.00683783;
        final double C6 = -5.481717E-2;
        final double C7 = 1.22874E-3;
        final double C8 = 8.5282E-4;
        final double C9 = -1.99E-6;
        double T = temperature;
        double R = humidity;
        double T2 = temperature * temperature;
        double R2 = humidity * humidity;

/*      Hindex = -42.379 + 2.04901523 * currentTemp + 10.14333127 * currentHumidity;
         Hindex = Hindex - 0.22475541 * currentTemp * currentHumidity - 6.83783 * Math.pow(10, -3) * currentTemp * currentTemp;
         Hindex = Hindex - 5.481717 * Math.pow(10, -2) * currentHumidity * currentHumidity;
         Hindex = Hindex + 1.22874 * Math.pow(10, -3) * currentTemp * currentTemp * currentHumidity;
         Hindex = Hindex + 8.5282 * Math.pow(10, -4) * currentTemp * currentHumidity * currentHumidity;
         Hindex = Hindex - 1.99 * Math.pow(10, -6) * currentTemp * currentTemp * currentHumidity * currentHumidity;*/


        answer = C1 + (C2 * T) + (C3 * R) + (C4 * T * R) + (C5 * T2) + (C6 * R2) + (C7 * T2 * R) + (C8 * T * R2) + (C9 * T2 * R2);
        //  double answer=C1+result1+result2+result3+result4+result5+result6+result7+result8;
        //   return answer;
         DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
         df.setRoundingMode(RoundingMode.HALF_UP);
        this.spinner = spinner;
         return Double.parseDouble(df.format(answer));
     }


   /* public class IncomeTaxResults{

        private double incomeTaxAfterRelief;

      }

    public double  calculateIncomeTaxAfterRelief() {
        Scanner input = new Scanner(System.in);
        double currentTemp = input.nextDouble();

        if (spinner == "fahrenheit") {

            double incomeTaxAfterRelief= ((currentTemp - 32)*5)/9;

            return incomeTaxAfterRelief;

        } else if (spinner == "celcius") {

            double incomeTaxAfterRelief = calculateIncomeTaxSeniorCitizen();

            return incomeTaxAfterRelief;

        } else if (spinner == "kelvin") {

            double incomeTaxAfterRelief = calculateIncomeTaxSuperSeniorCitizen();

            return incomeTaxAfterRelief;

        }
        else
            return 0;
    }

    private double calculateIncomeTaxSuperSeniorCitizen() {

        return 0;
    }

    private double calculateIncomeTaxSeniorCitizen() {
        return 0;
    }

    private double calculateIncomeTaxCitizen() {
        return 0;
    }*/
}