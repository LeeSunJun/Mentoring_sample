package testcom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LeeSunjun on 2017-11-16.
 */

public class bt2_Activity extends Activity {
    EditText editText;

    int R_value;
    int G_value;
    int B_value;

    View tmp_view;

    boolean valid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt2_screen);

        editText = (EditText)findViewById(R.id.Edit_G_value);

        Intent intent = getIntent();

        R_value = Integer.parseInt(intent.getStringExtra("RED"));
        G_value = Integer.parseInt(intent.getStringExtra("GREEN"));
        B_value = Integer.parseInt(intent.getStringExtra("BLUE"));

        tmp_view = (View)findViewById(R.id.t_frame);
        tmp_view.setBackgroundColor(Color.rgb(R_value,G_value,B_value));
    }

    @Override
    public void onBackPressed(){
        ;
    }

    public void active2_back_clicked(View v) {
        Intent returnIntent = new Intent();

        if(valid) {
            returnIntent.putExtra("GREEN", Integer.toString(G_value));

            Log.d("color","G_Num1 : " + G_value);

            setResult(Activity.RESULT_OK, returnIntent);
            super.onBackPressed();
        } else {
            Toast.makeText(this, "You should set valid 'G' value!", Toast.LENGTH_SHORT).show();
        }
    }

    public void apply_b_clicked(View v){
        G_value = Integer.parseInt(editText.getText().toString());

        if(G_value>=0 && G_value<=255) {
            tmp_view.setBackgroundColor(Color.rgb(R_value,G_value,B_value));
            valid = true;
        } else {
            Toast.makeText(this, "G value should be in the range (1 ~ 255)", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        editText.setText("");
    }
}
