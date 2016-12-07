package com.bwf.aiyiqi.gui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.HomeFragment;
import com.bwf.aiyiqi.gui.fragment.MessageFragment;
import com.bwf.aiyiqi.gui.fragment.MyFragment;
import com.bwf.aiyiqi.gui.fragment.SayFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.activity_home_frame)
    FrameLayout activityHomeFrame;
    @BindView(R.id.activity_home_bottom_home)
    CheckedTextView activityHomeBottomHome;
    @BindView(R.id.activity_home_bottom_say)
    CheckedTextView activityHomeBottomSay;
    @BindView(R.id.activity_home_bottom_msg)
    CheckedTextView activityHomeBottomMsg;
    @BindView(R.id.activity_home_bottom_mine)
    CheckedTextView activityHomeBottomMine;
    @BindView(R.id.activity_home_bottom)
    LinearLayout activityHomeBottom;
    private FragmentManager mManager;
    private List<Fragment> mFragments;
    private CheckedTextView[] mTabs;
    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mManager = getSupportFragmentManager();
        mTabs = new CheckedTextView[activityHomeBottom.getChildCount()];
        mFragments = getmFragments();
        switchFragment(0);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.activity_home_bottom_home, R.id.activity_home_bottom_say, R.id.activity_home_bottom_msg, R.id.activity_home_bottom_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_home_bottom_home:
                switchFragment(0);
                break;
            case R.id.activity_home_bottom_say:
                switchFragment(1);
                break;
            case R.id.activity_home_bottom_msg:
                switchFragment(2);
                break;
            case R.id.activity_home_bottom_mine:
                switchFragment(3);
                break;
        }
    }
    private List<Fragment> getmFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SayFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MyFragment());

        for (int i = 0; i < fragments.size(); i++) {
            mTabs[i] = (CheckedTextView) activityHomeBottom.getChildAt(i);
        }
        return fragments;
    }

    /**
     * 切换fragment的方法
     * @param index
     */
    private int currentIndex = -1;
    private void switchFragment(int index){
        if(currentIndex == index)return;

        FragmentTransaction mTransaction = mManager.beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            if(index == i){
                Fragment fragment = mFragments.get(i);
                if(mFragments.get(i).isAdded()){
                    mTransaction.show(fragment);
                }else{
                    mTransaction.add(R.id.activity_home_frame,fragment);
                    mTransaction.show(fragment);
                }
                currentIndex = i;
                mTabs[i].setChecked(true);
            }else{
                mTransaction.hide(mFragments.get(i));
                mTabs[i].setChecked(false);
            }
        }
        mTransaction.commit();
    }

    /**
     * 读文件 工具类
     */
//    public void Print(String str){
//        PrintStream ps = null;
//        try {
//            ps = new PrintStream(new File(getFilesDir().getAbsolutePath()+"/2.txt"));
//            ps.print(str);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            ps.close();
//        }
//    }

    /***
     * 再按一次退出
     */
    private long oldTime;
    private long currentTime;
    private int exitTime = 3000;//3秒退出
    @Override
    public void onBackPressed() {
        currentTime = System.currentTimeMillis();
        if( currentTime - oldTime >= exitTime){
            oldTime = currentTime;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            return;
        }else {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }

}
