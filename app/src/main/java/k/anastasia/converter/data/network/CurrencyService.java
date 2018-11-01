package k.anastasia.converter.data.network;

import k.anastasia.converter.data.repository.CurrencyDataSource;

public interface CurrencyService {
    void getCurrencies(CurrencyDataSource.CurrenciesCallback callback);

    void unsubscribe();
}