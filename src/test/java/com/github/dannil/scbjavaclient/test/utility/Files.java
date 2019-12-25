package com.github.dannil.scbjavaclient.test.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Files {

	/**
	 * <p>
	 * Private constructor to prevent instantiation.
	 * </p>
	 */
	private Files() {

	}

	public static List<File> find(String path, String partOfFile) {
		List<File> allFiles = new ArrayList<File>();
		File dir = new File(path);
		if (!dir.exists()) {
			throw new IllegalArgumentException("Directory " + dir + " doesn't exist.");
		}
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.isDirectory()) {
				allFiles.addAll(find(file.getAbsolutePath(), partOfFile));
			} else {
				String partOfFileToRegex = ".*?" + partOfFile.replace("*", ".*?") + ".*?";
				if (file.getAbsolutePath().matches(partOfFileToRegex)) {
					allFiles.add(file);
				}
			}
		}
		return allFiles;
	}

	public static String fileToBinaryName(File file) {
		return fileToBinaryName(file, "");
	}

	public static String fileToBinaryName(File file, String cutoffSequence) {
		// Convert path into binary name
		String path = file.getAbsolutePath();
		path = path.replaceAll("\\.[^.]*$", "");
		if (cutoffSequence != null && !cutoffSequence.isEmpty()) {
			path = path.substring(path.indexOf(cutoffSequence));
		}

		// Handle both UNIX and Windows separators
		String binaryName = path.replaceAll("/|\\\\", ".");
		return binaryName;
	}

}
