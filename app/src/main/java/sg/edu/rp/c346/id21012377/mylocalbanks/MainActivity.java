package sg.edu.rp.c346.id21012377.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    String wordClicked = "";

    TextView OCBC;
    TextView DBS;
    TextView UOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OCBC = findViewById(R.id.ocbc);
        DBS = findViewById(R.id.dbs);
        UOB = findViewById(R.id.uob);

        registerForContextMenu(OCBC);
        registerForContextMenu(DBS);
        registerForContextMenu(UOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == OCBC) {
            wordClicked = "ocbc";
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the bank");
        } else if (v == DBS) {
            wordClicked = "dbs";
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the bank\"");
        } else if (v == UOB) {
            wordClicked = "uob";
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the bank");
        }


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18003633333"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18001111111"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18002222121"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }

        }
        return super.onContextItemSelected(item);}

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            OCBC.setText("OCBC");
            DBS.setText("DBS");
            UOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            OCBC.setText("华侨银行");
            DBS.setText("星展银行");
            UOB.setText("大华银行");
            return true;
        } else {
            OCBC.setText("Error translation");
            DBS.setText("Error translation");
            UOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}