package oo.max.oodisplayspecs.ui;


import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import oo.max.oodisplayspecs.system.CustomApplication;

public abstract class AbstractActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomApplication.getApplication(this).inject(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

}
