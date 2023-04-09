package org.happysanta.gd;

import static org.acra.ReportField.*;

import android.app.Application;

import org.acra.*;
import org.acra.annotation.*;

@ReportsCrashes(
		formKey = "",
		formUri = "http://gdtr.net/report.php",
		customReportContent = {APP_VERSION_NAME, APP_VERSION_CODE, ANDROID_VERSION, PHONE_MODEL, PRODUCT, DISPLAY, STACK_TRACE, LOGCAT, USER_CRASH_DATE, INSTALLATION_ID, CUSTOM_DATA}
)
public class GDApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		if (Global.ACRA_ENABLED) {
			ACRA.init(this);
		}
	}

}