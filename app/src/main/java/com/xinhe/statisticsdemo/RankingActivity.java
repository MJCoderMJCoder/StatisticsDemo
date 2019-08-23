package com.xinhe.statisticsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-05-04.
 */

public class RankingActivity extends AppCompatActivity {
    public static String TAG = "RankingActivity";

    private Spinner sRankingType;
    private Spinner sRankingRange;

    private ArrayAdapter<String> typeAdapter;
    private ArrayAdapter<String> rangeAdapter;
    private String[] types;
    private String[] ranges;

    private TextView tvTypeName;
    private TextView tvRangeName;

    private ListView lvRanking;
    private RankingAdapter adapter;
    private List<RankingUser> users;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_ranking);

        initView();
        initData();
        setListeners();
        setRankingAdapter();

    }

    private void setRankingAdapter() {
        //准备数据
        getListData();
        adapter = new RankingAdapter(this, users);
        lvRanking.setAdapter(adapter);
    }

    private void getListData() {
        users = new ArrayList<>();
        users.add(0, new RankingUser(3, "", "Male", "tom", "200 卡路里", "1200 磅", "6000 步"));
        users.add(1, new RankingUser(2, "", "Female", "lily", "3000 卡路里", "13000 磅", "6000 步"));
        users.add(2, new RankingUser(1, "", "Male", "tom", "200 卡路里", "13000 磅", "6000 步"));
        users.add(3, new RankingUser(4, "", "Male", "jerry", "200 卡路里", "13000 磅", "10000 步"));
        users.add(4, new RankingUser(5, "", "Male", "jerry", "200 卡路里", "13000 磅", "10000 步"));
        users.add(5, new RankingUser(6, "", "Male", "tom", "200 卡路里", "13000 磅", "6000 步"));
        users.add(6, new RankingUser(8, "", "Female", "lily", "3000 卡路里", "13000 磅", "10000 步"));
        users.add(7, new RankingUser(9, "", "Male", "tom", "200 卡路里", "1200 磅", "10000 步"));
        users.add(8, new RankingUser(10, "", "Male", "tom", "200 卡路里", "13000 磅", "10000 步"));
        users.add(9, new RankingUser(19, "", "Female", "lucy", "200 卡路里", "13000 磅", "6000 步"));
        users.add(10, new RankingUser(20, "", "Male", "tom", "3000 卡路里", "1200 磅", "6000 步"));
        users.add(11, new RankingUser(14, "", "Female", "lucy", "200 卡路里", "13000 磅", "10000 步"));
        users.add(12, new RankingUser(44, "", "Male", "tom", "200 卡路里", "13000 磅", "10000 步"));
        users.add(13, new RankingUser(43, "", "Female", "lucy", "200 卡路里", "13000 磅", "10000 步"));
        users.add(14, new RankingUser(24, "", "Male", "jerry", "3000 卡路里", "1200 磅", "6000 步"));
        users.add(15, new RankingUser(22, "", "Male", "tom", "200 卡路里", "13000 磅", "10000 步"));
        users.add(16, new RankingUser(34, "", "Male", "jerry", "200 卡路里", "1200 磅", "10000 步"));
        users.add(17, new RankingUser(76, "", "Male", "tom", "200 卡路里", "13000 磅", "6000 步"));
        users.add(18, new RankingUser(60, "", "Female", "jerry", "3000 卡路里", "1200 磅", "10000 步"));
    }

    private void setListeners() {
        //修改列表标题
        sRankingType.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        sRankingType.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });

        sRankingType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvSpinnerItem = (TextView) view.findViewById(R.id.ctv_spinner);
                tvSpinnerItem.setTextColor(Color.WHITE);
                String str = (String) tvSpinnerItem.getText();
                tvTypeName.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sRankingRange.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        sRankingRange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvSpinnerItem = (TextView) view.findViewById(R.id.ctv_spinner);
                tvSpinnerItem.setTextColor(Color.WHITE);
                String str = (String) tvSpinnerItem.getText();
                tvRangeName.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initData() {
        types = getResources().getStringArray(R.array.rankingType_array);
        typeAdapter = new ArrayAdapter<String>(this, R.layout.spinner_checked_text, R.id.ctv_spinner, types);
        typeAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        sRankingType.setAdapter(typeAdapter);

        ranges = getResources().getStringArray(R.array.rankingRange_array);
        rangeAdapter = new ArrayAdapter<String>(this, R.layout.spinner_checked_text, R.id.ctv_spinner, ranges);
        rangeAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        sRankingRange.setAdapter(rangeAdapter);
    }

    private void initView() {
        tvTypeName = (TextView) findViewById(R.id.tv_ranking_type_name);
        tvRangeName = (TextView) findViewById(R.id.tv_ranking_range_name);

        sRankingType = (Spinner) findViewById(R.id.ms_rankingType);
        sRankingRange = (Spinner) findViewById(R.id.ms_rankingRange);

        lvRanking = (ListView) findViewById(R.id.lv_ranking);
    }
}
