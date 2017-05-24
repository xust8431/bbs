package com.xust.bbs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class BBSImagePathUtil {

	public static String getImagePath(File file, String fileFileName, String fileContentType) {
		String dire = "bbs/picture/";
		return saveToFTP(file, fileFileName, dire);
	}
	
	public static String getIconPath(File file, String fileFileName, String fileContentType) {
		String dire = "bbs/icon/";
		return saveToFTP(file, fileFileName, dire);
	}

	private static String saveToFTP(File file, String fileFileName, String dire) {
		FTPClient ftpClient = new FTPClient(); 
		try { 
			ftpClient.connect("127.0.0.1", 2121); 
			ftpClient.login("Wuyk", "weixiao"); 
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			//设置上传目录 
			ftpClient.changeWorkingDirectory(dire);
			//设置文件的路径
			String prefix = fileFileName.substring(fileFileName.lastIndexOf(".") + 1);
			String path = BBSUtil.createId() + "." + prefix;
			
			FTPFile[] fs = ftpClient.listFiles();
			if (fs!=null && fs.length>0) {
				for(int i=0;i<fs.length;i++){
					if (fs[i].getName().equals(path)) {
						ftpClient.deleteFile(fs[i].getName());
						break;
					}
				}
			}
        
		    InputStream is = new FileInputStream(file);
		    OutputStream os = ftpClient.appendFileStream(path);
		    
		    byte[] buffer = new byte[1024];
		    int length = 0;
		    while(-1 != (length = is.read(buffer, 0, buffer.length)))
		    {
		        os.write(buffer);
		    }
		    os.flush();
		    os.close();
		    is.close();
			return "ftp://127.0.0.1:2121/" + dire + path;
		} catch(IOException e) {
			throw new RuntimeException(e);
		} finally {
			try { 
				ftpClient.disconnect(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		}
	}
}
