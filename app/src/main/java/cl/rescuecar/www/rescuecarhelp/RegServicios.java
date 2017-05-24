package cl.rescuecar.www.rescuecarhelp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegServicios extends ConexionMysqlHelper {

    LinearLayout menuServGrua, menuServEmer, menuServOtros;
    LinearLayout menuTituloGrua,menuTituloEmer, menuTituloOtros;
    int actMGrua=0, actMotros=0, actMemer=0;
    ImageView imGrua, imEmer, imOtros;
    Button guardar;
    CheckBox gm, ga, gc, go, po, am, bo, me, ne, tr, co;
    List<String> servicios = new ArrayList<String>();
    String rut, div, nombre, apellido;
    EditText nomCompleto;
    String gnombre, gapellido, grut, gdiv, gtelefono, gcod, gemail;
    String services=null;
    String id_mob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_servicios);
        id_mob = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        Context context = this;
        SharedPreferences sharPreferencias =getSharedPreferences("servicios",context.MODE_WORLD_READABLE);

        menuServGrua =(LinearLayout) findViewById (R.id.llMenuGrua);
        menuServEmer =(LinearLayout) findViewById (R.id.llmenuEmer);
        menuServOtros =(LinearLayout) findViewById (R.id.llMenuOtros);
        menuTituloGrua =(LinearLayout) findViewById (R.id.llTituloGrua);
        menuTituloEmer =(LinearLayout) findViewById (R.id.llTituloEmer);
        menuTituloOtros =(LinearLayout) findViewById (R.id.llTituloOtros);
        gm = (CheckBox) findViewById(R.id.cbgm);
        ga = (CheckBox) findViewById(R.id.cbga);
        gc = (CheckBox) findViewById(R.id.cbgc);
        go = (CheckBox) findViewById(R.id.cbgo);
        po = (CheckBox) findViewById(R.id.cbpo);
        am = (CheckBox) findViewById(R.id.cbma);
        bo = (CheckBox) findViewById(R.id.cbbo);
        me = (CheckBox) findViewById(R.id.cbme);
        ne = (CheckBox) findViewById(R.id.cbne);
        tr = (CheckBox) findViewById(R.id.cbtr);
        co = (CheckBox) findViewById(R.id.cbco);
        imGrua = (ImageView) findViewById(R.id.imGrua);
        imEmer = (ImageView) findViewById(R.id.imEmer);
        imOtros = (ImageView) findViewById(R.id.imOtros);
        guardar = (Button) findViewById(R.id.btRegistrar);
        nomCompleto = (EditText) findViewById(R.id.etNombre);
        obtenerDatos();
        guardar.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) {

            if (gm.isChecked() || ga.isChecked() || gc.isChecked() || go.isChecked() || po.isChecked()|| am.isChecked()|| bo.isChecked() || me.isChecked()|| ne.isChecked()|| tr.isChecked()||co.isChecked()){
                if (gm.isChecked()){ servicios.add("gm"); }
                if (ga.isChecked()){ servicios.add("ga"); }
                if (gc.isChecked()){ servicios.add("gc"); }
                if (go.isChecked()){ servicios.add("go"); }
                if (po.isChecked()){ servicios.add("po"); }
                if (am.isChecked()){ servicios.add("am"); }
                if (bo.isChecked()){ servicios.add("bo"); }
                if (me.isChecked()){ servicios.add("me"); }
                if (ne.isChecked()){ servicios.add("ne"); }
                if (tr.isChecked()){ servicios.add("tr"); }
                if (co.isChecked()){ servicios.add("co"); }

                agregarServ();

            }else{

                Toast.makeText(getApplicationContext(),"¡¡ Debe selecionar algun servicio !!",Toast.LENGTH_SHORT).show();

            }

        }});

        menuTituloGrua.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) {

            if (actMGrua==0){
                desplegarMenus(1);
                actMGrua=1;
            }else{
                replegarMenus();
                actMGrua=0;

            }

        }});
        menuTituloEmer.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) {

            if (actMemer==0){
                desplegarMenus(2);
                actMemer=1;
            }else{
                replegarMenus();
                actMemer=0;

            }

        }});
        menuTituloOtros.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) {

            if (actMotros==0){
                desplegarMenus(3);
                actMotros=1;
            }else{
                replegarMenus();
                actMotros=0;

            }

        }});

    }
    private void obtenerDatos() {

        varGlob varglob = (varGlob) getApplicationContext();
        grut = varglob.getRut();
        gdiv = varglob.getDiv();
        gnombre = varglob.getNombre();
        gapellido = varglob.getApellido();
        gtelefono = varglob.getTelefono();
        gemail = varglob.getEmail();

        Toast.makeText(getApplicationContext(),"Bienvenido "+gnombre+" "+gapellido, Toast.LENGTH_SHORT).show();
        nomCompleto.setText(gnombre+" "+gapellido);
    }

    private void desplegarMenus(int menu){

        switch (menu){
            case 1:
                imGrua.setImageResource(R.drawable.arriba);
                menuServGrua.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250));
                menuServEmer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                menuServOtros.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                break;

            case 2:
                imEmer.setImageResource(R.drawable.arriba);
                menuServEmer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250));
                menuServGrua.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                menuServOtros.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                break;

            case 3:
                imOtros.setImageResource(R.drawable.arriba);
                menuServOtros.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250));
                menuServGrua.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                menuServEmer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                break;

        }

    }

    private void replegarMenus(){
        imGrua.setImageResource(R.drawable.abajo);
        imEmer.setImageResource(R.drawable.abajo);
        imOtros.setImageResource(R.drawable.abajo);
        menuServGrua.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
        menuServEmer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
        menuServOtros.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));

    }

    private void agregarServ() {

        for (int i=0;i<servicios.size();i++){

            if (services==null){

                services = servicios.get(i);

            }else{

                services = services+","+servicios.get(i);
            }
        }

        varGlob varglob = (varGlob) getApplicationContext();
        varglob.setTipos(services);


        /****** Agrego en base de datos en otro hilo******/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new ConexionMysqlHelper.CargarDatos().execute("http://www.webinfo.cl/soshelp/save_serv.php?id_mob="+id_mob+"&rut="+grut+"&div="+gdiv+"&nom="+gnombre+"&ape="+gapellido+"&ema="+gemail+"&tel="+gtelefono+"&serv="+services);

                    }
                });
            }
        }, 0);


        Intent m = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(m);

    }

}
