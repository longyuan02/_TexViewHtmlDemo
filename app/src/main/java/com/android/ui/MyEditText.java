package com.android.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by liuweia on 2016/2/19.
 */
public class MyEditText extends EditText {
    private int widtha, heighta;

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        widtha = wm.getDefaultDisplay().getWidth();
        heighta = wm.getDefaultDisplay().getHeight();
    }

    public void insertDrawable(Bitmap id) {
        final SpannableString ss = new SpannableString("你好");
        //得到drawable对象，即所要插入的图片
        Drawable d = new BitmapDrawable(id);
        int width = id.getWidth();
        int height = id.getHeight();
        d.setBounds((widtha-width)/2, 0, widtha-(widtha-width)/2, height);

        //用这个drawable对象代替字符串easy
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        //包括0但是不包括"easy".length()即：4。[0,4)。值得注意的是当我们复制这个图片的时候，实际是复制了"easy"这个字符串。
        ss.setSpan(span, 0, "你好".length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        append("\n");
        append(ss);
//        append("\n"+ss);
    }
}
