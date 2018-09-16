package com.arit.demo.localstoage;

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.TableRow;
import android.widget.Toast;

import com.arit.demo.localstoage.model.User;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;

public class BaseApplicaton extends Application {

    private RealmAsyncTask task;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("setting",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key","test shared preferences");
        editor.putBoolean("safe-mode",true);
        editor.apply();

        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("local.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
        Realm realm = Realm.getDefaultInstance();
      //  realm.createObject(User.class); //Manage Object

        final User user = new User(); // UnManage Object
        user.setFirstname("John");
        user.setLastname("Doe");


//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.insert(user);
//            }
//        });

        task = realm.executeTransactionAsync(new Realm.Transaction() {
                  @Override
                  public void execute(Realm realm) {
                      realm.insert(user);

                  }
                  }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(BaseApplicaton.this, "Inser Completed", Toast.LENGTH_SHORT).show();
                    }
                  }, new Realm.Transaction.OnError() {
                      @Override
                      public void onError(Throwable error) {

                      }
                  });

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Realm.getDefaultInstance().close();
        this.task.cancel();
    }
}
