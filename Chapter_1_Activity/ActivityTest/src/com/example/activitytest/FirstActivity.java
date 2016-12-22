package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.example.activitytest.R;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		
		
		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*1.1加入button，点击显示通知*/
				Toast.makeText(FirstActivity.this, "You clicked Button 1",
				Toast.LENGTH_SHORT).show();
				
//				/*1.2跳转到另外一个活动*/
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				startActivity(intent);
				
				/*1.2向另外一个活动传递数据*/
				String data = "Hello SecondActivity";
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("extra_data", data);
				//startActivity(intent);
				
				startActivityForResult(intent, 1);
				//如果要从下一个活动返回数据，则调用startActivityForResult();
			}
		});
	}
	
	/*2.按菜单键的时候显示菜单*/
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*3.响应点击菜单*/
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.add_item:
				Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
				break;
			case R.id.remove_item:
				Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
				break;
			default:
		}
		return true;
	}
	
	/*4.如果有数据，接收下一个活动返回的数据*/
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case 1:
				if (resultCode == RESULT_OK) {
					String returnedData = data.getStringExtra("data_return");
					Log.e("FirstActivity", returnedData);
				}
				break;
			default:
		}
	}
	
	
}
