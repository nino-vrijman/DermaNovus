package nl.dermanovus.dermanovus.Schermen;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import nl.dermanovus.dermanovus.R;
import nl.dermanovus.dermanovus.Recept;

public class ReceptenScherm extends AppCompatActivity {

    //Listviews aanmaken voor de recepten
    ListView actieveRecepten;
    ListView beeindigdeRecepten;
    //String arrays voor de recepten
    String[] actieveReceptenTitel = {"Immerin 20mg","Differin 120mg"};
    String[] actieveReceptenOmschrijving = {"Bevestig bestelling - Jan 9, 2015", "Tot 29 januari 2015"};
    String[] beeindigdeReceptenTitel = {"Ibuprofen 50mg","Innerin 12mg"};
    String[] beeindigdeReceptenOmschrijving = {"Beëindigd 04 januari 2015","Beëindigd 27 december 2015"};
    //Image arrays voor de recepten
    Integer[] actieveReceptenImg = {R.drawable.omeprazol,R.drawable.pic1};
    Integer[] beeindigdeReceptenImg = {R.drawable.omeprazol,R.drawable.pic1};
    //IDs van de recepten in de volgorde van dat ze in de listview staan
    Integer[] actieveReceptenID = {1,2};
    Integer[] beeindigdeReceptenID = {1,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepten_scherm);
        //TODO Recepten vullen met legit informatie uit de database
        //Listview actieve recepten vullen
        CustomListAdapter adapterActieveRecepten = new CustomListAdapter(this,actieveReceptenTitel,actieveReceptenImg,actieveReceptenOmschrijving);
        actieveRecepten = (ListView)findViewById(R.id.lvActieveRecepten);
        actieveRecepten.setAdapter(adapterActieveRecepten);
        //onlclick event om er voor te zorgen dat je vanuit de listview naar een medicijn kunt gaan
        actieveRecepten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //redirect naar het medicijn
                SharedPreferences sharedPref  = getSharedPreferences("Medicijn", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("MedicijnID", actieveReceptenID[position]);
                editor.commit();
                startActivity(new Intent(ReceptenScherm.this, MedicijnScherm.class));
            }
        });
        //Listview beeindigde recepten toevoegen
        CustomListAdapter adapterBeeindigdeRecepten = new CustomListAdapter(this,beeindigdeReceptenTitel,beeindigdeReceptenImg,beeindigdeReceptenOmschrijving);
        beeindigdeRecepten = (ListView)findViewById(R.id.lvBeeindigdeRecepten);
        beeindigdeRecepten.setAdapter(adapterBeeindigdeRecepten);
        //onclick event om er voor te zorgen dat je vanuit de listview item naar een medicijn kunt gaan
        beeindigdeRecepten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //redirect naar het medicijn
                SharedPreferences sharedPref  = getSharedPreferences("Medicijn", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("MedicijnID", beeindigdeReceptenID[position]);
                editor.commit();
                startActivity(new Intent(ReceptenScherm.this, MedicijnScherm.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recepten_scherm, menu);
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

    public void btnHome(View view) {
        startActivity(new Intent(this,Hoofdscherm.class));

    }
}
