package Telegram.Speed.Hook;

import android.app.Activity;
import android.app.AndroidAppHelper;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    private final static long DEFAULT_MAX_FILE_SIZE = 1024L * 1024L * 2000L;
    private static long speedUpShown = 0;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        
        if ("org.telegram.messenger".equals(loadPackageParam.packageName)) {
            try {
                XposedHelpers.findAndHookMethod("org.telegram.messenger.FileLoadOperation", loadPackageParam.classLoader, "updateParams", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        
                        int downloadChunkSizeBig = 1024 * 1024;
                        int maxDownloadRequests = 12;
                        int maxDownloadRequestsBig = 12;

                        var maxCdnParts = (int) (DEFAULT_MAX_FILE_SIZE / downloadChunkSizeBig);
                        XposedHelpers.setIntField(param.thisObject, "downloadChunkSizeBig", downloadChunkSizeBig);
                        XposedHelpers.setObjectField(param.thisObject, "maxDownloadRequests", maxDownloadRequests);
                        XposedHelpers.setObjectField(param.thisObject, "maxDownloadRequestsBig", maxDownloadRequestsBig);
                        XposedHelpers.setObjectField(param.thisObject, "maxCdnParts", maxCdnParts);

                        try {
                            var fileSize = XposedHelpers.getLongField(param.thisObject, "totalBytesCount");
                            if (fileSize > 15 * 1024 * 1024 && System.currentTimeMillis() - speedUpShown > 1000 * 60 * 5) {
                                speedUpShown = System.currentTimeMillis();
                                var title = "Speed Boost Activated";
                                var subtitle = "Extreme Speed Mode Enabled by AraafRoyall";
                                try {
                                    var notificationCenterClass = XposedHelpers.findClass("org.telegram.messenger.NotificationCenter", loadPackageParam.classLoader);
                                    var globalInstance = XposedHelpers.callStaticMethod(notificationCenterClass, "getGlobalInstance");
                                    new Handler(Looper.getMainLooper()).post(() -> XposedHelpers.callMethod(
                                            globalInstance,
                                            "postNotificationName",
                                            XposedHelpers.getStaticIntField(notificationCenterClass, "showBulletin"),
                                            new Object[]{4, title, subtitle}));
                                } catch (Throwable t) {
                                    XposedBridge.log(t);
                                    Toast.makeText(AndroidAppHelper.currentApplication(), title + "\n" + subtitle, Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (Throwable t) {
                            XposedBridge.log(t);
                        }
                    }
                });
            } catch (Throwable t) {
                XposedBridge.log(t);
                XposedHelpers.findAndHookMethod(Activity.class, "onResume", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        Toast.makeText((Activity) param.thisObject, "TeleSpeed: Unsupported Feature", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}