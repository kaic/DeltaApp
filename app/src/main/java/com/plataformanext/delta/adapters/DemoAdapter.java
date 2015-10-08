package com.plataformanext.delta.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.plataformanext.delta.R;
import com.plataformanext.delta.domain.Demo;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;

import java.util.List;


public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {
    private List<Demo> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;


    public DemoAdapter(Context c, List<Demo> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_demo, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.tvNome.setText(mList.get(position).getNome());
        myViewHolder.tvAxis.setText(mList.get(position).getAxis());
        myViewHolder.tvConteudo.setText(mList.get(position).getConteudo());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvNome;
        public TextView tvAxis;
        public TextView tvConteudo;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.tv_nome);
            tvAxis = (TextView) itemView.findViewById(R.id.tv_axis);
            tvConteudo = (TextView) itemView.findViewById(R.id.tv_conteudo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}
