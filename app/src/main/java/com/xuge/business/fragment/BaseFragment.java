package com.xuge.business.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * 为所有的fragment提供公共的行为
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mContext;

    public abstract BaseFragment newInstance();
}
