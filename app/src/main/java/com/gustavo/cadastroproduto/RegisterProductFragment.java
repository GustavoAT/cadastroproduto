package com.gustavo.cadastroproduto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gustavo.cadastroproduto.persistence.AppDatabase;
import com.gustavo.cadastroproduto.persistence.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterProductFragment extends Fragment {

    private AppDatabase db;
    private Product newProduct;
    private EditText codeEdit;
    private EditText nameEdit;
    private EditText valueEdit;

    public RegisterProductFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastroproduto, container, false);

        codeEdit = view.findViewById(R.id.editText_codigo);
        nameEdit = view.findViewById(R.id.editText_nome);
        valueEdit = view.findViewById(R.id.editText_valor);
        View activityMainView = container.getRootView().getRootView();
        activityMainView.findViewById(R.id.fab).setVisibility(FloatingActionButton.INVISIBLE);
        Button registerButton = view.findViewById(R.id.button_cadastrar);
        registerButton.setOnClickListener(v -> {
            newProduct = new Product();
            newProduct.code = codeEdit.getText().toString();
            newProduct.name = nameEdit.getText().toString();
            newProduct.value = Double.parseDouble(valueEdit.getText().toString());
            registerButton.setEnabled(false);
            new Thread(() -> {
                CharSequence message;
                try {
                    db.productDao().insertAll(newProduct);
                    message = getText(R.string.data_saved);
                } catch (Exception e) {
                    message = getText(R.string.data_not_saved);
                }
                Snackbar.make(view, message,Snackbar.LENGTH_SHORT).show();
                //Prevent user to navigate back to this fragment
                NavHostFragment.findNavController(RegisterProductFragment.this)
                        .popBackStack();
            }).start();

        });

        return view;
    }
}