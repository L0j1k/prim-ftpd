package org.primftpd;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import org.primftpd.prefs.LoadPrefsUtil;
import org.primftpd.util.ServicesStartStopUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartServerAndExitActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger logger = LoggerFactory.getLogger(getClass());
        Context context = getApplicationContext();

        SharedPreferences prefs = LoadPrefsUtil.getPrefs(context);
        PrefsBean prefsBean = LoadPrefsUtil.loadPrefs(logger, prefs);
        ServicesStartStopUtil.startServers(context, prefsBean, null);

        finish();
    }
}
