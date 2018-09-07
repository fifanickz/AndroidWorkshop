package com.arit.demo.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.tvMessage) TextView tvMessage;
    @BindView(R.id.tvResult) TextView tvResult;
    @BindView(R.id.etHeight) EditText etHeight;
    @BindView(R.id.etWeight) EditText etWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //init bk
    }

    @OnClick(R.id.btnSubmit)
    public void doClickHello(){
        this.tvResult.setText(adviceResult());

    }

    public String adviceResult(){
      double bmi =  calBMI();
      String result = new String();
      if (bmi < 15 ) {
          result = adviceFormat(bmi, "Very severely underweight");
      } else if (bmi >= 15 && bmi <=16 ) {
          result = adviceFormat(bmi, "Severely underweight");
      } else if (bmi > 16 && bmi <=18.5 ) {

          result =  adviceFormat(bmi, "Underweight");
      } else if (bmi > 18.5 && bmi <= 25 ) {
          result = adviceFormat(bmi, "Normal (healthy weight)");
      } else if (bmi > 25 && bmi <= 30 ) {
          result = adviceFormat(bmi, "Overweight");
      } else if (bmi > 30 && bmi <=35 ) {
          result = adviceFormat(bmi, "Moderately obese");
      } else if (bmi > 35 && bmi <=40 ) {
          result = adviceFormat(bmi, "Severely obese");
      } else if (bmi > 40  ) {
          result =  adviceFormat(bmi, "Very severely obese");
      }
        return result;
    }

    public String adviceFormat(double bmi , String wording){
       return String.format("Your BMI is  %.2f : %s", bmi,wording);
    }

    public double calBMI() {
        double  weight = Double.parseDouble(etWeight.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        return weight / Math.pow(height/100,2);
    }

}
