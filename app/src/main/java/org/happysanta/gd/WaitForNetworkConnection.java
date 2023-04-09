package org.happysanta.gd;

import static org.happysanta.gd.Helpers.isOnline;
import static org.happysanta.gd.Helpers.logDebug;

import android.os.AsyncTask;

public class WaitForNetworkConnection extends AsyncTask<Object, Void, Void> {

	protected Runnable callback;

	@Override
	public Void doInBackground(Object... params) {
		callback = (Runnable) params[1];

		while (!isOnline()) {
			logDebug("Waiting for network...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}

		return null;
	}

	@Override
	public void onPostExecute(Void v) {
		logDebug("Network OK, callback.run() now...");
		callback.run();
	}

}
