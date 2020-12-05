package com.example.cadastroproduto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadastroproduto.persistence.AppDatabase;
import com.example.cadastroproduto.persistence.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroProdutoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroProdutoFragment extends Fragment {

    private AppDatabase db;
    private Produto novoProduto;
    private EditText codigoEdit;
    private EditText nomeEdit;
    private EditText valorEdit;

    public CadastroProdutoFragment() {
        // Required empty public constructor
    }


    public static CadastroProdutoFragment newInstance() {
        CadastroProdutoFragment fragment = new CadastroProdutoFragment();
        return fragment;
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

        codigoEdit = view.findViewById(R.id.editText_codigo);
        nomeEdit = view.findViewById(R.id.editText_nome);
        valorEdit = view.findViewById(R.id.editText_valor);
        getActivity().findViewById(R.id.fab).setVisibility(FloatingActionButton.INVISIBLE);
        Button btCadastrar = view.findViewById(R.id.button_cadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoProduto = new Produto();
                novoProduto.codigo = codigoEdit.getText().toString();
                novoProduto.nome = nomeEdit.getText().toString();
                novoProduto.valor = Double.parseDouble(valorEdit.getText().toString());
                btCadastrar.setEnabled(false);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CharSequence message = "Não salvo";
                        try {
                            db.produtoDao().insertAll(novoProduto);
                            message = "Produto salvo";
                        } catch (Exception e) {
                            message = "Não foi possivel salvar";
                        }
                        Snackbar.make(view, message,Snackbar.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(CadastroProdutoFragment.this)
                                .navigate(R.id.action_cadastroProduto_to_produtoFragment);
                    }
                }).start();
                
            }
        });

        return view;
    }
}