/*
Copyright (C) 2013 Johan Ceuppens

This program is free software; you can redistribute it and/or modify it unde    r the terms of the GNU General Public License as published by the Free Softw    are Foundation; either version 2 of the License, or (at your option) any lat    er version.

This program is distributed in the hope that it will be useful, but WITHOUT     ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNES    S FOR A PARTICULAR PURPOSE. See the GNU General Public License for more deta    ils.

You should have received a copy of the GNU General Public License along with     this program; if not, write to the Free Software Foundation, Inc., 59 Templ    e Place, Suite 330, Boston, MA 02111-1307 USA
*/
package com.example.game;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.view.Menu;
import android.widget.Gallery;

public class MainActivity extends Activity {

	Integer[] imageIDs = {
		R.drawable.heatman,
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        Gallery gallery = (Gallery) findViewById(R.id.game1);
        
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener()
        {
        	public void onItemClick(AdapterView parent, View v,
        			int position, long id)
        	{
        		Toast.makeText(getBaseContext(),
        				"heatman" + (position +  1) + "selected",
        				Toast.LENGTH_SHORT).show();
        		
        		///NOTE
        		ImageView imageView = (ImageView) findViewById(R.id.image1);
        		imageView.setImageResource(imageIDs[position]);
        	}
        });    
    
    }
    
    public class ImageAdapter extends BaseAdapter
    {
    	Context context;
    	int itemBackground;
    	
    	public ImageAdapter(Context c)
    	{
    		context = c;
    		TypedArray a = obtainStyledAttributes(R.styleable.Game1);
    		itemBackground = a.getResourceId(R.styleable.Game1_android_galleryItemBackground, 0);
    		a.recycle();
    	}
    	
    	public int getCount() {
    		return imageIDs.length;
    	}
    	
    	public Object getItem(int position) {
    		return position;
    	}
    	
    	public long getItemId(int position) {
    		return position;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
    		ImageView imageView;
    		if (convertView == null) {
    			imageView = new ImageView(context);
    			imageView.setImageResource(imageIDs[position]);
    			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    			imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
    		} else {
    			imageView = (ImageView) convertView;
    		}
    		imageView.setBackgroundResource(itemBackground);
    		return imageView;
    	}
    }
}
 /*   	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}*/
