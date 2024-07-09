package test.com.mvp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import test.com.mvp.splash.SplashFragment;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swapFragment(new SplashFragment(), "SplashFragment", true);
    }

    public void swapFragment(final Fragment newFragment, final String tag, final boolean addToStack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    final FragmentManager fm = getSupportFragmentManager();
                    final FragmentTransaction transaction = fm.beginTransaction();

                    transaction.replace(R.id.container, newFragment, tag);

                    if (addToStack) {
                        transaction.addToBackStack(null);
                    }

                    transaction.commitAllowingStateLoss();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        mHandler.postDelayed(runnable, 1);
    }

}
