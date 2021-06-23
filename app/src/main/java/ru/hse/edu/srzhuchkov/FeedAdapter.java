package ru.hse.edu.srzhuchkov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Feed> feeds;

    public FeedAdapter(Context context, List<Feed> feeds) {
        this.inflater = LayoutInflater.from(context);
        this.feeds = feeds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Feed feed = feeds.get(position);
        holder.title.setText(feed.getTitle());
        holder.description.setText(feed.getDescription());
        holder.source.setText(feed.getSource());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView description;
        final TextView source;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            source = itemView.findViewById(R.id.source);
        }
    }
}
