package com.osmancansonmezisik.lab3;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    List<Post> posts;
    private LayoutInflater inflater;

    public PostAdapter(Activity activity, List<Post> posts) {
        this.posts = posts;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return posts == null ? 0 : posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View rowView;
      rowView = inflater.inflate(R.layout.row,null);
        EditText txtMessage = rowView.findViewById(R.id.TxtPostMessage);
        TextView txtLocation = rowView.findViewById(R.id.TxtLocation);
        ImageView imageView = rowView.findViewById(R.id.imageView2);

        Post post = posts.get(position);
        txtMessage.setText(post.getMessage());
        imageView.setImageBitmap(post.getImage());
        if(post.getLocation() != null){
            txtLocation.setText(post.getLocation().getLatitude() + " " + post.getLocation().getLongitude());
        }

        return rowView;

    }
}
