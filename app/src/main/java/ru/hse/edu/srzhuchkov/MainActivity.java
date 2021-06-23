package ru.hse.edu.srzhuchkov;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Feed> feeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView feedView = findViewById(R.id.feedView);
        new Thread(() -> {
            feeds = WebServiceClient.retrieveFeeds();
            FeedAdapter adapter = new FeedAdapter(MainActivity.this, feeds);
            feedView.setAdapter(adapter);
        }).start();
    }
}