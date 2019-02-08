package com.samsad.topmovies.activity;

import android.support.v7.app.AppCompatActivity;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.samsad.topmovies.R;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.themoviedb.org/3/";
    public static String IMAGE_URL = "https://image.tmdb.org/t/p/w500/";

    public KProgressHUD hud_progress = null;

    public BaseActivity() {
    }

    public void setLoading() {
        hideProgress();
        if(isValid(hud_progress))
            hud_progress=null;

        hud_progress = KProgressHUD.create(this).
                setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setAnimationSpeed(2).setCancellable(false)
                .setMaxProgress(100)
                .setBackgroundColor(getResources().getColor(R.color.transparent))
                .setDimAmount(0.5f);

    }

    public void setLoading(String message) {
        hideProgress();
        if(isValid(hud_progress))
            hud_progress=null;
        hud_progress = KProgressHUD.create(this).
                setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).
                setLabel(""+message).setAnimationSpeed(2).
                setCancellable(false).
                setMaxProgress(100).setDimAmount(0.5f);

    }

    public void hideProgress() {
        try {
            if(isValid(hud_progress)) if(hud_progress.isShowing()) hud_progress.dismiss();
        }catch (Exception e)
        {

        }
    }

    public void showProgress() {
        try {
            hideProgress();
            if(isValid(hud_progress)) if(!hud_progress.isShowing()) hud_progress.show();
        }catch (Exception e)
        {

        }
    }

    public Boolean isValid(String text) {
        if (text != null)
            return !text.trim().equalsIgnoreCase("");
        return false;

    }

    public Boolean isValid(List list) {
        if (list != null)
            return list.size() > 0;
        return false;

    }

    public Boolean isValid(Object object) {
        return object != null;

    }

}
