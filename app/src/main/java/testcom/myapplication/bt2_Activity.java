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

public class bt2_Activity extends Activity {
    String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt2_screen);

        Intent intent = getIntent();

        count = intent.getStringExtra("Gcount");

        Log.d("count",count);

        TextView tv = (TextView)findViewById(R.id.bt2_count);
        tv.setText(count);
    }

    @Override
    public void onBackPressed(){
        ;
    }

    public void active2_back_clicked(View v) {
        super.onBackPressed();
    }
}
