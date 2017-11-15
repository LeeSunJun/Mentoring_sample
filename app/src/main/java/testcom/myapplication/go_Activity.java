package testcom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by LeeSunjun on 2017-11-16.
 */

public class go_Activity extends Activity {
    String words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go_screen);

        Intent intent = getIntent();

        words = intent.getStringExtra("words");

        Log.d("words",words);

        TextView tv = (TextView)findViewById(R.id.go_words);
        tv.setText(words);
    }

    @Override
    public void onBackPressed(){
        ;
    }

    public void activeGo_back_clicked(View v) {
        super.onBackPressed();
    }
}
