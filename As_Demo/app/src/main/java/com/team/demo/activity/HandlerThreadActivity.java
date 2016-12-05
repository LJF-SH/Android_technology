package com.team.demo.activity;


import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.UiThread;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.team.demo.R;
import com.team.demo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HandlerThreadActivity extends BaseActivity {

    String result = "实时更新中，当前大盘指数：<font color='red'>%d</font>";


    @BindView(R.id.id_textview)
    protected TextView mTvServiceInfo;

    @BindView(R.id.botton1)
    protected Button botton1;

    @BindView(R.id.botton2)
    protected Button botton2;

    private Handler threadHandler;


    //创建主线程的handler
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            Message message = new Message();
            uiRefresh();
            Log.d(TAG, "handleMessage: Main Handler " + Math.random());
            //向子线程发送消息
            threadHandler.sendMessageDelayed(message, 1000);
        }
    };


    @UiThread
    private void uiRefresh() {
        result = String.format(result, (int) (Math.random() * 3000 + 1000));
        mTvServiceInfo.setText(Html.fromHtml(result));
    }

    @Override
    protected void setupView() {
        HandlerThread thread = new HandlerThread("handlerThread");
        thread.start();
        //创建子线程的Handeler
        threadHandler = new Handler(thread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Message message = new Message();
                message.what = 1;
                Log.d(TAG, "handleMessage:thread Handler");
                //向主线程发送消息
                handler.sendMessageDelayed(message, 1000);
            }
        };

    }

    @Override
    public int setLayoutResID() {
        return R.layout.activity_handler_thread;
    }

    @Override
    protected void setTitleBar() {
        setLeftBackTitleBar("线程");
    }


    @OnClick({R.id.botton1, R.id.botton2})
    protected void btnCLick(View view) {
        switch (view.getId()) {
            case R.id.botton1:
                handler.sendEmptyMessage(1);
                break;
            case R.id.botton2:
                handler.removeMessages(1);
                break;
            default:
                break;
        }
    }

}
