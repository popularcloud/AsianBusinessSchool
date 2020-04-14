package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;


/**
 *
 */
public abstract class BaseActivity extends FragmentActivity {

	public Bundle savedInstanceState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.savedInstanceState = savedInstanceState;
		int layoutId = getContentViewId(savedInstanceState);

		setContentView(layoutId);
		ButterKnife.bind(this);
		/**
		 * 初始化
		 */
		init();

		/**
		 * 设置控件的监听
		 */
		widgetListener();

		/**
		 * 获取数据
		 */
		initGetData();

	}

	/**
	 * 获取显示view的xml文件ID
	 * 
	 * 在Activity的 {@link #onCreate(Bundle)}里边被调用
	 * 
	 * @version 1.0
	 * @param savedInstanceState
	 * @createTime 2014年4月21日,下午2:31:19
	 * @updateTime 2014年4月21日,下午2:31:19
	 * @createAuthor CodeApe
	 * @updateAuthor CodeApe
	 * @updateInfo (此处输入修改内容,若无修改可不写.)
	 * 
	 * @return xml文件ID
	 */
	protected abstract int getContentViewId(Bundle savedInstanceState);


	/**
	 * 初始化应用程序，设置一些初始化数据都获取数据等操作
	 * 
	 * 在{@link #widgetListener()}之后被调用
	 * 
	 * @version 1.0
	 * @createTime 2014年4月21日,下午1:55:15
	 * @updateTime 2014年4月21日,下午1:55:15
	 * @createAuthor CodeApe
	 * @updateAuthor CodeApe
	 * @updateInfo (此处输入修改内容,若无修改可不写.)
	 * 
	 */
	protected abstract void init();

	/**
	 * 获取上一个界面传送过来的数据
	 * 
	 * 在{@link BaseActivity#init()}之前被调用
	 * 
	 * @version 1.0
	 * @createTime 2014年4月21日,下午2:42:56
	 * @updateTime 2014年4月21日,下午2:42:56
	 * @createAuthor CodeApe
	 * @updateAuthor CodeApe
	 * @updateInfo (此处输入修改内容,若无修改可不写.)
	 * 
	 */
	protected abstract void initGetData();

	/**
	 * 组件监听模块
	 * 
	 * @version 1.0
	 * @createTime 2014年4月21日,下午1:56:06
	 * @updateTime 2014年4月21日,下午1:56:06
	 * @createAuthor CodeApe
	 * @updateAuthor CodeApe
	 * @updateInfo (此处输入修改内容,若无修改可不写.)
	 * 
	 */
	protected abstract void widgetListener();

}
