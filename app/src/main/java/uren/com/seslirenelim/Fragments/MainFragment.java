package uren.com.seslirenelim.Fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uren.com.seslirenelim.Fragments.Animals.AnimalsFragmentOne;
import uren.com.seslirenelim.Fragments.BodyParts.BodyPartsFragmentOne;
import uren.com.seslirenelim.Fragments.Colors.ColorsFragmentOne;
import uren.com.seslirenelim.Fragments.Jobs.JobsFragmentOne;
import uren.com.seslirenelim.Fragments.Numbers.NumbersFragmentOne;
import uren.com.seslirenelim.Fragments.Shapes.ShapesFragmentOne;
import uren.com.seslirenelim.Fragments.VegetablesAndFruits.VegetablesFragmentOne;
import uren.com.seslirenelim.Fragments.Vehicles.VehiclesFragmentOne;
import uren.com.seslirenelim.GeneralUtils.ShapeUtil;
import uren.com.seslirenelim.MainFragments.BaseFragment;
import uren.com.seslirenelim.R;

import static uren.com.seslirenelim.Constants.NumericConstant.LANG_ENGLISH;
import static uren.com.seslirenelim.Constants.NumericConstant.LANG_TURKISH;

@SuppressLint("ValidFragment")
public class MainFragment extends BaseFragment {

    View mView;

    @BindView(R.id.animalsLayout)
    FrameLayout animalsLayout;
    @BindView(R.id.colorsLayout)
    FrameLayout colorsLayout;
    @BindView(R.id.vehiclesLayout)
    FrameLayout vehiclesLayout;
    @BindView(R.id.fruitsLayout)
    FrameLayout fruitsLayout;
    @BindView(R.id.jobsLayout)
    FrameLayout jobsLayout;
    @BindView(R.id.numbersLayout)
    FrameLayout numbersLayout;
    @BindView(R.id.shapesLayout)
    FrameLayout shapesLayout;
    @BindView(R.id.bodyPartsLayout)
    FrameLayout bodyPartsLayout;

    @BindView(R.id.animalsTv)
    TextView animalsTv;
    @BindView(R.id.colorsTv)
    TextView colorsTv;
    @BindView(R.id.vehiclesTv)
    TextView vehiclesTv;
    @BindView(R.id.fruitsTv)
    TextView fruitsTv;
    @BindView(R.id.jobsTv)
    TextView jobsTv;
    @BindView(R.id.numbersTv)
    TextView numbersTv;
    @BindView(R.id.shapesTv)
    TextView shapesTv;
    @BindView(R.id.bodyPartsTv)
    TextView bodyPartsTv;

    private int selectedLanguage;

    public MainFragment(int selectedLanguage) {
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
            mView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.bind(this, mView);
            init();
            setDescriptions();
            setShapes();
            setListeners();
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {

    }

    private void setDescriptions(){
        if(selectedLanguage == LANG_TURKISH){
            animalsTv.setText(getContext().getResources().getString(R.string.ANIMALS_TR));
            colorsTv.setText(getContext().getResources().getString(R.string.COLORS_TR));
            vehiclesTv.setText(getContext().getResources().getString(R.string.VEHICLES_TR));
            fruitsTv.setText(getContext().getResources().getString(R.string.FRUITS_AND_VEGETABLES_TR));
            jobsTv.setText(getContext().getResources().getString(R.string.JOBS_TR));
            numbersTv.setText(getContext().getResources().getString(R.string.NUMBERS_TR));
            shapesTv.setText(getContext().getResources().getString(R.string.SHAPES_TR));
            bodyPartsTv.setText(getContext().getResources().getString(R.string.BODY_PARTS_TR));
        }else if(selectedLanguage == LANG_ENGLISH){
            animalsTv.setText(getContext().getResources().getString(R.string.ANIMALS));
            colorsTv.setText(getContext().getResources().getString(R.string.COLORS));
            vehiclesTv.setText(getContext().getResources().getString(R.string.VEHICLES));
            fruitsTv.setText(getContext().getResources().getString(R.string.FRUITS_AND_VEGETABLES));
            jobsTv.setText(getContext().getResources().getString(R.string.JOBS));
            numbersTv.setText(getContext().getResources().getString(R.string.NUMBERS));
            shapesTv.setText(getContext().getResources().getString(R.string.SHAPES));
            bodyPartsTv.setText(getContext().getResources().getString(R.string.BODY_PARTS));
        }
    }

    private void setShapes() {
        animalsLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        colorsLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        vehiclesLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        fruitsLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        jobsLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        numbersLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        shapesLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
        bodyPartsLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.White, null),
                0, GradientDrawable.RECTANGLE, 25, 0));
    }

    private void setListeners() {

        animalsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new AnimalsFragmentOne(selectedLanguage));
            }
        });

        colorsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new ColorsFragmentOne(selectedLanguage));
            }
        });

        vehiclesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new VehiclesFragmentOne(selectedLanguage));
            }
        });

        shapesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new ShapesFragmentOne(selectedLanguage));
            }
        });

        fruitsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new VegetablesFragmentOne(selectedLanguage));
            }
        });

        jobsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new JobsFragmentOne(selectedLanguage));
            }
        });

        numbersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new NumbersFragmentOne(selectedLanguage));
            }
        });

        bodyPartsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null)
                    mFragmentNavigation.pushFragment(new BodyPartsFragmentOne(selectedLanguage));
            }
        });
    }
}