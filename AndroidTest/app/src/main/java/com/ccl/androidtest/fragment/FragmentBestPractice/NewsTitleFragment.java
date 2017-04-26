package com.ccl.androidtest.fragment.FragmentBestPractice;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ccl.androidtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCL on 2016/12/10.
 */

public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {


    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane = false;

    @Override
    public void onAttach(Activity context) {
        Log.i("onattch1","123");
        newsList = getNews();

        adapter = new NewsAdapter(context, R.layout.news_item, newsList);
        Log.i("onattch2","123");
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        //if(getActivity().findViewById(R.id.news_content_layout) != null){
        if(1>0){
            Log.i("ccl","ccl");
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        if(isTwoPane){
            Log.i("ccl",news.toString());
            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refreshu(news.getTitle(), news.getContent());
        }else{
            NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
        }
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setContent("This sound is a major characteristic of the Beijing dialect, except “swallowing” *consonants–just think of “zhuangdianrtai” in Beijing dialect compared to China Central Television in Putonghua, also kown" +
                " as Modern Standard Mandarin. However, none of these features can be heard that often among today’s Beijing dwellers. A recent report by the Ministry of Education shows that the Beijing dialect is declining among the younger generation.");
        news1.setTitle("Regional dialects should be preserved");
        newsList.add(news1);
        News news2 = new News();
        news2.setContent("Nyame is the King of the Sky. All the stories belong to (属于) him. All day long people listen to his stories." +
                "Anansi is a spider. He is jealous of Nyame. He wants people to listen to him.\n");
        news2.setTitle("How Anansi gets his stories");
        newsList.add(news2);
        return newsList;
    }
}
