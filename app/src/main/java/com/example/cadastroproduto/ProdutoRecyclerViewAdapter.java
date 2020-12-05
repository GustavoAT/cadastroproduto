package com.example.cadastroproduto;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadastroproduto.persistence.Product;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Product}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ProdutoRecyclerViewAdapter extends RecyclerView.Adapter<ProdutoRecyclerViewAdapter.ViewHolder> {

    private final List<Product> mValues;

    public ProdutoRecyclerViewAdapter(List<Product> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.codigoView.setText(mValues.get(position).code);
        holder.nomeView.setText(mValues.get(position).name);
        String value = "R$ " + mValues.get(position).value;
        holder.valorView.setText(value);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView codigoView;
        public final TextView nomeView;
        public final TextView valorView;
        public Product mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            codigoView = view.findViewById(R.id.produto_codigo);
            nomeView = view.findViewById(R.id.produto_nome);
            valorView = view.findViewById(R.id.produto_valor);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + nomeView.getText() + "'";
        }
    }
}