package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.a2luglios.listasharedroid.util.DadosSync;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_layout);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new DadosSync(SplashActivity.this).carregaDados();

                finish();
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        }).start();
    }
}
