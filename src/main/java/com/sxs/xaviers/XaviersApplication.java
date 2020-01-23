package com.sxs.xaviers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.sxs.xaviers.services.StudentService;
import com.sxs.xaviers.util.DataUploader;

@SpringBootApplication
public class XaviersApplication {

	//@Autowired
	//StudentService stdService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(XaviersApplication.class, args);		
	}
	
	/*
	 * @EventListener(ApplicationReadyEvent.class) public void
	 * doSomethingAfterStartup() {
	 * System.out.println("hello world, I have just started up");
	 * stdService.saveAll(DataUploader.excelToList(
	 * "C:\\Users\\deepak.k\\Downloads\\test.csv")); }
	 */

}
