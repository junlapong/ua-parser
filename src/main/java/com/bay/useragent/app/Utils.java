package com.bay.useragent.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.util.IOUtils;

public class Utils {

	    public static void main(String[] args) throws Exception {
	        IOCopier.joinFiles(new File("D:/file_log/master_log.log")
	        		, new File[] { 
    				new File("D:/file_log/1.log") 
//	        		, new File("D:/file_log/1_2.log")
//	        		, new File("D:/file_log/2.log")
//	        		, new File("D:/file_log/2_2.log")
//	        		, new File("D:/file_log/3.log")
//	        		, new File("D:/file_log/3_2.log")
//	        		, new File("D:/file_log/4.log")
//	        		, new File("D:/file_log/4_2.log")
//	        		, new File("D:/file_log/5.log")
//	        		, new File("D:/file_log/5_2.log")
//	        		, new File("D:/file_log/6.log")
//	        		, new File("D:/file_log/6_2.log")
//	        		, new File("D:/file_log/7.log")
//	        		, new File("D:/file_log/7_2.log")
//	        		, new File("D:/file_log/8.log")
//	        		, new File("D:/file_log/8_2.log")
//	        		, new File("D:/file_log/9.log")
//	        		, new File("D:/file_log/9_2.log")
//	        		, new File("D:/file_log/10.log")
//	        		, new File("D:/file_log/10_2.log")
//	        		, new File("D:/file_log/11.log")
//	        		, new File("D:/file_log/11_2.log")
//	        		, new File("D:/file_log/12.log")
//	        		, new File("D:/file_log/12_2.log")
//	        		, new File("D:/file_log/13.log")
//	        		, new File("D:/file_log/13_2.log")
//	        		, new File("D:/file_log/14.log")
//	        		, new File("D:/file_log/14_2.log")
//	        		, new File("D:/file_log/15.log")
//	        		, new File("D:/file_log/15_2.log")
//	        		, new File("D:/file_log/16.log")
	        		, new File("D:/file_log/16_2.log")});
	    }
	}

	class IOCopier {
	    public static void joinFiles(File destination, File[] sources)
	            throws IOException {
	        OutputStream output = null;
	        try {
	            output = createAppendableStream(destination);
	            for (File source : sources) {
	                appendFile(output, source);
	            }
	        } finally {
	            IOUtils.closeQuietly(output);
	        }
	    }

	    private static BufferedOutputStream createAppendableStream(File destination)
	            throws FileNotFoundException {
	        return new BufferedOutputStream(new FileOutputStream(destination, true));
	    }

	    private static void appendFile(OutputStream output, File source)
	            throws IOException {
	        InputStream input = null;
	        try {
	            input = new BufferedInputStream(new FileInputStream(source));
	            IOUtils.copy(input, output);
	        } finally {
	            IOUtils.closeQuietly(input);
	        }
	    }
	}
