package uren.com.seslirenelim.Fragments.Animals;


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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

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
import static uren.com.seslirenelim.Constants.NumericConstant.MAX_BOUND_VALUE;

@SuppressLint("ValidFragment")
public class AnimalsFragmentTwo extends BaseFragment implements View.OnClickListener {

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
    private AudioPlayUtil audioPlayUtil;

    public AnimalsFragmentTwo(int selectedLanguage) {
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
            AdMobUtils.loadInterstitialAd(getContext());
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
        Glide.with(getContext())
                .load(R.drawable.elephant)
                .apply(RequestOptions.fitCenterTransform())
                .into(item1Imgv);

        Glide.with(getContext())
                .load(R.drawable.frog)
                .apply(RequestOptions.fitCenterTransform())
                .into(item2Imgv);

        Glide.with(getContext())
                .load(R.drawable.horse)
                .apply(RequestOptions.fitCenterTransform())
                .into(item3Imgv);

        Glide.with(getContext())
                .load(R.drawable.lion)
                .apply(RequestOptions.fitCenterTransform())
                .into(item4Imgv);

        Glide.with(getContext())
                .load(R.drawable.monkey)
                .apply(RequestOptions.fitCenterTransform())
                .into(item5Imgv);

        Glide.with(getContext())
                .load(R.drawable.sheep)
                .apply(RequestOptions.fitCenterTransform())
                .into(item6Imgv);

        Glide.with(getContext())
                .load(R.drawable.rooster)
                .apply(RequestOptions.fitCenterTransform())
                .into(item7Imgv);

        Glide.with(getContext())
                .load(R.drawable.tiger)
                .apply(RequestOptions.fitCenterTransform())
                .into(item8Imgv);

        Glide.with(getContext())
                .load(R.drawable.wolf)
                .apply(RequestOptions.fitCenterTransform())
                .into(item9Imgv);

        Glide.with(getContext())
                .load(R.drawable.icon_left_arrow)
                .apply(RequestOptions.fitCenterTransform())
                .into(navigationImgv);
    }

    @Override
    public void onClick(View v) {
        if (v == item1Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.elephant_desc_tr, R.raw.elephant_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.elephant_desc_en, R.raw.elephant_sound);
        }

        if (v == item2Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.frog_desc_tr, R.raw.frog_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.frog_desc_en, R.raw.frog_sound);
        }

        if (v == item3Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.horse_desc_tr, R.raw.horse_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.horse_desc_en, R.raw.horse_sound);
        }

        if (v == item4Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.lion_desc_tr, R.raw.lion_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.lion_desc_en, R.raw.lion_sound);
        }

        if (v == item5Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.monkey_desc_tr, R.raw.monkey_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.monkey_desc_en, R.raw.monkey_sound);
        }

        if (v == item6Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.sheep_desc_tr, R.raw.sheep_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.sheep_desc_en, R.raw.sheep_sound);
        }

        if (v == item7Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.rooster_desc_tr, R.raw.rooster_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.rooster_desc_en, R.raw.rooster_sound);
        }

        if (v == item8Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.tiger_desc_tr, R.raw.tiger_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.tiger_desc_en, R.raw.tiger_sound);
        }

        if (v == item9Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.wolf_desc_tr, R.raw.wolf_sound);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.wolf_desc_en, R.raw.wolf_sound);
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