package com.tourist.police.view.fragment;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.tourist.police.R;
import com.tourist.police.viewModel.FaqViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FAQFragment extends Fragment {

    private FaqViewModel mViewModel;

    @Bind(R.id.ac_tv_header_title)
    AppCompatTextView acTvHeaderTitle;

    @Bind(R.id.ac_iv_header_icon)
    AppCompatImageView acIvHeaderIcon;

    public static FAQFragment getInstance() {
        return new FAQFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faq_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FaqViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        acTvHeaderTitle.setText(R.string.txt_faq);
        Picasso.get().load(R.drawable.faq).into(acIvHeaderIcon);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}