package mixedquantum.blogspot.com.weather.ui.activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import mixedquantum.blogspot.com.weather.R;


public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private CoordinatorLayout mCoordinatorLayout;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        getToolbar();
    }

    public Toolbar getToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (mToolbar != null) {
                setSupportActionBar(mToolbar);
            }
        }
        return mToolbar;
    }

    public void setScreenTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }


    public void setStatusBarTranslucent(boolean makeTranslucent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (makeTranslucent) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            } else {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    public View getCoordinatorLayout() {
        if (mCoordinatorLayout == null) {
            mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.container);
        }
        return mCoordinatorLayout;
    }

    public void showErrorSnackbar(String message) {
        if (getCoordinatorLayout() != null) {
            if (mSnackbar != null) {
                mSnackbar.dismiss();
            }
            mSnackbar = Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG);
            View snackbarView = mSnackbar.getView();
            snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            TextView snackbarText = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
            snackbarText.setTextColor(Color.WHITE);
            mSnackbar.show();
        }
    }
}
