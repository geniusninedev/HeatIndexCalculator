package nineinfosys.heatindexcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView temperatureTextView,percentageTextView,descriptionTextView,resultTextView;
    EditText percentageEditText;
    TextView temp;
    EditText tempEditText;
heatIndexCalculator1 heatIndex;
    Spinner temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperature = (Spinner) findViewById(R.id.spinnerTemperature);
      //  temperatureTextView=(TextView)findViewById(R.id.textViewTemperature);
        percentageTextView=(TextView)findViewById(R.id.textViewPercentage);
        descriptionTextView=(TextView)findViewById(R.id.textViewDescription);
        resultTextView=(TextView)findViewById(R.id.textViewResult);
        temp=(TextView)findViewById(R.id.textViewTemp);
        tempEditText=(EditText)findViewById(R.id.editTextTemp);

     //   temperatureEditText=(EditText)findViewById(R.id.editTextTemperature);
        percentageEditText=(EditText)findViewById(R.id.editTextPercentage);

        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);

        ArrayList gender = new ArrayList();
        gender.add("fahrenheit");
        gender.add("celcius");
        gender.add("kelvin");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperature.setAdapter(dataAdapter);
        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinnerGender=temperature.getSelectedItem().toString().trim();


                //String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);

               if (TextUtils.isEmpty(tempEditText.getText().toString().trim())) {
                   tempEditText.setError("enter the temperature");
                    return;
                }
                if (TextUtils.isEmpty(percentageEditText.getText().toString().trim())) {
                    percentageEditText.setError("enter the humidity percentage");
                    return;
                }
              double temperatureValue=Double.parseDouble(tempEditText.getText().toString().trim());

                double pressureValue=Double.parseDouble(percentageEditText.getText().toString().trim());


                String consumptionValue1 = Double.toString((double) temperatureValue);
                String governmentconsumption1 = Double.toString((double) pressureValue);


                heatIndex=new heatIndexCalculator1();
                double resultgrossDomesticProductValue=heatIndex.calculateHeatIndex(temperatureValue,pressureValue,spinnerGender);

                  //String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);
                descriptionTextView.setText("\nAt a temperature of" + temperatureValue + "and a humidity of" + pressureValue + "percent . . .\n");
                resultTextView.setText( "Heat Index Temperature:".toString()+Double.toString((double) resultgrossDomesticProductValue));



            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tempEditText.getText().clear();
                percentageEditText.getText().clear();
                resultTextView.setText("");
                descriptionTextView.setText("");

            }
        });

    }
}
