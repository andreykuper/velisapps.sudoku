package com.velisapp.sudoku_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridBoardAdapter extends BaseAdapter {

    private final Context mContext;
    private ArrayList<String> boardNumbers;

    public GridBoardAdapter(Context context, ArrayList<String> boardNumbers){
        this.mContext = context;
        this.boardNumbers = boardNumbers;
    }


    @Override
    public int getCount() {
        return boardNumbers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final String number = boardNumbers.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.cell_layout, null);
        }

        final TextView finalNumberTextView = (TextView)convertView.findViewById(R.id.final_number);

        finalNumberTextView.setText(number);

        return convertView;
    }

}
