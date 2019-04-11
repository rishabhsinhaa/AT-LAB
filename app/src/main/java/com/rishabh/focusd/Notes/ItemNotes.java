package com.rishabh.focusd.Notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rishabh.focusd.R;

public class ItemNotes extends LinearLayout {

    private String title;
    private String text;
    private String id;
    private TextView tvTitle;
    private TextView tvText;

    public ItemNotes(Context context, String title, String text, String id) {
        super(context);

        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        this.title = title;
        this.text = text;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout body = (LinearLayout) layoutInflater.inflate(R.layout.item_notes, null, false);

        tvTitle = body.findViewById(R.id.title);
        tvText = body.findViewById(R.id.text);

        tvTitle.setText(title);
        tvText.setText(text);

        this.addView(body);
    }
}
