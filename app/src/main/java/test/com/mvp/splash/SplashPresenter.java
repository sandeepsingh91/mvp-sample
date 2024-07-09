package test.com.mvp.splash;

import android.content.Context;

import test.com.mvp.R;
import test.com.mvp.base.BasePresenter;

public class SplashPresenter extends BasePresenter {

    SplashView mSplashView;

    SplashPresenter(SplashView splashView) {
        mSplashView = splashView;
    }

    @Override
    public void onViewCreated() {
        mSplashView.updateImage(R.mipmap.ic_launcher_round);
    }


    @Override
    public void onViewDestroyed() {

    }

    @Override
    public Context getContext() {
        return null;
    }

}
