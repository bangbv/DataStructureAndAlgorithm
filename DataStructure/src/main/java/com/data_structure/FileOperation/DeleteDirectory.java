package com.data_structure.FileOperation;

import java.io.File;

public class DeleteDirectory {

	public static void main(String[] args) {
		DeleteDirectory d = new DeleteDirectory();
		File file = new File("/Users/bvbang/Documents/Game/test");
		d.deleteDirectory(file);

	}
	
	public void deleteDirectory(File file) {
		if(file.isDirectory()) {
			for (File temp : file.listFiles()) {
				if(temp.isDirectory()) {
					deleteDirectory(temp);
				}else {
					temp.delete();
				}
			}
		}
		file.delete();
	}

}
