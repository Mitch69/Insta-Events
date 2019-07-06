package android.example.instaeventsv1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportData;
//    private SportsAdapter mAdapter;

    private Toolbar mainToolbar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if application is opened for the first time
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);

        if (isFirstRun){
            //Show GetStartedActivity
            Log.i("FIRST TIME OPENING APP", "WORKING?!");
            Intent intent = new Intent(MainActivity.this, GetStartedActivity.class);
            startActivity(intent);
            finish();
        }

        getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit().putBoolean("isFirstRun", false).apply();


        mAuth = FirebaseAuth.getInstance();

        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("InstaEvents");

    }

   /* @Override
    protected void onStart() {
        super.onStart();

        //Firebase Login Authentication
        //Get the currently signed-in user
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_logout_button:
                logOut();
                return true;
            case R.id.action_settings_button:
                accountSetup();
           // case R.id.action_viewUsers_button:
            //    viewUploads();
                default:
                    return false;
        }

    }


    private void accountSetup() {
        Intent intent = new Intent(MainActivity.this, SetupActivity.class);
        startActivity(intent);
    }

    private void logOut() {
        mAuth.signOut();
        sendToLogin();
    }

    private void sendToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
