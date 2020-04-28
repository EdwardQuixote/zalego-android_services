package uk.co.edwardquixote.Zalego.ServiceProject;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ServiceHelloWorld extends Service {

    private ServiceHelloWorldHandler classServiceHelloWorldHandler;

    private Looper looperFromHandlerThread;


    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("ServiceHelloWorld", "onCreate() CALLED!");

//        HandlerThread handlerThread = new HandlerThread("ServiceHelloWorldThread", Process.THREAD_PRIORITY_BACKGROUND);
//        handlerThread.start();
//
//        looperFromHandlerThread = handlerThread.getLooper();
//        classServiceHelloWorldHandler = new ServiceHelloWorldHandler(looperFromHandlerThread);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Log.e("ServiceHelloWorld", "onStartCommand() CALLED!");

//        Message newRequestMessage = classServiceHelloWorldHandler.obtainMessage();
//        newRequestMessage.arg1 = startId;
//        classServiceHelloWorldHandler.sendMessage(newRequestMessage);

        Toast.makeText(ServiceHelloWorld.this, "I'm a running service!", Toast.LENGTH_LONG).show();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("ServiceHelloWorld", "onDestroy() CALLED!");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    private final class ServiceHelloWorldHandler extends Handler {

        public ServiceHelloWorldHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Toast.makeText(ServiceHelloWorld.this, "I'm a running service!", Toast.LENGTH_LONG).show();

            try {

                Thread.sleep(3000);

            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }

            stopSelf();

        }
    }

}
