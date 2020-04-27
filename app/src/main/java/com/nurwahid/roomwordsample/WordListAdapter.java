package com.nurwahid.roomwordsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurwahid.roomwordsample.models.Word;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.tvWord.setText(current.getWord());
        } else {
            holder.tvWord.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if (mWords != null) {
            return mWords.size();
        } else return 0;
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvWord;
        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.textView_item);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    void setWord(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    WordListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

}
