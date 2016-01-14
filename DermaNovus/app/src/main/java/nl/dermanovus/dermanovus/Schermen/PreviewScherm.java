package nl.dermanovus.dermanovus.Schermen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nl.dermanovus.dermanovus.R;

public class PreviewScherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_scherm);
    }

    public void btnHome(View view) {
        startActivity(new Intent(this, DermaCamActivity.class));
    }
}
