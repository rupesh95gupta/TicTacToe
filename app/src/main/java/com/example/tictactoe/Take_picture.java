package com.example.tictactoe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;

public class Take_picture extends AppCompatActivity {

    private ImageView imageHolder,imageholder1;
    private final int requestCode = 20;
    private final int requestcode1=21;
    Button nextactivty;
    AnimationDrawable anim;
    LinearLayout containe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);


        //Animation Drawable Background
        containe=(LinearLayout)findViewById(R.id.container1);
        anim=(AnimationDrawable)containe.getBackground();
        anim.setEnterFadeDuration(4000);
        anim.setExitFadeDuration(2000);


        imageHolder = (ImageView)findViewById(R.id.captured_photo);
        imageholder1=(ImageView)findViewById(R.id.captured_photo1);
        nextactivty=findViewById(R.id.next);
        nextactivty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);

                startActivity(intent);
            }
        });

        Button capturedImageButton = (Button)findViewById(R.id.photo_button);
        capturedImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });
        Button capturedImageButton1=(Button)findViewById(R.id.photo_button1);
        capturedImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent1,requestcode1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);

        }
            else if (this.requestcode1==requestcode1 && resultCode==RESULT_OK){
                Bitmap bitmap1=(Bitmap)data.getExtras().get("data");
                imageholder1.setImageBitmap(bitmap1);
            }
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
