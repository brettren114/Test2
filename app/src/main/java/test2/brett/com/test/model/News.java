package test2.brett.com.test.model;

import java.util.List;

/**
 * Created by Brett on 4/25/16.
 */
public class News {
    public String title;
    public String url;

    public List<Multimedia> multimedia;

    public News(String title, List<Multimedia> multimedia){
        this.title = title;
        this.multimedia = multimedia;
    }
}
