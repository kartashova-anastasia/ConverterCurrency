package k.anastasia.converter.di;

import android.content.Context;

import k.anastasia.converter.data.repository.CurrencyFakeDataSource;
import k.anastasia.converter.data.repository.CurrencyRepository;
import k.anastasia.converter.data.storage.CurrencyStorageImpl;
import k.anastasia.converter.enviroment.PreferencesManager;

public class Injection {
    private static CurrencyRepository currencyRepository;

    public static CurrencyRepository provideCurrencyRepository(Context context) {
        if (currencyRepository == null) {
            currencyRepository = new CurrencyRepository(
                    new CurrencyFakeDataSource(),
                    new CurrencyFakeDataSource(),
                    new CurrencyStorageImpl(new PreferencesManager(context)));
        }
        return currencyRepository;
    }
}