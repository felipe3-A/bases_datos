package com.andres.andresm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_codigo = (EditText) findViewById(R.id.et_codigo);
        et_precio=(EditText)findViewById(R.id.et_precio);
        et_descripcion=(EditText)findViewById(R.id.et_descripcion);
    }
    //Mostrar y ocultar menu
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    //Asignar funciones

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.item1){
            Toast.makeText(this, "Opcion1", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Opcion2", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Opcion3", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
    //Crear la opcion de registrar
    public void Registrar(View view) {
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this, "administracion", null, 1);
        //Dar permisos para la base de datos
        //acciones: escribir y editar
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty())
        {
            ContentValues registro =new ContentValues();
            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);

            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "INGRESA LOS DATOS :<", Toast.LENGTH_SHORT).show();
        }

    }





}