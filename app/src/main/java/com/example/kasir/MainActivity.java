package com.example.kasir;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etHarga, etJumlah, etBayar;
    Button btnTotal, btnHasil, btnHapus;
    TextView tvTotal, tvKembalian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNama=(EditText) findViewById(R.id.etNamaBarang);
        etHarga=(EditText) findViewById(R.id.etHargaBarang);
        etJumlah=(EditText) findViewById(R.id.etJumlahBarang);
        etBayar=(EditText) findViewById(R.id.etBayar);
        btnTotal=(Button) findViewById(R.id.btnTotal);
        btnHasil=(Button) findViewById(R.id.btnHasil);
        btnHapus=(Button) findViewById(R.id.btnHapus);
        tvTotal=(TextView) findViewById(R.id.tvTotal);
        tvKembalian=(TextView) findViewById(R.id.tvKembalian);

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double jmlbarang, hrgbarang, total;
                jmlbarang=Double.valueOf(etJumlah.getText().toString().trim());
                hrgbarang=Double.valueOf(etHarga.getText().toString().trim());
                total=jmlbarang * hrgbarang;
                String total1 = String.valueOf(total);
                tvTotal.setText(total1);
            }
        });

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bayar, totharga, hasil;
                totharga=Double.valueOf(tvTotal.getText().toString().trim());
                bayar=Double.valueOf(etBayar.getText().toString().trim());
                hasil=bayar - totharga;
                String hasil1 = String.valueOf(hasil);
                tvKembalian.setText(hasil1);
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNama.setText("");
                etHarga.setText("");
                etJumlah.setText("");
                etBayar.setText("");
                tvTotal.setText("");
                tvKembalian.setText("");
            }
        });
    }
}