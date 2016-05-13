package com.chengchikeji_fragment.www;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ex_projectitem2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePagerBannerFragment extends Fragment {

    private int[] bannerPicture = new int[]{R.drawable.bannerimage,R.drawable.bannerimage2,R.drawable.bannerimage,R.drawable.bannerimage2};

    public HomePagerBannerFragment() {
    }
    private int position;

    public HomePagerBannerFragment(int position) {
        // Required empty public constructor
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home_pager_banner, container, false);
        ImageView mBannerImage = (ImageView) inflate.findViewById(R.id.bannerImage);
        mBannerImage.setImageResource(bannerPicture[position]);
        return inflate;
    }

}
