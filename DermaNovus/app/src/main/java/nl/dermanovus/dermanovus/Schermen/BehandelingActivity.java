package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.SQLException;

import nl.dermanovus.dermanovus.Administratie;
import nl.dermanovus.dermanovus.Behandeling;
import nl.dermanovus.dermanovus.Expert;
import nl.dermanovus.dermanovus.R;

public class BehandelingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behandeling);
        Behandeling behandeling = null;
        SharedPreferences sharedPref = getSharedPreferences("Behandeling", Context.MODE_PRIVATE);
        int behandelingID = sharedPref.getInt("BehandelingID", 0);
        try {
            behandeling = Administratie.getInstance().getBehandeling(behandelingID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TextView titel = (TextView)findViewById(R.id.tvTitel);
        TextView startDatum = (TextView)findViewById(R.id.tvStartdatum);
        TextView symtoomOmschrijving = (TextView)findViewById(R.id.tvSymptoomomschrijving);
        TextView status = (TextView)findViewById(R.id.tvStatus);
        titel.setText(behandeling.getTitel());
        startDatum.setText(behandeling.getStartDatum().toString());
        symtoomOmschrijving.setText(behandeling.getSymptoomOmschrijving());
        status.setText("In behandeling");

    }

    public void btnHome_Click(View view) {
        finish();
    }

    public void btnToExpert(View view) {
        SharedPreferences sharedPref  = getSharedPreferences("Expert", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ExpertID", 1);
        editor.commit();
        startActivity(new Intent(BehandelingActivity.this, DermatoloogScherm.class));
    }
}
