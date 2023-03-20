package com.example.crawldata;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlUrl {
    private static final int MAX_DEPTH = 29;

    public static List<String> getUrl(String url) throws IOException {
        List<String> lst = new ArrayList<>();

            if (url.startsWith("https://giathuochapu.com/tin-tuc/page/")) {
                for (int i = 2; i < MAX_DEPTH; i++) {
                    String urlPage = url + i;
                    Document doc = Jsoup.connect(urlPage).get();

                    Elements newsHeadlines = doc.select(".post-list article h2 a");
                    for (Element headline : newsHeadlines) {
                        String urlArticle = headline.absUrl("href");
                        lst.add(urlArticle);
                    }
                }

            }else {
                String urlPage = "https://giathuochapu.com/tin-tuc/";
                Document doc = Jsoup.connect(urlPage).get();

                Elements newsHeadlines = doc.select(".post-list article h2 a");
                for (Element headline : newsHeadlines) {
                    String urlArticle = headline.absUrl("href");
                    lst.add(urlArticle);
                }
            }
        System.out.println("lst size " + lst.size());

        return lst;
    }

    public List<Data> getData(String url) throws IOException {
        List<String> lstUrl = getUrl(url);
        List<Data> nd = new ArrayList<>();
        for(String s : lstUrl){
            Data data = new Data();
            Document doc = Jsoup.connect(s).get();
            Elements eleTitle = doc.select("#content #primary article header h1");
            String title = eleTitle.attr("h1");
            Elements elem = doc.select("#content #primary article .entry-content");
            String content = elem.html();

            nd.add(new Data(title,content));

        }
        return nd;
    }
}
