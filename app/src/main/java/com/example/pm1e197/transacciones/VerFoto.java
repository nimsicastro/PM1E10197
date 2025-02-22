package com.example.pm1e197.transacciones;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pm1e197.R;

import java.io.ByteArrayInputStream;
import com.example.pm1e197.configuracion.Operaciones;
import com.example.pm1e197.configuracion.SQLiteconexion;


public class VerFoto extends AppCompatActivity {

    SQLiteconexion conexion = new SQLiteconexion(this, Operaciones.NameDatabase, null, 1);
    ImageView verfoto;
    Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_foto);

        btnvolver = (Button) findViewById(R.id.volverb);

        verfoto = (ImageView) findViewById(R.id.imagenvcontacto);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaContactos.class);
                startActivity(intent);
            }
        });

        Bitmap recuperarFoto = buscarImagen(getIntent().getStringExtra("codigoParaFoto"));
        verfoto.setImageBitmap(recuperarFoto);


    }

    public Bitmap buscarImagen(String id) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String sql = "SELECT foto FROM contactos WHERE id =" + id;
        Cursor cursor = db.rawQuery(sql, new String[] {});
        Bitmap bitmap = null;
        if(cursor.moveToFirst()){
            byte[] blob = cursor.getBlob(0);
            ByteArrayInputStream bais = new ByteArrayInputStream(blob);
            bitmap = BitmapFactory.decodeStream(bais);
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return bitmap;
    }
}