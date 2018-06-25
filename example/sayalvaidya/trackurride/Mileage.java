package com.example.sayalvaidya.trackurride;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.widget.LinearLayout.LayoutParams;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayalvaidya.trackurride.domain.Mileages;
import com.example.sayalvaidya.trackurride.utils.DatabaseConnection;

import static android.R.id.list;

public class Mileage extends AppCompatActivity {


    DatabaseConnection db = new DatabaseConnection(this);

    Mileages mil=new Mileages();

//    EditText initialkm;
//    EditText finalkm;
//    EditText refuel;
//    Button generate;
    Button history;

    EditText initial;
    EditText finalkm;
    EditText fuel;
    Button generate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mileage);


        initial= (EditText) findViewById(R.id.inputKM);
        finalkm= (EditText) findViewById(R.id.inputFKM);
        fuel= (EditText) findViewById(R.id.inputrefuel);
        generate = (Button) findViewById(R.id.generate);
        history = (Button)findViewById(R.id.mileage_history);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String initialkm = initial.getText().toString();
                String finalkkm= finalkm.getText().toString();
                String refuel= fuel.getText().toString();

//                if (initialkm.equals("")||finalkkm.equals("")||refuel.equals("")){
//                    generate.setEnabled(false);
//                }
                int ik=Integer.parseInt(initialkm);
                int fk=Integer.parseInt(finalkkm);
                int r=Integer.parseInt(refuel);
                String result;
                if (ik>fk) {
                    result = "Error!!! Initial kilometer greater than final kilometer";
                    Toast.makeText(Mileage.this,result, Toast.LENGTH_SHORT).show();
                }
                else if (initialkm.equals("")|| finalkkm.equals("")||refuel.equals("")){
                    result = "Error!!! Field is empty";
                    Toast.makeText(Mileage.this,result, Toast.LENGTH_SHORT).show();
                }
                else {

                    int m = (fk - ik) / r;
//        int result = (Integer.parseInt(finalkm.getText().toString()) - Integer.parseInt(initial.getText().toString()))/(Integer.parseInt(fuel.getText().toString()));
                    result = String.valueOf(m);
                  //  Toast.makeText(Mileage.this,"Mileage is "+result, Toast.LENGTH_SHORT).show();
                    showMessage("Mileage is",result.toString());
                    db.insert_Mileage(mil);

                    mil.setInitial_km(initialkm);
                    mil.setFinal_km(finalkkm);
                    mil.setRefulled_quantity(refuel);
                    mil.setMileage(String.valueOf(m));


                }



            }
        });

            history.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Cursor res=db.getData();
                            if(res.getCount()==0){
                                showMessage("Error","Nothing Found!!");
                                return;
                            }

                                StringBuffer buffer=new StringBuffer();
                                while (res.moveToNext()){
                                    buffer.append("_id:"+res.getString(0)+"\n");
                                    buffer.append("I_km:"+res.getString(1)+"\n");
                                    buffer.append("F_km:"+res.getString(2)+"\n");
                                    buffer.append("R_quantity:"+res.getString(3)+"\n");
                                    buffer.append("Mileage:"+res.getString(4)+"\n \n");
                                }

                                showMessage("Mileage History",buffer.toString());

                        }
                    }
            );




    }
//        db = new DatabaseConnection(this);
//
//        initialkm= (EditText) findViewById(R.id.inputKM);
//        finalkm=(EditText) findViewById(R.id.inputFKM);
//        refuel=(EditText)findViewById(R.id.inputrefuel);
//        generate=(Button)findViewById(R.id.generate);
//        history= (Button)findViewById(R.id.mileage_history);
//
//        m.setInitial_km((initialkm.getText().toString()));
//        m.setFinal_km((finalkm.getText().toString()));
//        m.setRefulled_quantity((refuel.getText().toString()));
//
//        addData();
//        viewData();
//    }
//
//
//    int result;
//
//    public void addData()
//    {
//
//        generate.setOnClickListener(
//                new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                result = (Integer.parseInt(finalkm.getText().toString()) - Integer.parseInt(initialkm.getText().toString()))/(Integer.parseInt(refuel.getText().toString()));
//
//                m.setMileage(Integer.toString(result));
//                db.insert_Mileage(m);
//                Toast.makeText(Mileage.this, result, Toast.LENGTH_SHORT).show();
//
//
//            }
//
//
//        });
//
//
//
//
//
//    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



}
