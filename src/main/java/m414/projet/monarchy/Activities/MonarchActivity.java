package m414.projet.monarchy.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import m414.projet.monarchy.Adapters.PagerAdapter;
import m414.projet.monarchy.Objects.ListMonarch;
import m414.projet.monarchy.Objects.ListPays;
import m414.projet.monarchy.R;

import static m414.projet.monarchy.Activities.PaysActivity.PAYS_POS;

public class MonarchActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;
    public static int POS_PAYS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_monarch);

        POS_PAYS=getIntent().getIntExtra(PAYS_POS, 1);

        ListMonarch mListP = new ListMonarch(ListPays.getInstance().get(POS_PAYS).getRois());

        tl =findViewById(R.id.MonarchTLayout);

        for(int i =0; i<mListP.size(); i++)
        {
            tl.addTab(tl.newTab().setText(mListP.get(i).getNom()));
        }

        vp=findViewById(R.id.MonarchVPager);

        PagerAdapter pa = new PagerAdapter(getSupportFragmentManager(), tl.getTabCount());

        vp.setAdapter(pa);

        tl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
