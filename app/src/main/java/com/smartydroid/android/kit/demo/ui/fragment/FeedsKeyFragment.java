package com.smartydroid.android.kit.demo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.smartydroid.android.kit.demo.api.ApiService;
import com.smartydroid.android.kit.demo.api.service.FeedService;
import com.smartydroid.android.kit.demo.model.entity.Feed;
import com.smartydroid.android.kit.demo.ui.viewholder.FeedViewHolderFactory;
import com.smartydroid.android.kit.demo.ui.viewholder.FeedsTextViewHolder;
import com.smartydroid.android.starter.kit.app.StarterKeysFragment;
import java.util.ArrayList;
import retrofit2.Call;

/**
 * Created by YuGang Yang on February 13, 2016.
 * Copyright 20015-2016 qiji.tech. All rights reserved.
 */
public class FeedsKeyFragment extends StarterKeysFragment<Feed> {
  private FeedService mFeedService;

  public static Fragment create() {
    return new FeedsKeyFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mFeedService = ApiService.createFeedService();
  }

  @Override public void viewHolderFactory(EasyRecyclerAdapter adapter) {
    adapter.viewHolderFactory(new FeedViewHolderFactory(getContext()));
  }

  @Override public Call<ArrayList<Feed>> paginate(Feed sinceItem, Feed maxItem, int perPage) {
    return mFeedService.getFeedsWith(
        maxItem == null ? null : maxItem.id + "",
        null,
        perPage);
  }

  @Override public Object getKeyForData(Feed item) {
    return item.id;
  }

  @Override public void bindViewHolders(EasyRecyclerAdapter adapter) {
    adapter.bind(Feed.class, FeedsTextViewHolder.class);
  }

  @Override public void onItemClick(int position, View view) {
    super.onItemClick(position, view);
    final Feed feed = getItem(position);
    Toast.makeText(getContext(), feed.content, Toast.LENGTH_SHORT).show();
  }
}
