package com.shanks.sea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = (ViewGroup) findViewById(R.id.content);
        addItem();
    }
    private void addItem() {
        add("test", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UriManager.open(MainActivity.this, "shanks://shanks.uri/test/main");
            }
        });
        add("main", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UriManager.open(MainActivity.this, "shanks://shanks.uri/map/main");
            }
        });
    }
    private void add(String name,View.OnClickListener listener) {
        TextView textView = generateItem(name);
        textView.setOnClickListener(listener);
        addView(textView);
    }

    private void add(Class clazz,View.OnClickListener listener) {
        TextView textView = generateItem(clazz.getSimpleName());
        textView.setOnClickListener(listener);
        addView(textView);
    }

    private TextView generateItem(String text) {
        TextView textView = (TextView) LayoutInflater.from(this).inflate(R.layout.demo_item, rootView,false);
        textView.setText(text);
        return textView;
    }

    private void addView(View view) {
        rootView.addView(view);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
