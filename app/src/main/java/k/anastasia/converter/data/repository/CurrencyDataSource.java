package k.anastasia.converter.data.repository;

import java.util.List;

import k.anastasia.converter.entity.Currency;

public interface CurrencyDataSource {
    interface CurrenciesCallback {
        void onLoadCompleted(List<Currency> currencies);

        void onLoadError();
    }

    void loadCurrencies(CurrenciesCallback callback);

    List<Currency> getCurrencies();

    Currency getCurrency(String currencyId);

    Currency getDefaultCurrency();

    void saveCurrencies(List<Currency> currencies);

    void unsubscribe();
}
