package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {


    Switch switchlr1,switchfr1,switchlr2,switchfr2,switch5;
    ImageView imageViewLightR1,imageViewLightR2;
    GifImageView gifImageViewFanR1,gifImageViewFanR2;
    TextView val_temperature,val_humidity,val_ph,val_lighting;
    DatabaseReference lightr1,fanr1,lightr2,fanr2,modeRef, mode1Ref;
    DatabaseReference temp,humi,ph,lighting;
    boolean updating = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val_temperature = findViewById(R.id.val_temperature);
        val_humidity = findViewById(R.id.val_humidity);
        val_ph = findViewById(R.id.val_ph);
        val_lighting = findViewById(R.id.val_lighting);
        temp = FirebaseDatabase.getInstance().getReference("/DuLieuBoard/temperature2");
        humi = FirebaseDatabase.getInstance().getReference("/DuLieuBoard/humidity2");
        ph = FirebaseDatabase.getInstance().getReference("/DuLieuBoard/gas2");
        lighting = FirebaseDatabase.getInstance().getReference("/DuLieuBoard/light2");

        switchlr1 = findViewById(R.id.switchlr1);
        switchfr1 = findViewById(R.id.switchfr1);

        switchlr2 = findViewById(R.id.switchlr2);
        switchfr2 = findViewById(R.id.switchfr2);

        switch5 = findViewById(R.id.switch5);

        imageViewLightR1 = findViewById(R.id.ledr1);
        imageViewLightR2 = findViewById(R.id.ledr2);

        gifImageViewFanR1 = findViewById(R.id.fanr1);
        gifImageViewFanR2 = findViewById(R.id.fanr2);

        lightr1 = FirebaseDatabase.getInstance().getReference("/DuLieuGuiXuongBoard/Den1");
        fanr1 = FirebaseDatabase.getInstance().getReference("/DuLieuGuiXuongBoard/Quat1");
        lightr2 = FirebaseDatabase.getInstance().getReference("/DuLieuGuiXuongBoard/Den2");
        fanr2 = FirebaseDatabase.getInstance().getReference("/DuLieuGuiXuongBoard/Quat2");
        modeRef = FirebaseDatabase.getInstance().getReference("/DuLieuGuiXuongBoard/Mode");
        mode1Ref = FirebaseDatabase.getInstance().getReference("/DuLieuBoard/Mode");

        switchlr1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    imageViewLightR1.setImageResource(R.drawable.lamp_on);
                    lightr1.setValue(1);
                }else{
                    imageViewLightR1.setImageResource(R.drawable.lamp);
                    lightr1.setValue(0);
                }
            }
        });

        switchfr1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    gifImageViewFanR1.setImageResource(R.drawable.fan_on);
                    fanr1.setValue(1);
                }else{
                    gifImageViewFanR1.setImageResource(R.drawable.fan);
                    fanr1.setValue(0);
                }
            }
        });
        switchlr2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    imageViewLightR2.setImageResource(R.drawable.lamp_on);
                    lightr2.setValue(1);
                }else{
                    imageViewLightR2.setImageResource(R.drawable.lamp);
                    lightr2.setValue(0);
                }
            }
        });

        switchfr2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    gifImageViewFanR2.setImageResource(R.drawable.fan_on);
                    fanr2.setValue(1);
                }else{
                    gifImageViewFanR2.setImageResource(R.drawable.fan);
                    fanr2.setValue(0);
                }
            }
        });


        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    modeRef.setValue(1);
                }else{
                    modeRef.setValue(0);
                }
            }
        });

        lightr1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue().toString();
                System.out.println(value);
                int myInteger = Integer.parseInt(value);
                if (myInteger == 1) {
                    switchlr1.setChecked(true);
                    System.out.println("light on");
                }
                else if (myInteger == 0){
                    System.out.println("light off");
                    switchlr1.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fanr1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue().toString();
                System.out.println(value);
                int myInteger = Integer.parseInt(value);
                if (myInteger == 1) {
                    switchfr1.setChecked(true);
                    System.out.println("fan on");
                }
                else if (myInteger == 0){
                    System.out.println("fan off");
                    switchfr1.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lightr2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue().toString();
                System.out.println(value);
                int myInteger = Integer.parseInt(value);
                if (myInteger == 1) {
                    switchlr2.setChecked(true);
                    System.out.println("light on");
                }
                else if (myInteger == 0){
                    System.out.println("light off");
                    switchlr2.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fanr2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue().toString();
                System.out.println(value);
                int myInteger = Integer.parseInt(value);
                if (myInteger == 1) {
                    switchfr2.setChecked(true);
                    System.out.println("fan on");
                }
                else if (myInteger == 0){
                    System.out.println("fan off");
                    switchfr2.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        modeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int mode = snapshot.getValue(Integer.class);
                if (!updating) {
                    updating = true;
                    mode1Ref.setValue(mode);
                    updating = false;
                }
                if (mode == 1) {
                    switch5.setChecked(true);
                } else {
                    switch5.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi khi đọc dữ liệu từ Firebase thất bại.
            }
        });

        mode1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int mode1 = snapshot.getValue(Integer.class);
                if (!updating) {
                    updating = true;
                    modeRef.setValue(mode1);
                    updating = false;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi khi đọc dữ liệu từ Firebase thất bại.
            }
        });

        temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String temper = snapshot.getValue().toString();
                double temp = Double.parseDouble(temper);
                int roundedTemp = (int) Math.round(temp);
                val_temperature.setText(roundedTemp + "°");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        humi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String temper = snapshot.getValue().toString();
                double temp = Double.parseDouble(temper);
                int roundedTemp = (int) Math.round(temp);
                val_humidity.setText(roundedTemp + "%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ph.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Double temper = snapshot.getValue(Double.class);
                DecimalFormat df = new DecimalFormat("#.##");
                String value = df.format(temper);
                val_ph.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        lighting.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String temper = snapshot.getValue().toString();
                val_lighting.setText(temper);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}