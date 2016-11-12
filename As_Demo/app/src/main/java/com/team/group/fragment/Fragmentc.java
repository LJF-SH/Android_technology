package com.team.group.fragment;

import android.util.Log;
import android.widget.ListView;

import com.andview.refreshview.XRefreshView;
import com.team.group.R;
import com.team.group.adapter.FragmentCAdapter;
import com.team.group.api.response.GroupResponse;
import com.team.group.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.team.group.R.id.listview;


/**
 * 未封装的刷新 未完成
 */
public class Fragmentc extends BaseFragment {

    @BindView(R.id.custom_view)
    XRefreshView customView;
    @BindView(listview)
    ListView mListView;
    private FragmentCAdapter mAdapter;

    @Override
    protected void initView() {
        List<GroupResponse> groupResponses = new ArrayList<>();
        int a = 0;
        while (a < 10) {
            GroupResponse re = new GroupResponse();
            re.setName("无刷新:");
            Log.d(TAG, "initView: 页面3");
            groupResponses.add(re);
            a++;
        }
        mAdapter = new FragmentCAdapter(getActivity());
        mListView.setAdapter(mAdapter);
        mAdapter.addDates(groupResponses);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected int setResID() {
        return R.layout.refresh_list_view;
    }

}
