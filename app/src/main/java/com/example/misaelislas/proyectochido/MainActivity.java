package com.example.misaelislas.proyectochido;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText telnumero;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telnumero = (EditText)findViewById(R.id.txt_num);
        url = (EditText)findViewById(R.id.txt_url);
    }

    public void intentTelefono(View view){

        String numero = telnumero.getText().toString();
            if (TextUtils.isDigitsOnly(numero) && numero.length()==10){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+ numero));
            startActivity(intent);
            }
            else {
                telnumero.setError("El teléfono tiene que ser de 10 dígitos");
        }
    }

    public void intentWeb(View view) {
        String nuevoURL = url.getText().toString();

        if (URLUtil.isValidUrl(nuevoURL)){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(nuevoURL));
            startActivity(i);
        }
        else {
            url.setError("Debe de ser una página válida");
        }
    }

    public void intentMaps (View view) {
        Uri gmmIntentUri = Uri.parse("geo:37.7749.-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
