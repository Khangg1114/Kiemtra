package com.example.kiemtra;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QuanLySanPham", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Veggie tomato mix', '1900', 'https://lh3.googleusercontent.com/SbaaP1HMHNFYOoZ-_hWVgDyDVl9EkMZTIv4ebbcnUUXW_g-KnZ1l9cRb1ix4dX-dUiozjzG_K-AIuFPcEsf4YQ=w640-h640-c-rw-v1-e365')," +
                "(2, 'Fishwith mix orange', '1921', 'https://lh3.googleusercontent.com/Vwk6GlIVVve3p01G4VACsoKkDMBzc2NwN3CynhI3A8FPiLM5KG_5elG0QXak7fZ0IVbJea1RBfP2_YIkJfEy=w640-h640-c-rw-v1-e365')," +
                "(3, 'Fishwith mix orange', '1921', 'https://lh3.googleusercontent.com/Vwk6GlIVVve3p01G4VACsoKkDMBzc2NwN3CynhI3A8FPiLM5KG_5elG0QXak7fZ0IVbJea1RBfP2_YIkJfEy=w640-h640-c-rw-v1-e365')," +
                "(4, 'Fresh Salsa', '2222', 'https://lh3.googleusercontent.com/YxeHDe87zBIIQDBPXi21kvh34IXKiM3DY1iPu25N2yNgAE7-BmhUUytYesFU8e6UJM9DZmq5E1x2Zr9tTcF4=w640-h640-c-rw-v1-e365')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
    public void updateSanPham(int maSP, String tenSP, float giaTien, String image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TenSP", tenSP);
        values.put("GiaTien", giaTien);
        values.put("Image", image);

        // Update the record based on the product code (MaSP)
        int rowsAffected = db.update("SanPham", values, "MaSP = ?", new String[]{String.valueOf(maSP)});

        if (rowsAffected > 0) {
            // Log success message
            Log.d("DbHelper", "Record updated successfully");
        } else {
            // Log failure message
            Log.e("DbHelper", "Failed to update record");
        }

        // Close the database connection
        db.close();
    }

}
