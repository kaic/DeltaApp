package com.plataformanext.delta.aulas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.plataformanext.delta.R;

public class AulaGeral extends AppCompatActivity {
    private Toolbar mToolbar;
    private SliderLayout sliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_geral);

        mToolbar = (Toolbar) findViewById(R.id.toolbarAulaGeral);
        mToolbar.setTitle("Aula Geral");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sliderShow = (SliderLayout) findViewById(R.id.sliderGeral);
        sliderShow.setDuration(0);
        sliderShow.startAutoCycle(5000, 5000, true);

        DefaultSliderView slide1 = new DefaultSliderView(this);
        slide1.image(R.drawable.mecanica_01);
        DefaultSliderView slide2 = new DefaultSliderView(this);
        slide2.image(R.drawable.mecanica_02);
        DefaultSliderView slide3 = new DefaultSliderView(this);
        slide3.image(R.drawable.cinematica_1);
        DefaultSliderView slide4 = new DefaultSliderView(this);
        slide4.image(R.drawable.cinematica_2);

        sliderShow.addSlider(slide1);
        sliderShow.addSlider(slide2);
        sliderShow.addSlider(slide3);
        sliderShow.addSlider(slide4);
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }

}
