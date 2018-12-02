package net.jevindement.collegeletgo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment
{
    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;
    /**
     *populates the screen
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Ipad 6",
                        "Mint condition",
                        4.9,
                        250,
                        R.drawable.ipad));

        productList.add(
                new Product(
                        1,
                        "Laptop",
                        "14 inch, Grey",
                        4.3,
                        320,
                        R.drawable.greylaptop));

        productList.add(
                new Product(
                        1,
                        "Microwave",
                        "Dont need anymore, ",
                        4.3,
                        20,
                        R.drawable.microwave));
        productList.add(
                new Product(
                        1,
                        "Microsoft Surface",
                        "13.3 inch, Silver- used",
                        3.5,
                        120,
                        R.drawable.microsoft_surface));
        productList.add(
                new Product(
                        1,
                        "Snowboard",
                        "mens, 160",
                        4.5,
                        100,
                        R.drawable.snowboard));
        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(getActivity(), productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

