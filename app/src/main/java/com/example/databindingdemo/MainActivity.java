package com.example.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //initialize variable
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign variable
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //get text from edit text
                String sText=binding.etInput.getText().toString().trim();
                //check condition
                if (!sText.equals("")){
                    //when text is not empty
                    //Set text on text view
                    binding.tvOutput.setText(sText);
                }else {
                    //when text is empty
                    //display toast
                    Toast.makeText(getApplicationContext(), "Please enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //initalize fragment
        Fragment fragment = new MainFragment();
        //commit fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment,fragment).commit();
    }
}