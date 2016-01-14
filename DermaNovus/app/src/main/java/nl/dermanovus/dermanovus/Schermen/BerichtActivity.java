package nl.dermanovus.dermanovus.Schermen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import nl.dermanovus.dermanovus.Behandeling;
import nl.dermanovus.dermanovus.R;

public class BerichtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bericht);
        TextView tvInhoud = (TextView) findViewById(R.id.tvInhoud);
        tvInhoud.setText("Ik heb gekeken naar je probleem en heb je een medicijn voor je uitgeschreven");
    }

    public void btnHome_Click(View view) {
        finish();
    }

    public void btnReageer_Click(View view) {
        startActivity(new Intent(this, NieuwBerichtActivity.class));
    }
}
