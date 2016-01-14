package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import nl.dermanovus.dermanovus.R;

public class NieuwBerichtActivity extends AppCompatActivity {
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuw_bericht);

        iv1 = (ImageView)findViewById(R.id.imageView);
        iv2 = (ImageView)findViewById(R.id.imageView2);
        iv3 = (ImageView)findViewById(R.id.imageView3);

        System.out.println("____On create called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("_____On resume called");

        SharedPreferences sharedPreferences = getSharedPreferences("NIEUWBERICHTACTIVITY", MODE_PRIVATE);

        Gson gson = new Gson();
        String fotoJSON;
        Bitmap foto;

        fotoJSON = sharedPreferences.getString("Foto", "");
        if (!fotoJSON.isEmpty()) {
            System.out.println("STRING NOT EMPTY");
            foto = gson.fromJson(fotoJSON, Bitmap.class);
            iv1.setImageBitmap(foto);
        } else {
            System.out.println("EMPTY");
        }
    }

    public void btnHome_Click(View view) {
        finish();
    }

    public void btnVoegFotosToe_Click(View view) {
        Intent fotoIntent = new Intent(this, DermaCamActivity.class);
        startActivity(fotoIntent);
    }

    public void btnPlaatsReactie_Click(View view) {
        //  TODO voeg reactie toe aan database
        finish();
    }
}
