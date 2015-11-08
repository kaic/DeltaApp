package com.plataformanext.delta.aulas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.plataformanext.delta.R;

public class AulaTeste extends AppCompatActivity {
    private Toolbar mToolbar;
    private SliderLayout sliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_teste);

        mToolbar = (Toolbar) findViewById(R.id.toolbarAulaTeste);
        mToolbar.setTitle("Aula Teste");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sliderShow = (SliderLayout) findViewById(R.id.slider);
        sliderShow.setDuration(4000);

        DefaultSliderView slide1 = new DefaultSliderView(this);
        slide1.image(R.drawable.mecanica_01);
        DefaultSliderView slide2 = new DefaultSliderView(this);
        slide2.image(R.drawable.mecanica_02);

        sliderShow.addSlider(slide1);
        sliderShow.addSlider(slide2);
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }

}
