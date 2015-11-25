package com.plataformanext.delta.aulas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.plataformanext.delta.R;

public class AulaVelocidade extends AppCompatActivity {
    private Toolbar mToolbar;
    private SliderLayout sliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_velocidade);

        mToolbar = (Toolbar) findViewById(R.id.toolbarAulaVelocidade);
        mToolbar.setTitle("Aula Velocidade");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sliderShow = (SliderLayout) findViewById(R.id.sliderVelocidade);
        sliderShow.setDuration(0);
        sliderShow.startAutoCycle(5000, 5000, true);

        DefaultSliderView slide1 = new DefaultSliderView(this);
        slide1.image(R.drawable.velocidade_1);
        DefaultSliderView slide2 = new DefaultSliderView(this);
        slide2.image(R.drawable.velocidade_2);
        DefaultSliderView slide3 = new DefaultSliderView(this);
        slide3.image(R.drawable.velocidade_3);
        DefaultSliderView slide4 = new DefaultSliderView(this);
        slide4.image(R.drawable.velocidade_4);
        DefaultSliderView slide5 = new DefaultSliderView(this);
        slide5.image(R.drawable.velocidade_5);
        DefaultSliderView slide6 = new DefaultSliderView(this);
        slide6.image(R.drawable.velocidade_6);
        DefaultSliderView slide7 = new DefaultSliderView(this);
        slide7.image(R.drawable.velocidade_7);
        DefaultSliderView slide8 = new DefaultSliderView(this);
        slide8.image(R.drawable.velocidade_8);

        sliderShow.addSlider(slide1);
        sliderShow.addSlider(slide2);
        sliderShow.addSlider(slide3);
        sliderShow.addSlider(slide4);
        sliderShow.addSlider(slide5);
        sliderShow.addSlider(slide6);
        sliderShow.addSlider(slide7);
        sliderShow.addSlider(slide8);
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }

}