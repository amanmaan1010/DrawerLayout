package com.midterm.lasalle.finalexamamandeepkaur;

import android.content.res.AssetManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Car;
import model.Vehicle;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listViewVehicle;
    DrawerLayout drawerLayout;
    ArrayList<Vehicle> listOfVehicles;
    ArrayAdapter vehicleAdapter;
    ArrayList<Car> listOfCar;
    String vehicleType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    public  void initialize()
    {
        listViewVehicle=findViewById(R.id.listView);
        drawerLayout=findViewById(R.id.drawerLayout);
        listViewVehicle.setOnItemClickListener(this);
        listOfVehicles=new ArrayList<Vehicle>();
        listOfCar=new ArrayList<Car>();
        listOfVehicles= populateFromAFile("vehicles.txt");
        listOfCar=populateFromAFile1("vehicles.txt");
        vehicleAdapter=new ArrayAdapter<>(this,R.layout.one_item,listOfVehicles);
        listViewVehicle.setAdapter(vehicleAdapter);
    }

    private ArrayList<Vehicle> populateFromAFile(String filename) {
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
        AssetManager assetManager = this.getResources().getAssets();
        try {
            InputStreamReader isr = new InputStreamReader(assetManager.
                    open(filename));
            BufferedReader br= new BufferedReader(isr);
            String oneLine=br.readLine();
            while (oneLine!=null){
                StringTokenizer st = new StringTokenizer(oneLine,",");
               vehicleType=st.nextToken();
                if (vehicleType.equalsIgnoreCase("C"))
                {
                    String brand=st.nextToken();
                    String model=st.nextToken();
                    int year=Integer.valueOf(st.nextToken());
                    float price = Float.valueOf(st.nextToken());
                    String strPicture = st.nextToken();
                    int picture=getResources().getIdentifier("drawable/"+strPicture,null,getPackageName());
                    list.add(new Vehicle(brand,price,picture));
                }
                else
                {
                    String brand=st.nextToken();
                    String bikeType=st.nextToken();
                    float price = Float.valueOf(st.nextToken());
                    String strPicture = st.nextToken();
                    int picture=getResources().getIdentifier("drawable/"+strPicture,null,getPackageName());
                    list.add(new Vehicle(brand,price,picture));
;                }
                oneLine=br.readLine();
            }
            br.close();
            isr.close();
        } catch (IOException e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return list;
    }

    private ArrayList<Car> populateFromAFile1(String filename) {
        ArrayList<Car> list1 = new ArrayList<Car>();
        AssetManager assetManager = this.getResources().getAssets();
        try {
            InputStreamReader isr = new InputStreamReader(assetManager.
                    open(filename));
            BufferedReader br= new BufferedReader(isr);
            String oneLine=br.readLine();
            while (oneLine!=null){
                StringTokenizer st = new StringTokenizer(oneLine,",");
                vehicleType=st.nextToken();
                if (vehicleType.equalsIgnoreCase("C"))
                {
                    String brand=st.nextToken();
                    String model=st.nextToken();
                    int year=Integer.valueOf(st.nextToken());
                    float price = Float.valueOf(st.nextToken());
                    String strPicture = st.nextToken();
                    int picture=getResources().getIdentifier("drawable/"+strPicture,null,getPackageName());
                    list1.add(new Car(model,year));
                }
                else
                {
                    String brand=st.nextToken();
                    String bikeType=st.nextToken();
                    float price = Float.valueOf(st.nextToken());
                    String strPicture = st.nextToken();
                    int picture=getResources().getIdentifier("drawable/"+strPicture,null,getPackageName());

                    ;                }
                oneLine=br.readLine();
            }
            br.close();
            isr.close();
        } catch (IOException e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return list1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if (listOfVehicles.get(position).getBrand().equalsIgnoreCase("Alan"))
            {
                fragment_UI_2 bikeFragment=new fragment_UI_2();
            android.app.FragmentManager fragmentManager1 = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
            fragmentTransaction1.replace(R.id.linearLayout,bikeFragment);
            fragmentTransaction1.commit();
            drawerLayout.closeDrawer(listViewVehicle);
            }
            else if(listOfVehicles.get(position).getBrand().equalsIgnoreCase("Arios"))
            {
                fragment_UI_2 bikeFragment=new fragment_UI_2();
                android.app.FragmentManager fragmentManager1 = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.linearLayout,bikeFragment);
                fragmentTransaction1.commit();
                drawerLayout.closeDrawer(listViewVehicle);
        }
            else if(listOfVehicles.get(position).getBrand().equalsIgnoreCase("Canyon"))
            {
                fragment_UI_2 bikeFragment=new fragment_UI_2();
                android.app.FragmentManager fragmentManager1 = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.linearLayout,bikeFragment);
                fragmentTransaction1.commit();
                drawerLayout.closeDrawer(listViewVehicle);
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Vehicle", listOfVehicles.get(position));
                bundle.putSerializable("Car", listOfCar.get(position));
                fragment_UI_1 vehicleFragment = new fragment_UI_1();
                vehicleFragment.setArguments(bundle);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linearLayout, vehicleFragment);
                fragmentTransaction.commit();
                setTitle(listOfVehicles.get(position).getBrand());
                drawerLayout.closeDrawer(listViewVehicle);
            }
    }
}
