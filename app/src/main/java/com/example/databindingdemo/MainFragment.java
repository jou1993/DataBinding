package com.example.databindingdemo;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.databindingdemo.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {


    //initialize variable
    private FragmentMainBinding binding;
    private View view;


    public MainFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main
        ,container,false);

        view = binding.getRoot();
        
        binding.btSubmit.setOnClickListener(v -> {
            //get text from edit text
            String sText = binding.etInput.getText().toString().trim();
            //check condition
            if (!sText.equals("")){
                //when text is not empty
                //set text on text view
                binding.tvOutput.setText(sText);
            }else {
                //when text is empty
                //display toast
                Toast.makeText(view.getContext(), "Please enter text", Toast.LENGTH_SHORT).show();
            }
        });
        //return view
        return view;
    }
}