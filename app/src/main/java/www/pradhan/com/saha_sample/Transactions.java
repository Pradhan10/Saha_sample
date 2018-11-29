package www.pradhan.com.saha_sample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Transactions extends AppCompatActivity {

    List<Agent> agents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction);
        RecyclerView recyclerView = findViewById(R.id.card_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Transactions.this);

        recyclerView.setLayoutManager(linearLayoutManager);


    }

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData() {
        agents = new ArrayList<>();
        agents.add(new Agent("Emma Wilson", "23 years old", R.drawable.agent1));
        agents.add(new Agent("Emma Wilson", "23 years old", R.drawable.agent1));

    }

}
