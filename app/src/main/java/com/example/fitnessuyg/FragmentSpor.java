package com.example.fitnessuyg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.fitnessuyg.databinding.FragmentSporBinding;
public class FragmentSpor extends Fragment {

    private String s, m, b, kal;
    private int sinav, mekik, barfiks, yakilanKalori;
    private FragmentSporBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSporBinding.inflate(getLayoutInflater(), container, false);

        addButton();

        return binding.getRoot();
    }



    public void calCalculator(){
        s = binding.editTextSinav.getText().toString();
        m = binding.editTextMekik.getText().toString();
        b = binding.editTextBarfiks.getText().toString();

        sinav = Integer.parseInt(s);
        mekik = Integer.parseInt(m);
        barfiks = Integer.parseInt(b);

        yakilanKalori = (sinav*2)+(mekik*2)+(barfiks*5);
        kal = Integer.toString(yakilanKalori);
        binding.textViewHareketBilgi.setText("Tebrikler. Bugün "+s+" adet şınav "+m+" adet mekik "+b+" adet barfiks çekmişsiniz. Bu yaptıklarınız sayesinde ortalama "+kal+" kalori yaktınız.");
    }


    public void addButton(){
        binding.buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = binding.editTextSinav.getText().toString();
                m = binding.editTextMekik.getText().toString();
                b = binding.editTextBarfiks.getText().toString();

                if (s.isEmpty() || m.isEmpty() || b.isEmpty()){
                    Toast.makeText(getActivity(), "Lütfen Tüm Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                } else {
                    calCalculator();
                }
            }
        });
    }
}