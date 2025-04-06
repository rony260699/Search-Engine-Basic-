package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;


public class Crawler {

    // it crawl using recursive dfs.
    HashSet<String> urlSet;
    Crawler(){
        urlSet = new HashSet<>();
    }
    int MAX_DEPTH = 4;

    public void get_page_text_and_links(String url, int depth) throws IOException, SQLException, ClassNotFoundException {

        if(urlSet.contains((url))){
            return;
        }
        if(depth>MAX_DEPTH){
            return;
        }
        urlSet.add(url);
        depth++;
        Document doc =  Jsoup.connect(url).timeout(5000).get(); // url to java object

        //indexer work start here
        Indexer indxer = new Indexer(doc, url);
        System.out.println(doc.title());
        Elements available_link_on_page = doc.select("a[href]");
        for(Element current_link : available_link_on_page){
            get_page_text_and_links(current_link.attr("abs:href"), depth);
        }

    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Crawler crawlerBot = new Crawler();
        crawlerBot.get_page_text_and_links("https://www.tpointtech.com/", 1);
    }
}