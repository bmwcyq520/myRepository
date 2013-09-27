package com.android.hello;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button button;
	int K = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) this.findViewById(R.id.tv);
		tv.setText(Html.fromHtml("aaa <font color=red>nihao</font> bbb"));
		
		button = (Button) this.findViewById(R.id.button);
		this.button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "kkk", Toast.LENGTH_LONG);
				
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("smsto:110"));
				intent.putExtra("sms_body", "hello");
				startActivity(intent);	
				startActivityForResult(intent, K);
			}
		});
		
//		this.bindService(service, conn, flags)
//		unbindService(conn)
//		startService(service)
//		stopService(name)
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
