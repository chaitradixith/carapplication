package com.naveen;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/CarForm.do")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
 
   
    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	 /**
         * Name of the directory where uploaded files will be saved, relative to
         * the web application directory.
         */

//    String SAVE_DIR = "uploadfiles";
         
    	
    	// on amazon 
    	String SAVE_DIR = "upload";
    	
    	// getting fields like name, contact, vehicle number 
    	
    

    	// for name 
    	Part namePart  = request.getPart("name"); 
    	Scanner scanner = new Scanner(namePart.getInputStream());
    	String name = scanner.nextLine(); 

    	
    	
    	// for contact 
    	
    	Part contactPart  = request.getPart("contact"); 
    	 scanner = new Scanner(contactPart.getInputStream());
    	String contact = scanner.nextLine(); 

    	// for vehicle number 
    	
    	Part vehiclePart  = request.getPart("vehno"); 
    	 scanner = new Scanner(vehiclePart.getInputStream());
    	String vehicleNumber = scanner.nextLine(); 
    	
    	System.out.println("Name " + name +",  " + contact +", " + vehicleNumber) ;
    	
    	
    	SAVE_DIR = SAVE_DIR +"/"+ vehicleNumber;
    	
        // gets absolute path of the web application
    	// on amazon 
        String appPath = "/home/ubuntu";
    	
    // 	String appPath ="/Users/naveenkumar/Desktop";
    	
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        System.out.println("Dir created... ");
         
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            
            
            System.out.println("File Name " + fileName);
           
            if(fileName.length()>4){
            	part.write(savePath + File.separator + fileName);
            }
        }
 
        request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
    }
 
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
    	
    	
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("contentDisp " + contentDisp);
        String[] items = contentDisp.split(";");
        

        
        for (String s : items) {
        	System.out.println("Attributes are " + s);
        	
        	if(s.trim().contains("filename")){
        	
        	
//            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}