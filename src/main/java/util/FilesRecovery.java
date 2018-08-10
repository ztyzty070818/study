package util;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class FilesRecovery {
	public static void main(String[] args) throws Exception {
		List<String> result = runShell("ls -i -l /proc/121367/fd");
//		List<String> result = ShellUtil.runShell("ls -i -l /proc/31211/fd");

		for(String item : result) {
			if(item.contains("->")) {
//				System.out.println(item);

				String fileName = item.split(" -> ")[1];
//				System.out.println(fileName);

				String[] strs = fileName.split("/");
				String fileNameSimple =  strs[strs.length-1];
				String filePath = fileName.substring(0,fileName.indexOf(fileNameSimple));

				runShell("mkdir -p " + filePath);


				String[] strs2 = item.split(" -> ")[0].split(" ");
				String primary = strs2[strs2.length-1];

				runShell(String.format("cat %s > %s", primary, fileName));
//				System.out.println("------");
			}



		}



		System.out.println();


//		System.out.println(ShellUtil.runShell("ls /home"));
	}

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
