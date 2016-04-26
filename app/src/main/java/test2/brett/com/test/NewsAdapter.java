package test2.brett.com.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test2.brett.com.test.model.News;

/**
 * Created by Brett on 4/25/16.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    Context context;
    int layoutResourceId;
    List<News> news = null;

    public NewsAdapter(Context context, int layoutResourceId, List<News> news) {
        super(context, layoutResourceId, news);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.news = news;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        NewsHolder holder = null;

        if(view == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);

            holder = new NewsHolder();
            holder.txtTitle = (TextView)view.findViewById(R.id.txtTitle);
            holder.imgPoster = (ImageView)view.findViewById(R.id.imagePoster);

            view.setTag(holder); //save the inflated View for future reuse
        }
        else {
            holder = (NewsHolder)view.getTag();
        }

        News newsItem = news.get(position);
        holder.txtTitle.setText(newsItem.title);
        if(!newsItem.multimedia.isEmpty()){
            Picasso.with(context).load(newsItem.multimedia.get(0).url).into(holder.imgPoster);
        }
        return view;
    }

    // cache the call to findViewById()
    public static class NewsHolder {
        ImageView imgPoster;
        TextView txtTitle;
    }
}
