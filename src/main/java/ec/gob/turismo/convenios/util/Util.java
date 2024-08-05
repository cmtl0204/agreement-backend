package ec.gob.turismo.convenios.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Objects;


public class Util {

	public static boolean isWindows(){
		String OS = System.getProperty("os.name").toLowerCase();
		return OS.contains("win");
	}

	public static File convertToFile(MultipartFile multipartFile) throws Exception {
		File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(multipartFile.getBytes());
		outputStream.close();
		return file;
	}
	
	public static void createFolderIfNotExists(String dirName) throws SecurityException {
		File theDir = new File(dirName);
        if (((!theDir.isDirectory()) || (!theDir.exists()) || (!theDir.canRead()))) {
           boolean result = theDir.mkdir();
        }
	}
	
	public static String slugify(String input) {
		if (input == null || input.isEmpty()) return "";
		String toReturn = normalize(input);
		toReturn = toReturn.replace(" ", "_");
		toReturn = toReturn.toLowerCase();
        toReturn = URLEncoder.encode(toReturn, StandardCharsets.UTF_8);
        return toReturn;
	}
	
	public static String extension(String fileName) {
		String extension="";
		if (fileName != null && fileName.contains("."))
			extension = fileName.substring(fileName.lastIndexOf(".")+1);
		return extension;
	}
	
	public static void copyFile(File source, File destination) throws Exception {
		FileUtils.copyFile(source, destination);
	}
	
	private static String normalize(String input) {
		if (input == null || input.isEmpty()) return "";
		return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]","");
	}


}
