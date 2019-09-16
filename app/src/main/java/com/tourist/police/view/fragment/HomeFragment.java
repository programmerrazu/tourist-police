package com.tourist.police.view.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tourist.police.R;
import com.tourist.police.adapter.HomeAdapter;
import com.tourist.police.interfaces.FragmentChanger;
import com.tourist.police.listeners.OnItemClickListener;
import com.tourist.police.model.HomeInfo;
import com.tourist.police.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    private static final int numberOfColumns = 3;
    private Context context;
    private FragmentChanger changer;

    private HomeViewModel mViewModel;

    @Bind(R.id.recycler_view_home)
    RecyclerView recyclerViewHome;

    @Bind(R.id.tv_msg)
    TextView tvMsg;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        GridLayoutManager manager = new GridLayoutManager(context, numberOfColumns);
        recyclerViewHome.setLayoutManager(manager);
        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setNestedScrollingEnabled(false);

        tvMsg.setText("Important News :\nCyclone Emergency Preparedness Update : Cox's Bazar");
        setAdapter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        this.changer = (FragmentChanger) context;
    }

    private void setAdapter() {

        List<HomeInfo> homeInfoList = new ArrayList<>();

        HomeInfo home = new HomeInfo(1, "Help/Complain", R.drawable.complain);
        homeInfoList.add(home);

        HomeInfo home2 = new HomeInfo(2, "Notice/News", R.drawable.notice);
        homeInfoList.add(home2);

        HomeInfo home3 = new HomeInfo(3, "Tourist Spot", R.drawable.tourist_spot);
        homeInfoList.add(home3);

        HomeInfo home4 = new HomeInfo(4, "About Tourist Police", R.drawable.about_tourist_police);
        homeInfoList.add(home4);

        HomeInfo home5 = new HomeInfo(5, "FAQ", R.drawable.faq);
        homeInfoList.add(home5);

        HomeInfo home6 = new HomeInfo(6, "Contact", R.drawable.contact);
        homeInfoList.add(home6);

        HomeInfo home7 = new HomeInfo(7, "Find us", R.drawable.find_us);
        homeInfoList.add(home7);

        HomeInfo home8 = new HomeInfo(8, "Laws & Rules", R.drawable.rules);
        homeInfoList.add(home8);

        HomeInfo home9 = new HomeInfo(9, "Forms", R.drawable.forms);
        homeInfoList.add(home9);

        HomeInfo home10 = new HomeInfo(10, "Live Chat", R.drawable.live_chat);
        homeInfoList.add(home10);

        HomeInfo home11 = new HomeInfo(11, "Social Network", R.drawable.social_network);
        homeInfoList.add(home11);

        HomeInfo home12 = new HomeInfo(12, "Hotline", R.drawable.hotline);
        homeInfoList.add(home12);

        HomeAdapter homeAdapter = new HomeAdapter(context, homeInfoList, new OnItemClickListener() {
            @Override
            public void onClick(HomeInfo home) {
                Fragment fragment;
                switch (home.getId()) {
                    case 1:
                        fragment = ComplainFragment.getInstance();
                        break;
                    case 2:
                        fragment = NoticeFragment.getInstance();
                        break;
                    case 3:
                        fragment = TouristSpotFragment.getInstance();
                        break;
                    case 4:
                        fragment = AboutTouristPoliceFragment.getInstance();
                        break;
                    case 5:
                        fragment = FAQFragment.getInstance();
                        break;
                    case 6:
                        fragment = ContactFragment.getInstance();
                        break;
                    case 7:
                        fragment = FindUsFragment.getInstance();
                        break;
                    case 8:
                        fragment = RulesFragment.getInstance();
                        break;
                    case 9:
                        fragment = FormsFragment.getInstance();
                        break;
                    case 10:
                        fragment = LiveChatFragment.getInstance();
                        break;
                    case 11:
                        fragment = SocialNetworkFragment.getInstance();
                        break;
                    case 12:
                        fragment = HotLineFragment.getInstance();
                        break;
                    default:
                        fragment = null;
                }
                if (fragment != null) {
                    changer.onChangeFragment(fragment);
                }
            }
        });
        recyclerViewHome.setAdapter(homeAdapter);
    }
}