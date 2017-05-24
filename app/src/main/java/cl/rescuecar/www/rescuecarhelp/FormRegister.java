package cl.rescuecar.www.rescuecarhelp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormRegister extends ConexionMysqlHelper {

    EditText nombre, apellido, rut, div, telefono, cod, email;
    String gnombre, gapellido, grut, gdiv, gtelefono, gcod, gemail;
    Button registrar;
    String id_mob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_access);


        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        rut = (EditText) findViewById(R.id.etRut);
        div = (EditText) findViewById(R.id.etDiv);
        email = (EditText) findViewById(R.id.etEmail);
        cod = (EditText) findViewById(R.id.etCod);
        telefono = (EditText) findViewById(R.id.etTelefono);
        registrar = (Button) findViewById(R.id.btRegistrar);
        //CapturaIdDispositivo
        id_mob = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        registrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                grut = rut.getText().toString();
                gdiv = div.getText().toString();
                gnombre = nombre.getText().toString();
                gapellido = apellido.getText().toString();
                gemail = email.getText().toString();
                gtelefono = telefono.getText().toString();

                varGlob varglob = (varGlob) getApplicationContext();
                varglob.setRut(grut);
                varglob.setDiv(gdiv);
                varglob.setNombre(gnombre);
                varglob.setApellido(gapellido);
                varglob.setTelefono(gtelefono);


                Intent m = new Intent(getApplicationContext(), RegServicios.class);
                startActivity(m);
            }
        });

    }

}
