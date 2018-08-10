package jdk.classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiskClassLoader extends ClassLoader {
	private String classPath;
	public DiskClassLoader(String classPath) {
		this.classPath = classPath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File file = new File(classPath, fileName);

		try(FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			int len = 0;
			while((len = fis.read()) != -1) {
				bos.write(len);
			}
			byte[] data = bos.toByteArray();
			return defineClass(name, data, 0, data.length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.findClass(name);
	}

	private String getFileName(String name) {
		int index = name.lastIndexOf('.');
		if(index == -1) {
			return name + ".class";
		} else {
			return name.substring(index + 1) + ".class";
		}
	}

	public static void main(String[] args) {
		DiskClassLoader diskClassLoader = new DiskClassLoader("/home/qwe/test");
		try {
			Class clazz = diskClassLoader.loadClass("test.Test");
			if(clazz != null) {
				try {
					Object object = clazz.newInstance();
					Method method = clazz.getMethod("say", null);
					method.invoke(object, null);
				} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
