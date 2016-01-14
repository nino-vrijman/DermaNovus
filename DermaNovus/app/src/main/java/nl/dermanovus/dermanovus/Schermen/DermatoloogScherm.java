package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.sql.SQLException;

import nl.dermanovus.dermanovus.Administratie;
import nl.dermanovus.dermanovus.Expert;
import nl.dermanovus.dermanovus.R;

public class DermatoloogScherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dermatoloog_scherm);
        SharedPreferences sharedPref = getSharedPreferences("Expert", Context.MODE_PRIVATE);
        int expertID = sharedPref.getInt("ExpertID", 0);
        Expert expert = null;
        try {
            expert = Administratie.getInstance().getExpert(expertID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TextView dermaNaam = (TextView) findViewById(R.id.tvDermaNaam);
        TextView dermaRating = (TextView) findViewById(R.id.tvInhoud);
        TextView dermaInfo = (TextView) findViewById(R.id.tvOverDermatoloog);
        TextView dermaEmail = (TextView) findViewById(R.id.tvExpertEmail);
        TextView dermaTelnummer = (TextView)findViewById(R.id.tvExpertTelnummer);
        dermaNaam.setText(expert.getVoornaam() + " "+expert.getAchternaam());
        dermaRating.setText("8/10");
        dermaInfo.setText(expert.getInfoOver());
        dermaEmail.setText(expert.getEmailadres());
        dermaTelnummer.setText(expert.getTelefoonnummer());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dermatoloog_scherm, menu);
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
}
