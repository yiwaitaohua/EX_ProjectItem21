package com.chengchikeji_scrollview.www;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.ex_projectitem2.R;

/**
 * Created by Administrator on 2016/5/16.
 * 首页向上滚动更新消息
 */
public class HomePageNewsRolling extends LinearLayout {

    private Context mContext;
    private ViewFlipper viewFlipper;
    private View scrollTitleView;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
                case 1:
                    bindNotices();
                    break;
                case -1:
                    break;
            }
        }
    };

    /**
     * 构造
     * @param context
     */
    public HomePageNewsRolling(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public HomePageNewsRolling(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();

    }
    /**
     * 网络请求后返回公告内容进行适配
     */
    protected void bindNotices() {
        // TODO Auto-generated method stub
        viewFlipper.removeAllViews();
        int i = 0;
        while (i < 5) {
            String text = "恭喜用户名称获得iPhone6plus";
            TextView textView = new TextView(mContext);
            textView.setText(text);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setOnClickListener(new NoticeTitleOnClickListener(mContext, i + text));
            LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
            viewFlipper.addView(textView, lp);
            i++;
        }
    }

    private void init() {
        bindLinearLayout();
        Message msg = new Message();
        msg.what = 1;
        mHandler.sendMessageDelayed(msg, 3000);

    }

    /**
     * 初始化自定义的布局
     */
    public void bindLinearLayout() {
        scrollTitleView = LayoutInflater.from(mContext).inflate(R.layout.layout_gundongxiaoxi, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        addView(scrollTitleView, layoutParams);

        viewFlipper = (ViewFlipper) scrollTitleView.findViewById(R.id.flipper_scrollTitle);
        //				viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left));
        //				viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right));
        //		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.bottom_in));
        //		viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.top_out));
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.side_bottom_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.side_top_out));
        viewFlipper.startFlipping();
        //				viewFlipper.showNext();
        View v = viewFlipper.getCurrentView();

    }

    /**
     * 获取公告资讯
     */
    public void getPublicNotices() {
        //网络请求获取
    }

    /**
     * 公告title监听
     * @author Nono
     *
     */
    class NoticeTitleOnClickListener implements OnClickListener {
        private Context context;
        private String titleid;

        public NoticeTitleOnClickListener(Context context, String whichText) {
            this.context = context;
            this.titleid = whichText;
        }

        public void onClick(View v) {
            // TODO Auto-generated method stub
            //			disPlayNoticeContent(context, titleid);
            Toast.makeText(context, titleid, Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 显示notice的具体内容
     * @param context
     * @param titleid
     */
    //	public void disPlayNoticeContent(Context context, String titleid) {
    //		// TODO Auto-generated method stub
    //		Toast.makeText(context, titleid, Toast.LENGTH_SHORT).show();
    //		intent = new Intent(context, InformationContentActivity.class);
    //		intent.putExtra("tag", titleid);
    //		((Activity) context).startActivity(intent);
    //	}
}
