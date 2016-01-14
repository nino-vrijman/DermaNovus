package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.ArrayList;

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
        ListView lvBerichten = (ListView) findViewById(R.id.lvBerichten);
        ArrayList<String> list = new ArrayList<String>();
        list.add("Begin behandeling bericht");
        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        lvBerichten.setAdapter(adapter);
        lvBerichten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                SharedPreferences sharedPref = getSharedPreferences("Bericht", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("BerichtID", 1);
                editor.commit();
                startActivity(new Intent(BehandelingActivity.this, BerichtActivity.class));
            }
        });

        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String behandelingString = gson.toJson(behandeling, Behandeling.class);
        editor.putString("ActieveBehandeling", behandelingString);
        editor.apply();
        editor.commit();

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
