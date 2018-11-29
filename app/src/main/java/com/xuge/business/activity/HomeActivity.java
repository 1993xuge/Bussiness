package com.xuge.business.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xuge.business.R;
import com.xuge.business.activity.base.BaseActivity;
import com.xuge.business.fragment.BaseFragment;
import com.xuge.business.fragment.home.HomeFragment;
import com.xuge.business.fragment.home.MineFragment;
import com.xuge.business.fragment.home.MessageFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private static final int FRAGMENT_INDEX_HOME = 1;
    private static final int FRAGMENT_INDEX_MESSAGE = 2;
    private static final int FRAGMENT_INDEX_MINE = 3;
    /**
     * fragment相关
     */
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFramgent;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 初始化
        initView();

        // 添加默认的fragment
        mHomeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout_view:
                switchFragment(FRAGMENT_INDEX_HOME);
                break;
            case R.id.message_layout_view:
                switchFragment(FRAGMENT_INDEX_MESSAGE);
                break;
            case R.id.mine_layout_view:
                switchFragment(FRAGMENT_INDEX_MINE);
                break;
        }
    }

    private void switchFragment(int framgentIndex) {
        Fragment fragment = getFragmentByIndex(framgentIndex);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, fragment);
        fragmentTransaction.commit();

        mCurrent = fragment;
    }

    private Fragment getFragmentByIndex(int framgentIndex) {
        switch (framgentIndex) {
            case FRAGMENT_INDEX_MESSAGE:
                if (mMessageFramgent == null) {
                    mMessageFramgent = new MessageFragment();
                }
                return mMessageFramgent;
            case FRAGMENT_INDEX_MINE:
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                }
                return mMineFragment;
            case FRAGMENT_INDEX_HOME:
            default:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                return mHomeFragment;
        }
    }
}
