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
import com.tourist.police.viewModel.ContactViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactFragment extends Fragment {

    private ContactViewModel mViewModel;

    @Bind(R.id.ac_tv_header_title)
    AppCompatTextView acTvHeaderTitle;

    @Bind(R.id.ac_iv_header_icon)
    AppCompatImageView acIvHeaderIcon;

    public static ContactFragment getInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        acTvHeaderTitle.setText(R.string.txt_contact);
        Picasso.get().load(R.drawable.contact).into(acIvHeaderIcon);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}