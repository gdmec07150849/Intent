package com.gdmec.jacky.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText urlEditText,telEditText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEditText= (EditText) findViewById(R.id.url);
        telEditText = (EditText) findViewById(R.id.tel);
        textView= (TextView) findViewById(R.id.textView1);
    }
    public void componentname(View view){
        ComponentName componentName=new ComponentName(this,IntentDemo2.class);
        Intent intent1= new Intent();
        intent1.setComponent(componentName);
        startActivity(intent1);
    }
    public void intentfilter(View view){
        String action="com.gdmec.jacky.intend2";
        Intent intent2=new Intent();
        intent2.setAction(action);
        startActivity(intent2);
    }
    public void openUrl(View view){
        Intent intent3=new Intent();
        intent3.setAction(Intent.ACTION_VIEW);
        Uri uri= Uri.parse(urlEditText.getText().toString());
        intent3.setData(uri);
        startActivity(intent3);
    }
    public void dial(View view){
        Intent intent3=new Intent(Intent.ACTION_DIAL);
        Uri uri=Uri.parse("tel:"+telEditText.getText().toString());
        intent3.setData(uri);
        startActivity(intent3);
    }
    public void startactivityforresult(View view){
        Bundle bundle=new Bundle();
        bundle.putString("value",urlEditText.getText().toString());
        Intent intent=new Intent(MainActivity.this,IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle bundle=data.getExtras();
                textView.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
