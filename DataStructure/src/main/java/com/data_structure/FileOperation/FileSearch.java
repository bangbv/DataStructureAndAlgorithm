package com.data_structure.FileOperation;

import java.io.File;

public class FileSearch {

	public static void main(String[] args) {
		FileSearch f = new FileSearch();
		f.bangFile();
	}

	public void bangFile() {
		String name = "bang.txt";
		String directory = "/Users/bvbang/Documents/Game";
		File file = new File(directory);
		System.out.println(search(file,name));
	}
	
	private String search(File file,String name) {
		if(file.isDirectory()) {
			if(file.canRead()) {
				for (File temp : file.listFiles()) {
					if(temp.isDirectory()) {
						return search(temp,name);
					}else {
						String tempName = temp.getName().toLowerCase();
						if(tempName.equalsIgnoreCase(name)) {
							return temp.getAbsolutePath().toString();
						}
					}
				}
			}
		}
		return null;
	}
}
