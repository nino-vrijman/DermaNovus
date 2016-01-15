package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.sql.SQLException;

import nl.dermanovus.dermanovus.Administratie;
import nl.dermanovus.dermanovus.Behandeling;
import nl.dermanovus.dermanovus.Bericht;
import nl.dermanovus.dermanovus.Patient;
import nl.dermanovus.dermanovus.R;

public class NieuwBerichtActivity extends AppCompatActivity {
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private boolean checkForFoto = false;
    private String fotoJSON;
    private SharedPreferences sharedPref;
    private Behandeling actBehandeling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuw_bericht);

        iv1 = (ImageView)findViewById(R.id.imageView);

        System.out.println("____On create called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("_____On resume called");

        if (checkForFoto) {
            sharedPref = getSharedPreferences("NIEUWEFOTO", MODE_PRIVATE);
            fotoJSON = sharedPref.getString("Foto", "");
            Gson gson = new Gson();
            /*
            sharedPref = getSharedPreferences("Behandeling", MODE_PRIVATE);
            String behandelingString = sharedPref.getString("ActieveBehandeling", "");
            if (!behandelingString.isEmpty()) {
                actBehandeling = gson.fromJson(behandelingString, Behandeling.class);
            }
            */
            Bitmap foto = gson.fromJson(fotoJSON, Bitmap.class);
            if (foto != null) {
                System.out.println("_____FOTO IS NOT NULL");
                iv1.setImageBitmap(foto);
            } else {
                System.out.println("____FOTO IS NULL!");
            }
        }
    }

    public void btnHome_Click(View view) {
        finish();
    }

    public void btnVoegFotosToe_Click(View view) {
        checkForFoto = true;
        Intent fotoIntent = new Intent(this, DermaCamActivity.class);
        startActivity(fotoIntent);
    }

    public void btnPlaatsReactie_Click(View view) throws SQLException {
        Patient patient = null;
        sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE);
        int patientID = sharedPref.getInt("GebruikerID",0);
        try {
            patient = Administratie.getInstance().getPatient(patientID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EditText textInvoer = (EditText)findViewById(R.id.editText);
        boolean gelukt = Administratie.getInstance().plaatsBericht(new Bericht(-1, textInvoer.getText().toString(), fotoJSON, "", "", false, patient), actBehandeling);
        if (gelukt) {
            Toast.makeText(this, "Toevoegen is gelukt", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
