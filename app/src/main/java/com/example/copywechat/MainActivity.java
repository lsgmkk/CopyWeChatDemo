package com.example.copywechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CopyWeChatEditText mCopyWeChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCopyWeChat = findViewById(R.id.copy_wechat);
        //一定要在这里面设置监听，否则删除会出现问题。如果有更好的办法请告知我，谢谢

        mCopyWeChat.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    return CopyWeChatEditText.KeyDownHelper(mCopyWeChat.getText());
                }
                return false;
            }
        });

        findViewById(R.id.bt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddText();
            }
        });
    }

    private void AddText() {
        //注意添加需要自己拼接@ 符号
        mCopyWeChat.addSpan("@啦啦啦 ");
    }
}
