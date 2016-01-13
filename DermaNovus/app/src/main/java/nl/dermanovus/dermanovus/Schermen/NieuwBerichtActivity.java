package nl.dermanovus.dermanovus.Schermen;

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
}
