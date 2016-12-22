package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.example.activitytest.R;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
//		/*1.1取出上一个活动传递过来的数据并且打印出来*/
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data");
//		Log.e("SecondActivity", data);
		
		/*2.1返回数据给上一个活动*/
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("data_return", "this is click button return Hello FirstActivity");
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}
	
	/*3.1如果是按返回键返回，在这个逻辑中出来返回的数据*/
	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "this is onBackPressed return Hello FirstActivity");
		setResult(RESULT_OK, intent);
		finish();
	}
}
