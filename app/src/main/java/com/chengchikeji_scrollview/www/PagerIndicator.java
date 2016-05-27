package com.chengchikeji_scrollview.www;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.ex_projectitem2.R;

/**
 * Created by Administrator on 2016/5/13.
 * banner自定义Indicator控件
 */
public class PagerIndicator extends View{

    private final Paint paintStoke;
    private int stokeColor = Color.parseColor("#FFFFFF");
    private int fillColor = Color.parseColor("#ED483A");
    private final Paint paintFill;
    private final int num;
    private int radiu = 10;
    private float offest;

    public PagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.circleIndicator);
        num = array.getInteger(R.styleable.circleIndicator_indicator, 4);
        paintStoke = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintStoke.setStyle(Paint.Style.STROKE);
        paintStoke.setColor(stokeColor);
        paintStoke.setStrokeWidth(2);
        paintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintFill.setStyle(Paint.Style.FILL);
        paintFill.setColor(fillColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float cx = getWidth() / 2 - (num - 1) * 1.5f * radiu;
        float cy = getHeight() / 2;
        for (int i = 0; i < num; i++) {
            canvas.drawCircle(cx + i * 3 * radiu, cy, radiu, paintStoke);
        }
        canvas.drawCircle(cx + offest, cy, radiu, paintFill);
    }

    public void move(int position){
        offest = position * 3 * radiu;
        invalidate();
    }

    public void move(int position,float positionOffest){
        offest = position * 3 * radiu + positionOffest * 3 * radiu;
        if (position == 3) {
            offest = position * 3 * radiu;
        }
        // 刷新画布
        invalidate();
    }
}
