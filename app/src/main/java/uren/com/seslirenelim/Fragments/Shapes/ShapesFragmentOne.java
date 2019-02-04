package uren.com.seslirenelim.Fragments.Shapes;


import android.annotation.SuppressLint;
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
public class ShapesFragmentOne extends BaseFragment implements View.OnClickListener {

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

    public ShapesFragmentOne(int selectedLanguage) {
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

        Glide.with(getContext())
                .load(R.drawable.rectangle)
                .apply(RequestOptions.fitCenterTransform())
                .into(item1Imgv);

        Glide.with(getContext())
                .load(R.drawable.circle)
                .apply(RequestOptions.fitCenterTransform())
                .into(item2Imgv);

        Glide.with(getContext())
                .load(R.drawable.square)
                .apply(RequestOptions.fitCenterTransform())
                .into(item3Imgv);

        Glide.with(getContext())
                .load(R.drawable.triangle)
                .apply(RequestOptions.fitCenterTransform())
                .into(item4Imgv);

        Glide.with(getContext())
                .load(R.drawable.star)
                .apply(RequestOptions.fitCenterTransform())
                .into(item5Imgv);

        Glide.with(getContext())
                .load(R.drawable.cylinder)
                .apply(RequestOptions.fitCenterTransform())
                .into(item6Imgv);

        Glide.with(getContext())
                .load(R.drawable.cube)
                .apply(RequestOptions.fitCenterTransform())
                .into(item7Imgv);

        Glide.with(getContext())
                .load(R.drawable.polygon)
                .apply(RequestOptions.fitCenterTransform())
                .into(item8Imgv);

        Glide.with(getContext())
                .load(R.drawable.ellipse)
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
                audioPlayUtil.setAndPlayAudioItems(R.raw.rectangle_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.rectangle_desc_en, 0);
        }

        if (v == item2Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.circle_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.circle_desc_en, 0);
        }

        if (v == item3Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.square_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.square_desc_en, 0);
        }

        if (v == item4Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.triangle_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.triangle_desc_en, 0);
        }

        if (v == item5Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.star_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.star_desc_en, 0);
        }

        if (v == item6Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.cylinder_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.cylinder_desc_en, 0);
        }

        if (v == item7Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.cube_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.cube_desc_en, 0);
        }

        if (v == item8Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.polynom_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.polingrom_desc_en, 0);
        }

        if (v == item9Imgv) {
            if (selectedLanguage == LANG_TURKISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.ellipse_desc_tr, 0);
            else if (selectedLanguage == LANG_ENGLISH)
                audioPlayUtil.setAndPlayAudioItems(R.raw.ellipce_desc_en, 0);
        }

        if (v == navigationImgv) {
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