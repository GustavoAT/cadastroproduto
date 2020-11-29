package com.example.cadastroproduto.dummy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadastroproduto.Produto;
import com.example.cadastroproduto.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroProduto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroProduto extends Fragment {

    private Produto novoProduto;

    public CadastroProduto() {
        // Required empty public constructor
    }


    public static CadastroProduto newInstance() {
        CadastroProduto fragment = new CadastroProduto();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastroproduto, container, false);

        EditText codigoEdit = view.findViewById(R.id.editText_codigo);
        EditText nomeEdit = view.findViewById(R.id.editText_nome);
        EditText valorEdit = view.findViewById(R.id.editText_quantidade);
        Button btCadastrar = view.findViewById(R.id.button_cadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = codigoEdit.getText().toString();
                String nome = nomeEdit.getText().toString();
                Double valor = Double.parseDouble(valorEdit.getText().toString());
                novoProduto = new Produto(codigo, nome, valor);
            }
        });

        return view;
    }
}