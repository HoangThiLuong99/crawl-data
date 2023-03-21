package com.example.crawldata;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;

public class GenFile {
    public void genFile(List<Data> lst) {
        String file = "data.txt";
        try {
            File f = new File(file);
            FileWriter fw = new FileWriter(file);
            for (Data e : lst) {
                fw.append(e.getTitle()).append("\t")
                        .append(e.getContent()).append("\n");
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
*  private void crawlNews(){
        try {
            List<String> lstUrl = new ArrayList<>();

            String links  = "https://giathuochapu.com/tin-tuc/page/" + page;
            Document docs = Jsoup.connect(links).get();
            Elements newsHeadlines = docs.select(".post-list article h2 a");
            for (Element headline : newsHeadlines) {
                String urlArticle = headline.absUrl("href");
                lstUrl.add(urlArticle);
            }

            String link = "https://giathuochapu.com/tin-tuc/";
            Document doc = Jsoup.connect(link).get();
            Elements newsUrl = doc.select(".post-list article h2 a");
            for (Element headline : newsUrl) {
                String urlArticle = headline.absUrl("href");
                lstUrl.add(urlArticle);
            }

            List<NewsCrawlDto> lstData = new ArrayList<>();
            for(String s : lstUrl){
                Document docNews = Jsoup.connect(s).get();
                Elements eleTitle = docNews.select("#content #primary article header h1");
                String title = eleTitle.text();
                Elements elem = docNews.select("#content #primary article .entry-content");
                String content = elem.html();
                lstData.add(new NewsCrawlDto(title,content));

            }

        }catch (Exception e){

        }

    }
* */
