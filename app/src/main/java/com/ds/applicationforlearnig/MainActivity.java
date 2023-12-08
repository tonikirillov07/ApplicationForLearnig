package com.ds.applicationforlearnig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ds.applicationforlearnig.incomes.Income;
import com.ds.applicationforlearnig.incomes.ShipsServiceIncome;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resultTextView);
        
        calculateMonthIncome();
    }

    private void calculateMonthIncome() {
        Income rentPortSpace = new Income(1, "Аренда площадей порта", 170000);
        ShipsServiceIncome shipsService = new ShipsServiceIncome(2, "Обслуживание морских судов", 3500, 125);

        int incomeResult = rentPortSpace.getCost() + shipsService.getCostPerMonth();

        result.setText("За услуги " + rentPortSpace.getName() + ", \n "+shipsService.getName() + " порт заработает за месяц " + incomeResult + " монет");
    }


}