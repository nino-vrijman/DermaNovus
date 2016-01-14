package nl.dermanovus.dermanovus.Schermen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import nl.dermanovus.dermanovus.R;


public class Hoofdscherm extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    //Titels van de navigatie drawer aanmaken
    //Optionele icons van de navigatie items deze staan op dit moment uit
    String TITLES[] = {"Overzicht","Recepten","Uw gegevens"};
    int ICONS[] = {R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home,R.drawable.ic_home};
    //String en email voor de navigatie drawer
    String NAME = "Kevin Jetten";
    String EMAIL = "Jetten.Kevin@gmail.com";
    //Profielfoto
    int PROFILE = R.drawable.friendlyface;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle

    //Listviews aanmaken voor de behandelingen
    ListView actieveBehandelingen;
    ListView beeindigdeBehandingen;
    //Stringarray voor de behandelingen
    String[] actieveBehandelingenTitel = {"Exceem op linkerarm","Verdachte moedervlek"};
    String[] beeindigdeBehandlingenTitel = {"Wratje op voet","Verdachte moedervlek"};
    String[] actieveBehandelingOmschrijving = {"Verstuur foto","Wordt behandeld"};
    String[] beeindigdeBehandelingOmschrijving = {"Voltooid 13 Januari 2015","Doorverwezen ziekenhuis"};
    Integer[] actieveBehandelingenID = {1,2};
    Integer[] beeindigdeBehandelingenID = {1,2};
    //Images voor de behandelingen
    Integer[] actieveBehandelingenImg = {R.drawable.pic1, R.drawable.omeprazol};
    Integer[] beeindigdeBehandelingenImg = {R.drawable.pic1, R.drawable.omeprazol};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoofdscherm);
 
    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
        mAdapter = new NavigatorCustomAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);       // Creating the Adapter of NavigatorCustomAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);// Setting the adapter to RecyclerView
        //Listener voor de knoppen van de navigatie
        final GestureDetector mGestureDetector = new GestureDetector(Hoofdscherm.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();
                    int position = recyclerView.getChildPosition(child);
                    switch(position){
                        case 1:
                            break;
                        case 2:
                            //StartActivity Berichten
                            startActivity(new Intent(Hoofdscherm.this,ReceptenScherm.class));
                            break;
                        case 3:
                            //StartActivity Recepten
                            startActivity(new Intent(Hoofdscherm.this,UwGegevensScherm.class));
                            break;
                        default:
                            break;
                    }
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager
        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }
            @Override

            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle


        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State
        //ontvangen van clicks op de navigatie items

        //TODO Uit de database data ophalen over behandelingen en deze in de lists zetten
        //Listview actieve behandelingen vullen
        CustomListAdapter adapterActieveBehandelingen = new CustomListAdapter(this, actieveBehandelingenTitel, actieveBehandelingenImg,actieveBehandelingOmschrijving);
        actieveBehandelingen=(ListView)findViewById(R.id.lvActieveBehandelingen);
        actieveBehandelingen.setAdapter(adapterActieveBehandelingen);

        actieveBehandelingen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Selecteditem = actieveBehandelingenTitel[position];
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
                //TODO redirecten van de activity naar Behandeling met ID in shared preference
                SharedPreferences sharedPref  = getSharedPreferences("Behandeling", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("BehandelingID", actieveBehandelingenID[position]);
                editor.commit();
                startActivity(new Intent(Hoofdscherm.this, BehandelingActivity.class));
            }
        });
        //Listview beeindigde behandelingen vullen
        CustomListAdapter adapterBeeindigde = new CustomListAdapter(this, beeindigdeBehandlingenTitel, beeindigdeBehandelingenImg,beeindigdeBehandelingOmschrijving);
        beeindigdeBehandingen=(ListView)findViewById(R.id.lvBeeindigdeBehandelingen);
        beeindigdeBehandingen.setAdapter(adapterBeeindigde);

        beeindigdeBehandingen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Selecteditem= beeindigdeBehandlingenTitel[position];
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
                //TODO redirecten van de activity naar Behandeling met ID in shared preference
                SharedPreferences sharedPref  = getSharedPreferences("Behandeling", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("BehandelingID", beeindigdeBehandelingenID[position]);
                editor.commit();
                startActivity(new Intent(Hoofdscherm.this, BehandelingActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hoofdscherm, menu);
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

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }
}