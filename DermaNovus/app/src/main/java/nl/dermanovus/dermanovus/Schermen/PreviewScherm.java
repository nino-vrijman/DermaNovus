package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import nl.dermanovus.dermanovus.R;

public class PreviewScherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_scherm);

        SharedPreferences sharedPref = getSharedPreferences("Foto1", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String fotoStringJSON = sharedPref.getString("Foto1", "");
        Bitmap gemaakteFoto = gson.fromJson(fotoStringJSON, Bitmap.class);

        ImageView gemaakteFotoView = (ImageView)findViewById(R.id.ivPreview);
        gemaakteFotoView.setImageBitmap(gemaakteFoto);
    }

    public void btnHome(View view) {
        startActivity(new Intent(this, DermaCamActivity.class));
    }


    public void btnKeurFotoGoed_Click(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Test");
        alert.setMessage("Wilt u een nieuwe foto maken?");
        alert.setPositiveButton("Ja", null);
        alert.setNegativeButton("Nee", null);
        alert.show();
    }
}
