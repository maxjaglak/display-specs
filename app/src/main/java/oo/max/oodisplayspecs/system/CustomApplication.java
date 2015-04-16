package oo.max.oodisplayspecs.system;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import dagger.ObjectGraph;

public class CustomApplication extends Application implements Thread.UncaughtExceptionHandler{

    public static final String TAG = "SpecsApplication";

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(this);
        createObjectGraph();
    }

    private void createObjectGraph() {
        objectGraph = ObjectGraph.create(new InjectingModule(this));
    }

    public void inject(Object target) {
        objectGraph.inject(target);
    }

    public static CustomApplication getApplication(Context context) {
        return (CustomApplication) context.getApplicationContext();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e(TAG, ex.getMessage(), ex);
    }
}
