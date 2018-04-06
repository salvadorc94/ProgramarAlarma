package com.salvador.programaralarma;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button setAlarm;
    EditText hora;
    EditText minuto;
    EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarm = (Button) findViewById(R.id.botonSetAlarm);
        mensaje = (EditText) findViewById(R.id.text_mensaje);
        hora = (EditText) findViewById(R.id.text_hora);
        minuto = (EditText) findViewById(R.id.text_minutos);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(AlarmClock.ACTION_SET_ALARM);

                if(mensaje.length() != 0 && hora.length() != 0 && minuto.length() != 0){
                    sendIntent.putExtra(AlarmClock.EXTRA_MESSAGE, mensaje.getText().toString());
                    sendIntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hora.getText().toString()));
                    sendIntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minuto.getText().toString()));

                    if (sendIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(sendIntent);
                    }
                }

            }
        });

    }
}
