package uk.co.edwardquixote.Zalego.ServiceProject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Intent intentStartHelloWorldService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MainActivity", "onCreate() CALLED!");

        initializeViewsAndClassObjects();

    }


    private void initializeViewsAndClassObjects() {

        Button btnStartService = (Button) this.findViewById(R.id.btnStartService);
        Button btnStopService = (Button) this.findViewById(R.id.btnStopService);
        btnStartService.setOnClickListener(clkMain);
        btnStopService.setOnClickListener(clkMain);

    }

    private void codeToStartHelloWorldService() {

        intentStartHelloWorldService = new Intent(MainActivity.this, ServiceHelloWorld.class);
        this.startService(intentStartHelloWorldService);

        Intent intentStartHelloWorldServiceB = new Intent(MainActivity.this, IntentServiceHelloWorld.class);
        this.startService(intentStartHelloWorldServiceB);

    }


    private View.OnClickListener clkMain = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnStartService:

                    codeToStartHelloWorldService();

                    break;

                case R.id.btnStopService:

                    stopService(intentStartHelloWorldService);

                    break;

            }

        }

    };

}
