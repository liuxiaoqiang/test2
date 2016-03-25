package Ynzc.Util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetID {
	String IPCONFIG_COMMAND_WIN = "ipconfig    /all";

	boolean realMac = true;

	String unique = "";

	public static String getMacAddress() {

		NetID hwid = new NetID();

		return hwid.getUnique().trim();

	}

	private String getUnique() {

		String os = System.getProperty("os.name");
		if (os.startsWith("Windows")) {
			return getUniqueWindows();
		} else {
			return "";
		}

	}

	private String getUniqueWindows() {
		String ipConfigResponse = null;
		try {
			ipConfigResponse = runConsoleCommand(IPCONFIG_COMMAND_WIN);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		StringTokenizer tokenizer = new StringTokenizer(ipConfigResponse, "\n");
		while (tokenizer.hasMoreTokens()) {
			String line = tokenizer.nextToken().trim();
			int macAddressPosition = line.indexOf(":");
			if (macAddressPosition <= 0) {
				continue;
			}
			String macAddressCandidate = line.substring(macAddressPosition + 1).trim();
			if (isMacAddWin(macAddressCandidate)) {
				if (realMac == true) {
					generateUnique(macAddressCandidate);
				}
				else {
					realMac = true;
				}
			}
		}
		return unique;
	}

	private String runConsoleCommand(String command) throws IOException {

		Process p = Runtime.getRuntime().exec(command);

		InputStream stdoutStream = new BufferedInputStream(p.getInputStream());

		StringBuffer buffer = new StringBuffer();

		while (true) {

			int c = stdoutStream.read();

			if (c == -1) {

				break;

			}

			buffer.append((char) c);

		}

		String outputText = buffer.toString();

		stdoutStream.close();

		return outputText;

	}

	private boolean isMacAddWin(String macAddressCandidate) {

		Pattern macPattern = Pattern
				.compile("[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}");

		Matcher m = macPattern.matcher(macAddressCandidate);

		return m.matches();

	}

	private boolean isMacAddOSX(String macAddressCandidate) {

		if (macAddressCandidate.length() != 17) {
			return false;
		}
		else {
			return true;
		}

	}

	private void generateUnique(String macAddress) {

		if (unique == "") {
			unique += macAddress;
		}

		else {
			unique += "#";
			unique += macAddress;
		}
	}

}
