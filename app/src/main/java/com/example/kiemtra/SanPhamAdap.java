package com.example.kiemtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SanPhamAdap extends RecyclerView.Adapter<SanPhamAdap.SanPhamViewHolder> {
    private Context context;
    private List<SanPham> sanPhamList;

    public SanPhamAdap(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public SanPhamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemproduct, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SanPhamViewHolder holder, int position) {
        SanPham sanPham = this.sanPhamList.get(position);
        holder.edtTenSP.setText(sanPham.getTenSP());
        holder.edtPrice.setText(sanPham.getGiaTien().toString());
        Picasso picasso = Picasso.get();
        picasso.load(sanPham.getImage())
                .into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
    public static  class SanPhamViewHolder extends RecyclerView.ViewHolder {
        TextView edtTenSP, edtPrice;
        ImageView productImage;
        public SanPhamViewHolder(View itemView) {
            super(itemView);
            edtTenSP = itemView.findViewById(R.id.edtTenSP);
            edtPrice = itemView.findViewById(R.id.edtPrice);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }


}