package www.pradhan.com.saha_sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {

    private static String LOG_TAG = "CardViewActivity";
    /*Resources*/
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Agents at a glance");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*New code*/
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Agent> getDataSet() {
        ArrayList results = new ArrayList<Agent>();
        Agent obj = new Agent("Agent number 4 : Mahesh",
                "Collection on 22/10/18 : Rs 7538/-", R.drawable.agent3);
        results.add(obj);
        Agent obj1 = new Agent("Agent number 10 : Hari",
                "Collection on 22/10/18 : Rs 85000/-", R.drawable.agent3);
        results.add(obj1);
        Agent obj2 = new Agent("Agent number 3 : Gulab",
                "Collection on 22/10/18 : Rs 1200/-", R.drawable.agent3);
        results.add(obj2);
        Agent obj3 = new Agent("Agent number 15 : Mahesh",
                "Collection on 22/10/18 : Rs 7538/-", R.drawable.agent3);
        results.add(obj3);
        Agent obj4 = new Agent("Agent number 32 : Anant",
                "Collection on 22/10/18 : Rs 100432/-", R.drawable.agent1);
        results.add(obj4);
        Agent obj5 = new Agent("Agent number 42 : Mahesh",
                "Collection on 22/10/18 : Rs 7538/-", R.drawable.agent1);
        results.add(obj5);
        Agent obj6 = new Agent("Agent number 1 : Ajay",
                "Collection on 22/10/18 : Rs 4538/-", R.drawable.agent1);
        results.add(obj6);
        Agent obj7 = new Agent("Agent number 82 : Aarti",
                "Collection on 22/10/18 : Rs 5632/-", R.drawable.agent1);
        results.add(obj7);
        Agent obj8 = new Agent("Agent number 4 : Kumar",
                "Collection on 22/10/18 : Rs 627/-", R.drawable.agent1);
        results.add(obj8);
        Agent obj9 = new Agent("Agent number 19 : Prabhu",
                "Collection on 22/10/18 : Rs 7538/-", R.drawable.agent1);
        results.add(obj9);
        Agent obj0 = new Agent("Agent number 12 : Kamini",
                "Collection on 22/10/18 : Rs 10000/-", R.drawable.agent1);
        results.add(obj0);

        return results;
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
