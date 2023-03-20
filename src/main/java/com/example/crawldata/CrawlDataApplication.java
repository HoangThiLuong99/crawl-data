package com.example.crawldata;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;



@SpringBootApplication
public class CrawlDataApplication {


    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        CrawlUrl crawlUrl = new CrawlUrl();
        String url = "https://giathuochapu.com/tin-tuc/";
        crawlUrl.getData(url);
        System.out.println("Done");
//

    }

}
