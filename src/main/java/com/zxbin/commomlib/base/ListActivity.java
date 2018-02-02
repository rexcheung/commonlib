package com.zxbin.commomlib.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zxbin.commomlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex.Zhang on 2016/2/20.
 */
public abstract class ListActivity extends BaseActivity {

    protected RecyclerView mRecyclerView;
    protected LinearLayoutManager llm;
    protected RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genture_activity);
        findViews();
        initRecyclerView();
    }

    private void findViews() {
        mRecyclerView = findViewById(R.id.list);
    }

    private void initRecyclerView() {
        llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);
        mAdapter = initAdapter();
        if (mAdapter != null) {
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    protected abstract RecyclerView.Adapter initAdapter();

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            mAdapter = adapter;
        }
    }

    protected List<String> getClassNames(Class[] cls) {
        if (cls == null || cls.length == 0) {
            return null;
        }

        ArrayList list = new ArrayList();
        for (Class clz : cls) {
            list.add(clz.getSimpleName());
        }

        return list;
    }
}
