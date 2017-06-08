package com.gitant.gitant.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gitant.gitant.R;

import cn.com.ichile.bigbug.UIUtils;

/**
 * FBI WARNING ! MAGIC ! DO NOT TOUGH !
 * Created by WangZQ on 2017/6/8 - 17:38.
 */

public class RightButton extends RelativeLayout {


    private ImageView mIvItem;
    private ImageView mIvArrow;
    private TextView mTvDesc;
    private View mView;
    private RelativeLayout mBtnRoot;

    public RightButton(Context context) {
        this(context, null);
    }

    public RightButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.btn_icon_desc_right, this,
                true);
        mIvItem = (ImageView) findViewById(R.id.iv_btn_right_item);
        mIvArrow = (ImageView) findViewById(R.id.iv_btn_right_arrow);
        mTvDesc = (TextView) findViewById(R.id.tv_btn_right);
        mBtnRoot = (RelativeLayout) findViewById(R.id.right_btn_root);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.BtnRight);
        if (attributes != null) {
            //iv src
            int iv_src = attributes.getResourceId(R.styleable.BtnRight_iv_src, R.mipmap
                    .ic_launcher);
            if (iv_src >= -1) {
                mIvItem.setImageResource(iv_src);
            }
            //iv padding
            int iv_padding = (int) attributes.getDimension(R.styleable.BtnRight_iv_padding, UIUtils
                    .dipToPx(context, 15));
            if (iv_padding >= 0) {
                mIvItem.setPadding(iv_padding, iv_padding, iv_padding, iv_padding);
            }
            //tv desc
            String desc = attributes.getString(R.styleable.BtnRight_tv_desc);
            if (!TextUtils.isEmpty(desc)) {
                mTvDesc.setText(desc);
            }
            //tv text size
            float text_size = attributes.getDimension(R.styleable.BtnRight_tv_text_size, UIUtils
                    .dipToPx(context, 18));
            if (text_size >= 0) {
                mTvDesc.setTextSize(text_size);
            }
            //tv text color
            int text_color = attributes.getColor(R.styleable.BtnRight_tv_text_color, getResources
                    ().getColor(R.color
                    .colorPrimary));
            if (text_color > -1) {
                mTvDesc.setTextColor(text_color);
            }
            //iv arrow src
            int arrow_src = attributes.getResourceId(R.styleable.BtnRight_iv_arrow_src, R.mipmap
                    .ic_launcher);
            if (arrow_src > -1) {
                mIvArrow.setImageResource(arrow_src);
            }
            //iv arrow padding
            int arrow_padding = (int) attributes.getDimension(R.styleable
                    .BtnRight_iv_arrow_padding, UIUtils
                    .dipToPx(context, 15));
            if (arrow_padding >= 0) {
                mIvItem.setPadding(arrow_padding, arrow_padding, arrow_padding, arrow_padding);
            }


            attributes.recycle();
        }

    }

    public void setRightBtnOnclickLis(OnClickListener onclickLis) {
        if (onclickLis != null) {
            mBtnRoot.setOnClickListener(onclickLis);
        }
    }

}
