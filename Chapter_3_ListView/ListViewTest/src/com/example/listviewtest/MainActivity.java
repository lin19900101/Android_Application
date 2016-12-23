package com.example.listviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
			"Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };

	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFruits(); // 初始化水果数据
		FruitAdapter adapter = new FruitAdapter(MainActivity.this,
				R.layout.fruit_item, fruitList);
		ListView listView = (ListView) findViewById(R.id.list_view);

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Fruit fruit = fruitList.get(position);
				Toast.makeText(MainActivity.this, fruit.getName(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initFruits() {
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.apple_pic);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.apple_pic);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.apple_pic);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.apple_pic);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.apple_pic);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.apple_pic);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.apple_pic);
		fruitList.add(strawberry);
		Fruit cherry = new Fruit("Cherry", R.drawable.apple_pic);
		fruitList.add(cherry);
		Fruit mango = new Fruit("Mango", R.drawable.apple_pic);
		fruitList.add(mango);
	}

	public class FruitAdapter extends ArrayAdapter<Fruit> {
		private int resourceId;

		public FruitAdapter(Context context, int textViewResourceId,
				List<Fruit> objects) {
			super(context, textViewResourceId, objects);
			resourceId = textViewResourceId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Fruit fruit = getItem(position);
			View view;
			ViewHolder viewHolder;
			if (convertView == null) {
				view = LayoutInflater.from(getContext()).inflate(resourceId,
						null);
				viewHolder = new ViewHolder();
				viewHolder.fruitImage = (ImageView) view
						.findViewById(R.id.fruit_image);
				viewHolder.fruitName = (TextView) view
						.findViewById(R.id.fruit_name);
				view.setTag(viewHolder); // 将ViewHolder存储在View中
			} else {
				view = convertView;
				viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
			}
			viewHolder.fruitImage.setImageResource(fruit.getImageId());
			viewHolder.fruitName.setText(fruit.getName());
			return view;

		}

		class ViewHolder {
			ImageView fruitImage;
			TextView fruitName;
		}
	}
}
