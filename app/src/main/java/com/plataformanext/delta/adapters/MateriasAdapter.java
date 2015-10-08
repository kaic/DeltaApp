package com.plataformanext.delta.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.plataformanext.delta.R;
import com.plataformanext.delta.domain.Materias;
import com.plataformanext.delta.interfaces.RecyclerViewOnClickListenerHack;
import com.plataformanext.delta.layouts.ImageHelper;

import java.util.List;


public class MateriasAdapter extends RecyclerView.Adapter<MateriasAdapter.MyViewHolder> {
    private Context mContext;
    private List<Materias> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private float scale;
    private int width;
    private int height;


    public MateriasAdapter(Context c, List<Materias> l){
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int) (14 * scale + 0.5f);
        height = (width / 16) * 9;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_materias_card, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.tvMateria.setText(mList.get(position).getMateria());
        myViewHolder.tvSubtitulo.setText(mList.get(position).getSubtitulo());

            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), mList.get(position).getPhoto());
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 6, width, height, false, false, true, true);

            myViewHolder.ivMateria.setImageBitmap(bitmap);
        }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvMateria;
        public TextView tvSubtitulo;
        public ImageView ivMateria;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvMateria = (TextView) itemView.findViewById(R.id.tv_materia);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tv_subtitulo);
            ivMateria = (ImageView) itemView.findViewById(R.id.iv_materia);

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
