package com.example.kiemtra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView edtMaSP, edtTenSP, edtPrice, edtImageName;
    Button btnClear, btnSave;
    ImageButton imageDelete;
    private RecyclerView recyclerView;
    private SanPhamAdap sanPhamAdap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SanPhamDAO sanPhamDAO = new SanPhamDAO(this);
        ArrayList<SanPham> listSanPham = sanPhamDAO.getListSanPham();
        sanPhamAdap = new SanPhamAdap(this, listSanPham);
        recyclerView.setAdapter(sanPhamAdap);
        View customDialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);
        edtMaSP = customDialogView.findViewById(R.id.edtMaSP);
        edtTenSP = customDialogView.findViewById(R.id.edtTenSP);
        edtPrice = customDialogView.findViewById(R.id.edtPrice);
        edtImageName = customDialogView.findViewById(R.id.edtImageName);
        btnClear = customDialogView.findViewById(R.id.btnClear);
        btnSave = customDialogView.findViewById(R.id.btnSave);
        // Sự kiện lắng nghe cho flButton (FloatingActionButton)
        FloatingActionButton flButton = findViewById(R.id.flButton);
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate layout của đoạn mã XML bạn đã cung cấp
                View customDialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);

                // Tạo đối tượng AlertDialog.Builder với nội dung là customDialogView
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(customDialogView);

                // Nút tích cực
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Xử lý khi nhấn nút OK
                        dialogInterface.dismiss();
                    }
                });

                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
}