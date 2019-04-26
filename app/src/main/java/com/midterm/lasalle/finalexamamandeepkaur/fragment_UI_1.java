package com.midterm.lasalle.finalexamamandeepkaur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import model.Car;
import model.Vehicle;

public class fragment_UI_1  extends android.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_ui_1,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Vehicle vehicle =(Vehicle) getArguments().getSerializable("Vehicle");
        Car car=(Car)getArguments().getSerializable("Car");

        TextView textViewBrand =getActivity().findViewById(R.id.textViewBrand);
        textViewBrand.setText(vehicle.getBrand());

        TextView textViewModel =getActivity().findViewById(R.id.textViewModel);
        textViewModel.setText(car.getModel());

        TextView textViewYear =getActivity().findViewById(R.id.textViewYear);
        textViewYear.setText(String.valueOf(car.getYear()));

        TextView textViewPrice=getActivity().findViewById(R.id.textViewPrice);
        textViewPrice.setText(String.valueOf(vehicle.getPrice()));

        ImageView imageViewCar =getActivity().findViewById(R.id.imageViewCar);
        imageViewCar.setImageResource(vehicle.getPicture());

    }
}
