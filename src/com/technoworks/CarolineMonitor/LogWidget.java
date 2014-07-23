package com.technoworks.CarolineMonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * Created by Olga on 22.07.2014.
 */

public class LogWidget extends Activity {

//    private final Paint mPaint;
//    private final int INDENT = 8;
//    private final Rect mTextBounds;
//    private String mTextLog;
//    private int interval;
//
//    public LogWidget() {
//
//        mPaint = new Paint();
//        mPaint.setColor(0xFF000000);
//        mPaint.setTextSize(15);
//        mTextBounds = new Rect();
//
//        mPaint.getTextBounds(mTextLog, 0, mTextLog.length(), mTextBounds);
//        interval = mTextBounds.height() + 6;
//    }
//
//    protected void onDraw(Canvas canvas) {
//
//        updateText();
//        final int x = INDENT;
//        int y// = -INDENT - interval;
//        canvas.drawText(mTextLog, x, y, mPaint);
//    }
//
//    protected void updateText() {
//        //mTextLog = com.technoworks.CarolineMonitor.Protocol.Log.getDefaultInstance();
//        //String mTextLog = newLog.toString();
//        //Protocol.Message.Builder
//    }

//    public class SimpleAdapter {
//
//        ListView lv;
//        String[] texts = {};
//        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
//        Map<String, Object> map;
//        for (int i = 0; i < texts.length; i++) {
//            map = new HashMap<String, Object>();
//            map.put(nameText, texts[i]);
//            data.add(map);
//        }
//
//        String[] from = {nameText};
//        int[] to = {android.R.id.tvText};
//
//        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, from, to);
//
//        }
//    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(SavedInstanceState);
        setContentView(R.layout.listview);

        SimpleAdapter adapter = new SimpleAdapter(this, createLogList(), android.R.layout.simple_expandable_list_item_2,
                new String[]{"log"},
                new int[]{android.R.id.text1, android.R.id.text2});

        ListView lv = (ListView) findViewById(R.id.List);
        lv.setAdapter(adapter);
    }

    private List<Map<String, ?>> createLogList() {

        Protocol.Log log;
        String textLog = log.getLine();
        List<String> logs = new ArrayList<String>();
        logs.add(textLog);

        List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();

        for (String s : logs) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("log", s);
            items.add(map);
        }

        return items;
    }
}
