package codeware.moovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class MovieDetailsActivity extends AppCompatActivity {
	
	private HashMap<String, Object> mapvar = new HashMap<>();
	private String videoUrl = "";
	private String bannerUrl = "";
	private double index = 0;
	private String castItemUrl = "";
	
	private ArrayList<HashMap<String, Object>> data = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> castList = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear12;
	private TextView textview15;
	private TextView textview5;
	private TextView textview6;
	private HorizontalScrollView hscroll1;
	private TextView textview7;
	private TextView textview9;
	private TextView textview10;
	private TextView textview12;
	private TextView textview13;
	private TextView textview14;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ImageView imageview1;
	private LinearLayout linear8;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private ImageView imageview2;
	private TextView textview1;
	private ImageView imageview3;
	private TextView textview2;
	private ImageView imageview4;
	private TextView textview3;
	private ImageView imageview5;
	private TextView textview4;
	private LinearLayout linear13;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.movie_details);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview14 = (TextView) findViewById(R.id.textview14);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		getWindow().setStatusBarColor(Color.TRANSPARENT);
		hscroll1.setVerticalScrollBarEnabled(false);
		hscroll1.setHorizontalScrollBarEnabled(false);
		vscroll1.setVerticalScrollBarEnabled(false);
		vscroll1.setHorizontalScrollBarEnabled(false);
		mapvar = new Gson().fromJson(getIntent().getStringExtra("data"), new TypeToken<HashMap<String, Object>>(){}.getType());
		data.add(mapvar);
		_setUpVideoView();
		androidx.cardview.widget.CardView cardview1 = new androidx.cardview.widget.CardView(getApplicationContext());
		cardview1.setRadius(30);
		cardview1.setCardElevation(0);
		
		linear5.removeView(imageview1);
		
		cardview1.addView(imageview1);
		
		linear5.addView(cardview1);
		Glide.with(getApplicationContext()).load(Uri.parse(data.get((int)0).get("banner").toString())).into(imageview1);
		textview5.setText(data.get((int)0).get("description").toString());
		textview9.setText(data.get((int)0).get("awards").toString());
		textview15.setText(data.get((int)0).get("name").toString());
		textview12.setText(data.get((int)0).get("directors").toString());
		textview14.setText(data.get((int)0).get("writers").toString());
		castList = new Gson().fromJson(mapvar.get("cast").toString(), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		_addCastList();
		linear1.setPadding(0,0,0,-290);
		_shapeRadius(linear12, "#C52F25", 30);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _setUpVideoView () {
		View inflate = getLayoutInflater().inflate(R.layout.video_player_view, null);
		linear2.addView(inflate);
		final ImageView banner = inflate.findViewById(R.id.imageview2);
		bannerUrl = data.get((int)0).get("banner").toString();
		Glide.with(getApplicationContext()).load(bannerUrl).into(banner);
		final LinearLayout videoContainer = inflate.findViewById(R.id.linear2);
		final VideoView vidview = new VideoView(this);
		vidview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 750));
		videoContainer.addView(vidview);
		vidview.setScaleX(2);
		vidview.setScaleY(2);
		videoUrl = data.get((int)0).get("video").toString();
		vidview.setVideoURI(Uri.parse(videoUrl));
		vidview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				vidview.start();
				banner.setImageResource(R.drawable.shadow_bottom);
			} });
	}
	
	
	public void _addCastList () {
		index = 0;
		for(int _repeat12 = 0; _repeat12 < (int)(castList.size()); _repeat12++) {
			View inflate = getLayoutInflater().inflate(R.layout.cast_item, null);
			ImageView profile = inflate.findViewById(R.id.imageview1);
			castItemUrl = castList.get((int)index).get("profile").toString();
			Glide.with(getApplicationContext()).load(castItemUrl).into(profile);
			LinearLayout container = inflate.findViewById(R.id.linear2);
			androidx.cardview.widget.CardView cardview1 = new androidx.cardview.widget.CardView(getApplicationContext());
			cardview1.setRadius(180);
			cardview1.setCardElevation(0);
			
			container.removeView(profile);
			
			cardview1.addView(profile);
			
			container.addView(cardview1);
			linear13.addView(inflate);
			index++;
		}
	}
	
	
	public void _shapeRadius (final View _v, final String _color, final double _radius) {
		android.graphics.drawable.GradientDrawable shape = new android.graphics.drawable.GradientDrawable();
		  shape.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
		
		shape.setCornerRadius((int)_radius);
		
		shape.setColor(Color.parseColor(_color));
		_v.setBackgroundDrawable(shape);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}