package com.enjoy.celebrations.Intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.enjoy.celebrations.R;


public class IntroViewPagerAdapter extends PagerAdapter {

    Context context;

    public IntroViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.intro_viewpager_design,null);
        TextView introHeading=view.findViewById(R.id.introHeading);
        TextView introBody=view.findViewById(R.id.introBody);
        ImageView imageView=view.findViewById(R.id.introImageView);

        introHeading.setText(heading[position]);
        introBody.setText(body[position]);
        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.img1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.img2);
                break;
            case 2:
                imageView.setImageResource(R.drawable.img3);
                break;
        }
        container.addView(view);
        return view;
    }

    String[] heading =new String[]{"Abhinav","Bhaskara","Chandu"};
    String[] body =new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam luctus tincidunt nisl at congue. Pellentesque dapibus pretium ante",
            "In tincidunt eleifend risus, id semper velit iaculis ac. Mauris id mi id est efficitur cursus. Cras ut leo ac mauris scelerisque suscipit ac in arcu.",
            "Duis vitae faucibus lorem. Etiam commodo aliquet sapien. Vivamus et lacus commodo, lacinia elit at, condimentum tellus. Vestibulum bibendum nibh metus"};

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
