package com.mursitaffandi.cataloguemovie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mursitaffandi.cataloguemovie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mursitaffandi on 14/01/18.
 */

public class ResultVH extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.iv_item_poster)
    ImageView imageView;

    @BindView(R.id.tv_item_title)
    TextView tv_title;

    @BindView(R.id.tv_item_overview)
    TextView tv_overview;

    @BindView(R.id.tv_item_release_date)
    TextView tv_release;

    @BindView(R.id.btn_item_detail)
    Button btn_detail;

    @BindView(R.id.btn_item_share)
    Button btn_share;
    VHEvent event;

    public ResultVH(View itemView, VHEvent event) {
        super(itemView);
        this.event = event;
        ButterKnife.bind(this, itemView);

        btn_detail.setOnClickListener(this);
        btn_share.setOnClickListener(this);
    }

    public interface VHEvent {
        void postItemClick(ResultVH resultVH);
        void shareItemMovie(ResultVH resultVH);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_item_detail:
                event.postItemClick(this);
                break;
            case R.id.btn_item_share:
                event.shareItemMovie(this);
                break;
            default:
                break;
        }
    }
}

