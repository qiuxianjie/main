package edu.feicui.app.phone.activity;

import android.os.Bundle;
import android.view.View;

import edu.feicui.app.phone.base.db.BaseActivity;

public class HomeActivity extends BaseActivity {
//你大爷的   哈哈哈哈哈哈
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void  hitHomeitem(View view){
        int viewID=view.getId();
        switch (viewID){
            case R.id.icon_rocket:
                //startActivityTest();
                break;
            case  R.id.icon_softmgr:
                break;
            case  R.id.icon_phonemgr:
                break;
            case  R.id.icon_telmgr:
                break;
            case  R.id.icon_filemgr:
                break;
            case  R.id.icon_sdclean:
                break;
        }
    }
}
