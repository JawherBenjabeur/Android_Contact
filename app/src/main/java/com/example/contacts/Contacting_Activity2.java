package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacting_Activity2 extends AppCompatActivity {


    LinearLayout layoutNaviguer,layoutsearch,layoutAppeler;
    EditText  _txtName, _txtAddress, _txtNum1 , _txtNum2, _txtEntreprise, _txtsearch;
    ImageButton _btnsearch ;
    Button _btnPrevious, _btnNext ;
    Button _btnAppeler;
    Button _btnAjout, _btnMiseAjour, _btnDelete;
    Button  _btnAnnuler, _btnEnreg;
    int op=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacting_2);

        layoutNaviguer = (LinearLayout) findViewById(R.id.layNavig);
        layoutsearch = (LinearLayout) findViewById(R.id.laysearch);
        layoutAppeler = (LinearLayout) findViewById(R.id.layAppeler) ;


        _txtsearch = (EditText)findViewById(R.id.txtsearch);

        _txtName = (EditText)findViewById(R.id.txtName);
        _txtAddress = (EditText)findViewById(R.id.txtAddress);
        _txtNum1 = (EditText)findViewById(R.id.txtNum1);
        _txtNum2 = (EditText)findViewById(R.id.txtNum2);
        _txtEntreprise = (EditText)findViewById(R.id.txtEntreprise);

        _btnPrevious = (Button)findViewById(R.id.btnPrevious);
        _btnNext = (Button)findViewById(R.id.btnNext);
        _btnAppeler= (Button)findViewById(R.id.btnAppeler);

        _btnAjout = (Button)findViewById(R.id.btnAjout);
        _btnMiseAjour = (Button)findViewById(R.id.btnMiseAjour);
        _btnDelete = (Button)findViewById(R.id.btnDelete);

        _btnAnnuler = (Button)findViewById(R.id.btnAnnuler);
        _btnEnreg = (Button)findViewById(R.id.btnEnreg);

        _btnsearch = (ImageButton)findViewById(R.id.btnsearch);


        layoutNaviguer.setVisibility(View.INVISIBLE);
        _btnEnreg.setVisibility(View.INVISIBLE);
        _btnAnnuler.setVisibility(View.INVISIBLE);
        layoutAppeler.setVisibility(View.INVISIBLE);
        /*
        _btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = db.rawQuery("select * from Contacts where (nom like ?) OR (entreprise like ?) OR (tel1 like ?) OR (tel2 like ?)",new String[]{"%" + _txtsearch.getText().toString() + "%" , "%" + _txtsearch.getText().toString() + "%", "%" + _txtsearch.getText().toString() + "%","%" + _txtsearch.getText().toString() + "%"});
                try {

                    cur.moveToFirst();
                    _txtName.setText(cur.getString(1));
                    _txtAddress.setText(cur.getString(2));
                    _txtNum1.setText(cur.getString(3));
                    _txtNum2.setText(cur.getString(4));
                    _txtEntreprise.setText(cur.getString(5));
                    if(cur.getCount()==1){
                        layoutNaviguer.setVisibility(View.INVISIBLE);

                    }else {
                        layoutNaviguer.setVisibility(View.VISIBLE);
                        _btnPrevious.setEnabled(false);
                        _btnNext.setEnabled(true);
                    }
                    callVisibility();


                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"aucun résultat",Toast.LENGTH_SHORT).show();
                    _txtName.setText("");
                    _txtAddress.setText("");
                    _txtNum1.setText("");
                    _txtNum2.setText("");
                    _txtEntreprise.setText("");
                    layoutNaviguer.setVisibility(View.INVISIBLE);
                }
            }
        });

        _btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cur.moveToNext();

                    _txtName.setText(cur.getString(1));
                    _txtAddress.setText(cur.getString(2));
                    _txtNum1.setText(cur.getString(3));
                    _txtNum2.setText(cur.getString(4));
                    _txtEntreprise.setText(cur.getString(5));
                    _btnPrevious.setEnabled(true);
                    if (cur.isLast()){
                        _btnNext.setEnabled(false);
                    }
                    callVisibility();


                } catch (Exception e) {
                    e.printStackTrace();


                }
            }
        });

        _btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cur.moveToPrevious();

                    _txtName.setText(cur.getString(1));
                    _txtAddress.setText(cur.getString(2));
                    _txtNum1.setText(cur.getString(3));
                    _txtNum2.setText(cur.getString(4));
                    _txtEntreprise.setText(cur.getString(5));
                    _btnNext.setEnabled(true);
                    if (cur.isFirst()){
                        _btnPrevious.setEnabled(false);
                    }

                    callVisibility();


                } catch (Exception e) {
                    e.printStackTrace();


                }
            }
        }); */

        _btnAjout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                op=1;
                _txtName.setText("");
                _txtAddress.setText("");
                _txtNum1.setText("");
                _txtNum2.setText("");
                _txtEntreprise.setText("");

                _btnEnreg.setVisibility(View.VISIBLE);
                _btnAnnuler.setVisibility(View.VISIBLE);
                _btnMiseAjour.setVisibility(View.INVISIBLE);
                _btnDelete.setVisibility(View.INVISIBLE);
                _btnAjout.setEnabled(false);
                layoutNaviguer.setVisibility(View.INVISIBLE);
                layoutsearch.setVisibility(View.INVISIBLE);
                layoutAppeler.setVisibility(View.INVISIBLE);
            }
        });

        _btnAppeler.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    AlertDialog dial = MyOptions();
                    dial.show();
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Sélectionner",Toast.LENGTH_SHORT).show();
                }
            }
        });

                _btnEnreg.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String nom = _txtName.getText().toString();
                        String adresse = _txtAddress.getText().toString();
                        String num1 = _txtNum1.getText().toString();
                        String num2 = _txtNum2.getText().toString();
                        String entreprise = _txtEntreprise.getText().toString();
                        if (op == 1){
                            bg_insertion bg = new bg_insertion(Contacting_Activity2.this);
                            bg.execute(nom,adresse,num1,num2,entreprise);
                             }

                        _btnEnreg.setVisibility(View.INVISIBLE);
                        _btnAnnuler.setVisibility(View.INVISIBLE);
                        _btnMiseAjour.setVisibility(View.VISIBLE);
                        _btnDelete.setVisibility(View.VISIBLE);

                        _btnAjout.setVisibility(View.VISIBLE);
                        _btnAjout.setEnabled(true);
                        _btnMiseAjour.setEnabled(true);
                        _btnsearch.performClick();
                        layoutsearch.setVisibility(View.VISIBLE);
                    }
                });
        _btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = 0;

                _btnEnreg.setVisibility(View.INVISIBLE);
                _btnAnnuler.setVisibility(View.INVISIBLE);
                _btnMiseAjour.setVisibility(View.VISIBLE);
                _btnDelete.setVisibility(View.VISIBLE);

                _btnAjout.setVisibility(View.VISIBLE);
                _btnAjout.setEnabled(true);
                _btnMiseAjour.setEnabled(true);

                layoutsearch.setVisibility(View.VISIBLE);
            }
        });






    }



private class bg_insertion extends AsyncTask <String,Void,String >{
        AlertDialog dialog;
        Context context;

    public bg_insertion(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new AlertDialog.Builder(context).create();
    }


    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        String strnom = strings[0];
        String stradresse = strings[1];
        String strnum1 = strings[2];
        String strnum2 = strings[3];
        String strentreprise = strings[4];

        String connstr = "http://adresse-ip/android1/contact.php";

        try {

            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data = URLEncoder.encode("nom", "UTF-8") + "=" + URLEncoder.encode(strnom, "UTF-8");
             data += "&"+ URLEncoder.encode("adresse", "UTF-8") + "=" + URLEncoder.encode(stradresse, "UTF-8");
             data += "&"+ URLEncoder.encode("num1", "UTF-8") + "=" + URLEncoder.encode(strnum1, "UTF-8");
             data += "&"+ URLEncoder.encode("num2", "UTF-8") + "=" + URLEncoder.encode(strnum2, "UTF-8");
             data += "&"+ URLEncoder.encode("entreprise", "UTF-8") + "=" + URLEncoder.encode(strentreprise, "UTF-8");

            writer.write(data);
            Log.v("Contacting", data);
            writer.flush();
            writer.close();
            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "UTF-8"));
            String ligne = "";
            while ((ligne = reader.readLine()) != null) {
                result += ligne;
            }
            reader.close();
            ips.close();
            http.disconnect();

            return result;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        dialog.setMessage(s);
        dialog.show();
        if (s.contains("success insertion")) {
            Toast.makeText(context, "Insertion avec succès.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Problème d'insertion.", Toast.LENGTH_LONG).show();
        }
    }
}

    private void callVisibility(){
        if (((_txtNum1.getText().length() ==0) && (_txtNum2.getText().length() == 0)) ){

            layoutAppeler.setVisibility(View.INVISIBLE);

        } else  {
            layoutAppeler.setVisibility(View.VISIBLE);

        }

    }

    private AlertDialog MyOptions(){
        AlertDialog MiDia = new AlertDialog.Builder(this)
                .setTitle("confirmation")
                .setMessage("Séléctionnez le numéro que vous allez appeler")

                .setPositiveButton("tel1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //selectionnez le num 1 et appeller
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:"+_txtNum1.getText().toString().trim()));
                        startActivity(callIntent);
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("tel2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //selectionner le tel2 et appllez
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:"+_txtNum2.getText().toString().trim()));
                        startActivity(callIntent);
                        dialogInterface.dismiss();
                    }

                })
                .create();
        return MiDia;
    }
}
