package com.technoworks.CarolineMonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by Olga on 22.07.2014.
 */

public class LogWidget extends ListView {
    List<Map<String, ?>> mLog;

    public LogWidget(Context context, AttributeSet attrs) {
        super(context, attrs);

        mLog = new ArrayList<Map<String, ?>>();

        SimpleAdapter adapter = new SimpleAdapter(context, mLog, android.R.layout.simple_expandable_list_item_2,
                new String[]{"log"},
                new int[]{android.R.id.text1, android.R.id.text2});
        setAdapter(adapter);
    }

    public void push(Protocol.Log logMessage)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("log", logMessage.getLine());

        mLog.add(map);
    }
}
