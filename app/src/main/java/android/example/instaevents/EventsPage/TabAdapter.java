package android.example.instaevents.EventsPage;

import android.example.instaevents.EventsPage.MyEvents.MyEventsFragment;
import android.example.instaevents.EventsPage.Upcoming.UpcomingFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {
    int countTab;


    public TabAdapter(FragmentManager fm, int counttab) {
        super(fm);
        this.countTab = counttab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                MyEventsFragment myEventsFragment = new MyEventsFragment();
                return myEventsFragment;

            case 1:
                UpcomingFragment upcomingFragment = new UpcomingFragment();
                return upcomingFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
