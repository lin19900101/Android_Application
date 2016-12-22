package com.example.uiwidgettest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

//public class MainActivity extends Activity {
//
//	private Button button;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		
//		button = (Button)findViewById(R.id.button);
//		button.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//			// 在此处添加逻辑
//				Toast.makeText(MainActivity.this, "You clicked Button",
//						Toast.LENGTH_SHORT).show();
//			}
//		});
//			
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//}

//以下为另一种监听按键按下的方法
public class MainActivity extends Activity implements OnClickListener {
	
	private Button button;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);
		editText = (EditText) findViewById(R.id.edit_text);
		imageView = (ImageView) findViewById(R.id.image_view);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		
		button.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			case R.id.button:
				
//				String inputText = editText.getText().toString();
//				Toast.makeText(MainActivity.this, inputText,Toast.LENGTH_SHORT).show();
//				imageView.setImageResource(R.drawable.jelly_bean);
				
//				if (progressBar.getVisibility() == View.GONE) {
//					progressBar.setVisibility(View.VISIBLE);
//				} else {
//					progressBar.setVisibility(View.GONE);
//				}
				int progress = progressBar.getProgress();
				progress = progress + 10;
				progressBar.setProgress(progress);
				// 在此处添加逻辑
				break;
		default:
			break;
		}
	}
}
