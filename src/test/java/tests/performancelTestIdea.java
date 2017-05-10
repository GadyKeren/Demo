package tests;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class performancelTestIdea {

    @Test
    public void downloadSiteForCompare() throws IOException, InterruptedException {
        //This can be done per file or as a batch, but the idea is to down load file be file and compare
        //The  relevant attributes to the benchmark

        String[] command = {"C:\\Program Files\\GnuWin32\\bin\\wget.exe", "-o index.html", "--mirror", "http://booking.uz.gov.ua/i/img/favicon.ico"};
        Process proc = Runtime.getRuntime().exec(command);
        int exitCode = proc.waitFor();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("Finished with code: " + String.valueOf(exitCode));
    }
}
