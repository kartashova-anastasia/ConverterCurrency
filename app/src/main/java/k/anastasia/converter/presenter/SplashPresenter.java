package k.anastasia.converter.presenter;

import k.anastasia.converter.data.repository.CurrencyRepository;
import k.anastasia.converter.interactor.CurrenciesInteractor;
import k.anastasia.converter.view.SplashView;

public class SplashPresenter extends BasePresenter<SplashView> {
    private CurrenciesInteractor currenciesInteractor;

    public SplashPresenter(CurrenciesInteractor currenciesInteractor) {
        this.currenciesInteractor = currenciesInteractor;
    }

    @Override
    protected void onViewAttach() {
        currenciesInteractor.refreshCurrencies(new CurrencyRepository.LoadCurrenciesCallback() {
            @Override
            public void onLoadCompleted() {
                getView().navigateToConverterScreen();
            }

            @Override
            public void onLoadError() {
                getView().showRefreshErrorMessage();
                getView().navigateToConverterScreen();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        currenciesInteractor.unsubscribe();
    }
}
