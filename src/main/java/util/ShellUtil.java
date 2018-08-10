package util;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ShellUtil {
	public static List<String> runShell(String shStr) throws Exception {
		List<String> result = Lists.newArrayList();

		Process process;
		process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr});
		process.waitFor();
		BufferedReader read = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = null;
		while ((line = read.readLine())!=null){
			result.add(line);
		}
		return result;
	}
}
