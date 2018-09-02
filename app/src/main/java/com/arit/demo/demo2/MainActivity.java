package com.arit.demo.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.tvMessage) TextView tvMessage; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //init bk
    }

    @OnClick(R.id.btnSubmit)
    public void doClickHello(){
        this.tvMessage.setText("I love butter knife !!!");
    }

}
