package com.dinhnguyen.battery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SpannedActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<>();
    SpannedGridLayoutManager spannedGridLayoutManager;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spanned);
        recyclerView = (RecyclerView) findViewById(R.id.recylcer);
        adapter = new Adapter(movieList,SpannedActivity.this);
        spannedGridLayoutManager = new SpannedGridLayoutManager(new SpannedGridLayoutManager.GridSpanLookup() {
            @Override
            public SpannedGridLayoutManager.SpanInfo getSpanInfo(int position) {
                switch (position % 8 ) {
                    case 0:
                        return new SpannedGridLayoutManager.SpanInfo(2, 4);
                    case 1:
                        return new SpannedGridLayoutManager.SpanInfo(4, 2);
                    case 2:
                        return new SpannedGridLayoutManager.SpanInfo(4, 4);
                    case 3:
                        return new SpannedGridLayoutManager.SpanInfo(2, 2);
                    case 4:
                        return new SpannedGridLayoutManager.SpanInfo(2, 2);
                    case 5:
                        return new SpannedGridLayoutManager.SpanInfo(2, 2);
                    case 6:
                        return new SpannedGridLayoutManager.SpanInfo(2, 2);
                    case 7:
                        return new SpannedGridLayoutManager.SpanInfo(6, 1);
                    default:
                }
                return null;
            }
        }, 6, 1f);
        recyclerView.setLayoutManager(spannedGridLayoutManager);
        recyclerView.setAdapter(adapter);
        prepareMovieData();
    }
    private void prepareMovieData() {
        Movie movie = new Movie("1", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("2", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("3", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("4", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("5", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("6", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("7", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("8", "Science Fiction", "2009");
        movieList.add(movie);

        adapter.notifyDataSetChanged();
    }
}
