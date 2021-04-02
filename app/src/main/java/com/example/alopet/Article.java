package com.example.alopet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.alopet.Model.Articles;
import com.example.alopet.Model.Headlines;
import com.google.android.material.tabs.TabLayout;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Article extends AppCompatActivity {
RecyclerView recyclerView;
final String API_KEY = "627f57d562a94cf5b486e6a043054b32";
private ImageButton backbt;
Adapter adapter;
List<Articles> articles=new ArrayList<>();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        backbt=findViewById(R.id.backbt);
        backbt.setOnClickListener(v->{

            startActivity(new Intent(Article.this, Homepage.class));


        });
         recyclerView=findViewById(R.id.reciclerView);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         String country=getCountry();
         retrieveJson("id",API_KEY);

        /*NewsApiClient newsApiClient = new NewsApiClient("627f57d562a94cf5b486e6a043054b32");
         newsApiClient.getTopHeadlines(
                 new TopHeadlinesRequest.Builder()
                         .q("bitcoin")
                         .language("en")
                         .build(),
                 new NewsApiClient.ArticlesResponseCallback() {
                     @Override
                     public void onSuccess(ArticleResponse response) {
                         System.out.println(response.getArticles().get(0).getTitle());
                     }

                     @Override
                     public void onFailure(Throwable throwable) {
                         System.out.println(throwable.getMessage());
                     }
                 }
         );
         newsApiClient.getEverything(
                 new EverythingRequest.Builder()
                         .q("trump")
                         .build(),
                 new NewsApiClient.ArticlesResponseCallback() {
                     @Override
                     public void onSuccess(ArticleResponse response) {
                         System.out.println(response.getArticles().get(0).getTitle());
                     }

                     @Override
                     public void onFailure(Throwable throwable) {
                         System.out.println(throwable.getMessage());
                     }
                 }
         );
         newsApiClient.getSources(
                 new SourcesRequest.Builder()
                         .language("en")
                         .country("us")
                         .build(),
                 new NewsApiClient.SourcesCallback() {
                     @Override
                     public void onSuccess(SourcesResponse response) {
                         System.out.println(response.getSources().get(0).getName());
                     }

                     @Override
                     public void onFailure(Throwable throwable) {
                         System.out.println(throwable.getMessage());
                     }
                 }
         );*/
}
public void retrieveJson(String country, String apiKey){

    Call<Headlines> call=ApiClient.getInstance().getApi().getHeadlines(country,apiKey,"health");
    call.enqueue(new Callback<Headlines>() {
        @Override
        public void onResponse(Call<Headlines> call, Response<Headlines> response) {
            if(response.isSuccessful()&& response.body().getArticles()!=null){
                articles.clear();
                articles=response.body().getArticles();
                adapter=new Adapter(Article.this,articles);
                recyclerView.setAdapter(adapter);


            }
        }

        @Override
        public void onFailure(Call<Headlines> call, Throwable t) {

        }
    });

}
public String getCountry(){
         Locale locale= Locale.getDefault();
         String country=locale.getCountry();
         return country;
}
}