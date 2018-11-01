package k.anastasia.converter.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import k.anastasia.converter.R;
import k.anastasia.converter.di.Injection;
import k.anastasia.converter.interactor.CurrenciesInteractor;
import k.anastasia.converter.presenter.SplashPresenter;
import k.anastasia.converter.view.SplashView;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashView {
    private SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = instantiatePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

   @Override
    protected SplashPresenter providePresenter() {
        return new SplashPresenter(
                new CurrenciesInteractor(Injection.provideCurrencyRepository(this)));
    }

    @Override
    public void showRefreshErrorMessage() {
        Toast.makeText(this, R.string.refresh_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToConverterScreen() {
        startActivity(ConverterActivity.getStartIntent(this));
        finish();
    }
}