/**
 * HTTPS tester.
 */

package kit.https;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;


/**
 * http://en.wikipedia.org/wiki/Ackerman_function
 */
public class HttpsTester {
	public static void main(String[] argv) {
		if (argv.length < 2) {
			System.err.println("Missing URL");
			return;
		}

		String spec = argv[1];
		try {
			SSLSocketFactory sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
			URL url = new URL(spec);
			System.out.println("Connecting to " + url.toString() + "...");
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			connection.setSSLSocketFactory(sslSocketFactory);
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String string = null;
			while ((string = br.readLine()) != null) {
			    System.out.println(string);
			}

			br.close();
			isr.close();
			is.close();
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
