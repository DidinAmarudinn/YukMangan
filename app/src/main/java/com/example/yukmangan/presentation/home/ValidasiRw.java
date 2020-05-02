package com.example.yukmangan.presentation.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yukmangan.R;
public class ValidasiRw extends AppCompatActivity {
    LinearLayout copyToClipBoard;
    LinearLayout btn_call_via_whatsapp;
    TextView tv_validasi_rw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validasi_rw);
        tv_validasi_rw=findViewById(R.id.tv_text_validasi);
        btn_call_via_whatsapp=findViewById(R.id.btn_call_via_whatsapp);
        copyToClipBoard=findViewById(R.id.copyToClipBoard);
        copyToClipBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData=ClipData.newPlainText("textview",tv_validasi_rw.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(ValidasiRw.this,"Copied",Toast.LENGTH_SHORT).show();
            }
        });
        btn_call_via_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendWhatsapMessage();
            }
        });
    }
    private void sendWhatsapMessage(){
        String contact="6287824549282";
        String message="TerimKasih";
        String url="https://wa.me/"+contact+"/?text="+message;
        try {
            PackageManager pm= this.getPackageManager();
            pm.getPackageInfo("com.whatsapp",PackageManager.GET_ACTIVITIES);
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(ValidasiRw.this,"WhatsApp Not Installed",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
