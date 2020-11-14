package uz.loving.infinbank.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uz.loving.infinbank.R;
import uz.loving.infinbank.models.Repository;

public class MasterListAdapter extends ArrayAdapter<Repository> {
    private Context mContext;
    private ArrayList<Repository> repositories;
    private Integer position = -1;

    public MasterListAdapter(Context context, int resource, ArrayList<Repository> repos) {
        super(context, resource,repos);
        this.mContext = context;
        this.repositories = repos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Repository repo = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.item,parent,false);
        ((TextView)convertView.findViewById(R.id.name)).setText(repo.getName());
        ((TextView)convertView.findViewById(R.id.language)).setText(repo.getLanguage());
        /*ImageView image=((ImageView)convertView.findViewById(R.id.avatar));
        glideImageLoad(getContext(),repo,image);*/
        convertView.setTag(repo);
        return convertView;
    }
    private void glideImageLoad(Context context,Repository repo,ImageView imageView){

        Glide
                .with(imageView.getContext())
                .load(repo.getHtmlUrl())
                .into(imageView);
    }

}
