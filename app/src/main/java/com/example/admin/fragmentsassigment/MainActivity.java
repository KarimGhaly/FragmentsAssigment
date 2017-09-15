package com.example.admin.fragmentsassigment;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListingFragment.OnFragmentInteractionListener, DetailsFragment.OnFragmentInteractionListener {

    public Celebritie getSelectedCelebritie() {
        return selectedCelebritie;
    }

    public void setSelectedCelebritie(Celebritie selectedCelebritie) {
        this.selectedCelebritie = selectedCelebritie;
    }

    public Celebritie selectedCelebritie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database DB = new Database(this);
        List<Celebritie> celebritiesList= DB.getCelebritiesList();
        if(celebritiesList.size()<=0)
        {
            DB.InsertCelebrities(SetCelebrities());
            celebritiesList= DB.getCelebritiesList();
        }

        ListingFragment listingFragment = ListingFragment.newInstance("Test","Test");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.ListingFragment,listingFragment,"Testtt");
        fragmentTransaction.commit();

        DetailsFragment detailsFragment = DetailsFragment.newInstance("","");
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.add(R.id.DetailsFragment,detailsFragment,"Testtts");
        fragmentTransaction1.commit();


    }

    public List<Celebritie> SetCelebrities()
    {
        List<Celebritie> celebritiesList = new ArrayList<>();
        Celebritie Trump = new Celebritie("Donald Trump",71, R.drawable.trump,"Donald John Trump is the 45th and current President of the United States, in office since January 20, 2017. Before entering politics, he was a businessman and television personality");
        Celebritie Beyonce = new Celebritie("Beyonce",36,R.drawable.beyonce,"Beyoncé Giselle Knowles-Carter is an American singer, songwriter, dancer, and actress. Born and raised in Houston, Texas, Beyoncé performed in various singing and dancing competitions as a child.");
        Celebritie Taylor = new Celebritie("Taylor Swift",27,R.drawable.taylor,"Taylor Alison Swift is an American singer-songwriter. One of the leading contemporary recording artists, she is known for narrative songs about her personal life, which have received widespread media coverage.");
        Celebritie Kim = new Celebritie("Kim Kardashian",36,R.drawable.kim,"Kimberly Kardashian West is an American reality television personality, socialite, actress, businesswoman and model.");
        Celebritie Sean = new Celebritie("Sean Combs",47,R.drawable.sean,"Sean John Combs, also known by his stage names Puff Daddy, Puffy, P. Diddy, and Diddy, is an American rapper, singer, songwriter, actor, record producer, and entrepreneur. He was born in Harlem and was raised in Mount Vernon, New York");
        Celebritie Rihanna = new Celebritie("Rihanna",29,R.drawable.rihanna,"Robyn Rihanna Fenty is a Barbadian singer, songwriter, and actress. Born in Saint Michael, Barbados and raised in Bridgetown, during 2003 she recorded demo tapes under the direction of record producer");
        Celebritie Justien = new Celebritie("Justien Bieber",23,R.drawable.bieber,"Justin Drew Bieber is a Canadian singer and songwriter. After a talent manager discovered him through his YouTube videos covering songs in 2008 and signed to RBMG, Bieber released his debut EP, My World, in late 2009.");
        Celebritie Drake = new Celebritie("Drake",30,R.drawable.drake,"Aubrey Drake Graham is a Canadian rapper, singer, songwriter, record producer, actor, and entrepreneur. Drake initially gained recognition as an actor on the teen drama television series Degrassi: The Next Generation in the early 2000s");
        Celebritie Katy = new Celebritie("Katy Perry",32,R.drawable.katy,"Katheryn Elizabeth Hudson, known professionally as Katy Perry, is an American singer and songwriter. After singing in church during her childhood, she pursued a career in gospel music as a teenager. ");
        Celebritie Jennifer = new Celebritie("Jennifer Lopez",48,R.drawable.lopez,"Jennifer Lynn Lopez, also known by her nickname J.Lo, is an American singer, actress, dancer and fashion designer.");
        Celebritie Ellen = new Celebritie("Ellen DeGeneres", 59,R.drawable.ellen,"Ellen Lee DeGeneres is an American comedian, television host, actress, writer, and producer. DeGeneres starred in the popular sitcom Ellen from 1994 to 1998 and has hosted her syndicated TV talk show, The Ellen DeGeneres Show, since 2003. ");
        Celebritie Operah = new Celebritie("Oprah Winfery",63,R.drawable.oprah,"Oprah Winfrey is an American media proprietor, talk show host, actress, producer, and philanthropist.");
        Celebritie Jay = new Celebritie("Jay Z",47,R.drawable.jay,"Shawn Corey Carter, known professionally as JAY-Z is an American rapper and businessman. He is one of the best-selling musicians of all time, having sold more than 100 million records, while receiving 21 Grammy Awards for his music. ");
        Celebritie Angilena = new Celebritie("Angelina Jolie",42,R.drawable.jolie,"Angelina Jolie Pitt is an American actress, filmmaker and humanitarian. She has received an Academy Award, two Screen Actors Guild Awards, and three Golden Globe Awards, and has been cited as Hollywood's highest-paid actress");
        Celebritie Dwayne = new Celebritie("Dwayne Johnson",45,R.drawable.dwayne,"Dwayne Douglas Johnson, also known by his ring name The Rock, is an American actor, producer and professional wrestler. ");
        Celebritie Tom = new Celebritie("Tom Cruise",55,R.drawable.tom,"Thomas Cruise Mapother IV, known professionally as Tom Cruise, is an American actor and producer. He has been nominated for three Academy Awards and has won three Golden Globe Awards. He started his career at age 19 in the film Endless Love.");

        celebritiesList.add(Trump);
        celebritiesList.add(Beyonce);
        celebritiesList.add(Taylor);
        celebritiesList.add(Kim);
        celebritiesList.add(Sean);
        celebritiesList.add(Rihanna);
        celebritiesList.add(Justien);
        celebritiesList.add(Drake);
        celebritiesList.add(Katy);
        celebritiesList.add(Jennifer);
        celebritiesList.add(Ellen);
        celebritiesList.add(Operah);
        celebritiesList.add(Jay);
        celebritiesList.add(Angilena);
        celebritiesList.add(Dwayne);
        celebritiesList.add(Tom);


        return celebritiesList;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void SendCelbtoAct(Celebritie c) {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.DetailsFragment);
        if(detailsFragment!= null)
        {
            detailsFragment.SetCelebritieDetail(c);
        }

    }
}
