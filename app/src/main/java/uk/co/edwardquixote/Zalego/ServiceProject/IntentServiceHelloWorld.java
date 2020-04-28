package uk.co.edwardquixote.Zalego.ServiceProject;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class IntentServiceHelloWorld extends IntentService {


    public IntentServiceHelloWorld() {
        super("IntentServiceHelloWorld");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Toast.makeText(IntentServiceHelloWorld.this, "I'm a running IntentService!", Toast.LENGTH_LONG).show();

    }

}
