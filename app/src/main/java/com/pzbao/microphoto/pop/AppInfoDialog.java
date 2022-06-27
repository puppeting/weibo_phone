package com.pzbao.microphoto.pop;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.pzbao.microphoto.R;


/**
 * */
public class AppInfoDialog extends Dialog {
     private Context context;


    public AppInfoDialog(Context context, int  threm ){
        super(context,threm);
        this.context = context;

     }


    protected AppInfoDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }


    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.appstoe_pop_layout, null, false);
        setContentView(view);
        setCancelable(false);//点击外部不可dismiss
        Window window = this.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);

//        tvDialogTitle.setText("温馨提示");
//        String mess="请阅读《用户协议》、《隐私政策》并同意授权，以保证app的正常使用";
//        tvDialogInfo.setText( Html.fromHtml(mess));
//        tvDialogInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, XieYiActivity.class));
//            }
//        });
//        llShared.setVisibility(View.GONE);
//        llShared.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dismiss();
//            }
//        });
//        llTongYi.setText("去阅读");
        findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
    }


}
