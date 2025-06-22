package Telegram.Speed.Hook;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView info;
	private TextView speed;
	private TextView textview2;
	private TextView textview5;
	private TextView textview4;
	private LinearLayout linear2;
	private TextView textview6;
	private LinearLayout cleanerRoyall;
	private TextView github;
	private TextView dev;
	private ImageView imageview1;
	private LinearLayout linear8;
	private TextView textview13;
	private TextView textview12;
	private LinearLayout linear10;
	private TextView cgithub;
	private TextView download;
	
	private android.content.Context cntx;
	private AlertDialog.Builder developer;
	private SharedPreferences sett;
	private AlertDialog.Builder first;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		info = findViewById(R.id.info);
		speed = findViewById(R.id.speed);
		textview2 = findViewById(R.id.textview2);
		textview5 = findViewById(R.id.textview5);
		textview4 = findViewById(R.id.textview4);
		linear2 = findViewById(R.id.linear2);
		textview6 = findViewById(R.id.textview6);
		cleanerRoyall = findViewById(R.id.cleanerRoyall);
		github = findViewById(R.id.github);
		dev = findViewById(R.id.dev);
		imageview1 = findViewById(R.id.imageview1);
		linear8 = findViewById(R.id.linear8);
		textview13 = findViewById(R.id.textview13);
		textview12 = findViewById(R.id.textview12);
		linear10 = findViewById(R.id.linear10);
		cgithub = findViewById(R.id.cgithub);
		download = findViewById(R.id.download);
		developer = new AlertDialog.Builder(this);
		sett = getSharedPreferences("sett", Activity.MODE_PRIVATE);
		first = new AlertDialog.Builder(this);
		
		github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent gt = new Intent(Intent.ACTION_VIEW);
				gt.setData(Uri.parse("https://github.com/araafroyall/Telegram-Speed-Hook"));
				startActivity(gt);
			}
		});
		
		dev.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				developer.setTitle("𝗗𝗲𝘃𝗲𝗹𝗼𝗽𝗲𝗿 𝗗𝗲𝘁𝗮𝗶𝗹𝘀");
				developer.setView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.dev, null));
				developer.setIcon(R.drawable.dev);
				final AlertDialog developerdeveloper = developer.create();
				developerdeveloper.show();
				try {
					developerdeveloper.getWindow().setGravity(Gravity.BOTTOM);
					developerdeveloper.getWindow().getDecorView().setBackgroundDrawable(new GradientDrawable(){
						    {
							        setShape(GradientDrawable.RECTANGLE);
							        setColor(0xFFE8F5E9);
							        setCornerRadii(new float[]{(int)120,(int)120,(int)120,(int)120,(int)50,(int)50,(int)50,(int)50});
							    }
					});
				} catch (Exception e) {
					 
				}
				try {
					{
						android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
						int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
						SketchUi.setColor(0xFFFFCDD2);
						SketchUi.setCornerRadius(d*360);
						((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.close)).setElevation(d*6);
						android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE1BEE7}), SketchUi, null);
						((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.close)).setBackground(SketchUi_RD);
						((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.close)).setClickable(true);
					}
				} catch (Exception e) {
					 
				}
				try {
					((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							try { if (developerdeveloper != null && developerdeveloper.isShowing()) developerdeveloper.dismiss(); } catch (Exception ignored) {}
						}
					});
				} catch (Exception e) {
					 
				}
				try {
					((TextView) developerdeveloper.getWindow().getDecorView().findViewById(R.id.info)).setTextIsSelectable(true);
				} catch (Exception e) {
					 
				}
			}
		});
		
		cgithub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent repo = new Intent(Intent.ACTION_VIEW);
				repo.setData(Uri.parse("https://github.com/araafroyall/Cleaner-Royall"));
				startActivity(repo);
			}
		});
		
		download.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent down = new Intent(Intent.ACTION_VIEW);
				down.setData(Uri.parse("https://github.com/araafroyall/Cleaner-Royall/releases/download/Latest/CleanerRoyall.apk"));
				startActivity(down);
			}
		});
	}
	
	private void initializeLogic() {
		cntx = this;
	}
	
	@Override
	protected void onPostCreate(Bundle _savedInstanceState) {
		super.onPostCreate(_savedInstanceState);
		_color();
		String NECheck = sett.getString("open", "");
		if (NECheck == null || NECheck.isEmpty()) {
			 _FirstOpen();
		}
		else {
			  
		}
	}
	public void _color() {
		info.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFE8F5E9));
		cleanerRoyall.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFE0F2F1));
		SketchwareUtil.ViewIcon(dev, (Activity)cntx, R.drawable.dev, 15, 0xFFDCEDC8, "40");
		SketchwareUtil.ViewIcon(download, (Activity)cntx, R.drawable.download, 15, 0xFF80CBC4, "32");
		SketchwareUtil.ViewIcon(github, (Activity)cntx, R.drawable.github, 15, 0xFFE0E0E0, "40");
		SketchwareUtil.ViewIcon(cgithub, (Activity)cntx, R.drawable.github, 15, 0xFFE0E0E0, "32");
	}
	
	
	public void _FirstOpen() {
		developer.setTitle("𝐓𝐞𝐥𝐞𝐠𝐫𝐚𝐦 𝐒𝐩𝐞𝐞𝐝 𝐇𝐨𝐨𝐤");
		developer.setView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.entry, null));
		developer.setIcon(R.drawable.tele);
		final AlertDialog developerdeveloper = developer.create();
		developerdeveloper.show();
		try {
			developerdeveloper.getWindow().setGravity(Gravity.BOTTOM);
			developerdeveloper.getWindow().getDecorView().setBackgroundDrawable(new GradientDrawable(){
				    {
					        setShape(GradientDrawable.RECTANGLE);
					        setColor(0xFFF1F8E9);
					        setCornerRadii(new float[]{(int)120,(int)120,(int)120,(int)120,(int)50,(int)50,(int)50,(int)50});
					    }
			});
		} catch (Exception e) {
			 
		}
		try {
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFF81C784);
				SketchUi.setCornerRadius(d*360);
				((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.next)).setElevation(d*6);
				android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE1BEE7}), SketchUi, null);
				((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.next)).setBackground(SketchUi_RD);
				((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.next)).setClickable(true);
			}
		} catch (Exception e) {
			 
		}
		try {
			((Button) developerdeveloper.getWindow().getDecorView().findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sett.edit().putString("open", "1").commit();
					try { if (developerdeveloper != null && developerdeveloper.isShowing()) developerdeveloper.dismiss(); } catch (Exception ignored) {}
					SketchwareUtil.showMessage(getApplicationContext(), "Welcome to Telegram Speed Hook");
				}
			});
		} catch (Exception e) {
			 
		}
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