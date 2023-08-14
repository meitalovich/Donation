package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int totalDonated = 0;

    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private TextView textView;
    private int target=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        totalDonated = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);
        textView=findViewById(R.id.textView);
        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(10000);
        progressBar.setMax(10000);
        textView.setText("Total so far "+totalDonated);


    }

    public void decButtonPressed(View view)
    {
        amountPicker.setValue(totalDonated);
        progressBar.setProgress(totalDonated);
        if(totalDonated>0)
        {
            totalDonated--;
            amountPicker.setValue(totalDonated);
            progressBar.setProgress(totalDonated);
        }
        textView.setText("Total so far "+totalDonated);
    }

    public void incButtonPressed(View view)
    {
        amountPicker.setValue(totalDonated);
        progressBar.setProgress(totalDonated);
        if(totalDonated<10000)
        {
            totalDonated++;
            amountPicker.setValue(totalDonated);
            progressBar.setProgress(totalDonated);
        }
        textView.setText("Total so far "+totalDonated);
    }

    public void donateButtonPressed (View view)
    {
        EditText inputText=findViewById(R.id.lastvaltxt);
        int val=0;
        if(inputText.length()>0)
        {
            val=Integer.parseInt( inputText.getText().toString());
            amountPicker.setValue(totalDonated+val);
        }
        totalDonated = totalDonated + val;
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ? "PayPal" : "Direct";
        progressBar.setProgress(totalDonated);
        textView.setText("Total so far "+totalDonated);
        Toast toast = Toast.makeText(this, "Thanks for donating", Toast.LENGTH_SHORT);
        toast.show();
        inputText.setText("");

        if(totalDonated>=target)
        {
            Toast toast1 = Toast.makeText(this, "Reached the Target", Toast.LENGTH_SHORT);
            toast1.show();
            finish();

        }


    }

}