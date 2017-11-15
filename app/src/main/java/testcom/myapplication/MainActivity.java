package testcom.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Rcount;
    String Gcount;
    String Bcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rcount = "Red : 0";
        Gcount = "Green : 0";
        Bcount = "Blue : 0";
    }

    public void bt1_clicked(View v) {
        TextView box;
        box = (TextView)findViewById(R.id.t_box);

        box.setText("bt1 clicked");
        box.setTextColor(0xFFFF0000);

        Intent intent = new Intent(this,bt1_Activity.class);

        intent.putExtra("Rcount",Rcount);

        startActivity(intent);
    }

    public void bt2_clicked(View v) {
        TextView box;
        box = (TextView)findViewById(R.id.t_box);

        box.setText("bt2 clicked");
        box.setTextColor(0xFF00FF00);

        Intent intent = new Intent(this,bt2_Activity.class);

        intent.putExtra("Gcount",Gcount);

        startActivity(intent);
    }

    public void bt3_clicked(View v) {
        TextView box;
        box = (TextView)findViewById(R.id.t_box);

        box.setText("bt3 clicked");
        box.setTextColor(0xFF0000FF);

        Intent intent = new Intent(this,bt3_Activity.class);

        intent.putExtra("Bcount",Bcount);

        startActivity(intent);
    }

    public void Go_Clicked(View v) {
        EditText et = (EditText)findViewById(R.id.t_edit);
        String str = et.getText().toString();

        Intent intent = new Intent(this,go_Activity.class);

        intent.putExtra("words",str);

        startActivity(intent);
    }
}
