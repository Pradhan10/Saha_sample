package www.pradhan.com.saha_sample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import www.pradhan.com.saha_sample.db.SahakaritaContract;
import www.pradhan.com.saha_sample.db.SahakaritaDbHelper;
import www.pradhan.com.saha_sample.util.InsertFakeData;

public class ScrollingActivity extends AppCompatActivity {

    private static String LOG_TAG = "CardViewActivity";
    /*Resources*/
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /*Reference of SQLiteDatabase class to set/retrieve data and show on RecyclerView List*/
    private SQLiteDatabase mDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Agents at a glance");
        setSupportActionBar(toolbar);

        /*Create object of DBHelper class by passing reference to activity*/
        SahakaritaDbHelper dbHelper = new SahakaritaDbHelper(this);

        /*Set mDBHelper reference to object of DBHelper class that will push data in SQLite*/
        mDBHelper = dbHelper.getWritableDatabase();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add agent to DB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*New code*/
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /*Passing ref to SQLItedatabase to delete existing table and recreate*/
        InsertFakeData.insertFakeData(mDBHelper);

        /*Get recently inserted data to show in RecyclerView Adapter*/
        Cursor cursor = getAgentData();

        mAdapter = new MyRecyclerViewAdapter(cursor);
        /*TODO A1 : Fetch agents info from DB/network*/
        mRecyclerView.setAdapter(mAdapter);
    }

    /*Method to retrieve all agents*/
    private Cursor getAgentData() {
        return mDBHelper.query(
                SahakaritaContract.AgentEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                SahakaritaContract.AgentEntry.COLUMN_DATE
        );
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

}
