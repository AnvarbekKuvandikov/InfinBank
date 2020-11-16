package uz.loving.infinbank.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;

import uz.loving.infinbank.R;
import uz.loving.infinbank.databinding.ItemBinding;
import uz.loving.infinbank.viewmodel.RepositoryViewModel;

public class MasterListAdapter extends ArrayAdapter<RepositoryViewModel> {
    private Context mContext;
    private ArrayList<RepositoryViewModel> repositories;

    public MasterListAdapter(Context context, int resource, ArrayList<RepositoryViewModel> repos) {
        super(context, resource,repos);
        this.mContext = context;
        this.repositories = repos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        @SuppressLint("ViewHolder")
        ItemBinding itemBinding= DataBindingUtil.inflate(inflater,R.layout.item,parent,false);
        itemBinding.setRepos(repositories.get(position));
        return itemBinding.getRoot();
    }


}
