package nl.dermanovus.dermanovus.Schermen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Date;

import nl.dermanovus.dermanovus.Administratie;
import nl.dermanovus.dermanovus.Gebruiker;
import nl.dermanovus.dermanovus.Patient;
import nl.dermanovus.dermanovus.R;

public class UwGegevensScherm extends AppCompatActivity {
    Patient patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uw_gegevens_scherm);

        patient = new Patient(1, "Peter","de Boer", Date.valueOf("1950-3-20"),"0674928375","kappa@hotmail.com","empty","overdeberg","3721BE",2,"a");
        TextView tvNaam = (TextView)findViewById(R.id.tvKlantNaam);
        TextView tvGeboorteDatum = (TextView)findViewById(R.id.tvKlantGeboorteDatum);
        EditText etAdres = (EditText)findViewById(R.id.etAdres);
        EditText etPostcode = (EditText)findViewById(R.id.etPostcode);
        EditText etTelefoon = (EditText)findViewById(R.id.etTelefoonNr);
        EditText etEmail = (EditText)findViewById(R.id.etEmail);
        tvNaam.setText(patient.getVoornaam()+" "+patient.getAchternaam());
        tvGeboorteDatum.setText(patient.getGeboortedatum().toString());
        etAdres.setText(patient.getAdres()+patient.getHuisnummer()+patient.getToevoeging());
        etPostcode.setText(patient.getPostcode());
        etTelefoon.setText(patient.getTelefoonnummer());
        etEmail.setText(patient.getEmailadres());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_uw_gegevens_scherm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnBackHome(View view) {
        startActivity(new Intent(this,Hoofdscherm.class));
    }
}
