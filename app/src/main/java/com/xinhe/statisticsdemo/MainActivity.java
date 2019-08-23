package com.xinhe.statisticsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import com.xinhe.statisticsdemo.radar.RadarData;
import com.xinhe.statisticsdemo.radar.RadarView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadarView rvMuscleCompare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        rvMuscleCompare = (RadarView) findViewById(R.id.rv_muscle_radar);

        rvMuscleCompare.setEmptyHint("无数据");
        List<Integer> layerColor = new ArrayList<>();
        Collections.addAll(layerColor, 0x3300bcd4, 0x3303a9f4, 0x335677fc, 0x333f51b5, 0x33673ab7);
        rvMuscleCompare.setLayerColor(layerColor);
        List<String> vertexText = new ArrayList<>();
        Collections.addAll(vertexText, "力量", "敏捷", "速度", "智力", "精神", "耐力", "体力", "魔力", "意志", "幸运");
        rvMuscleCompare.setVertexText(vertexText);
        List<Float> values = new ArrayList<>();
        Collections.addAll(values, 3f, 6f, 2f, 7f, 5f, 1f, 4f, 3f, 8f, 5f);
        RadarData data = new RadarData(values);
        List<Float> values2 = new ArrayList<>();
        Collections.addAll(values2, 7f, 1f, 4f, 2f, 8f, 3f, 9f, 6f, 5f, 3f);
        RadarData data2 = new RadarData(values2);
        rvMuscleCompare.addData(data);
        rvMuscleCompare.addData(data2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toggle_rotation:
                rvMuscleCompare.setRotationEnable(!rvMuscleCompare.isRotationEnable());
                break;
            case R.id.anime_value:
                rvMuscleCompare.animeValue(2000);
                break;
            case R.id.change_layer:
                int randomInt = new Random().nextInt(6) + 1;
                rvMuscleCompare.setLayer(randomInt);
                break;
            case R.id.change_web_mode:
                if (rvMuscleCompare.getWebMode() == RadarView.WEB_MODE_POLYGON) {
                    rvMuscleCompare.setWebMode(RadarView.WEB_MODE_CIRCLE);
                } else {
                    rvMuscleCompare.setWebMode(RadarView.WEB_MODE_POLYGON);
                }
                break;
            case R.id.toggle_line_enable:
                rvMuscleCompare.setRadarLineEnable(!rvMuscleCompare.isRadarLineEnable());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
