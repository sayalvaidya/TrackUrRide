package com.example.sayalvaidya.trackurride;

import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sayalvaidya.trackurride.domain.Services;
import com.example.sayalvaidya.trackurride.utils.DatabaseConnection;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.sayalvaidya.trackurride.R.id.time;

public class Service extends AppCompatActivity {

    DatabaseConnection dbase = new DatabaseConnection(this);

    Services ser = new Services();

    EditText initial_s;
    EditText final_s;
    EditText date;
    EditText note_s;
    Button serviced;
    Button history_s;
    Button generate_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        date= (EditText) findViewById(R.id.inputDate);
        initial_s= (EditText) findViewById(R.id.inputSKM);
        final_s = (EditText)findViewById(R.id.inputUKM);
        note_s= (EditText)findViewById(R.id.notes);
        generate_s=(Button)findViewById(R.id.generate_s);
        history_s=(Button)findViewById(R.id.service_history);
        serviced=(Button)findViewById(R.id.serviced);

//
//
        generate_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String initialkm_s = initial_s.getText().toString();
                int ik=Integer.parseInt(initialkm_s);
                int sk = ik+2000;

                String result = String.valueOf(sk);
                showMessage("To be serviced around",result.toString());
            }

        });

        serviced.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String finalkm_s= final_s.getText().toString();
                String note= note_s.getText().toString();
                long time = System.currentTimeMillis();
                SimpleDateFormat dayTime = new SimpleDateFormat("dd/MM/yy");
                String str = dayTime.format(new Date(time));
                date.setText(str);

                if(finalkm_s.equals("")){
                    String msg = "Error!!! No kilometer update";
                    Toast.makeText(Service.this,msg, Toast.LENGTH_SHORT).show();
                }
                else{
                    showMessage("Serviced on", finalkm_s.toString() + "km" + " on" + " " + str);

                    dbase.insert_Service(ser);

                    ser.setServiced_date(str);
                    ser.setFinal_km_S(finalkm_s);
                    ser.setNotes(note);


                }
            }
        });
        history_s.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor rest=dbase.getData_s();
                        if(rest.getCount()==0){
                            showMessage("Error","Nothing Found!!");
                            return;
                        }

                        StringBuffer buffer=new StringBuffer();
                        while (rest.moveToNext()){
                            buffer.append("_id:"+rest.getString(0)+"\n");
                            buffer.append("Serviced_date:"+rest.getString(1)+"\n");
                            buffer.append("Final_km_s:"+rest.getString(2)+"\n");
                            buffer.append("Notes:"+rest.getString(3)+"\n \n");

                        }

                        showMessage("Servicing History",buffer.toString());

                    }
                }
        );



    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



}
