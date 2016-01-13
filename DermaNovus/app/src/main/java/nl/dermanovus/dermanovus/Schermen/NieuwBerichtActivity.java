package nl.dermanovus.dermanovus.Schermen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nl.dermanovus.dermanovus.R;

public class NieuwBerichtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuw_bericht);
    }

    public void btnHome_Click(View view) {
        finish();
    }

    public void btnVoegFotosToe_Click(View view) {
        startActivity(new Intent(this, DermaCamActivity.class));
    }

    public void btnPlaatsReactie_Click(View view) {
        //  TODO voeg reactie toe aan database
        finish();
    }
}
