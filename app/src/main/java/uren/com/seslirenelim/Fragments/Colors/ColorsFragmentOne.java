package uren.com.seslirenelim.Fragments.Colors;


import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import uren.com.seslirenelim.Activities.MainContentActivity;
import uren.com.seslirenelim.FragmentControllers.FragNavController;
import uren.com.seslirenelim.GeneralUtils.AdMobUtils;
import uren.com.seslirenelim.GeneralUtils.AudioPlayUtil;
import uren.com.seslirenelim.MainFragments.BaseFragment;
import uren.com.seslirenelim.R;

import static uren.com.seslirenelim.Constants.NumericConstant.LANG_ENGLISH;
import static uren.com.seslirenelim.Constants.NumericConstant.LANG_TURKISH;

@SuppressLint("ValidFragment")
public class ColorsFragmentOne extends BaseFragment implements View.OnClickListener {

    View mView;

    @BindView(R.id.item1Imgv)
    ImageView item1Imgv;
    @BindView(R.id.item2Imgv)
    ImageView item2Imgv;
    @BindView(R.id.item3Imgv)
    ImageView item3Imgv;
    @BindView(R.id.item4Imgv)
    ImageView item4Imgv;
    @BindView(R.id.item5Imgv)
    ImageView item5Imgv;
    @BindView(R.id.item6Imgv)
    ImageView item6Imgv;
    @BindView(R.id.item7Imgv)
    ImageView item7Imgv;
    @BindView(R.id.item8Imgv)
    ImageView item8Imgv;
    @BindView(R.id.item9Imgv)
    ImageView item9Imgv;

    @BindView(R.id.homeImgv)
    ImageView homeImgv;
    @BindView(R.id.navigationImgv)
    ImageView navigationImgv;

    AdView adView;

    private int selectedLanguage;
    AudioPlayUtil audioPlayUtil;

    public ColorsFragmentOne(int selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_content_items, container, false);
            ButterKnife.bind(this, mView);
            init();
            initAdMob();
            setImages();
            AdMobUtils.loadBannerAd(adView);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        item1Imgv.setOnClickListener(this);
        item2Imgv.setOnClickListener(this);
        item3Imgv.setOnClickListener(this);
        item4Imgv.setOnClickListener(this);
        item5Imgv.setOnClickListener(this);
        item6Imgv.setOnClickListener(this);
        item7Imgv.setOnClickListener(this);
        item8Imgv.setOnClickListener(this);
        item9Imgv.setOnClickListener(this);
        navigationImgv.setOnClickListener(this);
        homeImgv.setOnClickListener(this);
        audioPlayUtil = new AudioPlayUtil(getContext());
    }

    private void initAdMob() {
        adView = mView.findViewById(R.id.adView);
        MobileAds.initialize(getContext(), getActivity().getResources().getString(R.string.ADMOB_APP_ID));
    }

    private void setImages() {
        item1Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Red, null));
        item2Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Blue, null));
        item3Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Green, null));
        item4Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Yellow, null));
        item5Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.White, null));
        item6Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Pink, null));
        item7Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Orange, null));
        item8Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Purple, null));
        item9Imgv.setBackgroundColor(getContext().getResources().getColor(R.color.Sienna, null));

        Glide.with(getContext())
                .load(R.drawable.icon_left_arrow)
                .apply(RequestOptions.fitCenterTransform())
                .into(navigationImgv);
    }

    @Override
    public void onClick(View v) {
        if (v == item1Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.red_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.red_desc_en, 0);
        }

        if (v == item2Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.blue_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.blue_desc_en, 0);
        }

        if (v == item3Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.green_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.green_desc_en, 0);
        }

        if (v == item4Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.yellow_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.yellow_desc_en, 0);
        }

        if (v == item5Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.white_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.white_desc_en, 0);
        }

        if (v == item6Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.pink_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.pink_desc_en, 0);
        }

        if (v == item7Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.orange_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.orange_desc_en, 0);
        }

        if (v == item8Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.purple_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.purple_desc_en, 0);
        }

        if (v == item9Imgv){
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.brown_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.brown_desc_en, 0);
        }

        if (v == navigationImgv) {
            if (mFragmentNavigation != null)
                audioPlayUtil.clearMediPlayer();
                getActivity().onBackPressed();
        }

        if (v == homeImgv) {
            try {
                audioPlayUtil.clearMediPlayer();
                ((MainContentActivity) getActivity()).clearStackGivenIndex(FragNavController.TAB1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}