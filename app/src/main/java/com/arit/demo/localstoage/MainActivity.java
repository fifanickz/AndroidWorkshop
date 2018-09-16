package com.arit.demo.localstoage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.arit.demo.localstoage.model.User;

import java.util.Observable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private String displayname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @OnClick(R.id.btnGetPref)
    public void onGetPref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("setting",MODE_PRIVATE);
       this.displayname = pref.getString("key","");
        Toast.makeText(this, "Pref: "+this.displayname, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnGetRealData)
    public void onInsertRealm() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User results = realm.where(User.class).findFirst();


                Toast.makeText(MainActivity.this, results.getFirstname(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
