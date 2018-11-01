package k.anastasia.converter.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.DialogFragment;

import java.util.List;

import k.anastasia.converter.R;
import k.anastasia.converter.ui.adapter.CurrencyAdapter;
import k.anastasia.converter.entity.Currency;

public class SelectCurrencyDialogFragment extends DialogFragment {
    private List<Currency> currencyList;
    private CurrencyAdapter.OnItemClickListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View contentView = inflater.inflate(
                R.layout.dialog_select_currency, container, false);
        final RecyclerView rvCurrencies = contentView.findViewById(R.id.rvCurrencies);
        final CurrencyAdapter adapter = new CurrencyAdapter(currencyList, listener);
        rvCurrencies.setAdapter(adapter);

        return contentView;
    }

    public static SelectCurrencyDialogFragment newInstance(
            List<Currency> currencyList, CurrencyAdapter.OnItemClickListener listener) {
        final Bundle args = new Bundle();
        final SelectCurrencyDialogFragment fragment = new SelectCurrencyDialogFragment();
        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        fragment.setArguments(args);
        fragment.currencyList = currencyList;
        fragment.listener = listener;
        return fragment;
    }
}