package test.com.mvp.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test.com.mvp.R;
import test.com.mvp.base.BasePresenter;

public class SplashFragment extends Fragment implements SplashView {


    private View mRootView;
    private BasePresenter mPresenter;
    private ImageView mImageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();

            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fragment_splash, container, false);
        }

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fill();

        mPresenter.onViewCreated();
    }

    private void fill() {

        mPresenter = new SplashPresenter(this);

        mImageView = (ImageView) mRootView.findViewById(R.id.imageView);
    }

    @Override
    public void updateImage(int resId) {
        mImageView.setImageResource(resId);
    }
}
