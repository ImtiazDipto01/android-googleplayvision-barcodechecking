package com.example.annanovas.barcodechecking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class NewMainActivity extends AppCompatActivity {

    Button scan ;
    TextView tvReuslt ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        scan = findViewById(R.id.btn_scan) ;
        tvReuslt = findViewById(R.id.tv_barcode_result) ;

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewMainActivity.this, ScanBarcodeActivity.class);
                startActivityForResult(intent, 0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){

            if(resultCode == CommonStatusCodes.SUCCESS){
                if(data != null){
                    Barcode barcode = data.getParcelableExtra("barcode") ;
                    tvReuslt.setText("VALUE IS : "+barcode.displayValue);
                }
                else{
                    tvReuslt.setText("VALUE IS : NULL");
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
