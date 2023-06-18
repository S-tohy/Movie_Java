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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private HashMap<String, Object> mapvar = new HashMap<>();
	private String banner = "";
	private String title = "";
	private String year = "";
	private String description = "";
	private double index = 0;
	private String id = "";
	private double position = 0;
	
	private ArrayList<HashMap<String, Object>> movies = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> castList = new ArrayList<>();
	
	private LinearLayout linear8;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview2;
	private LinearLayout linear3;
	private TextView textview3;
	private HorizontalScrollView hscroll2;
	private TextView textview4;
	private HorizontalScrollView hscroll3;
	private TextView textview5;
	private LinearLayout linear7;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private LinearLayout linear5;
	private LinearLayout linear6;
	
	private RequestNetwork forInternetPermission;
	private RequestNetwork.RequestListener _forInternetPermission_request_listener;
	private Intent i = new Intent();
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview3 = (TextView) findViewById(R.id.textview3);
		hscroll2 = (HorizontalScrollView) findViewById(R.id.hscroll2);
		textview4 = (TextView) findViewById(R.id.textview4);
		hscroll3 = (HorizontalScrollView) findViewById(R.id.hscroll3);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		forInternetPermission = new RequestNetwork(this);
		
		_forInternetPermission_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		
		_addMovieData();
		_trendingNow();
		_popularMovies();
		_recommendedForYou();
		_movieOrginals();
		hscroll2.setVerticalScrollBarEnabled(false);
		hscroll2.setHorizontalScrollBarEnabled(false);
		hscroll3.setVerticalScrollBarEnabled(false);
		hscroll3.setHorizontalScrollBarEnabled(false);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _addMovieData () {
		mapvar = new HashMap<>();
		mapvar.put("name", "Fantastic Four");
		mapvar.put("year", "2015");
		mapvar.put("tag", "Action, Adventure, Sci-Fi");
		mapvar.put("banner", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTdi2yndXt7DQ_lwKajWhaSCDnwzYitIAoXXQ&usqp=CAU");
		mapvar.put("description", "Four young outsiders teleport to an alternate and dangerous universe which alters their physical form in shocking ways. The four must learn to harness their new abilities and work together to save Earth from a former friend turned enemy.");
		mapvar.put("video", "http://assets.ign.com/videos/zencoder/960/7d5caa287452f09b3d1819fe2189ae5c-1500000-1429489425-w.mp4");
		mapvar.put("awards", "8 wins & 4 nominations.");
		mapvar.put("directors", "Josh Trank , Stephen E. Rivkin");
		mapvar.put("writers", "Jeremy Slater (screenplay), Simon Kinberg (screenplay), Josh Trank (screenplay), Stan Lee (Marvel comic book), Jack Kirby (Marvel comic book)");
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTY2MzM2NzAxNF5BMl5BanBnXkFtZTgwMDIyMzg1NDE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMjExOTY3NzExM15BMl5BanBnXkFtZTgwOTg1OTAzMTE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMjE5MDY3OTE4MV5BMl5BanBnXkFtZTcwNTA0MDM5OQ@@._V1_UY264_CR75,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BZjgzMzc5MzMtNzQ4My00M2FlLTk4ZGUtNzM0ZTU2Yjc0ZGNlXkEyXkFqcGdeQXVyNjkwNzEwMzY@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		mapvar.put("cast", new Gson().toJson(castList));
		movies.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("name", "Avatar");
		mapvar.put("year", "2009");
		mapvar.put("tag", "Action, Adventure, Fantasy");
		mapvar.put("banner", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSjhs7WXHyhJ8sd98xYqjAzcMOOGoBh-NVZmQ&usqp=CAU");
		mapvar.put("description", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.");
		mapvar.put("video", "https://srv-store5.gofile.io/download/qBz488/Avatar%20_%20Official%20Trailer%20(HD)%20_%2020th%20Century%20FOX%20(%20720%20X%201280%20).mp4");
		mapvar.put("awards", "Won 3 Oscars.\nAnother 86 wins & 130 nominations.");
		mapvar.put("directors", "James Cameron");
		mapvar.put("writers", "James Cameron");
		castList.clear();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTc5NTMyMjIwMV5BMl5BanBnXkFtZTcwNTMyNjYwMw@@._V1_UY264_CR4,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTM2MjIwOTc0Nl5BMl5BanBnXkFtZTcwNzQ5ODM1Mw@@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTk1MTcyNTE3OV5BMl5BanBnXkFtZTcwMTA0MTMyMw@@._V1_UY264_CR9,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMjE4NzYwNTc5Nl5BMl5BanBnXkFtZTcwMzQzOTUyNw@@._V1_UY264_CR6,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		mapvar.put("cast", new Gson().toJson(castList));
		movies.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("name", "Avengers: Endgame");
		mapvar.put("year", "2019");
		mapvar.put("tag", "Action, Adventure, Drama");
		mapvar.put("banner", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTO0uHv5D0flmfRhRzj8fFwIHFjT3k3s2yZ1Q&usqp=CAU");
		mapvar.put("description", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.");
		mapvar.put("video", "https://srv-store3.gofile.io/download/JWw56e/Avengers_%20Endgame%20Trailer%20-%201%20(2019)%20_%20Movieclips%20Trailers%20(%20720%20X%201280%20).mp4");
		mapvar.put("awards", "Nominated for 1 Oscar.\nAnother 67 wins & 104 nominations.");
		mapvar.put("directors", "Anthony Russo , Joe Russo");
		mapvar.put("writers", "Christopher Markus (screenplay by), Stephen McFeely (screenplay by), Stan Lee (based on the Marvel comics by), Jack Kirby (based on the Marvel comics by), Joe Simon (Captain America created by), Jack Kirby (Captain America created by), Steve Englehart (Star-Lord created by), Steve Gan (Star-Lord created by), Bill Mantlo (Rocket Raccoon created by), Keith Giffen (Rocket Raccoon created by), Jim Starlin (Thanos, Gamora & Drax created by), Stan Lee (Groot created by), Larry Lieber (Groot created by), Jack Kirby (Groot created by), Steve Englehart (Mantis created by), Don Heck (Mantis created by)");
		castList.clear();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BNzg1MTUyNDYxOF5BMl5BanBnXkFtZTgwNTQ4MTE2MjE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMjExOTY3NzExM15BMl5BanBnXkFtZTgwOTg1OTAzMTE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTM3OTUwMDYwNl5BMl5BanBnXkFtZTcwNTUyNzc3Nw@@._V1_UY264_CR19,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BNWIzZTI1ODUtZTUzMC00NTdiLWFlOTYtZTg4MGZkYmU4YzNlXkEyXkFqcGdeQXVyNTExOTk5Nzg@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		mapvar.put("cast", new Gson().toJson(castList));
		movies.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("name", "Jurassic World: Fallen Kingdom");
		mapvar.put("year", "2018");
		mapvar.put("tag", "Action, Adventure, Sci-Fi");
		mapvar.put("banner", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYG2rnxZoEsAZtEjBgCWWpdLwVWXp5L17Uig&usqp=CAU");
		mapvar.put("description", "When the island's dormant volcano begins roaring to life, Owen and Claire mount a campaign to rescue the remaining dinosaurs from this extinction-level event.");
		mapvar.put("video", "https://srv-store3.gofile.io/download/JWw56e/Jurassic%20World_%20Fallen%20Kingdom%20-%20Official%20Trailer%20_HD_%20(%20720%20X%201280%20).mp4");
		mapvar.put("awards", "4 wins & 25 nominations.");
		mapvar.put("directors", "J.A. Bayona");
		mapvar.put("writers", "Derek Connolly, Colin Trevorrow, Michael Crichton (based on characters created by)");
		castList.clear();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BNzg3MTgwOTgzMV5BMl5BanBnXkFtZTgwODIxMTUwMjE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BODEzNzBhODYtOWEzNi00Y2I3LWFjMGEtNzAxNzU5ZjZiMDRiXkEyXkFqcGdeQXVyMjQ0MTg4Nw@@._V1_UY264_CR11,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BNzU3OTIzMzM1OF5BMl5BanBnXkFtZTcwMDc1MDkwOQ@@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTgwMzc5NzM1MV5BMl5BanBnXkFtZTYwMzA0ODk0._V1_UY264_CR3,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		mapvar.put("cast", new Gson().toJson(castList));
		movies.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("name", "The Amazing Spider-Man 2");
		mapvar.put("year", "2014");
		mapvar.put("tag", "Action, Adventure, Sci-Fi");
		mapvar.put("banner", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTD6Ms736o7BOMtLY3UFz0n5Sh3vJC3a8URiA&usqp=CAU");
		mapvar.put("description", "When New York is put under siege by Oscorp, it is up to Spider-Man to save the city he swore to protect as well as his loved ones.");
		mapvar.put("video", "https://srv-store3.gofile.io/download/JWw56e/THE%20AMAZING%20SPIDER-MAN%202%20-%20Official%20Trailer%20(HD)%20(%20720%20X%201280%20).mp4");
		mapvar.put("awards", "4 wins & 30 nominations.");
		mapvar.put("directors", "Marc Webb");
		mapvar.put("writers", "Alex Kurtzman (screenplay), Roberto Orci (screenplay), Jeff Pinkner (screenplay), Alex Kurtzman (screen story), Roberto Orci (screen story), Jeff Pinkner (screen story), James Vanderbilt (screen story), Stan Lee (Marvel comic book), Steve Ditko (Marvel comic book)");
		castList.clear();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMjE2MjI2OTk1OV5BMl5BanBnXkFtZTgwNTY1NzM4MDI@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMjI4NjM1NDkyN15BMl5BanBnXkFtZTgwODgyNTY1MjE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTkyNjY1NDg3NF5BMl5BanBnXkFtZTgwNjA2MTg0MzE@._V1_UY264_CR9,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTUzOTgwNjg0OV5BMl5BanBnXkFtZTgwNTgyMTA1NjE@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		mapvar.put("cast", new Gson().toJson(castList));
		movies.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("name", "The Dark Knight");
		mapvar.put("year", "2008");
		mapvar.put("tag", "Action, Crime, Drama");
		mapvar.put("banner", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTcJ4nmjnJZ2MyNeISmtAilLZNsDWfRwHNWdw&usqp=CAU");
		mapvar.put("description", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
		mapvar.put("video", "https://srv-store3.gofile.io/download/JWw56e/The%20Dark%20Knight%20(2008)%20Official%20Trailer%20-%201%20-%20Christopher%20Nolan%20Movie%20HD%20(%20544%20X%201280%20).mp4");
		mapvar.put("awards", "Won 2 Oscars.\nAnother 153 wins & 160 nominations.");
		mapvar.put("directors", "Christopher Nolan");
		mapvar.put("writers", "Jonathan Nolan (screenplay), Christopher Nolan (screenplay), Christopher Nolan (story), David S. Goyer (story), Bob Kane (characters)");
		castList.clear();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTkxMzk4MjQ4MF5BMl5BanBnXkFtZTcwMzExODQxOA@@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTI2NTY0NzA4MF5BMl5BanBnXkFtZTYwMjE1MDE0._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTc4MTAyNzMzNF5BMl5BanBnXkFtZTcwMzQ5MzQzMg@@._V1_UY264_CR4,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("profile", "https://m.media-amazon.com/images/M/MV5BMTM1MjY3NzA4NF5BMl5BanBnXkFtZTcwNzE4MjMyMw@@._V1_UX180_CR0,0,180,264_AL_.jpg");
			castList.add(_item);
		}
		
		mapvar.put("cast", new Gson().toJson(castList));
		movies.add(mapvar);
	}
	
	
	public void _trendingNow () {
		index = 0;
		for(int _repeat10 = 0; _repeat10 < (int)(movies.size()); _repeat10++) {
			View inflate = getLayoutInflater().inflate(R.layout.movie_horizontal, null);
			banner = movies.get((int)index).get("banner").toString();
			id = String.valueOf((long)(index));
			inflate.setTag(id);
			ImageView imageview1 = inflate.findViewById(R.id.imageview1);
			LinearLayout container = inflate.findViewById(R.id.linear1);
			Glide.with(getApplicationContext()).load(banner).into(imageview1);
			androidx.cardview.widget.CardView cardview1 = new androidx.cardview.widget.CardView(MainActivity.this);
			cardview1.setRadius(30);
			cardview1.setCardElevation(0);
			
			container.removeView(imageview1);
			
			cardview1.addView(imageview1);
			
			container.addView(cardview1);
			inflate.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					id = _view.getTag().toString();
					mapvar = movies.get((int)Double.parseDouble(id));
					i.setClass(getApplicationContext(), MovieDetailsActivity.class);
					i.putExtra("data", new Gson().toJson(mapvar));
					startActivity(i);
					 }});
			linear5.addView(inflate);
			index++;
		}
	}
	
	
	public void _popularMovies () {
		index = movies.size() - 1;
		for(int _repeat10 = 0; _repeat10 < (int)(movies.size()); _repeat10++) {
			View inflate = getLayoutInflater().inflate(R.layout.movie_horizontal, null);
			banner = movies.get((int)index).get("banner").toString();
			id = String.valueOf((long)(index));
			inflate.setTag(id);
			ImageView imageview1 = inflate.findViewById(R.id.imageview1);
			LinearLayout container = inflate.findViewById(R.id.linear1);
			Glide.with(getApplicationContext()).load(banner).into(imageview1);
			androidx.cardview.widget.CardView cardview1 = new androidx.cardview.widget.CardView(MainActivity.this);
			cardview1.setRadius(30);
			cardview1.setCardElevation(0);
			
			container.removeView(imageview1);
			
			cardview1.addView(imageview1);
			
			container.addView(cardview1);
			inflate.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					id = _view.getTag().toString();
					mapvar = movies.get((int)Double.parseDouble(id));
					i.setClass(getApplicationContext(), MovieDetailsActivity.class);
					i.putExtra("data", new Gson().toJson(mapvar));
					startActivity(i);
					 }});
			linear6.addView(inflate);
			index--;
		}
	}
	
	
	public void _recommendedForYou () {
		index = 0;
		for(int _repeat10 = 0; _repeat10 < (int)(movies.size()); _repeat10++) {
			View inflate = getLayoutInflater().inflate(R.layout.recommended_item, null);
			id = String.valueOf((long)(index));
			inflate.setTag(id);
			inflate.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					id = _view.getTag().toString();
					mapvar = movies.get((int)Double.parseDouble(id));
					i.setClass(getApplicationContext(), MovieDetailsActivity.class);
					i.putExtra("data", new Gson().toJson(mapvar));
					startActivity(i);
					 }});
			banner = movies.get((int)index).get("banner").toString();
			ImageView imageview1 = inflate.findViewById(R.id.imageview1);
			TextView txtTitle = inflate.findViewById(R.id.textview1);
			TextView txtYear = inflate.findViewById(R.id.textview2);
			TextView txtDescription = inflate.findViewById(R.id.textview3);
			title = movies.get((int)index).get("name").toString();
			txtTitle.setText(title);
			year = movies.get((int)index).get("year").toString();
			txtYear.setText(year);
			description = movies.get((int)index).get("description").toString();
			txtDescription.setText(description);
			txtDescription.setMaxLines(3);
			txtDescription.setEllipsize(TextUtils.TruncateAt.END);
			Glide.with(getApplicationContext()).load(banner).into(imageview1);
			LinearLayout container = inflate.findViewById(R.id.linear2);
			androidx.cardview.widget.CardView cardview1 = new androidx.cardview.widget.CardView(MainActivity.this);
			cardview1.setRadius(30);
			cardview1.setCardElevation(0);
			
			container.removeView(imageview1);
			
			cardview1.addView(imageview1);
			
			container.addView(cardview1);
			linear7.addView(inflate);
			index++;
		}
	}
	
	
	public void _viewPagerAdapter () {
	}
	private class MooviePagerAdapter extends androidx.viewpager.widget.PagerAdapter {
		public int getCount() {
			return movies.size();
		}
		public Object instantiateItem(View collection, final int position) {
			View inflate = getLayoutInflater().inflate(R.layout.pager_movie_item, null);
			((androidx.viewpager.widget.ViewPager)collection).addView(inflate, 0);
			ImageView imgBanner = inflate.findViewById(R.id.imageview1);
			LinearLayout container = inflate.findViewById(R.id.linear2);
			TextView textview1 = inflate.findViewById(R.id.textview1);
			String title = movies.get(position).get("name").toString();
			String year = movies.get(position).get("year").toString();
			textview1.setText(title +"\n"+year);
			String bannerUrl = movies.get(position).get("banner").toString();
			Glide.with(imgBanner.getContext()).load(bannerUrl).into(imgBanner);
			androidx.cardview.widget.CardView cardview1 = new androidx.cardview.widget.CardView(MainActivity.this);
			cardview1.setRadius(30);
			cardview1.setCardElevation(0);
			
			container.removeView(imgBanner);
			
			cardview1.addView(imgBanner);
			
			container.addView(cardview1);
			inflate.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					MainActivity.this.position = position;
					mapvar = movies.get((int)position);
					i.setClass(getApplicationContext(), MovieDetailsActivity.class);
					i.putExtra("data", new Gson().toJson(mapvar));
					startActivity(i);
					 }});
			return inflate;
		}
		 @Override
		public void destroyItem(View arg0, int arg1, Object arg2) { ((androidx.viewpager.widget.ViewPager) arg0).removeView((View) arg2);
		}
		 @Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);
		}
	}
	{
	}
	
	
	public void _movieOrginals () {
		final androidx.viewpager.widget.ViewPager viewPager1 = new androidx.viewpager.widget.ViewPager(this);
		viewPager1.setAdapter(new MooviePagerAdapter());
		viewPager1.setCurrentItem(0);
		linear3.addView(viewPager1);
		androidx.core.widget.NestedScrollView scrollView = new androidx.core.widget.NestedScrollView(MainActivity.this);
		scrollView.setFillViewport (true);  
		scrollView.setVerticalScrollBarEnabled(false);
		scrollView.setHorizontalScrollBarEnabled(false);
		linear8.removeView(linear1);
		scrollView.addView(linear1);
		linear8.addView(scrollView);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if(viewPager1.getCurrentItem() == (movies.size()-1)){
							viewPager1.setCurrentItem(0, true);
						}else{
							viewPager1.setCurrentItem((viewPager1.getCurrentItem()+1), true);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(3000), (int)(3000));
	}
	
	
	public void _library () {
	}
	private com.bumptech.glide.RequestManager initGlide(){
		return Glide.with(getApplicationContext());
	}
	{
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