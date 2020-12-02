package com.example.cadastroproduto;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadastroproduto.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProdutoRecyclerViewAdapter extends RecyclerView.Adapter<MyProdutoRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;

    public MyProdutoRecyclerViewAdapter(List<DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.codigoView.setText(mValues.get(position).id);
        holder.nomeView.setText(mValues.get(position).content);
        holder.valorView.setText("00,00");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView codigoView;
        public final TextView nomeView;
        public final TextView valorView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            codigoView = (TextView) view.findViewById(R.id.produto_codigo);
            nomeView = (TextView) view.findViewById(R.id.produto_nome);
            valorView = (TextView) view.findViewById(R.id.produto_valor);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nomeView.getText() + "'";
        }
    }
}