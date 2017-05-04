package constraint.sample.com.constraintsample;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.separator));
        recyclerView.addItemDecoration(dividerItemDecoration);

        ExampleAdapter exampleAdapter = new ExampleAdapter(getResources().getStringArray(R.array.example_list), mOnItemClickListener);
        recyclerView.setAdapter(exampleAdapter);
    }

    private final ExampleAdapter.OnItemClickListener mOnItemClickListener = new ExampleAdapter.OnItemClickListener() {
        @Override
        public void onClick(int position) {
            switch (position) {
                case 0:
                    startActivity(new Intent(MainActivity.this, GeneralActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, ChainActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, RatioActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, GuidelineActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(MainActivity.this, BiasActivity.class));
                    break;
            }
        }
    };

}
