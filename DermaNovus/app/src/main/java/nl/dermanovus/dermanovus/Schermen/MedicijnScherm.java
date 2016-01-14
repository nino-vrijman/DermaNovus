package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nl.dermanovus.dermanovus.Medicijn;
import nl.dermanovus.dermanovus.R;

public class MedicijnScherm extends AppCompatActivity {
    int medicijnID= 0;
    Medicijn medicijn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicijn_scherm);
        SharedPreferences sharedPref = getSharedPreferences("Medicijn", Context.MODE_PRIVATE);
        medicijnID = sharedPref.getInt("MedicijnID",0);
         //todo Database het medicijn ophalen met het medicijn ID
        medicijn = new Medicijn(medicijnID,"Immerin","bijsluiter wolla veel text kijk mij mamma",63.39, 1, 200, "imagestring",true);
        TextView tvMedicijnNaam = (TextView)findViewById(R.id.tvMedicijnNaam);
        tvMedicijnNaam.setText(medicijn.getNaam());
        //vul de informatie van het medicijn met het medicijn wat in de shared preference staat
        TextView tvMedicijnEenheid = (TextView)findViewById(R.id.tvEenheid);
        TextView tvMedicijnInhoud = (TextView)findViewById(R.id.tvInhoud);
        TextView tvMedicijnPrijs = (TextView)findViewById(R.id.tvPrijs);
        TextView tvMedicijnBijsluiter = (TextView)findViewById(R.id.tvBijsluiter);
        tvMedicijnEenheid.setText(""+medicijn.getEenheid());
        tvMedicijnInhoud.setText(medicijn.getHoeveelheid()+"mg");
        tvMedicijnPrijs.setText("€"+medicijn.getPrijs());
        tvMedicijnBijsluiter.setText(medicijn.getBijsluiter());
        //de knop goed zetten of de bestelling al is goed gekeurd of niet
        Button bestellingGoedkeuren = (Button) findViewById(R.id.btnBestellingGoedkeuren);
        if(medicijn.isBestellingGoedgekeurd()){
            bestellingGoedkeuren.setText("Bestelling goedgekeurd");
            bestellingGoedkeuren.setEnabled(false);
        }
        else{
            bestellingGoedkeuren.setText("Bestelling goedgekeuren");
            bestellingGoedkeuren.setEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medicijn_scherm, menu);
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
    public void btnToHome(View view) {
        startActivity(new Intent(this,Hoofdscherm.class));
    }

    public void btnKeurBestellingGoed(View view) {
        //todo huidige status naar database schrijven
        medicijn.isBestellingGoedgekeurd(true);
        Button bestellingGoedkeuren = (Button) findViewById(R.id.btnBestellingGoedkeuren);
        bestellingGoedkeuren.setText("Bestelling goedgekeurd");
        bestellingGoedkeuren.setEnabled(false);
    }
}
