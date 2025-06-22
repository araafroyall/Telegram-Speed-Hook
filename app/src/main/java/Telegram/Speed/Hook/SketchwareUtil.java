package Telegram.Speed.Hook;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;


public class SketchwareUtil {

    public static void showMessage(Context _context, String _s) {
        Toast.makeText(_context, _s, Toast.LENGTH_SHORT).show();
    }


    public static void Dialog(Activity a, String title, String msg) {
    new AlertDialog.Builder(a)
        .setTitle(title).setMessage(msg)
        .setIcon(title.equals("𝗜𝗻𝗳𝗼𝗿𝗺𝗮𝘁𝗶𝗼𝗻") ? R.drawable.info :
                 title.equals("𝗦𝘂𝗰𝗲𝘀𝘀") ? R.drawable.check :
                 title.equals("𝗘𝗿𝗿𝗼𝗿") ? R.drawable.error : android.R.drawable.ic_dialog_alert)
        .setPositiveButton("OK", (d, w) -> {}).show();
    }
    

    private static int getValidColor(String colorCode) {
        try { return colorCode.startsWith("#") && (colorCode.length() == 7 || colorCode.length() == 9) ? Color.parseColor(colorCode) : 0xFFE8F5E9; }
        catch (Exception e) { return 0xFFE8F5E9; }
    }

    private static int getValidRadius(String radiusString) {
        try { return Integer.parseInt(radiusString); }
        catch (Exception e) { return 15; }
    }
    
    
    public static void showCustomDialog(Activity a, String t, String m, int i, boolean c, Runnable ok) {
     new AlertDialog.Builder(a).setTitle(t).setMessage(m).setIcon(i).setCancelable(c)
        .setPositiveButton("OK", (d, w) -> { if (ok != null) ok.run(); }).show();
    }
    
    public static void displayDialog(Activity a, String t, String m, int i, boolean c, Runnable ok, Runnable cancel) {
     new AlertDialog.Builder(a).setTitle(t).setMessage(m).setIcon(i).setCancelable(c)
        .setPositiveButton("OK", (d, w) -> { if (ok != null) ok.run(); })
        .setNegativeButton("Cancel", (d, w) -> { if (cancel != null) cancel.run(); }).show();
    }
    
    
    public static void ViewIcon(TextView view, Context context, int iconResId, int radius, int color, String size) {
     try {
        Drawable original = context.getResources().getDrawable(iconResId);
        Bitmap bitmap = ((BitmapDrawable) original).getBitmap();
        Bitmap scaled;
        if (size == null || size.trim().isEmpty()) {
            scaled = bitmap;
        } else {
            int px = Integer.parseInt(size.trim());
            scaled = Bitmap.createScaledBitmap(bitmap, px, px, true);
        }
        Drawable resized = new BitmapDrawable(context.getResources(), scaled);
        view.setCompoundDrawablesWithIntrinsicBounds(resized, null, null, null);
        view.setBackground(new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
                this.setCornerRadius(a);
                this.setColor(b);
                return this;
            }
        }.getIns(radius, color));
     } catch (Exception e) {
     }
    }
    
    
    
}
