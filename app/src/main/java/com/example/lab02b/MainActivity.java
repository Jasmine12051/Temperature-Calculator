package com.example.lab02b;

import static java.lang.Double.parseDouble;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lab02b.databinding.ActivityMainBinding;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText fahrenheitInput = binding.FahrenheitInput;
                EditText celsiusInput = binding.CelsiusInput;
                String fahrenheit = fahrenheitInput.getText().toString();
                String celsius = celsiusInput.getText().toString();
                checkInputs(fahrenheit, celsius);
            }
        });

    }

    private void checkInputs(String fahrenheit, String celsius){
        if(fahrenheit.isEmpty() && celsius.isEmpty()){
            Log.d("CHECK INPUTS", "ERROR: All inputs not provided!");
        }

        else if(celsius.matches("") && !fahrenheit.isEmpty()){
            double fahrenheitNum = parseDouble(fahrenheit);
            calculateCelsius(fahrenheitNum);
        }
        else if(fahrenheit.matches("") && !celsius.isEmpty()){
                double celsiusNum = parseDouble(celsius);
                calculateFahrenheit(celsiusNum);
            }
        else if(!fahrenheit.isEmpty() && !celsius.isEmpty()){
            double fahrenheitNum = parseDouble(fahrenheit);
            calculateCelsius(fahrenheitNum);
        }
        else{
            Log.d("CHECK INPUTS", "Found Non-Numeric value!");
        }
    }

    private void calculateCelsius(double fahrenheit) {
        DecimalFormat roundFormatter = new DecimalFormat("#,##0.00");
        double conversion = ((double) 5 /9) * (fahrenheit - 32);
        String formattedResult = roundFormatter.format(conversion);
        TextView t = binding.output;
        String outputText = "Fahrenheit to Celsius: " + formattedResult;
        t.setText(outputText);
    }

    private void calculateFahrenheit(double celsius) {
        DecimalFormat roundFormatter = new DecimalFormat("#,##0.00");
        double conversion = ((double) 9 /5 * celsius) + 32;
        String formattedResult = roundFormatter.format(conversion);
        TextView t = binding.output;
        String outputText = "Celsius to Fahrenheit: " + formattedResult;
        t.setText(outputText);
    }

}