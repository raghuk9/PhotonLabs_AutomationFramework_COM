package framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;

public class Report_Header {

	public void report_Header(String viewPort, String application) throws IOException {
		String ipaddress = Inet4Address.getLocalHost().getHostAddress();
		String osname = System.getProperty("os.name").toLowerCase();
		System.out.println("osname = " + osname);
		FileWriter fw = null;
		String newPath = null;
		BufferedWriter bw = null;
		System.out.println(application);
		File ff = new File("DriverSheet.ods");
		String path = ff.getAbsolutePath().trim();
		System.out.println("Path in Report_header = " + path);
		if(osname.contains("win")) {
			newPath = path.substring(0, path.lastIndexOf("\\")).concat("\\");
		} else {
			newPath = path.substring(0, path.lastIndexOf("/")).concat("/");
		}
		System.out.println("newPath = " + newPath);
		String Files = newPath.concat(viewPort).concat(application).concat(".html");
		File file = new File(Files);
		if (file.exists()) {
			file.delete();
		}
		fw = new FileWriter(Files);
		bw = new BufferedWriter(fw);
		String pixel = "1000px";
		bw.write("<html><head><title>Automation reports</title></head><body>");
		bw.write("<TABLE Border=1 style=width:" + pixel
				+ "><TR  BGCOLOR=#C0C0C0><TH style=width:333px align=left>IPAddress:" + ipaddress
				+ "<TH style=width:333px align=left>OS version:" + osname
				+ "<TH style=width:40px align=left>application:" + application + "</TR>");
		bw.write("<TABLE Border=1 style=width:" + pixel
				+ "><TR  BGCOLOR=#C0C0C0><TH style=width:100px align=left>TCNO<TH style=width:800px align=left>TCDescription<TH style=width:100px align=left>Status<TH style=width:100px align=left>Timetaken<TH style=width:100px align=left>Execution time</TR>");
		bw.write("</TABLE>");
		bw.close();
	}
}
