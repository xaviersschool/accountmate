package com.sxs.xaviers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
