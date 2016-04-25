package test2.brett.com.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import test2.brett.com.test.model.APIResponse;
import test2.brett.com.test.model.News;

/**
 * Created by Brett on 4/25/16.
 */
public class MainFragment extends Fragment {

    private NewsAdapter mNewsAdapter;
    private ListView mListView;
    private List<News> mNews;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // The ArrayAdapter will take data from a source and
        // use it to populate the ListView it's attached to.
        mNewsAdapter =
                new NewsAdapter(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_news, // The ID of the textview to populate.
                        new ArrayList<News>());

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        mListView = (ListView) rootView.findViewById(R.id.listview_news);

        mListView.setAdapter(mNewsAdapter);

        getNewsResponse();

        return rootView;
    }

    public void getNewsResponse(){
        APIProvider.getService(getActivity()).getResponse()
                .enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Response<APIResponse> response, Retrofit retrofit) {
                        if (response.body() != null) {
                            ArrayList<News> list = response.body().getResults();
                            updateView(list);
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

    }


    public void updateView(ArrayList<News> list){
        for (News newsItem : list) {
            mNewsAdapter.add(newsItem);
        }
    }
}