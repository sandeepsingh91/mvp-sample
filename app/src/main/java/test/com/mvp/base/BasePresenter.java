package test.com.mvp.base;

import android.content.Context;

public abstract class BasePresenter implements BaseView {

    public abstract void onViewCreated();

    public abstract void onViewDestroyed();

    @Override
    public abstract Context getContext();
}
